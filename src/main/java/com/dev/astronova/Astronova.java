package com.dev.astronova;

import com.dev.astronova.init.ModBlocks;
import com.dev.astronova.init.ModItems;
import com.dev.astronova.init.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Astronova implements ModInitializer {
	public static final String MOD_ID = "astronova";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.initialize();
		ModSounds.initialize();
	}
}