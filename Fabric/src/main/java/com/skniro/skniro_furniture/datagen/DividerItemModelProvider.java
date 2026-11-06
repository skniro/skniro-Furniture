package com.skniro.skniro_furniture.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.skniro.skniro_furniture.Furniture;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Emits the divider item definitions with the dynamic banner special model.
 */
public class DividerItemModelProvider implements DataProvider {
    private static final String[][] DIVIDERS = {
            {"white_wood_divider", "white"},
            {"orange_wood_divider", "orange"},
            {"magenta_wood_divider", "magenta"},
            {"light_blue_wood_divider", "light_blue"},
            {"yellow_wood_divider", "yellow"},
            {"lime_wood_divider", "lime"},
            {"pink_wood_divider", "pink"},
            {"gray_wood_divider", "gray"},
            {"light_gray_wood_divider", "light_gray"},
            {"cyan_wood_divider", "cyan"},
            {"purple_wood_divider", "purple"},
            {"blue_wood_divider", "blue"},
            {"brown_wood_divider", "brown"},
            {"green_wood_divider", "green"},
            {"red_wood_divider", "red"},
            {"black_wood_divider", "black"},
    };

    private final PackOutput output;

    public DividerItemModelProvider(FabricPackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        PackOutput.PathProvider paths = this.output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (String[] divider : DIVIDERS) {
            JsonObject base = new JsonObject();
            base.addProperty("type", "minecraft:model");
            base.addProperty("model", Furniture.MOD_ID + ":block/" + divider[0]);

            JsonObject special = new JsonObject();
            special.addProperty("type", Furniture.MOD_ID + ":divider_banner");
            special.addProperty("color", divider[1]);

            JsonObject specialModel = new JsonObject();
            specialModel.addProperty("type", "minecraft:special");
            specialModel.addProperty("base", Furniture.MOD_ID + ":block/" + divider[0]);
            specialModel.add("model", special);

            JsonArray models = new JsonArray();
            models.add(base);
            models.add(specialModel);

            JsonObject composite = new JsonObject();
            composite.addProperty("type", "minecraft:composite");
            composite.add("models", models);

            JsonObject root = new JsonObject();
            root.add("model", composite);

            Identifier id = Identifier.fromNamespaceAndPath(Furniture.MOD_ID, divider[0]);
            futures.add(DataProvider.saveStable(cache, root, paths.json(id)));
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "Divider item models";
    }
}
