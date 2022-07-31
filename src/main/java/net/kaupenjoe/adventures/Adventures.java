package net.kaupenjoe.adventures;

import com.mojang.logging.LogUtils;
import net.kaupenjoe.adventures.biome.CustomOverworldRegion;
import net.kaupenjoe.adventures.biome.ModBiomes;
import net.kaupenjoe.adventures.biome.ModSurfaceRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Adventures.MODID)
public class Adventures {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "adventures";
    // Directly reference an slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Adventures() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModBiomes.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // relatively low weight as adding only 1 biome.
            Regions.register(new CustomOverworldRegion(1));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());
        });
    }
}