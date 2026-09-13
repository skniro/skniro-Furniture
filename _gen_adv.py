# -*- coding: utf-8 -*-
"""One-off generator for Skniro Furniture advancements + item tags + lang entries."""
import json
import os
import re

ROOT = os.path.dirname(os.path.abspath(__file__))
NS = "skniro_furniture"
LOADERS = ["Fabric", "Forge", "Neoforge"]

ITEMS_DIR = os.path.join(ROOT, "Neoforge", "src", "main", "resources", "assets", NS, "items")
ITEM_IDS = sorted(f[:-5] for f in os.listdir(ITEMS_DIR) if f.endswith(".json"))
ITEM_SET = set(ITEM_IDS)

# ---------------------------------------------------------------- item tags
# name -> regex matched against the item id (None = every item)
TAG_PATTERNS = {
    "furniture": None,                                  # every item

    # 家具入门
    "cushions": r"cushion",
    "chairs": r"_chair$",                               # excludes coffee chairs
    "coffee_chairs": r"coffee_chair",
    "sofas": r"sofa",

    # 木工基础
    "plank_tables": r"^(?!.*(?:end|coffee|glass)_table$).*_table$",
    "coffee_tables": r"coffee_table",
    "end_tables": r"end_table",
    "glass_tables": r"glass_table",
    "book_desks": r"book_desk",
    "bedside_cabinets": r"bedside_cabinet",
    "desk_cabinets": r"desk_cabinet",

    # 厨房初学者
    "counters": r"kitchen_counter$",                    # excludes counter drawers
    "counter_drawers": r"kitchen_counter_drawer",
    "kitchen_cabinets": r"kitchen_cabinet",
    "sinks": r"kitchen_sink",
    "ovens": r"oven",
    "fridges": r"fridge",

    # 收纳大师
    "triple_cabinets": r"_(?:plank|wood)_triple_cabinet$",
    "four_grid_cabinets": r"_(?:plank|wood)_four_grid_cabinet$",
    "glass_door_triple_cabinets": r"double_glass_doors_triple_cabinet",
    "glass_door_four_grid_cabinets": r"double_glass_doors_four_grid_cabinet",
    "wall_cabinets": r"wall_cabinet",

    # 卧室布置
    "beds": r"_bed$",
    "curtains": r"wood_divider",

    # 窗与门
    "windows": r"_window$",                             # excludes style 2
    "windows_style2": r"window_style2",
    "paper_sliding_doors": r"paper_sliding_door",
    "grid_glass_sliding_doors": r"grid_glass_sliding_door",
    "glass_sliding_doors": r"(?<!grid_)glass_sliding_door",

    # 客厅布置
    "tv_stands": r"tv_stand",
    "tvs": r"_tv$",                                     # excludes tv stands

    # 装饰艺术
    "plates": r"_plate$",
    "ceiling_lamps": r"ceiling_lamp",
    "animal_paintings": r"_draw$",
}

# tags that no longer exist and must be removed from every loader
OBSOLETE_TAGS = [
    "tables", "cabinets", "drawers", "lamps", "doors",
    "bookshelves", "teddy_bears",
]


def tag_members(pattern):
    if pattern is None:
        return list(ITEM_IDS)
    rx = re.compile(pattern)
    return [i for i in ITEM_IDS if rx.search(i)]


# ------------------------------------------------------------ advancements
def inv(tags):
    """inventory_changed criterion condition for one or more item tags (OR)."""
    return {"trigger": "minecraft:inventory_changed",
            "conditions": {"items": [{"items": "#%s:%s" % (NS, t)} for t in tags]}}


