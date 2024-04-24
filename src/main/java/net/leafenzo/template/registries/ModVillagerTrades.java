package net.leafenzo.template.registries;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.leafenzo.template.ModInit;
import net.leafenzo.template.Super;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModVillagerTrades {
    public static void registerVillagerTrades() {
        ModInit.LOGGER.debug("Registering villager trades for " + Super.MOD_ID);

//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4,
//                factories -> {
//                    factories.add(((entity, random) -> new TradeOffer(
//                            new ItemStack(Items.EMERALD, 12),
//                            new ItemStack(ModBlocks., 4),
//                            14, 5, 0.15f))
//                    );
//                }
//        );

        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
//                    factories.add(((entity, random) -> new TradeOffer( new ItemStack(Items.EMERALD, 2), new ItemStack(ModBlocks.CORAL_ANEMONE, 1), 12, 5, 0.15f)));
                }
        );
    }
}
