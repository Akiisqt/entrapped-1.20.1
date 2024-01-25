package com.akiisqt.customblock;

import com.akiisqt.customblockentity.BarrelEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.stream.Stream;

public class EmptyBarrel extends Template implements BlockEntityProvider, Waterloggable {
    private static final VoxelShape shape = Stream.of(
            Block.createCuboidShape(2.5, 0, 2.5, 13.5, 1, 13.5),
            Block.createCuboidShape(1, 0, 0.5, 15, 16, 2.5),
            Block.createCuboidShape(13, 0, 2.5, 13.5, 16, 3),
            Block.createCuboidShape(2.5, 0, 2.5, 3, 16, 3),
            Block.createCuboidShape(2.5, 0, 13, 3, 16, 13.5),
            Block.createCuboidShape(13, 0, 13, 13.5, 16, 13.5),
            Block.createCuboidShape(1, 0, 13.5, 15, 16, 15.5),
            Block.createCuboidShape(13.5, 0, 1, 15.5, 16, 15),
            Block.createCuboidShape(0.5, 0, 1, 2.5, 16, 15)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BarrelEntity(pos, state);
    }
    public static final IntProperty Level = IntProperty.of("level", 0, 8);
    public EmptyBarrel(AbstractBlock.Settings settings) {
        super(settings, shape);
        this.setDefaultState(this.getDefaultState().with(Level, 0));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Level);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }
}