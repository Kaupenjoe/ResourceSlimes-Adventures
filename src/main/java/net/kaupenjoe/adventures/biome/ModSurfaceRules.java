package net.kaupenjoe.adventures.biome;

import net.kaupenjoe.resourceslimes.block.ModBlocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules
{
    public static SurfaceRules.RuleSource makeRules()
    {
        return SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(ModBiomes.Keys.SLIME_WASTELANDS),
                    SurfaceRules.state(ModBlocks.SLIMEY_DIRT.get().defaultBlockState())
            )
        );
    }
}
