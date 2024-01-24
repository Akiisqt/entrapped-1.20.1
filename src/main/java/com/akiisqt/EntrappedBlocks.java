package com.akiisqt;

import com.akiisqt.customblocks.Barrel;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registry;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EntrappedBlocks {

    //public static Map<String, HashMap<Block, String>> blockMap = new HashMap<>();
    public static Map<String, Block> blockMap = new HashMap<>();
    static {
        //setValuesOfKey(blockMap, "gunpowder_barrel", new Barrel(FabricBlockSettings.create()), "yo");
        blockMap.put("gunpowder_barrel", new Barrel(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
    }
//    public static void setValuesOfKey(Map<String, HashMap<Block, String>> map, String key, Block block, String string) {
//        // Get the inner map for the specified key
//        HashMap<Block, String> innerMap = map.getOrDefault(key, new HashMap<>());
//
//        // Set the value for the provided Block in the inner map
//        innerMap.put(block, string);
//
//        // Put the updated inner map back into the outer map
//        map.put(key, innerMap);
//    }
}
