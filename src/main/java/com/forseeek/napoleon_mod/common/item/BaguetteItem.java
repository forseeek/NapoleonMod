package com.forseeek.napoleon_mod.common.item;

import com.forseeek.napoleon_mod.NapoleonMod;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class BaguetteItem extends SwordItem {

    public BaguetteItem(Tier tier, int attack_damage, float attack_speed, Properties properties) {
        super(tier, attack_damage, attack_speed, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @org.jetbrains.annotations.Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc"));

            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc_baguette"));

        } else {
            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc_more_information", "§6[§r§eSHIFT§r§6]§r"));
        }

        super.appendHoverText(itemStack, world, tooltip, tooltipFlag);
    }
}
