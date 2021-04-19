package net.arcano.arcana2plus;

import net.arcano.arcana2plus.registry.APPRegisterBlocks;
import net.arcano.arcana2plus.registry.APPRegisterItems;
import net.arcano.arcana2plus.registry.APPRegisterWorld;
import net.fabricmc.api.ModInitializer;

public class Arcana2Plus implements ModInitializer {

    public static final String MOD_ID = "arcana2plus";

    @Override
    public void onInitialize() {
        APPRegisterWorld.registerOreVeins();
        APPRegisterBlocks.registerBlocks();
        APPRegisterItems.registerItems();
    }
}
