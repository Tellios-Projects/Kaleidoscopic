package net.leafenzo.kaleidoscopic;

import net.fabricmc.api.ClientModInitializer;
import net.leafenzo.kaleidoscopic.client.render.ModColorHandler;
import net.leafenzo.kaleidoscopic.client.render.ModRenderLayers;
import net.leafenzo.kaleidoscopic.particle.ModParticleTypes;

public class ModClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderLayers.registerBlockCutouts();
        ModColorHandler.registerBlockColorProviders();

        ModParticleTypes.registerFactoriesForClient();
    }
}
