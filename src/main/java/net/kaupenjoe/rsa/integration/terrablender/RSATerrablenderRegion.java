package net.kaupenjoe.rsa.integration.terrablender;

import com.mojang.datafixers.util.Pair;
import net.kaupenjoe.rsa.ResourceSlimesAdventures;
import net.kaupenjoe.rsa.biomes.RSABiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class RSATerrablenderRegion extends Region {
    public RSATerrablenderRegion(int weight) {
        super(new ResourceLocation(ResourceSlimesAdventures.MODID, "overworld"), RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        addCustomBiomes(mapper, RSABiomes.SLIME_WASTELANDS.getKey());
    }

    @SafeVarargs
    private void addCustomBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, ResourceKey<Biome>... biomes) {
        for (var biome : biomes) {
            addBiome(mapper, ParameterUtils.Temperature.ICY, ParameterUtils.Humidity.WET, ParameterUtils.Continentalness.COAST, ParameterUtils.Erosion.EROSION_0, ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING, ParameterUtils.Depth.SURFACE, 0.2F, biome);
        }
    }
}
