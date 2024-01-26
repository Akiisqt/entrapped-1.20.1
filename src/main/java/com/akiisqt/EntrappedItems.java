package com.akiisqt;

import com.akiisqt.customblock.Barrel;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class EntrappedItems {
    private static final ItemGroup itemGroup = FabricItemGroup.builder().icon(() -> new ItemStack(Items.TNT)).displayName(Text.translatable("itemGroup.entrapped.main")).build();

    public static Map<String, Item> itemMap = new HashMap<>();
    static {
        itemMap.put("barrel_lid", new Item(new FabricItemSettings()));
    }

    public static void registerAll() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(Entrapped.modId, "main"), itemGroup);

        for ( var entry: EntrappedBlocks.blockMap.entrySet() ) {
            var Item = Registry.register(Registries.ITEM, new Identifier(Entrapped.modId, entry.getKey()), new BlockItem(entry.getValue(), new FabricItemSettings()));
            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Entrapped.modId, "main"))).register((entries) ->
            {
                entries.add(Item);
            });
        }

        for (var entry: itemMap.entrySet() ) {
            var Item = Registry.register(Registries.ITEM, new Identifier(Entrapped.modId, entry.getKey()), entry.getValue());
            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Entrapped.modId, "main"))).register((entries) ->
            {
                entries.add(Item);
            });
        }
    }
}
