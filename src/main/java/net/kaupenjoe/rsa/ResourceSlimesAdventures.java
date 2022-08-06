package net.kaupenjoe.rsa;

import com.mojang.logging.LogUtils;
import net.kaupenjoe.rsa.biomes.RSABiomes;
import net.kaupenjoe.rsa.integration.terrablender.RSATerrablenderIntegration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
// @todo look at how terrablender works!
@Mod(ResourceSlimesAdventures.MODID)
public class ResourceSlimesAdventures {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "rsa";
    // Directly reference an slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static boolean initialized = isModLoaded(MODID);

    public ResourceSlimesAdventures() {
        if (initialized) {
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

            // Register the commonSetup method for modloading
            modEventBus.addListener(this::commonSetup);

            RSABiomes.register(modEventBus);
        }

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("!!!!!!!!!! COMMON SETUP PHASE INITIATION !!!!!!!!!!!");
        event.enqueueWork(RSATerrablenderIntegration::initiateIntegration);
    }
}