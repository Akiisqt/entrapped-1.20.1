package com.akiisqt.customblockentity;

import com.akiisqt.EntrappedBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BarrelEntity extends BlockEntity {
    public BarrelEntity(BlockPos pos, BlockState state) {
        super(EntrappedBlockEntities.BarrelEntity, pos, state);
    }
}
