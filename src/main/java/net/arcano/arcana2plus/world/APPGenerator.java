package net.arcano.arcana2plus.world;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class APPGenerator {
    private static ConfiguredFeature<?,?> CAVE_CLAY = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Blocks.CLAY.getDefaultState(),
                    16))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 79)))
            .spreadHorizontally().repeatRandomly(2);

    public static ConfiguredFeature claygenerator(){
        return CAVE_CLAY;
    }
}
