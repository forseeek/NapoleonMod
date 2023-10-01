package com.forseeek.napoleon_mod.client.renderer;

import com.forseeek.napoleon_mod.common.item.NapoleonArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NapoleonArmorRenderer extends GeoArmorRenderer<NapoleonArmorItem> {
    public NapoleonArmorRenderer() {
        super(new NapoleonArmorModel());
    }
//    public SkinArmorRenderer() {
//        super(new DefaultedItemGeoModel<>(new ResourceLocation(GeckoLib.MOD_ID, "armor/skin")));
//    }
}
