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
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

public class APPGenerator {
    private static final ConfiguredFeature<?,?> OVERWORLD_CLAY_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    Blocks.CLAY.getDefaultState(),
                    16));

    public static PlacedFeature OVERWORLD_CLAY_ORE_PLACED_FEATURE = OVERWORLD_CLAY_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(2),
            SquarePlacementModifier.of(),
            HeightRangePlacementModifier.uniform(YOffset.fixed(45), YOffset.fixed(79)));


    public static void registerOreVeins(){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Arcana2Plus.MOD_ID, "overworld_clay_ore"), OVERWORLD_CLAY_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE,
                new Identifier(Arcana2Plus.MOD_ID, "overworld_clay_ore"), OVERWORLD_CLAY_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Arcana2Plus.MOD_ID, "overworld_clay_ore")));
    }
}
