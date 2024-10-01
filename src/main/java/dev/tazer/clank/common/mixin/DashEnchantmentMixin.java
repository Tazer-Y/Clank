package dev.tazer.clank.common.mixin;

import com.jsburg.clash.enchantments.spear.DashEnchantment;
import com.jsburg.clash.registry.AllEnchantments;
import dev.tazer.clank.Config;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DashEnchantment.class)
public class DashEnchantmentMixin {

    @Redirect(method = "tryAgilityDash", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getItemEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/item/ItemStack;)I"))
    private static int injected(Enchantment enchant, ItemStack spear) {
        if(Config.DEFAULT_AGILITY.get() || EnchantmentHelper.getItemEnchantmentLevel(AllEnchantments.AGILITY.get(), spear) > 0) return 1;
        return 0;
    }
}
