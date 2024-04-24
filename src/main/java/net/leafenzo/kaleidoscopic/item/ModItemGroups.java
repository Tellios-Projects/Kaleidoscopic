package net.leafenzo.kaleidoscopic.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.kaleidoscopic.ModInit;
import net.leafenzo.kaleidoscopic.Super;
import net.leafenzo.kaleidoscopic.block.ModBlocks;
import net.leafenzo.kaleidoscopic.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.*;

public class ModItemGroups {
    public static void registerModItemGroups() {
        ModInit.LOGGER.debug("Registering item groups for " + Super.MOD_ID);
    }

        public final static String[] COLOR_ORDER = new String[] {
                "white",
                "light_gray",
                "gray",
                "black",
                "acorn",
                "brown",
                "mold",
                "maroon",
                "red",
                "peach",
                "vermilion",
                "orange",
                "amber",
                "yellow",
                "banana",
                "artichoke",
                "lime",
                "sap",
                "green",
                "sage",
                "shamrock",
                "mint",
                "cyan",
                "cerulean",
                "light_blue",
                "navy",
                "blue",
                "periwinkle",
                "grape",
                "purple",
                "indigo",
                "magenta",
                "velvet",
                "mauve",
                "fuchsia",
                "pink"
        };
    public static Collection<ItemStack> orderBlocksByColor(HashMap<Block, DyeColor> colorFromBlock, ArrayList<Block> ... blockSets) {
        // Conjoin all lists
        ArrayList<Block> blockSet = new ArrayList<Block>();
        for (int i = 0; i < blockSets.length; i++) {
            if(i == 0) { blockSet = blockSets[i]; }
            else if (i > 0) { blockSet.addAll(blockSets[i]); }
        }

        // Add if color exists
        ArrayList<ItemStack> c = new ArrayList<ItemStack>();
        for (String colorName : COLOR_ORDER) {
            for (Block block : blockSet) {
                if(Objects.equals(colorFromBlock.get(block).getName(), colorName)) {
                    c.add(block.asItem().getDefaultStack());
                }
            }
        }
        return c;
    }

    public static ItemGroup KALEIDOSCOPIC_STONES = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "kaleidoscopic_stones"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kaleidoscopic_stones"))
                    .icon(() -> new ItemStack(Blocks.AIR)).entries((displayContext, entries) -> {
                     entries.addAll(orderBlocksByColor(ModBlocks.DYECOLOR_FROM_BLOCK, ModBlocks.DYED_ROCKS, ModBlocks.DYED_POLISHED_ROCKS));
                     entries.addAll(orderBlocksByColor(ModBlocks.DYECOLOR_FROM_BLOCK, ModBlocks.DYED_ROCK_BRICKS));
                    }).build());
}
