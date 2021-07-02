package net.arcano.arcana2plus.recipes;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class APPRecipeManager {

    public static List<String> SLABS = new ArrayList<>();
    public static JsonObject BLOCK = null;

    public static void addSlabType(){
        SLABS.add("stone");
        SLABS.add("smooth_stone");
        SLABS.add("cobblestone");
        SLABS.add("mossy_cobblestone");
        //SLABS.add("stone_bricks");
        SLABS.add("mossy_stone_bricks");
        SLABS.add("andesite");
        SLABS.add("polished_andesite");
        SLABS.add("diorite");
        SLABS.add("polished_diorite");
        SLABS.add("granite");
        SLABS.add("polished_granite");
        //SLABS.add("sandstone");
        SLABS.add("cut_sandstone");
        SLABS.add("smooth_sandstone");
        //SLABS.add("red_sandstone");
        SLABS.add("cut_red_sandstone");
        SLABS.add("smooth_red_sandstone");
        SLABS.add("bricks");
        SLABS.add("prismarine");
        SLABS.add("prismarine_bricks");
        SLABS.add("dark_prismarine");
        //SLABS.add("nether_bricks");
        SLABS.add("red_nether_bricks");
        //SLABS.add("quartz_block");
        SLABS.add("smooth_quartz");
        //SLABS.add("purpur_block");
        SLABS.add("end_stone_bricks");
        SLABS.add("blackstone");
        //SLABS.add("polished_blackstone");
        SLABS.add("polished_blackstone_bricks");
        SLABS.add("cut_copper");
        SLABS.add("exposed_cut_copper");
        SLABS.add("weathered_cut_copper");
        SLABS.add("oxidized_cut_copper");
        SLABS.add("waxed_cut_copper");
        SLABS.add("waxed_exposed_cut_copper");
        SLABS.add("waxed_weathered_cut_copper");
        SLABS.add("waxed_oxidized_cut_copper");
        //SLABS.add("cobbled_deepslate");
        SLABS.add("polished_deepslate");
        SLABS.add("deepslate_bricks");
        SLABS.add("deepslate_tiles");
        SLABS.add("oak_planks");
        SLABS.add("spruce_planks");
        SLABS.add("birch_planks");
        SLABS.add("jungle_planks");
        SLABS.add("acacia_planks");
        SLABS.add("dark_oak_planks");
        SLABS.add("crimson_planks");
        SLABS.add("warped_planks");
    }

    public static void slabsToBlock(String block){
        BLOCK = createShaped(
                Lists.newArrayList(
                        "#",
                        "#",
                        " "),
                Lists.newArrayList('#'),
                Lists.newArrayList("item"),
                Lists.newArrayList(new Identifier("minecraft",
                        block
                                .replace("_planks", "")
                                .replace("bricks", "brick")
                                .replace("block", "")
                                .replace("tiles", "tile")
                                + "_slab")),
                new Identifier(block),
                1
        );
    }

    public static JsonObject createShaped(ArrayList<String> pattern, ArrayList<Character> keys, ArrayList<String> type,
                                          ArrayList<Identifier> items, Identifier output, int outputCount){
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shaped");

        JsonArray jsonArray = new JsonArray();
        jsonArray.add(pattern.get(0));
        jsonArray.add(pattern.get(1));
        jsonArray.add(pattern.get(2));

        json.add("pattern", jsonArray);

        JsonObject individualKey;
        JsonObject keyList = new JsonObject();

        for(int i = 0; i < keys.size(); i++){
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), items.get(i).toString());
            keyList.add(keys.get(i) + "", individualKey);
        }

        json.add("key", keyList);

        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", outputCount);
        json.add("result", result);

        return json;
    }
}
