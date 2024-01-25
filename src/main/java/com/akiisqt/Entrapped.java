package com.akiisqt;

import com.akiisqt.customblockentity.BarrelEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
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
    public static final Logger LOGGER = LoggerFactory.getLogger("entrapped");
	public static final String ModId = "entrapped";
	private static final ItemGroup itemGroup = FabricItemGroup.builder()
			.icon(() -> new ItemStack(Items.TNT))
			.displayName(Text.translatable("itemGroup.entrapped.main"))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Entrapped - Loading Registries!");

		Registry.register(Registries.ITEM_GROUP, new Identifier(ModId, "main"), itemGroup);
		for ( var Entry: EntrappedBlocks.blockMap.entrySet() ) {
			var Item = Registry.register(Registries.ITEM, new Identifier(ModId, Entry.getKey()), new BlockItem(Entry.getValue(), new FabricItemSettings()));
			ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ModId, "main"))).register((entries) ->
			{
					entries.add(Item);
			});

			EntrappedBlocks.blockMap.replace(Entry.getKey(), Registry.register(Registries.BLOCK, new Identifier(ModId, Entry.getKey().toLowerCase()), Entry.getValue()));
		}
		LOGGER.info("Entrapped - Blocks and their items Registered!");

		EntrappedBlockEntities.registerAll();
//		for ( var Entry: EntrappedBlockEntities.blockEntityMap.entrySet() ) {
//			EntrappedBlockEntities.blockEntityMap.replace(Entry.getKey(),
//					Registry.register(Registries.BLOCK_ENTITY_TYPE,
//					new Identifier(ModId, Entry.getKey()),
//					FabricBlockEntityTypeBuilder.create(Entry.getValue().getValue(), EntrappedBlocks.blockMap.get(Entry.getValue().getKey())).build()));
//		}
		LOGGER.info("Entrapped - BlocksEntities Registered");

		LOGGER.info("Entrapped Loaded!");
	}
}