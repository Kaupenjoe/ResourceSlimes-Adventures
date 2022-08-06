package net.kaupenjoe.rsa.biomes;

import net.kaupenjoe.resourceslimes.block.ModBlocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class RSASurfaceRuleData {

    @Contract(" -> new")
    public static SurfaceRules.@NotNull RuleSource makeRules()
    {
        return SurfaceRules.sequence(
          SurfaceRules.ifTrue(SurfaceRules.isBiome(RSABiomes.SLIME_WASTELANDS.getKey()),
                  SurfaceRules.state(ModBlocks.SLIMEY_DIRT.get().defaultBlockState()))
        );
    }
}
