package net.arcano.arcana2plus.items;

import net.arcano.arcana2plus.Arcana2Plus;
import net.arcano.arcana2plus.blocks.APPBlocks;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class APPItems {
    //items
    public static final Item COAL_NUGGET = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CHARCOAL_NUGGET = new Item(new Item.Settings().group(ItemGroup.MISC));

    //shears
    public static final Item FLINT_SHEARS = new APPShears(new Item.Settings().maxDamage(16).group(ItemGroup.TOOLS));
    public static final Item BONE_SHEARS = new APPShears(new Item.Settings().maxDamage(32).group(ItemGroup.TOOLS));
    public static final Item GOLDEN_SHEARS = new APPShears(new Item.Settings().maxDamage(64).group(ItemGroup.TOOLS));
    public static final Item COPPER_SHEARS = new APPShears(new Item.Settings().maxDamage(128).group(ItemGroup.TOOLS));
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

    public static void registerItems(){
        //items
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "coal_nugget"), COAL_NUGGET);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "charcoal_nugget"), CHARCOAL_NUGGET);

        //Foods
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "guava"), GUAVA);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "hazelnut"), HAZELNUT);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "mango"), MANGO);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "peach"), PEACH);

        //Tools
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "flint_shears"), FLINT_SHEARS);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "bone_shears"), BONE_SHEARS);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "golden_shears"), GOLDEN_SHEARS);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "copper_shears"), COPPER_SHEARS);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "diamond_shears"), DIAMOND_SHEARS);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "netherite_shears"), NETHERITE_SHEARS);

        //block items
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "charcoal_block"), CHARCOAL_BLOCK);

        //fuels
        FuelRegistry.INSTANCE.add(APPItems.COAL_NUGGET, 200);
        FuelRegistry.INSTANCE.add(APPItems.CHARCOAL_NUGGET, 200);
        FuelRegistry.INSTANCE.add(APPItems.CHARCOAL_BLOCK, 16000);
    }
}
