package com.dev.astronova.world.biome;

import com.dev.astronova.world.biome.surface.ModMaterialRules;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import static com.dev.astronova.Astronova.MOD_ID;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModMaterialRules.makeRules());
    }
}
