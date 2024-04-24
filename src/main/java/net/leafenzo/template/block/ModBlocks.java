package net.leafenzo.template.block;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.leafenzo.template.ModInit;
import net.leafenzo.template.Super;
import net.leafenzo.template.item.ModItemGroups;
import net.leafenzo.template.registration.WoodSet;
import net.leafenzo.template.sound.ModBlockSoundGroup;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ToIntFunction;

public class ModBlocks {
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

    //public static final Block BLAZE_ROD_BLOCK = registerBlock("blaze_rod_block", new ReversiblePillarBlock(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_YELLOW).requiresTool().strength(2.0f).sounds(ModBlockSoundGroup.BLAZE_ROD_BLOCK).luminance(state -> 7)),ModItemGroups.SQUASHED);

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
