package net.leafenzo.kaleidoscopic.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.leafenzo.kaleidoscopic.ModInit;
import net.leafenzo.kaleidoscopic.Super;
import net.leafenzo.kaleidoscopic.registration.ModRegistryHelper;
import net.leafenzo.kaleidoscopic.registration.WoodSet;
import net.leafenzo.kaleidoscopic.registries.ModFabricRegistries;
import net.leafenzo.kaleidoscopic.util.ModUtil;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final HashMap<Block, DyeColor> DYECOLOR_FROM_BLOCK = new HashMap<Block, DyeColor>();
    public static final HashMap<Block, FlowerPotBlock> FLOWER_POT_FROM_BLOCK = new HashMap<Block, FlowerPotBlock>();
    public static final ArrayList<Block> SMALL_FLOWERS = new ArrayList<Block>();
    public static final ArrayList<Block> FLOWER_POTS = new ArrayList<Block>();
    public static final ArrayList<Block> MUSHROOM_PLANTS = new ArrayList<Block>();
    public static final ArrayList<Block> SLABS = new ArrayList<Block>();
    public static final ArrayList<Block> STAIRS = new ArrayList<Block>();
    public static final ArrayList<Block> WALLS = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_SLABS = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_STAIRS = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_FENCES = new ArrayList<Block>();
    public static final ArrayList<Block> FENCE_GATES = new ArrayList<Block>();
    public static final ArrayList<Block> PLANKS = new ArrayList<Block>();
    public static final ArrayList<Block> LOGS = new ArrayList<Block>();
    public static final ArrayList<Block> LOGS_THAT_BURN = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_DOORS = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_TRAPDOORS = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_PRESSURE_PLATES = new ArrayList<Block>();
    public static final ArrayList<Block> WOODEN_BUTTONS = new ArrayList<Block>();
    public static final ArrayList<Block> SIGNS = new ArrayList<Block>();
    public static final ArrayList<Block> RENDER_LAYER_CUTOUT = new ArrayList<Block>();
    public static final ArrayList<Block> RENDER_LAYER_CUTOUT_MIPPED = new ArrayList<Block>();
    public static final ArrayList<Block> RENDER_LAYER_TRANSLUCENT = new ArrayList<Block>();
    public static final ArrayList<Block> HAS_FOLIAGE_COLOR_PROVIDER = new ArrayList<Block>();
    public static final ArrayList<Block> LEAVES = new ArrayList<Block>();
    public static final ArrayList<Block> SAPLINGS = new ArrayList<Block>();
    public static final ArrayList<WoodSet> WOODSETS = new ArrayList<WoodSet>();

    public static final ArrayList<Block> DYED_WOODEN_DOORS = dyedWoodenDoors();
    private static ArrayList<Block> dyedWoodenDoors() {
        ArrayList<Block> bs = new ArrayList<Block>();
        for (DyeColor color : ModUtil.VANILLA_DYE_COLORS) {
            Block b = registerDyedWoodenDoor(color);
            bs.add(b);
        }
        return bs;
    }
    public static Block registerDyedWoodenDoor(DyeColor color) {
        Block b = registerBlock(color.getName() + "_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).burnable().sounds(BlockSetType.OAK.soundType()).nonOpaque().mapColor(color.getMapColor()), BlockSetType.OAK), null);
        ModFabricRegistries.registerFuel(b, 200);
        // not flammable because doors are just built different i guess. thx minecraft.
        WOODEN_DOORS.add(b);
        RENDER_LAYER_CUTOUT.add(b);
        DYECOLOR_FROM_BLOCK.put(b, color);
        return b;
    }

    public static final ArrayList<Block> DYED_WOODEN_TRAPDOORS = dyedWoodenTrapdoors();
    private static ArrayList<Block> dyedWoodenTrapdoors() {
        ArrayList<Block> bs = new ArrayList<Block>();
        for (DyeColor color : ModUtil.VANILLA_DYE_COLORS) {
            Block b = registerDyedWoodenTrapdoor(color);
            bs.add(b);
        }
        return bs;
    }
    public static Block registerDyedWoodenTrapdoor(DyeColor color) {
        Block b = registerBlock(color.getName() + "_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSetType.OAK.soundType()).nonOpaque().mapColor(color.getMapColor()), BlockSetType.OAK), null);
        ModFabricRegistries.registerFuel(b, 300);
        // not flammable because doors are just built different i guess. thx minecraft.
        WOODEN_TRAPDOORS.add(b);
        RENDER_LAYER_CUTOUT.add(b);
        DYECOLOR_FROM_BLOCK.put(b, color);
        return b;
    }

    //TODO stair and slab variants for rocks (sans polished) and bricks
    public static final ArrayList<Block> DYED_ROCKS = dyedRocks();
    private static ArrayList<Block> dyedRocks() {
        ArrayList<Block> bs = new ArrayList<Block>();
        for (DyeColor color : ModUtil.VANILLA_DYE_COLORS) {
            Block b = registerDyedRock(color);
            bs.add(b);
        }
        return bs;
    }
    public static Block registerDyedRock(DyeColor color) {
        Block b = registerBlock(color.getName() + "_rock", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).mapColor(color.getMapColor())), null);
        DYECOLOR_FROM_BLOCK.put(b, color);
        return b;
    }
    
    public static final ArrayList<Block> DYED_POLISHED_ROCKS = dyedPolishedRocks();
    private static ArrayList<Block> dyedPolishedRocks() {
        ArrayList<Block> bs = new ArrayList<Block>();
        for (DyeColor color : ModUtil.VANILLA_DYE_COLORS) {
            Block b = registerDyedPolishedRock(color);
            bs.add(b);
        }
        return bs;
    }
    public static Block registerDyedPolishedRock(DyeColor color) {
        Block b = registerBlock("polished_" + color.getName() + "_rock", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).mapColor(color.getMapColor())), null);
        DYECOLOR_FROM_BLOCK.put(b, color);
        return b;
    }
    
    public static final ArrayList<Block> DYED_ROCK_BRICKS = dyedRockBricks();
    private static ArrayList<Block> dyedRockBricks() {
        ArrayList<Block> bs = new ArrayList<Block>();
        for (DyeColor color : ModUtil.VANILLA_DYE_COLORS) {
            Block b = registerDyedRockBrick(color);
            DYECOLOR_FROM_BLOCK.put(b, color);
            bs.add(b);
        }
        return bs;
    }
    public static Block registerDyedRockBrick(DyeColor color) {
        Block b = registerBlock(color.getName() + "_rock_bricks", new Block(FabricBlockSettings.copyOf(Blocks.BRICKS).mapColor(color.getMapColor())), null);
        DYECOLOR_FROM_BLOCK.put(b, color);
        return b;
    }
    
    public static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name,block,group);
        //if(block.getDefaultState().isOpaque()) { ModRenderLayers.registerCutout(block);  }
        return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static ToIntFunction<BlockState> createLightLevelFromProperty(int litLevel, BooleanProperty property) {
        return state -> state.get(property) != false ? litLevel : 0;
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem));
        return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), blockItem);
    }

    public static void registerModBlocks() {
        ModInit.LOGGER.debug("Registering mod blocks for " + Super.MOD_ID);
    }
}
