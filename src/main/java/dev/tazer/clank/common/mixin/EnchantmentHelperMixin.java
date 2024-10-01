package dev.tazer.clank.common.mixin;

import com.jsburg.clash.registry.AllEnchantments;
import dev.tazer.clank.Config;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getAvailableEnchantmentResults", at = @At("TAIL"))
    private static void removeBlacklisted(int num, ItemStack stack, boolean p_44820_, CallbackInfoReturnable<List<EnchantmentInstance>> callback) {
        if (Config.DEFAULT_JAB.get()) callback.getReturnValue().removeIf(enchantmentInstance -> enchantmentInstance.enchantment.equals(AllEnchantments.JAB.get()));
        if (Config.DEFAULT_AGILITY.get()) callback.getReturnValue().removeIf(enchantmentInstance -> enchantmentInstance.enchantment.equals(AllEnchantments.AGILITY.get()));
        if (Config.DEFAULT_SWEET_SPOT.get()) callback.getReturnValue().removeIf(enchantmentInstance -> enchantmentInstance.enchantment.equals(AllEnchantments.SWEET_SPOT.get()));
    }
}

