package com.akiisqt.customblock;

import com.akiisqt.EntrappedItems;
import com.akiisqt.customblockentity.BarrelEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
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

public class Barrel extends HorizontalFacingBlock implements BlockEntityProvider {
    private static final VoxelShape shape = Stream.of(
            Block.createCuboidShape(2, 0, 14, 14, 16, 15),
            Block.createCuboidShape(14, 0, 2, 15, 16, 14),
            Block.createCuboidShape(13, 0, 13, 14, 16, 14),
            Block.createCuboidShape(13, 0, 2, 14, 16, 3),
            Block.createCuboidShape(2, 0, 1, 14, 16, 2),
            Block.createCuboidShape(2, 0, 2, 3, 16, 3),
            Block.createCuboidShape(1, 0, 2, 2, 16, 14),
            Block.createCuboidShape(2, 0, 13, 3, 16, 14),
            Block.createCuboidShape(2, 0, 2, 14, 1, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public static final IntProperty level = IntProperty.of("level", 0, 8);
    public static final BooleanProperty sealed = BooleanProperty.of("sealed");

    public Barrel(Settings settings) {
        super(settings, shape);
        this.setDefaultState(this.getDefaultState().with(level, 0).with(sealed, false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BarrelEntity(pos, state);
    }

    @Override
    @SuppressWarnings("all")
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builderProperties.add(level);
        builderProperties.add(sealed);
        builder.add(builderProperties.toArray(new Property[]{}));
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//Check if barrel is sealed, check thst item stack is empty, check if player is crouched.
//check if barrel isnt sealed, check for barrel lid and right click seal barrel, if no lid and player is shift left clicking return prevous item

//check that hand has a valid recipe, if so send to client to change color of the powder and change the blockstate level up
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }
}