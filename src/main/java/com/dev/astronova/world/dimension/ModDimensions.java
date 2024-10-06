package com.dev.astronova.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.awt.*;
import java.util.OptionalLong;

import static com.dev.astronova.Astronova.MOD_ID;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> MOON_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(MOD_ID, "moon"));
    public static final RegistryKey<World> MOON_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(MOD_ID, "moon"));
    public static final RegistryKey<DimensionType> MOON_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(MOD_ID, "moon_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(MOON_TYPE, new DimensionType(
                OptionalLong.of(20000), // Fixed time
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm,
                true,
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                -0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_END, // infiburn
                DimensionTypes.THE_END_ID, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
