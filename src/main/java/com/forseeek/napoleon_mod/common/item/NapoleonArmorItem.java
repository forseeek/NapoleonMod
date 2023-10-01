package com.forseeek.napoleon_mod.common.item;

import com.forseeek.napoleon_mod.NapoleonMod;
import com.forseeek.napoleon_mod.client.renderer.NapoleonArmorRenderer;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;
import java.util.function.Consumer;

public class NapoleonArmorItem extends ArmorItem implements GeoItem {

    public String  upgraded;

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public NapoleonArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    public NapoleonArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties, String upgraded) {
        super(armorMaterial, type, properties);
        this.upgraded = upgraded;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private NapoleonArmorRenderer renderer;
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new NapoleonArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide){
            if(isFullArmorEquipped(player)){
                if(player.getHealth()<=5 && player.isAlive()){
                    player.setHealth(player.getMaxHealth());
                    player.sendSystemMessage(Component.translatable("chat." + NapoleonMod.MOD_ID + ".napoleon", player.getName()));
                }
            }
        }
        super.onArmorTick(stack, level, player);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @org.jetbrains.annotations.Nullable Level world, List<Component> tooltip, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc"));

            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc_napoleon_armor"));

        } else {
            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc_more_information", "§6[§r§eSHIFT§r§6]§r"));
        }

        if(upgraded!=null){
            tooltip.add(Component.translatable("tooltip." + NapoleonMod.MOD_ID + ".desc_napoleon_armor_upgraded"));
        }

        super.appendHoverText(itemStack, world, tooltip, tooltipFlag);
    }

    private boolean isFullArmorEquipped(Player player){
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
//        return null;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
