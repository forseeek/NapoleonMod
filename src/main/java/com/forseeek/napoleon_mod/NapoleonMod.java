package com.forseeek.napoleon_mod;

import com.forseeek.napoleon_mod.common.init.ItemsInit;
import com.forseeek.napoleon_mod.common.init.TabsInit;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NapoleonMod.MOD_ID)
public class NapoleonMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "napoleon_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public NapoleonMod()
    {
        GeckoLib.initialize();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ItemsInit.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.COMBAT){
            event.accept(ItemsInit.napoleon_sword);
            event.accept(ItemsInit.napoleon_helmet);
            event.accept(ItemsInit.napoleon_chestplate);
            event.accept(ItemsInit.napoleon_leggings);
            event.accept(ItemsInit.napoleon_boots);
            event.accept(ItemsInit.upgraded_napoleon_helmet);
            event.accept(ItemsInit.upgraded_napoleon_chestplate);
            event.accept(ItemsInit.upgraded_napoleon_leggings);
            event.accept(ItemsInit.upgraded_napoleon_boots);
        }
        if (event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ItemsInit.white_leather);
            event.accept(ItemsInit.black_leather);
            event.accept(ItemsInit.red_leather);
            event.accept(ItemsInit.yellow_leather);
            event.accept(ItemsInit.blue_leather);
        }
        if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ItemsInit.baguette);
        }
        if(event.getTab() == TabsInit.NAPOLEON_TAB){
            event.accept(ItemsInit.napoleon_sword);
            event.accept(ItemsInit.napoleon_helmet);
            event.accept(ItemsInit.napoleon_chestplate);
            event.accept(ItemsInit.napoleon_leggings);
            event.accept(ItemsInit.napoleon_boots);
            event.accept(ItemsInit.upgraded_napoleon_helmet);
            event.accept(ItemsInit.upgraded_napoleon_chestplate);
            event.accept(ItemsInit.upgraded_napoleon_leggings);
            event.accept(ItemsInit.upgraded_napoleon_boots);
            event.accept(ItemsInit.white_leather);
            event.accept(ItemsInit.black_leather);
            event.accept(ItemsInit.red_leather);
            event.accept(ItemsInit.yellow_leather);
            event.accept(ItemsInit.blue_leather);
            event.accept(ItemsInit.baguette);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
