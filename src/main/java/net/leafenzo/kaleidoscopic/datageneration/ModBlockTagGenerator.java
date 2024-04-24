package net.leafenzo.kaleidoscopic.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leafenzo.kaleidoscopic.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider<Block> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, Registries.BLOCK.getKey(), registriesFuture);
    }


   //BlockTags & ItemTags are vanilla

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                //.add(ModBlocks.)
             ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.DYED_ROCKS.toArray(new Block[0]))
            .add(ModBlocks.DYED_POLISHED_ROCKS.toArray(new Block[0]))
            .add(ModBlocks.DYED_ROCK_BRICKS.toArray(new Block[0]))
        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.LEAVES)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.WOOL)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SOUL_FIRE_BASE_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.SAND)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.DIRT)
        //.add(ModBlocks.)
        ;

        getOrCreateTagBuilder(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
        //.add(ModBlocks.)
        ;

        // Main
// SLABS & STAIRS & WALLS
        for (Block block : ModBlocks.SLABS) {
            getOrCreateTagBuilder(BlockTags.SLABS).add(block);
        }
        for (Block block : ModBlocks.STAIRS) {
            getOrCreateTagBuilder(BlockTags.STAIRS).add(block);
        }
        for (Block block : ModBlocks.WALLS) {
            getOrCreateTagBuilder(BlockTags.WALLS).add(block);
        }
        for (Block block : ModBlocks.WOODEN_FENCES) {
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(block);
        }
        for (Block block : ModBlocks.FENCE_GATES) {
            getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(block);
        }
        for (Block block : ModBlocks.SIGNS) {
            if(block instanceof SignBlock) {
                getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(block);
            }
            else if(block instanceof WallSignBlock) {
                getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(block);
            }
            else if(block instanceof HangingSignBlock) {
                getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(block);
            }
            else if(block instanceof WallHangingSignBlock) {
                getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(block);
            }
        }
        for (Block block : ModBlocks.WOODEN_DOORS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(block);
        }
        for (Block block : ModBlocks.WOODEN_TRAPDOORS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(block);
        }
        for (Block block : ModBlocks.WOODEN_STAIRS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(block);
        }
        for (Block block : ModBlocks.WOODEN_SLABS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(block);
        }
        for (Block block : ModBlocks.WOODEN_PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
        }
        for (Block block : ModBlocks.WOODEN_BUTTONS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(block);
        }
        for (Block block : ModBlocks.LOGS_THAT_BURN) {
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).add(block);
        }
        for (Block block : ModBlocks.LOGS) {
            getOrCreateTagBuilder(BlockTags.LOGS).add(block);
        }
        for (Block block : ModBlocks.PLANKS) {
            getOrCreateTagBuilder(BlockTags.PLANKS).add(block);
        }
        for (Block block : ModBlocks.LEAVES) {
            getOrCreateTagBuilder(BlockTags.LEAVES).add(block);
        }
        for (Block block : ModBlocks.SAPLINGS) {
            getOrCreateTagBuilder(BlockTags.SAPLINGS).add(block);
        }


////  WOOL_BLOCKS
//        for (Block block : ModBlocks.WOOL_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.WOOL).add(block);
//        }

////  CARPET_BLOCKS
//        for (Block block : ModBlocks.WOOL_CARPET_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.WOOL_CARPETS).add(block);
//        }

//////  TERRACOTTA_BLOCKS
//        for (Block block : ModBlocks.DYED_TERRACOTTA_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
//            getOrCreateTagBuilder(BlockTags.DEAD_BUSH_MAY_PLACE_ON).add(block);
//        }

//////  CONCRETE_BLOCKS
//        for (Block block : ModBlocks.CONCRETE_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
//        }

//////  CONCRETE_POWDER_BLOCKS
//        for (Block block : ModBlocks.CONCRETE_POWDER_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(block);
//        }

//////  GLAZED_TERRACOTTA_BLOCKS
//        for (Block block : ModBlocks.GLAZED_TERRACOTTA_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
//        }

//////  STAINED_GLASS_BLOCKS
//        for (Block block : ModBlocks.STAINED_GLASS_BLOCKS) {
//            getOrCreateTagBuilder(ModTags.Blocks.GLASS).add(block);
//            getOrCreateTagBuilder(ModTags.Blocks.GLASS_BLOCKS).add(block); //common tags just wanna be silly ig
//        }

////  STAINED_GLASS_PANE_BLOCKS
        // Not needed, I think?

//////  SHULKER_BOX_BLOCKS
//        for (Block block : ModBlocks.SHULKER_BOX_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
//            getOrCreateTagBuilder(BlockTags.SHULKER_BOXES).add(block);
//        }

//////  BED_BLOCKS
//        for (Block block : ModBlocks.BED_BLOCKS) {
////            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(block); // Nope! Not supposed to use that
//            getOrCreateTagBuilder(BlockTags.BEDS).add(block);
//        }

//////  CANDLE_BLOCKS
//        for (Block block : ModBlocks.CANDLE_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.CANDLES).add(block);
//        }

//////  CANDLE_CAKE_BLOCKS
//        for (Block block : ModBlocks.CANDLE_CAKE_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.CANDLE_CAKES).add(block);
//        }

//////  BANNER_BLOCKS
//        for (Block block : ModBlocks.BANNER_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(block);
//            getOrCreateTagBuilder(BlockTags.BANNERS).add(block);
//        }

//////  WALL_BANNER_BLOCKS
//        for (Block block : ModBlocks.WALL_BANNER_BLOCKS) {
//            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(block);
//            getOrCreateTagBuilder(BlockTags.BANNERS).add(block);
//        }

////  SMALL FLOWERS
        for (Block block : ModBlocks.SMALL_FLOWERS) {
            getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(block);
        }

////  FLOWER_POTS
        for (Block block : ModBlocks.FLOWER_POTS) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
            getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(block);
        }
    }
}

