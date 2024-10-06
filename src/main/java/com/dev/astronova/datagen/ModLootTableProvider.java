package com.dev.astronova.datagen;

import com.dev.astronova.init.ModBlocks;
import com.dev.astronova.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOON_STONE);
        addDrop(ModBlocks.MOON_STONE_SLAB, slabDrops(ModBlocks.MOON_STONE_SLAB));
        addDrop(ModBlocks.MOON_STONE_STAIRS);
        addDrop(ModBlocks.MOON_STONE_WALL);

        addDrop(ModBlocks.MOON_BRICK);
        addDrop(ModBlocks.MOON_BRICK_SLAB, slabDrops(ModBlocks.MOON_BRICK_SLAB));
        addDrop(ModBlocks.MOON_BRICK_STAIRS);
        addDrop(ModBlocks.MOON_BRICK_WALL);

        addDrop(ModBlocks.REGOLITH_BLOCK,
                dropsWithSilkTouch(ModBlocks.REGOLITH_BLOCK,
                        ItemEntry.builder(ModItems.REGOLITH_DUST)));
    }
}