# (file, parent, frame, icon, criteria)  criteria: list of (name, [tags])
ADVANCEMENTS = [
    # root
    ("furnishing", None, "task", "acacia_plank_chair",
     [("get_furniture", ["furniture"])]),

    # 家具入门
    ("furniture_intro", "furnishing", "goal", "acacia_plank_chair",
     [("get_cushion", ["cushions"]),
      ("get_chair", ["chairs"]),
      ("get_coffee_chair", ["coffee_chairs"]),
      ("get_sofa", ["sofas"])]),
    ("cushion", "furniture_intro", "task", "acacia_black_cushion",
     [("get_cushion", ["cushions"])]),
    ("chair", "furniture_intro", "task", "acacia_plank_chair",
     [("get_chair", ["chairs"])]),
    ("coffee_chair", "furniture_intro", "task", "acacia_plank_coffee_chair_black",
     [("get_coffee_chair", ["coffee_chairs"])]),
    ("sofa", "furniture_intro", "task", "black_sofa",
     [("get_sofa", ["sofas"])]),

    # 木工基础
    ("carpentry_basics", "furnishing", "goal", "acacia_table",
     [("get_plank_table", ["plank_tables"]),
      ("get_coffee_table", ["coffee_tables"]),
      ("get_end_table", ["end_tables"]),
      ("get_glass_table", ["glass_tables"]),
      ("get_book_desk", ["book_desks"]),
      ("get_bedside_cabinet", ["bedside_cabinets"]),
      ("get_desk_cabinet", ["desk_cabinets"])]),
    ("plank_table", "carpentry_basics", "task", "acacia_table",
     [("get_plank_table", ["plank_tables"])]),
    ("coffee_table", "carpentry_basics", "task", "acacia_plank_coffee_table",
     [("get_coffee_table", ["coffee_tables"])]),
    ("end_table", "carpentry_basics", "task", "acacia_end_table",
     [("get_end_table", ["end_tables"])]),
    ("glass_table", "carpentry_basics", "task", "acacia_plank_glass_table",
     [("get_glass_table", ["glass_tables"])]),
    ("book_desk", "carpentry_basics", "task", "acacia_planks_book_desk",
     [("get_book_desk", ["book_desks"])]),
    ("bedside_cabinet", "carpentry_basics", "task", "acacia_planks_bedside_cabinet",
     [("get_bedside_cabinet", ["bedside_cabinets"])]),
    ("desk_cabinet", "carpentry_basics", "task", "acacia_planks_desk_cabinet",
     [("get_desk_cabinet", ["desk_cabinets"])]),

    # 厨房初学者
    ("kitchen_beginner", "furnishing", "goal", "black_kitchen_counter",
     [("get_counter", ["counters"]),
      ("get_counter_drawer", ["counter_drawers"]),
      ("get_kitchen_cabinet", ["kitchen_cabinets"]),
      ("get_sink", ["sinks"]),
      ("get_oven", ["ovens"]),
      ("get_fridge", ["fridges"])]),
    ("kitchen_counter", "kitchen_beginner", "task", "black_kitchen_counter",
     [("get_counter", ["counters"])]),
    ("kitchen_counter_drawer", "kitchen_beginner", "task", "black_kitchen_counter_drawer",
     [("get_counter_drawer", ["counter_drawers"])]),
    ("kitchen_cabinet", "kitchen_beginner", "task", "black_kitchen_cabinet",
     [("get_kitchen_cabinet", ["kitchen_cabinets"])]),
    ("sink", "kitchen_beginner", "task", "black_kitchen_sink",
     [("get_sink", ["sinks"])]),
    ("oven", "kitchen_beginner", "task", "black_oven",
     [("get_oven", ["ovens"])]),
    ("fridge", "kitchen_beginner", "task", "black_fridge",
     [("get_fridge", ["fridges"])]),

    # 收纳大师
    ("storage_master", "furnishing", "goal", "acacia_plank_triple_cabinet",
     [("get_triple_cabinet", ["triple_cabinets"]),
      ("get_glass_door_triple_cabinet", ["glass_door_triple_cabinets"]),
      ("get_four_grid_cabinet", ["four_grid_cabinets"]),
      ("get_glass_door_four_grid_cabinet", ["glass_door_four_grid_cabinets"]),
      ("get_wall_cabinet", ["wall_cabinets"])]),
    ("triple_cabinet", "storage_master", "task", "acacia_plank_triple_cabinet",
     [("get_triple_cabinet", ["triple_cabinets"])]),
    ("glass_door_triple_cabinet", "triple_cabinet", "task",
     "acacia_plank_double_glass_doors_triple_cabinet",
     [("get_glass_door_triple_cabinet", ["glass_door_triple_cabinets"])]),
    ("four_grid_cabinet", "storage_master", "task", "acacia_plank_four_grid_cabinet",
     [("get_four_grid_cabinet", ["four_grid_cabinets"])]),
    ("glass_door_four_grid_cabinet", "four_grid_cabinet", "task",
     "acacia_plank_double_glass_doors_four_grid_cabinet",
     [("get_glass_door_four_grid_cabinet", ["glass_door_four_grid_cabinets"])]),
    ("wall_cabinet", "storage_master", "task", "acacia_plank_wall_cabinet",
     [("get_wall_cabinet", ["wall_cabinets"])]),

    # 卧室布置
    ("bedroom_setup", "furnishing", "goal", "acacia_red_wood_bed",
     [("get_bed", ["beds"]),
      ("get_bedside_cabinet", ["bedside_cabinets"]),
      ("get_curtain", ["curtains"]),
      ("get_cushion", ["cushions"])]),
    ("bed", "bedroom_setup", "task", "acacia_red_wood_bed",
     [("get_bed", ["beds"])]),
    ("curtain", "bedroom_setup", "task", "black_wood_divider",
     [("get_curtain", ["curtains"])]),

    # 窗与门
    ("windows_and_doors", "furnishing", "goal", "acacia_plank_window",
     [("get_window", ["windows"]),
      ("get_window_style2", ["windows_style2"]),
      ("get_paper_sliding_door", ["paper_sliding_doors"]),
      ("get_grid_glass_sliding_door", ["grid_glass_sliding_doors"]),
      ("get_glass_sliding_door", ["glass_sliding_doors"])]),
    ("window", "windows_and_doors", "task", "acacia_plank_window",
     [("get_window", ["windows"])]),
    ("window_style2", "windows_and_doors", "task", "acacia_plank_window_style2",
     [("get_window_style2", ["windows_style2"])]),
    ("paper_sliding_door", "windows_and_doors", "task", "acacia_black_paper_sliding_door",
     [("get_paper_sliding_door", ["paper_sliding_doors"])]),
    ("grid_glass_sliding_door", "windows_and_doors", "task",
     "acacia_black_grid_glass_sliding_door",
     [("get_grid_glass_sliding_door", ["grid_glass_sliding_doors"])]),
    ("glass_sliding_door", "windows_and_doors", "task", "acacia_black_glass_sliding_door",
     [("get_glass_sliding_door", ["glass_sliding_doors"])]),

    # 客厅布置
    ("living_room_setup", "furnishing", "goal", "black_sofa",
     [("get_sofa", ["sofas"]),
      ("get_end_table", ["end_tables"]),
      ("get_tv_stand", ["tv_stands"]),
      ("get_tv", ["tvs"])]),
    ("tv_stand", "living_room_setup", "task", "acacia_planks_tv_stand",
     [("get_tv_stand", ["tv_stands"])]),
    ("tv", "living_room_setup", "task", "acacia_planks_tv",
     [("get_tv", ["tvs"])]),

    # 装饰艺术
    ("decorative_art", "furnishing", "goal", "black_ceiling_lamp",
     [("get_plate", ["plates"]),
      ("get_ceiling_lamp", ["ceiling_lamps"]),
      ("get_animal_painting", ["animal_paintings"])]),
    ("plate", "decorative_art", "task", "acacia_plank_plate",
     [("get_plate", ["plates"])]),
    ("ceiling_lamp", "decorative_art", "task", "black_ceiling_lamp",
     [("get_ceiling_lamp", ["ceiling_lamps"])]),
    ("animal_painting", "decorative_art", "task", "acacia_allay_draw",
     [("get_animal_painting", ["animal_paintings"])]),

    # 挑战
    ("furniture_collector", "furnishing", "challenge", "acacia_bookshelf",
     [("get_basics", ["cushions", "chairs", "coffee_chairs", "sofas"]),
      ("get_carpentry", ["plank_tables", "coffee_tables", "end_tables", "glass_tables",
                         "book_desks", "bedside_cabinets", "desk_cabinets"]),
      ("get_kitchen", ["counters", "counter_drawers", "kitchen_cabinets",
                       "sinks", "ovens", "fridges"]),
      ("get_storage", ["triple_cabinets", "four_grid_cabinets",
                       "glass_door_triple_cabinets", "glass_door_four_grid_cabinets",
                       "wall_cabinets"]),
      ("get_bedroom", ["beds", "bedside_cabinets", "curtains", "cushions"]),
      ("get_windows_doors", ["windows", "windows_style2", "paper_sliding_doors",
                             "grid_glass_sliding_doors", "glass_sliding_doors"]),
      ("get_living_room", ["sofas", "end_tables", "tv_stands", "tvs"]),
      ("get_decorative", ["plates", "ceiling_lamps", "animal_paintings"])]),

    ("interior_design_master", "furnishing", "challenge", "acacia_planks_kitchen_sink",
     [("get_kitchen_counter", ["counters"]),
      ("get_kitchen_cabinet", ["kitchen_cabinets"]),
      ("get_sink", ["sinks"]),
      ("get_oven", ["ovens"]),
      ("get_fridge", ["fridges"]),
      ("get_bed", ["beds"]),
      ("get_bedside_cabinet", ["bedside_cabinets"]),
      ("get_curtain", ["curtains"]),
      ("get_cushion", ["cushions"]),
      ("get_sofa", ["sofas"]),
      ("get_end_table", ["end_tables"]),
      ("get_tv_stand", ["tv_stands"]),
      ("get_tv", ["tvs"])]),

    ("furniture_tycoon", "furnishing", "challenge", "acacia_planks_book_desk",
     [("get_cushion", ["cushions"]),
      ("get_chair", ["chairs"]),
      ("get_coffee_chair", ["coffee_chairs"]),
      ("get_sofa", ["sofas"]),
      ("get_plank_table", ["plank_tables"]),
      ("get_coffee_table", ["coffee_tables"]),
      ("get_end_table", ["end_tables"]),
      ("get_glass_table", ["glass_tables"]),
      ("get_book_desk", ["book_desks"]),
      ("get_bedside_cabinet", ["bedside_cabinets"]),
      ("get_desk_cabinet", ["desk_cabinets"]),
      ("get_counter", ["counters"]),
      ("get_counter_drawer", ["counter_drawers"]),
      ("get_kitchen_cabinet", ["kitchen_cabinets"]),
      ("get_sink", ["sinks"]),
      ("get_oven", ["ovens"]),
      ("get_fridge", ["fridges"]),
      ("get_triple_cabinet", ["triple_cabinets"]),
      ("get_four_grid_cabinet", ["four_grid_cabinets"]),
      ("get_glass_door_triple_cabinet", ["glass_door_triple_cabinets"]),
      ("get_glass_door_four_grid_cabinet", ["glass_door_four_grid_cabinets"]),
      ("get_wall_cabinet", ["wall_cabinets"]),
      ("get_bed", ["beds"]),
      ("get_curtain", ["curtains"]),
      ("get_window", ["windows"]),
      ("get_window_style2", ["windows_style2"]),
      ("get_paper_sliding_door", ["paper_sliding_doors"]),
      ("get_grid_glass_sliding_door", ["grid_glass_sliding_doors"]),
      ("get_glass_sliding_door", ["glass_sliding_doors"]),
      ("get_tv_stand", ["tv_stands"]),
      ("get_tv", ["tvs"]),
      ("get_plate", ["plates"]),
      ("get_ceiling_lamp", ["ceiling_lamps"]),
      ("get_animal_painting", ["animal_paintings"])]),
]

