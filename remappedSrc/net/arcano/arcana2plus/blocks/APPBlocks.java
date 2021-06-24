package net.arcano.arcana2plus.blocks;

import net.arcano.arcana2plus.Arcana2Plus;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class APPBlocks {
    public static final Block CHARCOAL_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BlockSoundGroup.STONE));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Arcana2Plus.MOD_ID, "charcoal_block"), CHARCOAL_BLOCK);
    }
}
