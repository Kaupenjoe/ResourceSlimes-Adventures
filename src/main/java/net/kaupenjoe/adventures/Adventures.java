package net.kaupenjoe.adventures;

import com.mojang.logging.LogUtils;
import net.kaupenjoe.adventures.biomes.ModBiomes;
import net.kaupenjoe.adventures.biomes.ModRegions;
import net.kaupenjoe.adventures.biomes.ModSurfaceRules;
import net.kaupenjoe.resourceslimes.ResourceSlimes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.core.TerraBlender;

@Mod(value = Adventures.MODID)
public class Adventures {
    public static final String MODID = "adventures";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Adventures() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        ModBiomes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // weight is relatively low as we are adding only one biome.
            if (ModList.get().isLoaded(TerraBlender.MOD_ID)) {
                Regions.register(new ModRegions(new ResourceLocation(MODID, "overworld"), 1));
                SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.createSlimeWastelands());
            }
        });
    }
}
