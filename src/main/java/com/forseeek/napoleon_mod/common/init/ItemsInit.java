package com.forseeek.napoleon_mod.common.init;

import com.forseeek.napoleon_mod.NapoleonMod;
import com.forseeek.napoleon_mod.common.item.BaguetteItem;
import com.forseeek.napoleon_mod.common.item.NapoleonArmorItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NapoleonMod.MOD_ID);

    public static final RegistryObject<Item> napoleon_helmet = ITEMS.register("napoleon_helmet",
            () -> new NapoleonArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> napoleon_chestplate = ITEMS.register("napoleon_chestplate",
            () -> new NapoleonArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> napoleon_leggings = ITEMS.register("napoleon_leggings",
            () -> new NapoleonArmorItem(ArmorMaterials.IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> napoleon_boots = ITEMS.register("napoleon_boots",
            () -> new NapoleonArmorItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> black_leather = ITEMS.register("black_leather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> red_leather = ITEMS.register("red_leather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> white_leather = ITEMS.register("white_leather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> yellow_leather = ITEMS.register("yellow_leather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> blue_leather = ITEMS.register("blue_leather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> napoleon_sword = ITEMS.register("napoleon_sword",
            () -> new SwordItem(
                    new Tier() {
                        @Override
                        public int getUses() {
                            return -1;
                        }

                        @Override
                        public float getSpeed() {
                            return 0f;
                        }

                        @Override
                        public float getAttackDamageBonus() {
                            return 2;
                        }

                        @Override
                        public int getLevel() {
                            return 3;
                        }

                        @Override
                        public int getEnchantmentValue() {
                            return 14;
                        }

                        @Override
                        public Ingredient getRepairIngredient() {
                            return Ingredient.of(ItemsInit.napoleon_sword.get());
                        }
                    }
                    , 6, -2.4f, new Item.Properties()));

    public static final RegistryObject<Item> upgraded_napoleon_helmet = ITEMS.register("upgraded_napoleon_helmet",
            () -> new NapoleonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties(), "upg"));
    public static final RegistryObject<Item> upgraded_napoleon_chestplate = ITEMS.register("upgraded_napoleon_chestplate",
            () -> new NapoleonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties(), "upg"));
    public static final RegistryObject<Item> upgraded_napoleon_leggings = ITEMS.register("upgraded_napoleon_leggings",
            () -> new NapoleonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties(), "upg"));
    public static final RegistryObject<Item> upgraded_napoleon_boots = ITEMS.register("upgraded_napoleon_boots",
            () -> new NapoleonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties(), "upg"));
    public static final RegistryObject<Item> baguette = ITEMS.register("baguette",
            () -> new BaguetteItem(
                    new Tier() {

                        @Override
                        public int getUses() {
                            return 2;
                        }

                        @Override
                        public float getSpeed() {
                            return 0f;
                        }

                        @Override
                        public float getAttackDamageBonus() {
                            return 1;
                        }

                        @Override
                        public int getLevel() {
                            return 0;
                        }

                        @Override
                        public int getEnchantmentValue() {
                            return 0;
                        }

                        @Override
                        public Ingredient getRepairIngredient() {
                            return Ingredient.of(ItemsInit.baguette.get());
                        }
                    }
                    , 3, -2.0f, new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(7f).build())
            ));
    
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
