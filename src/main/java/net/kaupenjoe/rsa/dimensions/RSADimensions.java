package net.kaupenjoe.rsa.dimensions;

import net.kaupenjoe.rsa.ResourceSlimesAdventures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class RSADimensions {
    public static final ResourceKey<Level> SLIME_EMPIRE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(ResourceSlimesAdventures.MODID, "slime_empire"));
    public static final ResourceKey<DimensionType> TYPE_SLIME_EMPIRE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, SLIME_EMPIRE.location());
}
