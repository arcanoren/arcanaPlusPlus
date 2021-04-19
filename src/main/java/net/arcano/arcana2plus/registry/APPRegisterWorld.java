package net.arcano.arcana2plus.registry;

import net.arcano.arcana2plus.Arcana2Plus;
import net.arcano.arcana2plus.world.APPGenerator;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class APPRegisterWorld {
    public static void registerOreVeins(){
        RegistryKey<ConfiguredFeature<?,?>> clayVeinOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(Arcana2Plus.MOD_ID, "clay_vein_overworld"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, clayVeinOverworld.getValue(), APPGenerator.claygenerator());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, clayVeinOverworld);
    }
}
