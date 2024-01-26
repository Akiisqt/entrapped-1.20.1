package com.akiisqt;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entrapped implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("entrapped");
	public static final String modId = "entrapped";

	@Override
	public void onInitialize() {
		LOGGER.info("Entrapped - Registering!");

		EntrappedBlocks.registerAll();
		LOGGER.info("Entrapped - Blocks Registered!");

		EntrappedBlockEntities.registerAll();
		LOGGER.info("Entrapped - BlocksEntities Registered");

		EntrappedItems.registerAll();
		LOGGER.info("Entrapped - Items Registered");

		LOGGER.info("Entrapped - Fully Loaded!");
	}
}