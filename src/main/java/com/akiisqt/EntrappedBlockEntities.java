package com.akiisqt;

import com.akiisqt.customblockentity.BarrelEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntrappedBlockEntities {
    public static BlockEntityType<com.akiisqt.customblockentity.BarrelEntity> BarrelEntity = FabricBlockEntityTypeBuilder.create(BarrelEntity::new, EntrappedBlocks.blockMap.get("empty_barrel")).build();
    public static void registerAll() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("entrapped", "empty_barrel_entity"), BarrelEntity);
    }
//public static Map<String, HashMap<String, BlockEntity>> blockEntityMap = new HashMap<>();
//public static final BlockEntity
//
//static {
//        setValuesOfKey(blockEntityMap,"empty_barrel_entity", "empty_barrel", (BlockEntity) BarrelEntity);
//    }
//    public static void setValuesOfKey(Map<String, BlockEntity> map, String entityName, String blockName, BlockEntity blockEntity) {
//        Map<String, BlockEntity> innerMap = (Map<String, BlockEntity>) map.getOrDefault(entityName, new HashMap<String, BlockEntity>());
//        innerMap.put(blockName, blockEntity);
//        map.replace(entityName, innerMap);
//    }
}


