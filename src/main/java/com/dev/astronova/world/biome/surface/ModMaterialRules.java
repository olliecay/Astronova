package com.dev.astronova.world.biome.surface;

import com.dev.astronova.init.ModBlocks;
import com.dev.astronova.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    // Define custom blocks for surface and underground
    private static final MaterialRules.MaterialRule REGOLITH = makeStateRule(ModBlocks.REGOLITH_BLOCK);
    private static final MaterialRules.MaterialRule MOON_STONE = makeStateRule(ModBlocks.MOON_STONE);

    public static MaterialRules.MaterialRule makeRules() {
        // Define condition for surface level (above water)

        // Define surface rule with Regolith at the surface and Moon Stone below
        MaterialRules.MaterialRule surface = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.surface(), REGOLITH),
                MOON_STONE // Below the water level, Moon Stone should replace everything
        );

        return MaterialRules.sequence(
                // Apply surface material for the Moon Plains biome
                MaterialRules.condition(MaterialRules.biome(ModBiomes.MOON_PLAINS),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, REGOLITH),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING_WITH_SURFACE_DEPTH, MOON_STONE)
                        )
                ),

                // Ensure surface (Regolith) on top and Moon Stone below all layers
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, surface),
                // Cover everything underneath with Moon Stone (underground layers)
                MOON_STONE
        );
    }

    // Utility method for creating block states
    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}