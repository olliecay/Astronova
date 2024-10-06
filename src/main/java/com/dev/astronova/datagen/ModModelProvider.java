package com.dev.astronova.datagen;

import com.dev.astronova.init.ModBlocks;
import com.dev.astronova.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool moonStoneTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOON_STONE);

        BlockStateModelGenerator.BlockTexturePool moonBrickTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOON_BRICK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REGOLITH_BLOCK);

        moonStoneTexturePool.slab(ModBlocks.MOON_STONE_SLAB);
        moonStoneTexturePool.stairs(ModBlocks.MOON_STONE_STAIRS);
        moonStoneTexturePool.wall(ModBlocks.MOON_STONE_WALL);

        moonBrickTexturePool.slab(ModBlocks.MOON_BRICK_SLAB);
        moonBrickTexturePool.stairs(ModBlocks.MOON_BRICK_STAIRS);
        moonBrickTexturePool.wall(ModBlocks.MOON_BRICK_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.REGOLITH_DUST, Models.GENERATED);
    }
}
