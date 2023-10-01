package com.forseeek.napoleon_mod.common.init;


import com.forseeek.napoleon_mod.NapoleonMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NapoleonMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TabsInit {
    public static CreativeModeTab NAPOLEON_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        NAPOLEON_TAB = event.registerCreativeModeTab(new ResourceLocation(NapoleonMod.MOD_ID, "napoleon_tab"),
                builder -> builder.icon(() -> new ItemStack(ItemsInit.napoleon_helmet.get()))
                        .title(Component.translatable("itemGroup." + NapoleonMod.MOD_ID + ".mod_tab")));
    }
}