LANG = {
    "en_us": {
        "furnishing": ("Furnishing Time", "Obtain any piece of Skniro Furniture"),
        "furniture_intro": ("Furniture Basics",
                            "Collect a cushion, a chair, a coffee chair and a sofa"),
        "cushion": ("Cushion", "Obtain a cushion"),
        "chair": ("Chair", "Obtain a chair"),
        "coffee_chair": ("Coffee Chair", "Obtain a coffee chair"),
        "sofa": ("Sofa", "Obtain a sofa"),
        "carpentry_basics": ("Carpentry Basics",
                             "Collect every kind of table, desk and cabinet"),
        "plank_table": ("Plank Table", "Obtain a plank table"),
        "coffee_table": ("Coffee Table", "Obtain a coffee table"),
        "end_table": ("End Table", "Obtain an end table"),
        "glass_table": ("Glass Table", "Obtain a glass table"),
        "book_desk": ("Book Desk", "Obtain a book desk"),
        "bedside_cabinet": ("Bedside Cabinet", "Obtain a bedside cabinet"),
        "desk_cabinet": ("Desk Cabinet", "Obtain a desk cabinet"),
        "kitchen_beginner": ("Kitchen Beginner",
                             "Collect a counter, a counter drawer, a kitchen cabinet, "
                             "a sink, an oven and a fridge"),
        "kitchen_counter": ("Kitchen Counter", "Obtain a kitchen counter"),
        "kitchen_counter_drawer": ("Kitchen Counter Drawer",
                                   "Obtain a kitchen counter drawer"),
        "kitchen_cabinet": ("Kitchen Cabinet", "Obtain a kitchen cabinet"),
        "sink": ("Kitchen Sink", "Obtain a kitchen sink"),
        "oven": ("Oven", "Obtain an oven"),
        "fridge": ("Fridge", "Obtain a fridge"),
        "storage_master": ("Storage Master", "Collect every kind of cabinet"),
        "triple_cabinet": ("Triple Cabinet", "Obtain a triple cabinet"),
        "four_grid_cabinet": ("Four Grid Cabinet", "Obtain a four grid cabinet"),
        "glass_door_triple_cabinet": ("Glass Door Triple Cabinet",
                                      "Obtain a glass door triple cabinet"),
        "glass_door_four_grid_cabinet": ("Glass Door Four Grid Cabinet",
                                         "Obtain a glass door four grid cabinet"),
        "wall_cabinet": ("Wall Cabinet", "Obtain a wall cabinet"),
        "bedroom_setup": ("Bedroom Setup",
                          "Collect a bed, a bedside cabinet, a curtain and a cushion"),
        "bed": ("Bed", "Obtain a furniture bed"),
        "curtain": ("Curtain", "Obtain a curtain"),
        "windows_and_doors": ("Windows and Doors",
                              "Collect every kind of window and sliding door"),
        "window": ("Window", "Obtain a window"),
        "window_style2": ("Wood Window (Style 2)", "Obtain a style 2 wood window"),
        "paper_sliding_door": ("Paper Sliding Door", "Obtain a paper sliding door"),
        "grid_glass_sliding_door": ("Grid Glass Sliding Door",
                                    "Obtain a grid glass sliding door"),
        "glass_sliding_door": ("Glass Sliding Door", "Obtain a glass sliding door"),
        "living_room_setup": ("Living Room Setup",
                              "Collect a sofa, an end table, a TV stand and a TV"),
        "tv_stand": ("TV Stand", "Obtain a TV stand"),
        "tv": ("TV", "Obtain a TV"),
        "decorative_art": ("Decorative Art",
                           "Collect a plate, a ceiling lamp and an animal painting"),
        "plate": ("Plate", "Obtain a plate"),
        "ceiling_lamp": ("Ceiling Lamp", "Obtain a ceiling lamp"),
        "animal_painting": ("Animal Painting", "Obtain an animal painting"),
        "furniture_collector": ("Furniture Collector",
                                "Collect one piece from every furniture category"),
        "interior_design_master": ("Interior Design Master",
                                   "Furnish a complete kitchen, bedroom and living room"),
        "furniture_tycoon": ("Furniture Tycoon",
                             "Collect one piece of every kind of furniture"),
    },
    "zh_cn": {
        "furnishing": ("开始布置", "获得任意一件 Skniro 家具"),
        "furniture_intro": ("家具入门", "获得坐垫、椅子、咖啡椅和沙发各一件"),
        "cushion": ("坐垫", "获得一个坐垫"),
        "chair": ("椅子", "获得一把椅子"),
        "coffee_chair": ("咖啡椅", "获得一把咖啡椅"),
        "sofa": ("沙发", "获得一张沙发"),
        "carpentry_basics": ("木工基础", "集齐各种桌子、书桌和柜子"),
        "plank_table": ("木板桌", "获得一张木板桌"),
        "coffee_table": ("咖啡桌", "获得一张咖啡桌"),
        "end_table": ("茶几", "获得一张茶几"),
        "glass_table": ("玻璃桌", "获得一张玻璃桌"),
        "book_desk": ("书桌", "获得一张书桌"),
        "bedside_cabinet": ("床头柜", "获得一个床头柜"),
        "desk_cabinet": ("桌柜", "获得一个桌柜"),
        "kitchen_beginner": ("厨房初学者", "集齐操作台、操作台抽屉、厨柜、水槽、烤箱和冰箱"),
        "kitchen_counter": ("厨房柜台", "获得一个厨房柜台"),
        "kitchen_counter_drawer": ("厨房柜台抽屉", "获得一个厨房柜台抽屉"),
        "kitchen_cabinet": ("厨柜", "获得一个厨柜"),
        "sink": ("水槽", "获得一个水槽"),
        "oven": ("烤箱", "获得一台烤箱"),
        "fridge": ("冰箱", "获得一台冰箱"),
        "storage_master": ("收纳大师", "集齐各种柜子"),
        "triple_cabinet": ("三格柜", "获得一个三格柜"),
        "four_grid_cabinet": ("四格柜", "获得一个四格柜"),
        "glass_door_triple_cabinet": ("玻璃门三格柜", "获得一个玻璃门三格柜"),
        "glass_door_four_grid_cabinet": ("玻璃门四格柜", "获得一个玻璃门四格柜"),
        "wall_cabinet": ("壁柜", "获得一个壁柜"),
        "bedroom_setup": ("卧室布置", "集齐床、床头柜、布帘和坐垫"),
        "bed": ("床", "获得一张家具床"),
        "curtain": ("布帘", "获得一个布帘"),
        "windows_and_doors": ("窗与门", "集齐各种窗户和滑动门"),
        "window": ("窗", "获得一扇窗户"),
        "window_style2": ("木窗（样式2）", "获得一扇样式2木窗"),
        "paper_sliding_door": ("纸拉门", "获得一扇纸拉门"),
        "grid_glass_sliding_door": ("网格滑动门", "获得一扇网格滑动门"),
        "glass_sliding_door": ("玻璃滑动门", "获得一扇玻璃滑动门"),
        "living_room_setup": ("客厅布置", "集齐沙发、茶几、电视柜和电视"),
        "tv_stand": ("电视柜", "获得一个电视柜"),
        "tv": ("电视", "获得一台电视"),
        "decorative_art": ("装饰艺术", "集齐盘子、天花板灯和动物画"),
        "plate": ("盘子", "获得一个盘子"),
        "ceiling_lamp": ("天花板灯", "获得一盏天花板灯"),
        "animal_painting": ("动物画", "获得一幅动物画"),
        "furniture_collector": ("家具收藏家", "集齐每个家具类别各一件"),
        "interior_design_master": ("室内设计大师", "同时布置完整的厨房、卧室与客厅家具"),
        "furniture_tycoon": ("家具大亨", "集齐每一种家具各一件"),
    },
}


