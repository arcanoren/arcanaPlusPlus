package net.arcano.arcana2plus.recipes;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class APPRecipeManager {

    public static List<String> BLOCK_LIST = new ArrayList<>();
    public static JsonObject BLOCK = null;

    public static void addBlockToRecipe(String recipe){
        BLOCK_LIST.add("stone");
        BLOCK_LIST.add("cobblestone");
        BLOCK_LIST.add("mossy_cobblestone");
        BLOCK_LIST.add("mossy_stone_bricks");
        BLOCK_LIST.add("andesite");
        BLOCK_LIST.add("polished_andesite");
        BLOCK_LIST.add("diorite");
        BLOCK_LIST.add("polished_diorite");
        BLOCK_LIST.add("granite");
        BLOCK_LIST.add("polished_granite");
        BLOCK_LIST.add("smooth_sandstone");
        BLOCK_LIST.add("smooth_red_sandstone");
        BLOCK_LIST.add("bricks");

        BLOCK_LIST.add("prismarine");
        BLOCK_LIST.add("prismarine_bricks");
        BLOCK_LIST.add("dark_prismarine");

        BLOCK_LIST.add("red_nether_bricks");
        BLOCK_LIST.add("smooth_quartz");

        BLOCK_LIST.add("end_stone_bricks");

        BLOCK_LIST.add("blackstone");
        BLOCK_LIST.add("polished_blackstone_bricks");

        BLOCK_LIST.add("cut_copper");
        BLOCK_LIST.add("exposed_cut_copper");
        BLOCK_LIST.add("weathered_cut_copper");
        BLOCK_LIST.add("oxidized_cut_copper");
        BLOCK_LIST.add("waxed_cut_copper");
        BLOCK_LIST.add("waxed_exposed_cut_copper");
        BLOCK_LIST.add("waxed_weathered_cut_copper");
        BLOCK_LIST.add("waxed_oxidized_cut_copper");

        BLOCK_LIST.add("polished_deepslate");
        BLOCK_LIST.add("deepslate_bricks");
        BLOCK_LIST.add("deepslate_tiles");

        BLOCK_LIST.add("oak_planks");
        BLOCK_LIST.add("spruce_planks");
        BLOCK_LIST.add("birch_planks");
        BLOCK_LIST.add("jungle_planks");
        BLOCK_LIST.add("acacia_planks");
        BLOCK_LIST.add("dark_oak_planks");
        BLOCK_LIST.add("crimson_planks");
        BLOCK_LIST.add("warped_planks");
        BLOCK_LIST.add("stone_bricks");

        //Don't used by slabs
        BLOCK_LIST.add("cobbled_deepslate");
        BLOCK_LIST.add("polished_blackstone");
        BLOCK_LIST.add("purpur_block");
        BLOCK_LIST.add("quartz_block");
        BLOCK_LIST.add("nether_bricks");
        BLOCK_LIST.add("red_sandstone");
        BLOCK_LIST.add("sandstone");

        //Don't used by stairs
        BLOCK_LIST.add("smooth_stone");
        BLOCK_LIST.add("cut_sandstone");
        BLOCK_LIST.add("cut_red_sandstone");
    }

    public static void addSlabToBlock(Map<Identifier, JsonElement> map){
        newBlockRecipe(
                Lists.newArrayList(
                        "#",
                        "#",
                        " "),
                map, "slab", 1);
    }

    public static void addStairsToBlock(Map<Identifier, JsonElement> map){
        newBlockRecipe(
                Lists.newArrayList(
                        "##",
                        "##",
                        "  "),
                map, "stairs", 3);
    }

    public static void newBlockRecipe(ArrayList<String> pattern, Map<Identifier, JsonElement> map, String blockModel, int outputCount){

        if(BLOCK_LIST.isEmpty()){
            addBlockToRecipe(blockModel);
        }

        for(String block : BLOCK_LIST){
            BLOCK = createShaped(
                    pattern,
                    Lists.newArrayList('#'),
                    Lists.newArrayList("item"),
                    Lists.newArrayList(new Identifier("minecraft",
                            block
                                    .replace("_planks", "")
                                    .replace("bricks", "brick")
                                    .replace("_block", "")
                                    .replace("tiles", "tile")
                                    + "_" + blockModel)),
                    new Identifier(block),
                    outputCount
            );

            if(blockModel == "slab"){
                if(!block.contains("stone_bricks") && !block.contains("cobbled_deepslate") && !block.contains("polished_blackstone")
                        && !block.contains("purpur_block") && !block.contains("quartz_block") && !block.contains("nether_bricks")
                        && !block.contains("red_sandstone") && !block.contains("sandstone")){

                    map.put(new Identifier("minecraft", block + "_" + blockModel +"_to_block"), BLOCK);
                    System.out.println("Inserido " + block + " " + blockModel);

                }
            }else if(blockModel == "stairs"){
                if(!block.contains("smooth_stone") && !block.contains("cut_sandstone") && !block.contains("cut_red_sandstone")){

                    map.put(new Identifier("minecraft", block + "_" + blockModel +"_to_block"), BLOCK);
                    System.out.println("Inserido " + block + " " + blockModel);

                }
            }
        }
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
