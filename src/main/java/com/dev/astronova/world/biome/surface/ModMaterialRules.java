package com.dev.astronova.world.biome.surface;

import com.dev.astronova.init.ModBlocks;
import com.dev.astronova.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule REGOLITH = makeStateRule(ModBlocks.REGOLITH_BLOCK);
    private static final MaterialRules.MaterialRule MOON_STONE = makeStateRule(ModBlocks.MOON_STONE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialRule surface = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.surface(), REGOLITH),
                MOON_STONE
        );

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(ModBiomes.MOON_PLAINS),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, REGOLITH),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING_WITH_SURFACE_DEPTH, MOON_STONE)
                        )
                ),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, surface),
                MOON_STONE
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}