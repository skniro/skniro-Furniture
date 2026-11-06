package com.skniro.skniro_furniture.gametest;

import com.skniro.skniro_furniture.block.FurnitureBedroomBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.fabric.api.client.gametest.v1.FabricClientGameTest;
import net.fabricmc.fabric.api.client.gametest.v1.context.ClientGameTestContext;
import net.fabricmc.fabric.api.client.gametest.v1.context.TestSingleplayerContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.inventory.LoomMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DecoratedFurnitureClientGameTest implements FabricClientGameTest {
    private static final String PATTERN = "minecraft:bricks";

    private static void setupLoom(ClientGameTestContext context, TestSingleplayerContext sp, ItemStack banner) {
        sp.getServer().runOnServer(server -> {
            ServerPlayer player = server.getPlayerList().getPlayers().get(0);
            if (player.containerMenu instanceof LoomMenu menu) {
                menu.getBannerSlot().set(banner);
                menu.getDyeSlot().set(new ItemStack(Items.DYE.red()));
                menu.getPatternSlot().set(new ItemStack(Items.FIELD_MASONED_BANNER_PATTERN));
                menu.slotsChanged(menu.getBannerSlot().container);
                menu.clickMenuButton(player, 0);
            }
        });
        context.waitTicks(20);
    }

    private static ItemStack loomResult(TestSingleplayerContext sp) {
        ItemStack[] result = new ItemStack[1];
        sp.getServer().runOnServer(server -> {
            ServerPlayer player = server.getPlayerList().getPlayers().get(0);
            if (player.containerMenu instanceof LoomMenu menu) {
                result[0] = menu.getResultSlot().getItem().copy();
            }
        });
        return result[0];
    }

    @Override
    public void runTest(ClientGameTestContext context) {
        try (TestSingleplayerContext sp = context.worldBuilder().create()) {
            sp.getServer().runCommand("gamemode creative @a");
            sp.getServer().runCommand("time set noon");
            sp.getServer().runCommand("weather clear");
            sp.getServer().runCommand("fill 6 99 4 15 99 15 minecraft:oak_planks");
            sp.getServer().runCommand("setblock 10 100 10 minecraft:loom");
            sp.getServer().runCommand("tp @a 10.5 100.0 13.5 180 0");
            sp.getConnection().waitForChunksRender();
            context.getInput().lookAt(new BlockPos(10, 100, 10));
            context.waitTicks(10);
            context.getInput().pressKey(options -> options.keyUse);
            context.waitTicks(20);

            // Loom: cushion + dye + pattern
            setupLoom(context, sp, new ItemStack(MapleFurnitureBlocks.CUSHION_OAK_WHITE));
            context.takeScreenshot("loom_cushion_pattern");
            ItemStack cushionResult = loomResult(sp);
            if (cushionResult == null || !cushionResult.has(DataComponents.BANNER_PATTERNS)) {
                throw new AssertionError("Loom did not decorate the cushion item");
            }

            // Loom: bed + dye + pattern
            setupLoom(context, sp, new ItemStack(FurnitureBedroomBlocks.BED_OAK_WHITE_PLANK));
            context.takeScreenshot("loom_bed_pattern");
            ItemStack bedResult = loomResult(sp);
            if (bedResult == null || !bedResult.has(DataComponents.BANNER_PATTERNS)) {
                throw new AssertionError("Loom did not decorate the bed item");
            }

            // Put both results in the hotbar to verify the item special renderers.
            sp.getServer().runOnServer(server -> {
                ServerPlayer player = server.getPlayerList().getPlayers().get(0);
                player.getInventory().setItem(0, cushionResult.copy());
                player.getInventory().setItem(1, bedResult.copy());
                player.getInventory().setSelectedSlot(0);
                if (player.containerMenu instanceof LoomMenu menu) {
                    player.closeContainer();
                }
            });
            context.waitTicks(40);
            context.takeScreenshot("decorated_item_icons");

            // Place the decorated bed item (FurnitureBannerItem placement path).
            sp.getServer().runCommand("tp @a 10.5 100.0 18.5 180 0");
            sp.getServer().runOnServer(server -> {
                ServerPlayer player = server.getPlayerList().getPlayers().get(0);
                player.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, bedResult.copy());
                BlockPos target = new BlockPos(10, 99, 13);
                net.minecraft.world.item.context.UseOnContext useOn = new net.minecraft.world.item.context.UseOnContext(
                        player, net.minecraft.world.InteractionHand.MAIN_HAND,
                        new net.minecraft.world.phys.BlockHitResult(
                                net.minecraft.world.phys.Vec3.atCenterOf(target).add(0.0, 0.5, 0.0),
                                net.minecraft.core.Direction.UP, target, false));
                net.minecraft.world.InteractionResult result = player.getItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND).useOn(useOn);
                System.out.println("[gametest] bed item useOn -> " + result);
                if (!(server.overworld().getBlockState(new BlockPos(10, 100, 13)).getBlock()
                        instanceof com.skniro.skniro_furniture.block.init.FurnitureBedBlock)) {
                    throw new AssertionError("Decorated bed item did not place a bed");
                }
                if (!(server.overworld().getBlockEntity(new BlockPos(10, 100, 13))
                        instanceof com.skniro.skniro_furniture.block.entity.AbstractBannerDecoratedBlockEntity be)
                        || be.getPatterns().layers().isEmpty()) {
                    throw new AssertionError("Placed bed lost its banner patterns");
                }
            });

            // Place the decorated cushion item.
            sp.getServer().runOnServer(server -> {
                ServerPlayer player = server.getPlayerList().getPlayers().get(0);
                player.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, cushionResult.copy());
                BlockPos target = new BlockPos(13, 99, 14);
                net.minecraft.world.item.context.UseOnContext useOn = new net.minecraft.world.item.context.UseOnContext(
                        player, net.minecraft.world.InteractionHand.MAIN_HAND,
                        new net.minecraft.world.phys.BlockHitResult(
                                net.minecraft.world.phys.Vec3.atCenterOf(target).add(0.0, 0.5, 0.0),
                                net.minecraft.core.Direction.UP, target, false));
                net.minecraft.world.InteractionResult result = player.getItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND).useOn(useOn);
                System.out.println("[gametest] cushion item useOn -> " + result);
                if (!(server.overworld().getBlockState(new BlockPos(13, 100, 14)).getBlock()
                        instanceof com.skniro.skniro_furniture.block.init.CushionBlock)) {
                    throw new AssertionError("Decorated cushion item did not place a cushion");
                }
                if (!(server.overworld().getBlockEntity(new BlockPos(13, 100, 14))
                        instanceof com.skniro.skniro_furniture.block.entity.AbstractBannerDecoratedBlockEntity be)
                        || be.getPatterns().layers().isEmpty()) {
                    throw new AssertionError("Placed cushion lost its banner patterns");
                }
            });

            // Placed cushion with decorations.
            sp.getServer().runCommand("setblock 8 100 10 skniro_furniture:oak_white_cushion[facing=north]");
            sp.getServer().runCommand("data merge block 8 100 10 {patterns:[{pattern:\"" + PATTERN + "\",color:\"red\"}],base_color:\"white\"}");
            // Placed bed with decorations (foot at z=12, head at z=11).
            sp.getServer().runCommand("setblock 11 100 12 skniro_furniture:oak_white_plank_bed[part=foot,facing=north]");
            sp.getServer().runCommand("setblock 11 100 11 skniro_furniture:oak_white_plank_bed[part=head,facing=north]");
            sp.getServer().runCommand("data merge block 11 100 12 {patterns:[{pattern:\"" + PATTERN + "\",color:\"red\"}]}");
            sp.getServer().runCommand("data merge block 11 100 11 {patterns:[{pattern:\"" + PATTERN + "\",color:\"red\"}]}");
            sp.getServer().runCommand("tp @a 8.5 101.5 13.5 180 0");
            sp.getConnection().waitForChunksRender();
            context.getInput().lookAt(new BlockPos(8, 100, 10));
            context.waitTicks(100);
            context.takeScreenshot("decorated_cushion_world");

            sp.getServer().runCommand("tp @a 11.5 102.0 15.0 180 0");
            sp.getConnection().waitForChunksRender();
            context.getInput().lookAt(new BlockPos(11, 100, 12));
            context.waitTicks(20);
            context.takeScreenshot("decorated_bed_world");

            // Drop preservation: break a decorated cushion away from the player.
            sp.getServer().runCommand("tp @a 10.5 110.0 40.5 180 0");
            sp.getServer().runCommand("setblock 8 100 10 air destroy");
            context.waitTicks(10);
            boolean[] kept = {false};
            sp.getServer().runOnServer(server -> {
                for (net.minecraft.world.entity.Entity entity : server.overworld().getAllEntities()) {
                    if (entity instanceof ItemEntity item) {
                        System.out.println("[gametest] item drop " + item.getItem()
                                + " patterns=" + item.getItem().has(DataComponents.BANNER_PATTERNS));
                        if (item.getItem().has(DataComponents.BANNER_PATTERNS)) {
                            kept[0] = true;
                        }
                    }
                }
            });
            if (!kept[0]) {
                throw new AssertionError("Decorated cushion drop lost its banner patterns");
            }

            // Same preservation check for a divider.
            sp.getServer().runCommand("setblock 9 100 10 skniro_furniture:white_wood_divider[facing=north]");
            sp.getServer().runCommand("data merge block 9 100 10 {patterns:[{pattern:\"" + PATTERN + "\",color:\"red\"}],base_color:\"white\"}");
            sp.getServer().runCommand("setblock 9 100 10 air destroy");
            context.waitTicks(5);
            boolean[] dividerKept = {false};
            sp.getServer().runOnServer(server -> {
                net.minecraft.world.item.Item dividerItem = MapleFurnitureBlocks.WHITE_WOOD_DIVIDER.asItem();
                for (net.minecraft.world.entity.Entity entity : server.overworld().getAllEntities()) {
                    if (entity instanceof ItemEntity item && item.getItem().is(dividerItem)
                            && item.getItem().has(DataComponents.BANNER_PATTERNS)) {
                        dividerKept[0] = true;
                    }
                }
            });
            if (!dividerKept[0]) {
                throw new AssertionError("Decorated divider drop lost its banner patterns");
            }

            // Seating still works with an empty hand (same server path as a use packet).
            sp.getServer().runCommand("tp @a 13.5 100.0 17.0 180 0");
            sp.getServer().runOnServer(server -> {
                ServerPlayer player = server.getPlayerList().getPlayers().get(0);
                player.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                BlockPos cushionPos = new BlockPos(13, 100, 14);
                net.minecraft.world.phys.BlockHitResult hit = new net.minecraft.world.phys.BlockHitResult(
                        new net.minecraft.world.phys.Vec3(13.5, 100.22, 14.5),
                        net.minecraft.core.Direction.UP, cushionPos, false);
                net.minecraft.world.InteractionResult result = player.gameMode.useItemOn(player, server.overworld(),
                        ItemStack.EMPTY, net.minecraft.world.InteractionHand.MAIN_HAND, hit);
                System.out.println("[gametest] empty-hand useOn -> " + result + " vehicle=" + player.getVehicle());
                if (!(player.getVehicle() instanceof com.skniro.skniro_furniture.entity.furniture.CushionEntity)) {
                    throw new AssertionError("Empty-hand right click no longer seats on a cushion");
                }
            });
        }
    }
}
