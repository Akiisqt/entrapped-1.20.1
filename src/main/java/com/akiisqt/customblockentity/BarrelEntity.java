package com.akiisqt.customblockentity;

import com.akiisqt.EntrappedBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class BarrelEntity extends BlockEntity implements CustomInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(8, ItemStack.EMPTY);

    public BarrelEntity(BlockPos pos, BlockState state) {
        super(EntrappedBlockEntities.BarrelEntity, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }
}