package com.dev.astronova.world.biome;

import com.dev.astronova.world.biome.surface.ModMaterialRules;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;

import static com.dev.astronova.Astronova.MOD_ID;

public class ModBiomes {
    public static final RegistryKey<Biome> MOON_PLAINS = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(MOD_ID, "moon_plains"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(MOON_PLAINS, moonPlains(context));
    }

    public static void moonGeneration(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModMaterialRules.makeRules());
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, (RegistryEntry<PlacedFeature>) Feature.NO_OP);
        builder.feature(GenerationStep.Feature.LAKES, (RegistryEntry<PlacedFeature>) Feature.NO_OP);
    }

    public static Biome moonPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.AREA_EFFECT_CLOUD, 1, 1, 1));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        moonGeneration(biomeBuilder);

        return new Biome.Builder()
                .precipitation(false)
                .downfall(0.0F)
                .temperature(-3.0F)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects(new BiomeEffects.Builder()
                        .waterColor(0)
                        .waterFogColor(0)
                        .skyColor(0)
                        .grassColor(0)
                        .foliageColor(0)
                        .fogColor(1)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .build();
    }
}