def lang_paths():
    """Return {locale: [paths]} for each loader."""
    out = {"en_us": [], "zh_cn": []}
    for loader in LOADERS:
        if loader == "Fabric":
            base = os.path.join(ROOT, "Fabric", "src", "main", "generated",
                                "assets", NS, "lang")
        else:
            base = os.path.join(ROOT, loader, "src", "main", "resources",
                                "assets", NS, "lang")
        for loc in out:
            out[loc].append(os.path.join(base, loc + ".json"))
    return out


def data_dir(loader):
    return os.path.join(ROOT, loader, "src", "main", "resources", "data", NS)


def adv_dir(loader):
    """Fabric advancements live in the datagen output; the others are resources."""
    if loader == "Fabric":
        return os.path.join(ROOT, "Fabric", "src", "main", "generated", "data", NS, "advancement")
    return os.path.join(data_dir(loader), "advancement")


def write_json(path, obj):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(obj, f, indent=2, ensure_ascii=False)
        f.write("\n")


def build_advancement(name, parent, frame, icon, criteria, is_fabric):
    """is_fabric=True emits the datagen (generated) shape; otherwise the resource shape."""
    display = {
        "icon": {"id": "%s:%s" % (NS, icon)},
        "title": {"translate": "advancements.%s.%s.title" % (NS, name)},
        "description": {"translate": "advancements.%s.%s.description" % (NS, name)},
    }
    if not is_fabric or frame != "task":
        display["frame"] = frame
    if not is_fabric:
        display["show_toast"] = True
        display["announce_to_chat"] = True
        display["hidden"] = False
    if parent is None:
        display["background"] = "%s:block/bookshelf" % NS

    adv = {"display": display,
           "criteria": {cname: inv(tags) for cname, tags in criteria}}
    if parent is not None:
        adv["parent"] = "%s:%s" % (NS, parent)
    if is_fabric:
        adv["requirements"] = [[cname] for cname, _ in criteria]
        adv["sends_telemetry_event"] = True
    return adv


