package com.akiisqt;

import com.akiisqt.customblockentity.BarrelEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntrappedBlockEntities {
    public static BlockEntityType<BarrelEntity> BarrelEntity = FabricBlockEntityTypeBuilder.create(BarrelEntity::new, EntrappedBlocks.blockMap.get("barrel")).build();

    public static void registerAll() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("entrapped", "barrel_entity"), BarrelEntity);
    }
}


