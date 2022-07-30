package net.kaupenjoe.adventures.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

// @todo questionable name...
public class ModRegions extends Region {
    public ModRegions(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        addBiome(mapper, ParameterUtils.Temperature.HOT, ParameterUtils.Humidity.HUMID, ParameterUtils.Continentalness.COAST, ParameterUtils.Erosion.EROSION_0, ParameterUtils.Weirdness.FULL_RANGE, ParameterUtils.Depth.UNDERGROUND, 0.0F, ModBiomes.SLIME_WASTELANDS_KEY);
    }
}
