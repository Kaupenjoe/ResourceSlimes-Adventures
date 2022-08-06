package net.kaupenjoe.rsa.biomes;

import net.kaupenjoe.resourceslimes.world.feature.ModPlacedFeatures;
import net.kaupenjoe.rsa.ResourceSlimesAdventures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class RSABiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, ResourceSlimesAdventures.MODID);

    public static final RegistryObject<Biome> SLIME_WASTELANDS = BIOMES.register(
            "slime_wastelands",
            RSABiomes::slimeWastelands
    );

    @NotNull
    private static Biome slimeWastelands() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDefaultOres(builder);

        ModPlacedFeatures.PLACED_FEATURES.getEntries().forEach(entry -> {
            if (entry.isPresent()) {
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CITRINE_ORE_PLACED_TRIANGLE.getHolder().get());
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CITRINE_ORE_PLACED_UNIFORM.getHolder().get());
            }
        });

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
                .downfall(0.3F)
                .temperature(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder().skyColor(6660109).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE, 6000.0F)).build())
                .generationSettings(new BiomeGenerationSettings.Builder().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_CLAY).build())
                .build();
    }

    public static void register(IEventBus eventBus) {
        if (ResourceSlimesAdventures.initialized) BIOMES.register(eventBus);
    }
}
