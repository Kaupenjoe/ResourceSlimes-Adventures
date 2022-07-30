package net.kaupenjoe.adventures.biomes;

import net.kaupenjoe.adventures.mixin.SurfaceRulesAccessor;
import net.kaupenjoe.resourceslimes.block.ModBlocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    public static final SurfaceRules.RuleSource SLIMEY_DIRT = SurfaceRulesAccessor.makeBlockStateRule(ModBlocks.SLIMEY_DIRT.get());

    public static SurfaceRules.RuleSource createSlimeWastelands() {
        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SLIME_WASTELANDS_KEY), SLIMEY_DIRT));
    }
}
