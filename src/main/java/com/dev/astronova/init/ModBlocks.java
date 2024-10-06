package com.dev.astronova.init;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static com.dev.astronova.Astronova.MOD_ID;

public class ModBlocks {
    public static final Block MOON_STONE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).hardness(1.5f).resistance(6.0f)),
            "moon_stone", true
    );
    public static final Block MOON_STONE_SLAB = register(
            new SlabBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).hardness(1.5f).resistance(6.0f)),
            "moon_stone_slab", true
    );
    public static final Block MOON_STONE_STAIRS = register(
            new StairsBlock(ModBlocks.MOON_STONE.getDefaultState(), AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).hardness(1.5f).resistance(6.0f)),
            "moon_stone_stairs", true
    );
    public static final Block MOON_STONE_WALL = register(
            new WallBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).hardness(1.5f).resistance(6.0f)),
            "moon_stone_wall", true
    );

    public static final Block REGOLITH_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.SAND).strength(0.5f)),
            "regolith_block", true
    );

    public static final Block MOON_BRICK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF_BRICKS).hardness(1.5f).resistance(6.0f)),
            "moon_brick", true
    );
    public static final Block MOON_BRICK_SLAB = register(
            new SlabBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF_BRICKS).hardness(1.5f).resistance(6.0f)),
            "moon_brick_slab", true
    );
    public static final Block MOON_BRICK_STAIRS = register(
            new StairsBlock(ModBlocks.MOON_BRICK.getDefaultState(),AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF_BRICKS).hardness(1.5f).resistance(6.0f)),
            "moon_brick_stairs", true
    );
    public static final Block MOON_BRICK_WALL = register(
            new WallBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.TUFF_BRICKS).hardness(1.5f).resistance(6.0f)),
            "moon_brick_wall", true
    );

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(MOD_ID, name);

        // register an item for the block.
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {}
}
