package net.arcano.arcana2plus.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class APPBlocks {
    public static final Block CHARCOAL_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool()
            .strength(5.0F, 6.0F)
            .sounds(BlockSoundGroup.STONE));
}
