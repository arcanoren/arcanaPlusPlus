package net.arcano.arcana2plus.items;

import net.arcano.arcana2plus.blocks.APPBlocks;
import net.minecraft.item.*;

public class APPItems {
    //items
    public static final Item COAL_NUGGET = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CHARCOAL_NUGGET = new Item(new Item.Settings().group(ItemGroup.MISC));

    //shears
    public static final Item FLINT_SHEARS = new APPShears(new Item.Settings().maxDamage(16).group(ItemGroup.TOOLS));
    public static final Item GOLDEN_SHEARS = new APPShears(new Item.Settings().maxDamage(64).group(ItemGroup.TOOLS));
    public static final Item DIAMOND_SHEARS = new APPShears(new Item.Settings().maxDamage(1024).group(ItemGroup.TOOLS));
    public static final Item NETHERITE_SHEARS = new APPShears(new Item.Settings().maxDamage(1536).group(ItemGroup.TOOLS));

    //food
    public static final Item GUAVA = new Item(new Item.Settings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(2.2F).build()));
    public static final Item HAZELNUT = new Item(new Item.Settings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(1.4F).build()));
    public static final Item MANGO = new Item(new Item.Settings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(2.7F).build()));
    public static final Item PEACH = new Item(new Item.Settings().group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(2.0F).build()));

    //block items
    public static final Item CHARCOAL_BLOCK = new BlockItem(APPBlocks.CHARCOAL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
}
