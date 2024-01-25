package com.akiisqt;

import com.akiisqt.customblock.EmptyBarrel;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.HashMap;
import java.util.Map;


public class EntrappedBlocks {
    public static Map<String, Block> blockMap = new HashMap<>();
    static {
        blockMap.put("empty_barrel", new EmptyBarrel(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
    }
}
