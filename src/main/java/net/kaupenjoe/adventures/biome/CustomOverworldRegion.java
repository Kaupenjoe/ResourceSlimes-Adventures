package net.kaupenjoe.adventures.biome;

import com.mojang.datafixers.util.Pair;
import net.kaupenjoe.adventures.Adventures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class CustomOverworldRegion extends Region {

    public CustomOverworldRegion(int weight) {
        super(new ResourceLocation(Adventures.MODID, "overworld"), RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        addBiome(mapper, ParameterUtils.Temperature.COOL,
                ParameterUtils.Humidity.WET,
                ParameterUtils.Continentalness.INLAND, ParameterUtils.Erosion.FULL_RANGE,
                ParameterUtils.Weirdness.FULL_RANGE, ParameterUtils.Depth.FULL_RANGE,
                0.0F, ModBiomes.Keys.SLIME_WASTELANDS);
    }
}
