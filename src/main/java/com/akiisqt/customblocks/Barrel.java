package com.akiisqt.customblocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.awt.*;
import java.util.stream.Stream;

public  class Barrel extends Template {
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.1f, 0.0f, 0.1f, 0.9f, 1.0f, 0.9f);
    }
    private static final VoxelShape shape = Stream.of(
            Block.createCuboidShape(4, 0, 2, 12, 12, 14),
            Block.createCuboidShape(7, 13, 1, 9, 19, 3),
            Block.createCuboidShape(6, 12, 0, 10, 14, 4),
            Block.createCuboidShape(6, 11, 11, 10, 13, 13),
            Block.createCuboidShape(6, 13, 5, 10, 14, 13),
            Block.createCuboidShape(6, 11, 5, 10, 13, 7)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public Barrel(AbstractBlock.Settings settings) {
        super(settings);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {

        return ActionResult.SUCCESS;
    }
}