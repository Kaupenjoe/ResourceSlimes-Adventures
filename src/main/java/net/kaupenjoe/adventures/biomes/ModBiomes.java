package net.kaupenjoe.adventures.biomes;

import net.kaupenjoe.adventures.Adventures;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Adventures.MODID);

    public static final ResourceKey<Biome> SLIME_WASTELANDS_KEY = ResourceKey.create(Registry.BIOME_REGISTRY,
            new ResourceLocation(Adventures.MODID, "slime_wastelands"));

    private static final RegistryObject<Biome> SLIME_WASTELANDS = registerBiome(SLIME_WASTELANDS_KEY, createSlimeWastelands());

    private static RegistryObject<Biome> registerBiome(ResourceKey<Biome> key, Biome biome) {
        return BIOMES.register(key.location().getPath(), () -> biome);
    }

    @VisibleForDebug
    private static Biome createSlimeWastelands() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SWAMP);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).build();
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
