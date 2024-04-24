/*
 * SOURCES:
 * Team Hibiscus - https://github.com/Team-Hibiscus/NaturesSpirit/blob/1.20.1/src/main/java/net/hibiscus/naturespirit/registration/HibiscusRegistryHelper.java
 */

package net.leafenzo.kaleidoscopic.registration;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.leafenzo.kaleidoscopic.Super;
import net.leafenzo.kaleidoscopic.registry.tag.ModTags;
import net.leafenzo.kaleidoscopic.Super;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.apache.http.annotation.Obsolete;

import java.util.ArrayList;
import java.util.HashMap;

public class ModRegistryHelper {
    public static class ItemRegistry {
        public static final ArrayList<Item> BOAT_ITEMS = new ArrayList<Item>();
        public static final ArrayList<Item> CHEST_BOAT_ITEMS = new ArrayList<Item>();
        public static final ArrayList<Item> SIGN_ITEMS = new ArrayList<Item>();
        public static final ArrayList<Item> HANGING_SIGN_ITEMS = new ArrayList<Item>();

        public static Item registerItem(Identifier id, Item item) {
            return Registry.register(Registries.ITEM, id, (Item) item);
        }

        public static Item registerItem(String name, Item item) {
            return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), (Item) item);
        }

        public static Item registerItem(BlockItem item) {
            return Registry.register(Registries.ITEM, Registries.BLOCK.getId(item.getBlock()), (Item) item);
        }

        public static Item[] toItemArray(ArrayList<Item> input) {
            Item[] array = new Item[input.size()];
            return input.toArray(array);
        }

        public static Item registerItem(Block block, Item item) {
            BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
            return Registry.register(Registries.ITEM, Registries.BLOCK.getId(block), (Item) item);
        }
    }

    public static class BlockRegistry {
        public static final HashMap<DyeColor, Block> COLOR_FROM_WOOL = new HashMap<DyeColor, Block>(); static {
            COLOR_FROM_WOOL.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.LIME, Blocks.LIME_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.PINK, Blocks.PINK_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.RED, Blocks.RED_WOOL);
            COLOR_FROM_WOOL.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
        }

        public static Block registerBlock(String name, Block block) {
            registerBlockItem(name,block);
            return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
        }
        public static Block registerBlockWithoutBlockItem(String name, Block block) {
            return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
        }
        private static Item registerBlockItem(String name, Block block) {
            BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
            //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem)); // only for pre 1.20.1, around cuz I'd forget otherwise
            return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), blockItem);
        }

        /**
         * @param group unused 1.20+, only defined here in that version to make backporting easier.
         */
        @Obsolete
        public static Block registerBlock(String name, Block block, ItemGroup group) {
            registerBlockItem(name,block,group);
            return Registry.register(Registries.BLOCK, new Identifier(Super.MOD_ID, name), block);
        }

        /**
         * @param group unused 1.20+, only defined here in that version to make backporting easier.
         */
        @Obsolete
        private static Item registerBlockItem(String name, Block block, ItemGroup group) {
            BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
            //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(blockItem)); // only for pre 1.20.1, around cuz I'd forget otherwise
            return Registry.register(Registries.ITEM, new Identifier(Super.MOD_ID, name), blockItem);
        }
    }
}
