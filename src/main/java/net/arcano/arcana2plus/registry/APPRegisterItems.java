package net.arcano.arcana2plus.registry;

import net.arcano.arcana2plus.Arcana2Plus;
import net.arcano.arcana2plus.items.APPItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class APPRegisterItems {
    public static void registerItems(){
        //items
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "coal_nugget"), APPItems.COAL_NUGGET);
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "charcoal_nugget"), APPItems.CHARCOAL_NUGGET);

        //Tools
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "flint_shears"), APPItems.FLINT_SHEARS);

        //block items
        Registry.register(Registry.ITEM, new Identifier(Arcana2Plus.MOD_ID, "charcoal_block"), APPItems.CHARCOAL_BLOCK);

        //fuels
        FuelRegistry.INSTANCE.add(APPItems.COAL_NUGGET, 200);
        FuelRegistry.INSTANCE.add(APPItems.CHARCOAL_NUGGET, 200);
        FuelRegistry.INSTANCE.add(APPItems.CHARCOAL_BLOCK, 16000);
    }
}
