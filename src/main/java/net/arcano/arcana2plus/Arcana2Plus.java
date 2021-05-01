package net.arcano.arcana2plus;
import net.arcano.arcana2plus.blocks.APPBlocks;
import net.arcano.arcana2plus.items.APPItems;
import net.arcano.arcana2plus.loot.APPLoot;
import net.arcano.arcana2plus.world.APPGenerator;
import net.fabricmc.api.ModInitializer;

public class Arcana2Plus implements ModInitializer {

    public static final String MOD_ID = "arcana2plus";

    @Override
    public void onInitialize() {
        APPGenerator.registerOreVeins();
        APPBlocks.registerBlocks();
        APPItems.registerItems();

        APPLoot.allTreesDropFruits();
        APPLoot.initializeShearsLoot(null, null);
    }
}