def main():
    # --- sanity: icons exist / tags non-empty / parents resolvable
    names = {a[0] for a in ADVANCEMENTS}
    for name, parent, frame, icon, crit in ADVANCEMENTS:
        assert icon in ITEM_SET, "missing icon item: %s" % icon
        assert parent is None or parent in names, "missing parent %s for %s" % (parent, name)
        for cname, tags in crit:
            for t in tags:
                assert t in TAG_PATTERNS, "unknown tag %s in %s" % (t, name)
    assert set(LANG["en_us"]) == names, "en_us lang names mismatch"
    assert set(LANG["zh_cn"]) == names, "zh_cn lang names mismatch"

    # --- item tags
    tag_counts = {}
    for tag, pattern in TAG_PATTERNS.items():
        members = tag_members(pattern)
        assert members, "empty tag %s" % tag
        tag_counts[tag] = len(members)
        body = {"values": ["%s:%s" % (NS, m) for m in members]}
        for loader in LOADERS:
            write_json(os.path.join(data_dir(loader), "tags", "item", tag + ".json"), body)

    # --- remove obsolete tags from every loader
    for tag in OBSOLETE_TAGS:
        for loader in LOADERS:
            path = os.path.join(data_dir(loader), "tags", "item", tag + ".json")
            if os.path.exists(path):
                os.remove(path)

    # --- advancements
    for name, parent, frame, icon, crit in ADVANCEMENTS:
        for loader in LOADERS:
            adv = build_advancement(name, parent, frame, icon, crit, loader == "Fabric")
            write_json(os.path.join(adv_dir(loader), name + ".json"), adv)

    # --- lang
    for loc, paths in lang_paths().items():
        valid = set(LANG[loc])
        prefix = "advancements.%s." % NS
        for path in paths:
            with open(path, encoding="utf-8") as f:
                data = json.load(f)
            for key in [k for k in data if k.startswith(prefix)]:
                if key[len(prefix):].rsplit(".", 1)[0] not in valid:
                    del data[key]
            for name, (title, desc) in LANG[loc].items():
                data["advancements.%s.%s.title" % (NS, name)] = title
                data["advancements.%s.%s.description" % (NS, name)] = desc
            ordered = {k: data[k] for k in sorted(data)}
            with open(path, "w", encoding="utf-8") as f:
                json.dump(ordered, f, indent=2, ensure_ascii=False)
                f.write("\n")

    print("items:", len(ITEM_IDS))
    print("tags:", len(TAG_PATTERNS), tag_counts)
    print("advancements:", len(ADVANCEMENTS))


if __name__ == "__main__":
    main()
