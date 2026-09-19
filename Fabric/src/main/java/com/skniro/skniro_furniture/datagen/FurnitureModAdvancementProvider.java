package com.skniro.skniro_furniture.datagen;

import com.skniro.skniro_furniture.Furniture;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.ClientAsset;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.level.ItemLike;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FurnitureModAdvancementProvider extends FabricAdvancementProvider {
	protected FurnitureModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, registryLookup);
	}

	private static Identifier id(String name) {
		return Identifier.fromNamespaceAndPath(Furniture.MOD_ID, name);
	}

	private static TagKey<Item> tag(String name) {
		return TagKey.create(Registries.ITEM, id(name));
	}

	private static ItemLike item(HolderGetter<Item> items, String name) {
		return items.getOrThrow(ResourceKey.create(Registries.ITEM, id(name))).value();
	}

	/** Matches an inventory that contains an item of any of the given tags. */
	private static Criterion<InventoryChangeTrigger.TriggerInstance> hasTags(HolderGetter<Item> items, String... names) {
		ItemPredicate[] predicates = new ItemPredicate[names.length];
		for (int i = 0; i < names.length; i++) {
			predicates[i] = ItemPredicate.Builder.item().of(items, tag(names[i])).build();
		}
		return InventoryChangeTrigger.TriggerInstance.hasItems(predicates);
	}

	/** One advancement: its id, parent id (null for the root), frame, icon item and criteria. */
	private record Spec(String name, String parent, AdvancementType frame, String icon, String[][] criteria) {
	}

	/**
	 * The full achievement tree. Criteria entries are {criterionName, tag...}; several tags in one
	 * entry mean "any of them". Parents must be declared before their children.
	 */
	private static final Spec[] SPECS = {
			// root
			new Spec("furnishing", null, AdvancementType.TASK, "acacia_plank_chair",
					new String[][]{{"get_furniture", "furniture"}}),

			// 家具入门
			new Spec("furniture_intro", "furnishing", AdvancementType.GOAL, "acacia_plank_chair",
					new String[][]{{"get_cushion", "cushions"}, {"get_chair", "chairs"},
							{"get_coffee_chair", "coffee_chairs"}, {"get_sofa", "sofas"}}),
			new Spec("cushion", "furniture_intro", AdvancementType.TASK, "acacia_black_cushion",
					new String[][]{{"get_cushion", "cushions"}}),
			new Spec("chair", "furniture_intro", AdvancementType.TASK, "acacia_plank_chair",
					new String[][]{{"get_chair", "chairs"}}),
			new Spec("coffee_chair", "furniture_intro", AdvancementType.TASK, "acacia_plank_coffee_chair_black",
					new String[][]{{"get_coffee_chair", "coffee_chairs"}}),
			new Spec("sofa", "furniture_intro", AdvancementType.TASK, "black_sofa",
					new String[][]{{"get_sofa", "sofas"}}),

			// 木工基础
			new Spec("carpentry_basics", "furnishing", AdvancementType.GOAL, "acacia_table",
					new String[][]{{"get_plank_table", "plank_tables"}, {"get_coffee_table", "coffee_tables"},
							{"get_end_table", "end_tables"}, {"get_glass_table", "glass_tables"},
							{"get_book_desk", "book_desks"}, {"get_bedside_cabinet", "bedside_cabinets"},
							{"get_desk_cabinet", "desk_cabinets"}}),
			new Spec("plank_table", "carpentry_basics", AdvancementType.TASK, "acacia_table",
					new String[][]{{"get_plank_table", "plank_tables"}}),
			new Spec("coffee_table", "carpentry_basics", AdvancementType.TASK, "acacia_plank_coffee_table",
					new String[][]{{"get_coffee_table", "coffee_tables"}}),
			new Spec("end_table", "carpentry_basics", AdvancementType.TASK, "acacia_end_table",
					new String[][]{{"get_end_table", "end_tables"}}),
			new Spec("glass_table", "carpentry_basics", AdvancementType.TASK, "acacia_plank_glass_table",
					new String[][]{{"get_glass_table", "glass_tables"}}),
			new Spec("book_desk", "carpentry_basics", AdvancementType.TASK, "acacia_planks_book_desk",
					new String[][]{{"get_book_desk", "book_desks"}}),
			new Spec("bedside_cabinet", "carpentry_basics", AdvancementType.TASK, "acacia_planks_bedside_cabinet",
					new String[][]{{"get_bedside_cabinet", "bedside_cabinets"}}),
			new Spec("desk_cabinet", "carpentry_basics", AdvancementType.TASK, "acacia_planks_desk_cabinet",
					new String[][]{{"get_desk_cabinet", "desk_cabinets"}}),

			// 厨房初学者
			new Spec("kitchen_beginner", "furnishing", AdvancementType.GOAL, "black_kitchen_counter",
					new String[][]{{"get_counter", "counters"}, {"get_counter_drawer", "counter_drawers"},
							{"get_kitchen_cabinet", "kitchen_cabinets"}, {"get_sink", "sinks"},
							{"get_oven", "ovens"}, {"get_fridge", "fridges"}}),
			new Spec("kitchen_counter", "kitchen_beginner", AdvancementType.TASK, "black_kitchen_counter",
					new String[][]{{"get_counter", "counters"}}),
			new Spec("kitchen_counter_drawer", "kitchen_beginner", AdvancementType.TASK, "black_kitchen_counter_drawer",
					new String[][]{{"get_counter_drawer", "counter_drawers"}}),
			new Spec("kitchen_cabinet", "kitchen_beginner", AdvancementType.TASK, "black_kitchen_cabinet",
					new String[][]{{"get_kitchen_cabinet", "kitchen_cabinets"}}),
			new Spec("sink", "kitchen_beginner", AdvancementType.TASK, "black_kitchen_sink",
					new String[][]{{"get_sink", "sinks"}}),
			new Spec("oven", "kitchen_beginner", AdvancementType.TASK, "black_oven",
					new String[][]{{"get_oven", "ovens"}}),
			new Spec("fridge", "kitchen_beginner", AdvancementType.TASK, "black_fridge",
					new String[][]{{"get_fridge", "fridges"}}),

			// 收纳大师
			new Spec("storage_master", "furnishing", AdvancementType.GOAL, "acacia_plank_triple_cabinet",
					new String[][]{{"get_triple_cabinet", "triple_cabinets"},
							{"get_glass_door_triple_cabinet", "glass_door_triple_cabinets"},
							{"get_four_grid_cabinet", "four_grid_cabinets"},
							{"get_glass_door_four_grid_cabinet", "glass_door_four_grid_cabinets"},
							{"get_wall_cabinet", "wall_cabinets"}}),
			new Spec("triple_cabinet", "storage_master", AdvancementType.TASK, "acacia_plank_triple_cabinet",
					new String[][]{{"get_triple_cabinet", "triple_cabinets"}}),
			new Spec("glass_door_triple_cabinet", "triple_cabinet", AdvancementType.TASK,
					"acacia_plank_double_glass_doors_triple_cabinet",
					new String[][]{{"get_glass_door_triple_cabinet", "glass_door_triple_cabinets"}}),
			new Spec("four_grid_cabinet", "storage_master", AdvancementType.TASK, "acacia_plank_four_grid_cabinet",
					new String[][]{{"get_four_grid_cabinet", "four_grid_cabinets"}}),
			new Spec("glass_door_four_grid_cabinet", "four_grid_cabinet", AdvancementType.TASK,
					"acacia_plank_double_glass_doors_four_grid_cabinet",
					new String[][]{{"get_glass_door_four_grid_cabinet", "glass_door_four_grid_cabinets"}}),
			new Spec("wall_cabinet", "storage_master", AdvancementType.TASK, "acacia_plank_wall_cabinet",
					new String[][]{{"get_wall_cabinet", "wall_cabinets"}}),

			// 卧室布置
			new Spec("bedroom_setup", "furnishing", AdvancementType.GOAL, "acacia_red_wood_bed",
					new String[][]{{"get_bed", "beds"}, {"get_bedside_cabinet", "bedside_cabinets"},
							{"get_curtain", "curtains"}, {"get_cushion", "cushions"}}),
			new Spec("bed", "bedroom_setup", AdvancementType.TASK, "acacia_red_wood_bed",
					new String[][]{{"get_bed", "beds"}}),
			new Spec("curtain", "bedroom_setup", AdvancementType.TASK, "black_wood_divider",
					new String[][]{{"get_curtain", "curtains"}}),

			// 窗与门
			new Spec("windows_and_doors", "furnishing", AdvancementType.GOAL, "acacia_plank_window",
					new String[][]{{"get_window", "windows"}, {"get_window_style2", "windows_style2"},
							{"get_paper_sliding_door", "paper_sliding_doors"},
							{"get_grid_glass_sliding_door", "grid_glass_sliding_doors"},
							{"get_glass_sliding_door", "glass_sliding_doors"}}),
			new Spec("window", "windows_and_doors", AdvancementType.TASK, "acacia_plank_window",
					new String[][]{{"get_window", "windows"}}),
			new Spec("window_style2", "windows_and_doors", AdvancementType.TASK, "acacia_plank_window_style2",
					new String[][]{{"get_window_style2", "windows_style2"}}),
			new Spec("paper_sliding_door", "windows_and_doors", AdvancementType.TASK, "acacia_black_paper_sliding_door",
					new String[][]{{"get_paper_sliding_door", "paper_sliding_doors"}}),
			new Spec("grid_glass_sliding_door", "windows_and_doors", AdvancementType.TASK,
					"acacia_black_grid_glass_sliding_door",
					new String[][]{{"get_grid_glass_sliding_door", "grid_glass_sliding_doors"}}),
			new Spec("glass_sliding_door", "windows_and_doors", AdvancementType.TASK, "acacia_black_glass_sliding_door",
					new String[][]{{"get_glass_sliding_door", "glass_sliding_doors"}}),

			// 客厅布置
			new Spec("living_room_setup", "furnishing", AdvancementType.GOAL, "black_sofa",
					new String[][]{{"get_sofa", "sofas"}, {"get_end_table", "end_tables"},
							{"get_tv_stand", "tv_stands"}, {"get_tv", "tvs"}}),
			new Spec("tv_stand", "living_room_setup", AdvancementType.TASK, "acacia_planks_tv_stand",
					new String[][]{{"get_tv_stand", "tv_stands"}}),
			new Spec("tv", "living_room_setup", AdvancementType.TASK, "acacia_planks_tv",
					new String[][]{{"get_tv", "tvs"}}),

			// 装饰艺术
			new Spec("decorative_art", "furnishing", AdvancementType.GOAL, "black_ceiling_lamp",
					new String[][]{{"get_plate", "plates"}, {"get_ceiling_lamp", "ceiling_lamps"},
							{"get_animal_painting", "animal_paintings"}}),
			new Spec("plate", "decorative_art", AdvancementType.TASK, "acacia_plank_plate",
					new String[][]{{"get_plate", "plates"}}),
			new Spec("ceiling_lamp", "decorative_art", AdvancementType.TASK, "black_ceiling_lamp",
					new String[][]{{"get_ceiling_lamp", "ceiling_lamps"}}),
			new Spec("animal_painting", "decorative_art", AdvancementType.TASK, "acacia_allay_draw",
					new String[][]{{"get_animal_painting", "animal_paintings"}}),

			// 挑战
			new Spec("furniture_collector", "furnishing", AdvancementType.CHALLENGE, "acacia_bookshelf",
					new String[][]{{"get_basics", "cushions", "chairs", "coffee_chairs", "sofas"},
							{"get_carpentry", "plank_tables", "coffee_tables", "end_tables", "glass_tables",
									"book_desks", "bedside_cabinets", "desk_cabinets"},
							{"get_kitchen", "counters", "counter_drawers", "kitchen_cabinets",
									"sinks", "ovens", "fridges"},
							{"get_storage", "triple_cabinets", "four_grid_cabinets",
									"glass_door_triple_cabinets", "glass_door_four_grid_cabinets",
									"wall_cabinets"},
							{"get_bedroom", "beds", "bedside_cabinets", "curtains", "cushions"},
							{"get_windows_doors", "windows", "windows_style2", "paper_sliding_doors",
									"grid_glass_sliding_doors", "glass_sliding_doors"},
							{"get_living_room", "sofas", "end_tables", "tv_stands", "tvs"},
							{"get_decorative", "plates", "ceiling_lamps", "animal_paintings"}}),
			new Spec("interior_design_master", "furnishing", AdvancementType.CHALLENGE, "acacia_planks_kitchen_sink",
					new String[][]{{"get_kitchen_counter", "counters"}, {"get_kitchen_cabinet", "kitchen_cabinets"},
							{"get_sink", "sinks"}, {"get_oven", "ovens"}, {"get_fridge", "fridges"},
							{"get_bed", "beds"}, {"get_bedside_cabinet", "bedside_cabinets"},
							{"get_curtain", "curtains"}, {"get_cushion", "cushions"},
							{"get_sofa", "sofas"}, {"get_end_table", "end_tables"},
							{"get_tv_stand", "tv_stands"}, {"get_tv", "tvs"}}),
			new Spec("furniture_tycoon", "furnishing", AdvancementType.CHALLENGE, "acacia_planks_book_desk",
					new String[][]{{"get_cushion", "cushions"}, {"get_chair", "chairs"},
							{"get_coffee_chair", "coffee_chairs"}, {"get_sofa", "sofas"},
							{"get_plank_table", "plank_tables"}, {"get_coffee_table", "coffee_tables"},
							{"get_end_table", "end_tables"}, {"get_glass_table", "glass_tables"},
							{"get_book_desk", "book_desks"}, {"get_bedside_cabinet", "bedside_cabinets"},
							{"get_desk_cabinet", "desk_cabinets"}, {"get_counter", "counters"},
							{"get_counter_drawer", "counter_drawers"},
							{"get_kitchen_cabinet", "kitchen_cabinets"}, {"get_sink", "sinks"},
							{"get_oven", "ovens"}, {"get_fridge", "fridges"},
							{"get_triple_cabinet", "triple_cabinets"},
							{"get_four_grid_cabinet", "four_grid_cabinets"},
							{"get_glass_door_triple_cabinet", "glass_door_triple_cabinets"},
							{"get_glass_door_four_grid_cabinet", "glass_door_four_grid_cabinets"},
							{"get_wall_cabinet", "wall_cabinets"}, {"get_bed", "beds"},
							{"get_curtain", "curtains"}, {"get_window", "windows"},
							{"get_window_style2", "windows_style2"},
							{"get_paper_sliding_door", "paper_sliding_doors"},
							{"get_grid_glass_sliding_door", "grid_glass_sliding_doors"},
							{"get_glass_sliding_door", "glass_sliding_doors"},
							{"get_tv_stand", "tv_stands"}, {"get_tv", "tvs"},
							{"get_plate", "plates"}, {"get_ceiling_lamp", "ceiling_lamps"},
							{"get_animal_painting", "animal_paintings"}}),
	};

	@Override
	public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {
		HolderLookup.RegistryLookup<Item> items = wrapperLookup.lookupOrThrow(Registries.ITEM);
		Map<String, AdvancementHolder> parents = new HashMap<>();

		for (Spec spec : SPECS) {
			// Only the root advancement may carry the tab background image; the game rejects
			// a background on any advancement that has a parent.
			Optional<ClientAsset.ResourceTexture> background = spec.parent() == null
					? Optional.of(new ClientAsset.ResourceTexture(id("block/bookshelf")))
					: Optional.empty();
			Advancement.Builder builder = Advancement.Builder.advancement()
					.display(new DisplayInfo(
							new ItemStackTemplate(item(items, spec.icon()).asItem()),
							Component.translatable("advancements." + Furniture.MOD_ID + "." + spec.name() + ".title"),
							Component.translatable("advancements." + Furniture.MOD_ID + "." + spec.name() + ".description"),
							background,
							spec.frame(),
							true,
							true,
							false));
			if (spec.parent() != null) {
				builder.parent(parents.get(spec.parent()));
			}
			for (String[] criterion : spec.criteria()) {
				builder.addCriterion(criterion[0], hasTags(items, Arrays.copyOfRange(criterion, 1, criterion.length)));
			}
			parents.put(spec.name(), builder.save(consumer, Identifier.fromNamespaceAndPath(Furniture.MOD_ID, spec.name())));
		}
	}
}
