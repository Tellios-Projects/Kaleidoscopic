package net.leafenzo.kaleidoscopic.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leafenzo.kaleidoscopic.Super;
import net.leafenzo.kaleidoscopic.block.ModBlocks;
import net.leafenzo.kaleidoscopic.data.client.ModTexturedModel;
import net.leafenzo.kaleidoscopic.registration.WoodSet;
import net.leafenzo.kaleidoscopic.state.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void registerUpDefaultOrientable(BlockStateModelGenerator blockStateModelGenerator, Block block, TexturedModel.Factory modelFactory) {
        Identifier identifier = modelFactory.upload(block, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).coordinate(this.createUpDefaultRotationStates()));
        //blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(BlockStateModelGenerator.createNorthDefaultRotationStates(), identifier));
    }
    private static BlockStateVariantMap createUpDefaultRotationStates() {
        return BlockStateVariantMap.create(Properties.FACING).register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R180)).register(Direction.UP, BlockStateVariant.create()).register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90)).register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R180)).register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R270)).register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.Y, VariantSettings.Rotation.R90));
    }
    private void registerWithModelId(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier ModelId) {
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, ModelId));
    }

//    public final void registerBed(BlockStateModelGenerator blockStateModelGenerator, Block bed, Block particleSource) {
//        blockStateModelGenerator.blockStateCollector.accept(Models.TEMPLATE_BED.upload(ModelIds.getItemModelId(bed.asItem()), TextureMap.particle(particleSource), blockStateModelGenerator.modelCollector));
//    }

    public final void registerFlowerPot(BlockStateModelGenerator blockStateModelGenerator, Block plantBlock, Block flowerPotBlock, BlockStateModelGenerator.TintType tintType) {
        TextureMap textureMap = TextureMap.plant(plantBlock);
        Identifier identifier = tintType.getFlowerPotCrossModel().upload(flowerPotBlock, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(flowerPotBlock, identifier));
    }

    /**
     * @param blockStateModelGenerator
     * @param block Block class must have Properties.FACING and ModProperties.DIAGONAL
     */
    public final void registerDiagonalBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier straightId = Models.CUBE_ALL.upload(block, TextureMap.all(block), blockStateModelGenerator.modelCollector);
        Identifier diagonalId = Models.CUBE_ALL.upload(block, "_diagonal", TextureMap.all(TextureMap.getSubId(block, "_diagonal")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ModProperties.DIAGONAL, diagonalId, straightId))
                .coordinate(BlockStateModelGenerator.createNorthDefaultRotationStates()));
    }

    /**
     * @param blockStateModelGenerator
     * @param block Block class must have Properties.FACING and ModProperties.DIAGONAL
     */
    public final void registerDiagonalSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Block fullblock) {
        Identifier straightId = Models.CUBE_ALL.upload(block, "_double", TextureMap.all(fullblock), blockStateModelGenerator.modelCollector);
        Identifier diagonalId = Models.CUBE_ALL.upload(block, "diagonal_double", TextureMap.all(TextureMap.getSubId(fullblock, "_diagonal")), blockStateModelGenerator.modelCollector);

        Identifier slabId = Models.SLAB.upload(block, TextureMap.all(fullblock), blockStateModelGenerator.modelCollector);
        Identifier slabTopId = Models.SLAB_TOP.upload(block, "_top", TextureMap.all(fullblock), blockStateModelGenerator.modelCollector);

        Identifier diagonalSlabId = Models.SLAB.upload(block, "_diagonal", TextureMap.all(TextureMap.getSubId(fullblock, "_diagonal")), blockStateModelGenerator.modelCollector);
        Identifier diagonalSlabTopId = Models.SLAB_TOP.upload(block, "_diagonal_top", TextureMap.all(TextureMap.getSubId(fullblock, "_diagonal")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(Properties.SLAB_TYPE, ModProperties.DIAGONAL)
                        .register(SlabType.BOTTOM, false, BlockStateVariant.create().put(VariantSettings.MODEL, slabId))
                        .register(SlabType.TOP, false, BlockStateVariant.create().put(VariantSettings.MODEL, slabTopId))
                        .register(SlabType.DOUBLE, false, BlockStateVariant.create().put(VariantSettings.MODEL, straightId))

                        .register(SlabType.BOTTOM, true, BlockStateVariant.create().put(VariantSettings.MODEL, diagonalSlabId))
                        .register(SlabType.TOP, true, BlockStateVariant.create().put(VariantSettings.MODEL, diagonalSlabTopId))
                        .register(SlabType.DOUBLE, true, BlockStateVariant.create().put(VariantSettings.MODEL, diagonalId))
                )
                .coordinate(BlockStateModelGenerator.createNorthDefaultRotationStates())
        );
    }

    /**
     * See also:
     * BlockStateModelGenerator.registerTripwireHook
     * BlockStateModelGenerator.registerDoubleBlock
     * BlockStateModelGenerator.registerCrop
     */
    public final void registerTwoTallCrop(BlockStateModelGenerator blockStateModelGenerator, Block crop, Property<Integer> ageProperty/*, int[] upperAgeTextureIndices, int[] lowerAgeTextureIndices*/) {
        //This creates some extra unused models. This causes no issues whatsoever, so I've decided not to fix it.
        for(int i = 0; i < ageProperty.getValues().size(); i++) {
            blockStateModelGenerator.createSubModel(crop, "_stage" + i + "_top", Models.CROSS, TextureMap::cross);
            blockStateModelGenerator.createSubModel(crop, "_stage" + i + "_bottom", Models.CROSS, TextureMap::cross);
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop)
                .coordinate(BlockStateVariantMap.create(Properties.DOUBLE_BLOCK_HALF, ageProperty).register(
                        (a, b) -> BlockStateVariant.create().put(VariantSettings.MODEL, TextureMap.getSubId(crop, "_stage" + b + (a == DoubleBlockHalf.LOWER ? "_bottom" : "_top")))))
        );
    }
    public final void registerCrossCrop(BlockStateModelGenerator blockStateModelGenerator, Block crop, Property<Integer> ageProperty) {
        for(int i = 0; i < ageProperty.getValues().size(); i++) {
            blockStateModelGenerator.createSubModel(crop, "_stage" + i, Models.CROSS, TextureMap::cross);
        }
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop)
                .coordinate(BlockStateVariantMap.create(ageProperty).register(
                        (a) -> BlockStateVariant.create().put(VariantSettings.MODEL, TextureMap.getSubId(crop, "_stage" + a)))));
    }
    public final void createWoodSign(BlockStateModelGenerator blockStateModelGenerator, Block planks, Block signBlock, Block wallSignBlock) {
        TextureMap textureMapping = TextureMap.texture(planks);
        Identifier resourceLocation = Models.PARTICLE.upload(signBlock, textureMapping, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(signBlock, resourceLocation));
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(wallSignBlock, resourceLocation));
        blockStateModelGenerator.registerItemModel(signBlock.asItem());
        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(wallSignBlock);
    }
    public final void createHangingSign(BlockStateModelGenerator blockStateModelGenerator, Block strippedLog, Block hangingSign, Block wallHangingSign) {
        TextureMap textureMap = TextureMap.particle(strippedLog);
        Identifier identifier = Models.PARTICLE.upload(hangingSign, textureMap, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(hangingSign, identifier));
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(wallHangingSign, identifier));
        blockStateModelGenerator.registerItemModel(hangingSign.asItem());
        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(wallHangingSign);
    }
    public final void registerBlocksInWoodSet(BlockStateModelGenerator blockStateModelGenerator, WoodSet woodSet) {
        Block log = woodSet.getLog();
        Block wood = woodSet.getWood();

        if(log != null && wood != null) { blockStateModelGenerator.registerLog(log).log(log).wood(wood);  }
        else if(log != null) { blockStateModelGenerator.registerLog(log).log(log); }

        Block strippedLog = woodSet.getStrippedLog();
        Block strippedWood = woodSet.getStrippedWood();
        if(strippedLog != null && strippedWood != null) { blockStateModelGenerator.registerLog(strippedLog).log(strippedLog).wood(strippedWood);  }
        else if(strippedLog != null) { blockStateModelGenerator.registerLog(strippedLog).log(strippedLog); }

        Block leaves = woodSet.getLeaves();
        if(leaves != null) { blockStateModelGenerator.registerSingleton(leaves, TexturedModel.LEAVES); }

        Block sapling = woodSet.getSapling();
        Block pottedSapling = woodSet.getPottedSapling();
        if(sapling != null && pottedSapling != null) { blockStateModelGenerator.registerFlowerPotPlant(sapling, pottedSapling, BlockStateModelGenerator.TintType.NOT_TINTED); }
        else if(sapling != null) { blockStateModelGenerator.registerTintableCross(sapling, BlockStateModelGenerator.TintType.NOT_TINTED); }

        Block planks = woodSet.getPlanks();
        Block stairs = woodSet.getStairs();
        Block slab = woodSet.getSlab();
        Block fence = woodSet.getFence();
        Block fenceGate = woodSet.getFenceGate();
        Block pressurePlate = woodSet.getPressurePlate();
        Block button = woodSet.getButton();
        if(planks != null) {
            BlockStateModelGenerator.BlockTexturePool planksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(planks);
            if(stairs != null) { planksTexturePool.stairs(stairs); }
            if(slab != null) { planksTexturePool.slab(slab); }
            if(fence != null) { planksTexturePool.fence(fence); }
            if(fenceGate != null) { planksTexturePool.fenceGate(fenceGate); }
            if(pressurePlate != null) { planksTexturePool.pressurePlate(pressurePlate); }
            if(button != null) { planksTexturePool.button(button); }
        }

        Block mosaic = woodSet.getMosaic();
        Block mosaicStairs = woodSet.getMosaicStairs();
        Block mosaicSlab = woodSet.getMosaicSlab();
        if(mosaic != null) {
            BlockStateModelGenerator.BlockTexturePool mosaicTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(mosaic);
            if(mosaicStairs != null) { mosaicTexturePool.stairs(mosaicStairs); }
            if(mosaicSlab != null) { mosaicTexturePool.slab(mosaicSlab); }
        }

        Block door = woodSet.getDoor();
        if(door != null) { blockStateModelGenerator.registerDoor(door); }

        Block trapDoor = woodSet.getTrapDoor();
        if(trapDoor != null) { blockStateModelGenerator.registerTrapdoor(trapDoor); }

        Block sign = woodSet.getSign();
        Block wallSign = woodSet.getWallSign();
        if(sign != null && wallSign != null && planks != null) { createWoodSign(blockStateModelGenerator, planks, sign, wallSign); }

        Block hangingSign = woodSet.getHangingSign();
        Block hangingWallSign = woodSet.getHangingWallSign();
        if(hangingSign != null && hangingWallSign != null && strippedLog != null) { createHangingSign(blockStateModelGenerator, strippedLog, hangingSign, hangingWallSign); }

        Item boatItem = woodSet.getBoatItem();
        if(boatItem != null) { blockStateModelGenerator.registerItemModel(boatItem);  }

        Item chestBoatItem = woodSet.getChestBoatItem();
        if(chestBoatItem != null) { blockStateModelGenerator.registerItemModel(chestBoatItem);  }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        for(Block block : ModBlocks.DYED_ROCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        for(Block block : ModBlocks.DYED_POLISHED_ROCKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        for(Block block : ModBlocks.DYED_ROCK_BRICKS) {
            blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        }
        for(Block block : ModBlocks.DYED_WOODEN_DOORS) {
            blockStateModelGenerator.registerDoor(block);
        }
        for(Block block : ModBlocks.DYED_WOODEN_TRAPDOORS) {
            blockStateModelGenerator.registerTrapdoor(block);
        }

        // Block Models
        // Cube with all sides the same texture, IE Dirt
        // blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COMPRESSED_STONE);

        // Non-rotatable Cube with faces of different textures
        //blockStateModelGenerator.registerSingleton(ModBlocks.BOOK_BLOCK, TexturedModel.CUBE_COLUMN);

        // Pillar Block, IE Oak Logs
        //blockStateModelGenerator.registerAxisRotated(ModBlocks.SUPER_COMPRESSED_DEEPSLATE, TexturedModel.CUBE_COLUMN);

        // Reversible Pillar Block
        //registerUpDefaultOrientable(blockStateModelGenerator, ModBlocks.BLAZE_ROD_BLOCK, TexturedModel.CUBE_COLUMN);

        // Leaves Like Blocks, includes things that sample from Biome Color maps.
        //blockStateModelGenerator.registerSingleton(ModBlocks.GRASS_CLIPPINGS_BLOCK, TexturedModel.LEAVES);

        // BlockItem Models, every block model needs one of these
        //Copy Parent
        //blockStateModelGenerator.registerParentedItemModel(ModBlocks.BLAZE_ROD_BLOCK, Super.asResource("block/blaze_rod_block"));
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}