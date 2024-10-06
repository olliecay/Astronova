package com.dev.astronova.datagen;

import com.dev.astronova.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MOON_STONE)
                .add(ModBlocks.MOON_STONE_SLAB)
                .add(ModBlocks.MOON_STONE_STAIRS)
                .add(ModBlocks.MOON_STONE_WALL)

                .add(ModBlocks.MOON_BRICK)
                .add(ModBlocks.MOON_BRICK_SLAB)
                .add(ModBlocks.MOON_BRICK_STAIRS)
                .add(ModBlocks.MOON_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.REGOLITH_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MOON_STONE)
                .add(ModBlocks.MOON_STONE_SLAB)
                .add(ModBlocks.MOON_STONE_STAIRS)
                .add(ModBlocks.MOON_STONE_WALL)

                .add(ModBlocks.MOON_BRICK)
                .add(ModBlocks.MOON_BRICK_SLAB)
                .add(ModBlocks.MOON_BRICK_STAIRS)
                .add(ModBlocks.MOON_BRICK_WALL)
                .add(ModBlocks.REGOLITH_BLOCK);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.MOON_STONE_SLAB)
                .add(ModBlocks.MOON_BRICK_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.MOON_STONE_STAIRS)
                .add(ModBlocks.MOON_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.MOON_STONE_WALL)
                .add(ModBlocks.MOON_BRICK_WALL);
    }
}
