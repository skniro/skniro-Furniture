package com.skniro.skniro_furniture.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.CoffeeChairBlock;
import com.skniro.skniro_furniture.block.init.CushionBlock;
import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Emits composite item definitions for beds, cushions and coffee chairs so banner
 * patterns can be rendered on the item icon / loom preview.
 */
public class FurnitureDecoratedItemModelProvider implements DataProvider {
    private final PackOutput output;

    public FurnitureDecoratedItemModelProvider(FabricPackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        PackOutput.PathProvider paths = this.output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (Item item : BuiltInRegistries.ITEM) {
            if (!(item instanceof BlockItem blockItem)) {
                continue;
            }
            Block block = blockItem.getBlock();
            String specialType;
            if (block instanceof FurnitureBedBlock) {
                specialType = "bed_sheet";
            } else if (block instanceof CushionBlock) {
                specialType = "cushion_surface";
            } else if (block instanceof CoffeeChairBlock) {
                specialType = "coffee_chair_surface";
            } else {
                continue;
            }
            Identifier blockId = BuiltInRegistries.BLOCK.getKey(block);
            Identifier itemId = BuiltInRegistries.ITEM.getKey(item);
            if (blockId == null || itemId == null) {
                continue;
            }
            String modelId = blockId.getNamespace() + ":block/" + blockId.getPath();

            JsonObject base = new JsonObject();
            base.addProperty("type", "minecraft:model");
            base.addProperty("model", modelId);

            JsonObject special = new JsonObject();
            special.addProperty("type", Furniture.MOD_ID + ":" + specialType);

            JsonObject specialModel = new JsonObject();
            specialModel.addProperty("type", "minecraft:special");
            specialModel.addProperty("base", modelId);
            specialModel.add("model", special);

            JsonArray models = new JsonArray();
            models.add(base);
            models.add(specialModel);

            JsonObject composite = new JsonObject();
            composite.addProperty("type", "minecraft:composite");
            composite.add("models", models);

            JsonObject root = new JsonObject();
            root.add("model", composite);
            futures.add(DataProvider.saveStable(cache, root, paths.json(itemId)));
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "Furniture decorated item models";
    }
}
