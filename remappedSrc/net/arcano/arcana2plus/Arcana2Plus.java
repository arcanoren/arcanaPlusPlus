package net.arcano.arcana2plus;
import net.arcano.arcana2plus.blocks.APPBlocks;
import net.arcano.arcana2plus.config.Config;
import net.arcano.arcana2plus.config.JsonGenerator;
import net.arcano.arcana2plus.items.APPItems;
import net.arcano.arcana2plus.loot.APPLoot;
import net.arcano.arcana2plus.world.APPGenerator;
import net.fabricmc.api.ModInitializer;

public class Arcana2Plus implements ModInitializer {

    public static final String MOD_ID = "arcana2plus";
    public static final Config config = JsonGenerator.readConfig();

    @Override
    public void onInitialize() {

        APPGenerator.registerOreVeins();
        APPBlocks.registerBlocks();
        APPItems.registerItems();

        if(config.allTreesDropFruits){
            APPLoot.allTreesDropFruits();
        }
        if(config.useMoreShears){
            APPLoot.initializeShearsLoot(null, null);
        }
    }
}
