package com.akiisqt;

import com.akiisqt.customblock.Barrel;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class EntrappedBlocks {
    public static Map<String, Block> blockMap = new HashMap<>();
    static {
        blockMap.put("barrel", new Barrel(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
    }

     public static void registerAll() {
         for ( var entry: EntrappedBlocks.blockMap.entrySet() ) {
             Registry.register(Registries.BLOCK, new Identifier(Entrapped.modId, entry.getKey()), entry.getValue());
         }
     }
}
