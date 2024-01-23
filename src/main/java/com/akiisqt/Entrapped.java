package com.akiisqt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entrapped implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("entrapped");
	public static final String ModId = "entrapped";
	private static final ItemGroup itemGroup = FabricItemGroup.builder()
			.icon(() -> new ItemStack(Items.TNT))
			.displayName(Text.translatable("itemGroup.entrapped.main"))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM_GROUP, new Identifier(ModId, "main"), itemGroup);

		for ( var Entry:EntrappedBlocks.blockHashMap.entrySet() ) {
			Registry.register(Registries.BLOCK, new Identifier(ModId, Entry.getKey().toLowerCase()), Entry.getValue());

			var Item = Registry.register(Registries.ITEM, new Identifier(ModId, Entry.getKey()), new BlockItem(Entry.getValue(), new FabricItemSettings()));
			ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ModId, "main"))).register((entries) ->
			{
					entries.add(Item);
			});
		}

		LOGGER.info("Hello Fabric world!");
	}
}