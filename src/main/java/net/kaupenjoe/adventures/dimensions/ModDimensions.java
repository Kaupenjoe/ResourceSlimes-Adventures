package net.kaupenjoe.adventures.dimensions;

import net.kaupenjoe.adventures.Adventures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> SLIME_DOOM = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Adventures.MODID, "slime_doom"));
    public static final ResourceKey<DimensionType> SLIME_DOOM_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, SLIME_DOOM.location());
}
