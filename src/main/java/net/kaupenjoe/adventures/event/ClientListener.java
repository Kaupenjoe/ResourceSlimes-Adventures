package net.kaupenjoe.adventures.event;

import net.kaupenjoe.adventures.Adventures;
import net.kaupenjoe.adventures.biomes.ModBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Adventures.MODID, value = Dist.CLIENT)
public final class ClientListener {

    @SubscribeEvent
    public static void onViewportRenderFog(ViewportEvent.ComputeFogColor event) {
        BlockPos blockPos = Minecraft.getInstance().player.blockPosition();
        ClientLevel level = Minecraft.getInstance().level;
        if (level.getBiome(blockPos).is(ModBiomes.SLIME_WASTELANDS_KEY)) {
            event.setGreen(1.0F);
        }
    }

    private ClientListener() {
    }
}
