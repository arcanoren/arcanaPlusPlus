package net.arcano.arcana2plus.world;

import net.arcano.arcana2plus.Arcana2Plus;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class APPGenerator {
    private static final ConfiguredFeature<?,?> CAVE_CLAY = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Blocks.CLAY.getDefaultState(),
                    16))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 79)))
            .spreadHorizontally().repeatRandomly(2);

    public static ConfiguredFeature<?,?> claygenerator(){
        return CAVE_CLAY;
    }


    public static void registerOreVeins(){
        RegistryKey<ConfiguredFeature<?,?>> clayVeinOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Arcana2Plus.MOD_ID, "clay_vein_overworld"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, clayVeinOverworld.getValue(), claygenerator());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, clayVeinOverworld);
    }
}
