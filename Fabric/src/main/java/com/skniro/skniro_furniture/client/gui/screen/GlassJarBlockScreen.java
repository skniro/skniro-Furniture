package com.skniro.skniro_furniture.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.screen.GlassJarBlockScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GlassJarBlockScreen extends HandledScreen<GlassJarBlockScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(Furniture.MOD_ID, "textures/gui/container/glass_jar.png");

    public GlassJarBlockScreen(GlassJarBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight,256,256);
    }

    @Override
    public void render(DrawContext context , int mouseX, int mouseY, float delta) {
        //renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}

