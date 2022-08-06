package net.kaupenjoe.rsa.integration.terrablender;

import net.kaupenjoe.rsa.ResourceSlimesAdventures;
import net.kaupenjoe.rsa.biomes.RSASurfaceRuleData;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.core.TerraBlender;

import static net.kaupenjoe.rsa.ResourceSlimesAdventures.isModLoaded;

public class RSATerrablenderIntegration {
    public static void initiateIntegration() {
        if (isModLoaded(TerraBlender.MOD_ID)) {
            Regions.register(new RSATerrablenderRegion(1));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ResourceSlimesAdventures.MODID, RSASurfaceRuleData.makeRules());
        }
    }
}