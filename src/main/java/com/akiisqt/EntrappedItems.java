package com.akiisqt;

import com.akiisqt.customblock.EmptyBarrel;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.HashMap;
import java.util.Map;

public class EntrappedItems {
    public static Map<String, Block> itemMap = new HashMap<>();
    static {
        itemMap.put("empty_barrel", new EmptyBarrel(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
    }
}
