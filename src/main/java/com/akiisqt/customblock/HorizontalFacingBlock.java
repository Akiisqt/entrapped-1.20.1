package com.akiisqt.customblock;

import com.akiisqt.util.VoxelShapeRotator;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class HorizontalFacingBlock extends Block {
    static final DirectionProperty facing = Properties.HORIZONTAL_FACING;
    public static final List<Object> builderProperties = new ArrayList<>();
    static {
        builderProperties.add(facing);
    }

    final Map<Direction, VoxelShape> shapeMap;

    protected HorizontalFacingBlock(AbstractBlock.Settings settings, VoxelShape shape) {
        super(settings);
        this.shapeMap = VoxelShapeRotator.rotateAllDirections(shape);
        this.setDefaultState(this.getDefaultState().with(facing, Direction.NORTH));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer != null) {
            world.setBlockState(pos, state.with(facing, placer.getHorizontalFacing()), 2);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shapeMap.get(state.get(facing));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(facing, Direction.fromHorizontal(Math.floorMod((int)Math.floor((double)(Objects.requireNonNull(ctx.getPlayer()).getYaw() * 4.0F / 360.0F) + 0.5D), 4)));
    }
}
