package net.leafenzo.template.registries;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.*;
import net.leafenzo.template.ModInit;
import net.leafenzo.template.Super;
import net.leafenzo.template.block.ModBlocks;
import net.leafenzo.template.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModFabricRegistries {
    public static void registerFlammable(Block block, int burn, int spread) {
        FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
        flammableBlockRegistry.add(block, burn, spread);
    }
    public static void registerFuel(ItemConvertible item, int value) {
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
        fuelRegistry.add(item, value);
    }
    public static void registerCompostable(ItemConvertible item, float chance) {
        CompostingChanceRegistry compostingChanceRegistry = CompostingChanceRegistry.INSTANCE;
        compostingChanceRegistry.add(item, chance);
        VillagerInteractionRegistries.registerCompostable(item);
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        //Registry values can be safely overwritten
    }
    public static void registerCompostingChances() {
//        ModInit.LOGGER.debug("Registering composting chances for " + Super.MOD_ID); //This log is commented out because this is not the only place our mod registers this
        CompostingChanceRegistry compostingChanceRegistry = CompostingChanceRegistry.INSTANCE;
        for(ItemConvertible item : ModBlocks.SAPLINGS) {
            compostingChanceRegistry.add(item, 0.3f);
        }
        for(ItemConvertible item : ModBlocks.LEAVES) {
            compostingChanceRegistry.add(item, 0.3f);
        }

        //Registry values can be safely overwritten
    }

    public static void registerVillagerInteractions() {
        ModInit.LOGGER.debug("Registering villager interactions for " + Super.MOD_ID);
    }

    public static void registerFuels() {
//        ModInit.LOGGER.debug("Registering Smelting Fuels for " + Super.MOD_ID); //This log is commented out because this is not the only place our mod registers this
        FuelRegistry registry = FuelRegistry.INSTANCE;
        for(ItemConvertible item : ModBlocks.SAPLINGS) {
            registry.add(item, 100);
        }
        for(ItemConvertible item : ModBlocks.LOGS_THAT_BURN) {

            registry.add(item, 300);
        }

        //Registry values can be safely overwritten
    }

    public static void registerStrippables() {

    }

    public static void modifyLootTables() {

//        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
//            if (source.isBuiltin() && new Identifier("minecraft", "archaeology/desert_pyramid").equals(id)) {
//                tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(ModItems.AMBER).weight(amberDesertPyramidWeight)));
//            }
//        });
    }
}
