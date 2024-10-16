package foundry.veil.example.registry;

import foundry.veil.example.VeilExampleMod;
import foundry.veil.example.block.ProjectorBlock;
import foundry.veil.example.blockentity.ProjectorBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class VeilExampleBlocks {

    public static final Block PROJECTOR = register("projector", new ProjectorBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK)
            .noOcclusion()
            .isRedstoneConductor(Blocks::never)),
        new Item.Properties());
    public static final BlockEntityType<ProjectorBlockEntity> PROJECTOR_BE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, VeilExampleMod.path("projector"), BlockEntityType.Builder.of(ProjectorBlockEntity::new, PROJECTOR).build(null));

    public static void bootstrap() {
    }

    public static <T extends Block> T register(String name, T block, Item.Properties properties) {
        register(name, block);
        VeilExampleItems.register(name, new BlockItem(block, properties));
        return block;
    }

    public static Block register(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, VeilExampleMod.path(name), block);
    }
}
