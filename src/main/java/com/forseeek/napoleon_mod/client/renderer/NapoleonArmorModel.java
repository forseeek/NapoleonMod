package com.forseeek.napoleon_mod.client.renderer;

import com.forseeek.napoleon_mod.NapoleonMod;
import com.forseeek.napoleon_mod.common.item.NapoleonArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NapoleonArmorModel extends GeoModel<NapoleonArmorItem> {

    @Override
    public ResourceLocation getModelResource(NapoleonArmorItem animatable) {
        return new ResourceLocation(NapoleonMod.MOD_ID, "geo/armor/napoleon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NapoleonArmorItem animatable) {
        return new ResourceLocation(NapoleonMod.MOD_ID, "textures/models/armor/napoleon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NapoleonArmorItem animatable) {
        return new ResourceLocation(NapoleonMod.MOD_ID, "animations/armor/napoleon.animation.json");
    }
}
