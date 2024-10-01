package com.dev.astronova;

import com.dev.astronova.init.ModBlocks;
import com.dev.astronova.init.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Astronova implements ModInitializer {
	public static final String MOD_ID = "astronova";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.initialize();
	}
}