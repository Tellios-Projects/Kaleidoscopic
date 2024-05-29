package net.leafenzo.kaleidoscopic.client.render;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.leafenzo.kaleidoscopic.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class ModRenderLayers {
    public static void registerBlockCutouts() {
        for (Block block : ModBlocks.RENDER_LAYER_CUTOUT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }

        for (Block block : ModBlocks.RENDER_LAYER_TRANSLUCENT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
        }

        for (Block block : ModBlocks.RENDER_LAYER_CUTOUT_MIPPED) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
        }
    }
}
