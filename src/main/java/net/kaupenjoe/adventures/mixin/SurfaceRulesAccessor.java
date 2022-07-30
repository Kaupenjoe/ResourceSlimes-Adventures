package net.kaupenjoe.adventures.mixin;

import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SurfaceRuleData.class)
public interface SurfaceRulesAccessor {
    @Invoker("makeStateRule")
    static SurfaceRules.RuleSource makeBlockStateRule(Block block) {
        throw new AssertionError();
    }
}
