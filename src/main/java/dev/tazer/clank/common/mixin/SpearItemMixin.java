package dev.tazer.clank.common.mixin;

import com.jsburg.clash.registry.AllEnchantments;
import com.jsburg.clash.weapons.SpearItem;
import dev.tazer.clank.Config;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpearItem.class)
public class SpearItemMixin {

    @Redirect(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getItemEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/item/ItemStack;)I"))
    private int injected(Enchantment enchant, ItemStack spear) {
        if(Config.DEFAULT_SWEET_SPOT.get() && Config.DEFAULT_JAB.get()) return 1;
        else if (Config.DEFAULT_SWEET_SPOT.get() && EnchantmentHelper.getItemEnchantmentLevel(AllEnchantments.JAB.get(), spear) > 0) return 1;
        else if (Config.DEFAULT_JAB.get() && EnchantmentHelper.getItemEnchantmentLevel(AllEnchantments.SWEET_SPOT.get(), spear) > 0) return 1;
        else if (enchant == AllEnchantments.SWEET_SPOT.get() && Config.DEFAULT_SWEET_SPOT.get()) return 1;
        else if (enchant == AllEnchantments.JAB.get() && Config.DEFAULT_JAB.get()) return 1;

        return 0;
    }
}