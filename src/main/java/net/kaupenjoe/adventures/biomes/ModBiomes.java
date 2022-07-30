package net.kaupenjoe.adventures.biomes;

import net.kaupenjoe.adventures.Adventures;
import net.kaupenjoe.resourceslimes.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.VisibleForTesting;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, Adventures.MODID);

    public static final ResourceKey<Biome> SLIME_WASTELANDS_KEY = ResourceKey.create(Registry.BIOME_REGISTRY,
            new ResourceLocation(Adventures.MODID, "slime_wastelands"));

    private static final RegistryObject<Biome> SLIME_WASTELANDS = registerBiome(SLIME_WASTELANDS_KEY, createSlimeWastelands());

    private static RegistryObject<Biome> registerBiome(ResourceKey<Biome> key, Biome biome) {
        return BIOMES.register(key.location().getPath(), () -> biome);
    }

    private static Biome baseEndBiome(BiomeGenerationSettings.Builder p_194825_) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.endSpawns(mobspawnsettings$builder);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).temperature(0.5F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(p_194825_.build()).build();
    }

    @VisibleForTesting
    public static Biome createSlimeWastelands() {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.END_GATEWAY_RETURN).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacements.CHORUS_PLANT);
        return baseEndBiome(biomegenerationsettings$builder);
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
