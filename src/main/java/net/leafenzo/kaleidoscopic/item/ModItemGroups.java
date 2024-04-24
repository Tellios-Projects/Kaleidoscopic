package net.leafenzo.kaleidoscopic.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leafenzo.kaleidoscopic.ModInit;
import net.leafenzo.kaleidoscopic.Super;
import net.leafenzo.kaleidoscopic.block.ModBlocks;
import net.leafenzo.kaleidoscopic.util.ModUtil;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static void registerModItemGroups() {
        ModInit.LOGGER.debug("Registering item groups for " + Super.MOD_ID);
    }

    public static ItemGroup KALEIDOSCOPIC_STONES = Registry.register(Registries.ITEM_GROUP, new Identifier(Super.MOD_ID, "kaleidoscopic_stones"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kaleidoscopic_stones"))
                    .icon(() -> new ItemStack(Blocks.AIR)).entries((displayContext, entries) -> {
                     entries.addAll(ModUtil.toItemStacks(ModBlocks.DYED_ROCKS));
                     entries.addAll(ModUtil.toItemStacks(ModBlocks.DYED_POLISHED_ROCKS));
                     entries.addAll(ModUtil.toItemStacks(ModBlocks.DYED_ROCK_BRICKS));
                    }).build());
}
