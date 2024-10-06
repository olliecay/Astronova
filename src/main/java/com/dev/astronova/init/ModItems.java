package com.dev.astronova.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.dev.astronova.Astronova.MOD_ID;

public class ModItems {
    public static final Item REGOLITH_DUST = register(
        new Item(new Item.Settings()),
        "regolith_dust"
    );

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final RegistryKey<ItemGroup> ASTRONOVA_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "item_group"));
    public static final ItemGroup ASTRONOVA_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.BLACK_CONCRETE))
            .displayName(Text.translatable("itemGroup.astronovaGroup"))
            .build();

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, ASTRONOVA_GROUP_KEY, ASTRONOVA_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(ASTRONOVA_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.MOON_STONE.asItem());
            itemGroup.add(ModBlocks.MOON_STONE_SLAB.asItem());
            itemGroup.add(ModBlocks.MOON_STONE_STAIRS.asItem());
            itemGroup.add(ModBlocks.MOON_STONE_WALL.asItem());

            itemGroup.add(ModBlocks.REGOLITH_BLOCK.asItem());
            itemGroup.add(ModItems.REGOLITH_DUST);

            itemGroup.add(ModBlocks.MOON_BRICK.asItem());
            itemGroup.add(ModBlocks.MOON_BRICK_SLAB.asItem());
            itemGroup.add(ModBlocks.MOON_BRICK_STAIRS.asItem());
            itemGroup.add(ModBlocks.MOON_BRICK_WALL.asItem());
        });
    }
}
