package com.akiisqt;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EntrappedBlocks {
    public static HashMap<String, Block> blockHashMap = new HashMap<String, Block>();
        static {
            blockHashMap.put("bomb", new Block(FabricBlockSettings.create()));
            blockHashMap.put("ice_bomb", new Block(FabricBlockSettings.create()));
        }
}
