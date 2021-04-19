package net.arcano.arcana2plus.registry;

import net.arcano.arcana2plus.Arcana2Plus;
import net.arcano.arcana2plus.blocks.APPBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class APPRegisterBlocks {
    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Arcana2Plus.MOD_ID, "charcoal_block"), APPBlocks.CHARCOAL_BLOCK);
    }
}
