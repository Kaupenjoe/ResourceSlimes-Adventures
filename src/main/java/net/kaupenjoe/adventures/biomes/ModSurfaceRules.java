package net.kaupenjoe.adventures.biomes;

import net.kaupenjoe.adventures.mixin.SurfaceRulesAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    public static final SurfaceRules.RuleSource SWAMP_DIRT = SurfaceRulesAccessor.makeBlockStateRule(Blocks.DIRT);

    public static SurfaceRules.RuleSource createSlimeWastelands() {
        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SLIME_WASTELANDS_KEY), SWAMP_DIRT));
    }
}
