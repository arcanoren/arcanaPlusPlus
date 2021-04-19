package net.arcano.arcana2plus.items;

import net.arcano.arcana2plus.blocks.APPBlocks;
import net.minecraft.item.*;

public class APPItems {
    //block items
    public static final Item COAL_NUGGET = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CHARCOAL_NUGGET = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item FLINT_SHEARS = new APPShears(new Item.Settings().maxDamage(16).group(ItemGroup.TOOLS));

    //block items
    public static final Item CHARCOAL_BLOCK = new BlockItem(APPBlocks.CHARCOAL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
}
