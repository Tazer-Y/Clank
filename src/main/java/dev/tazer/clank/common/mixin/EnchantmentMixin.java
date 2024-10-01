//package dev.tazer.clank.mixin;
//
//import com.jsburg.clash.registry.AllEnchantments;
//import dev.tazer.clank.Config;
//import net.minecraft.world.item.enchantment.Enchantment;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(Enchantment.class)
//public class EnchantmentMixin {
//    @Inject(method = "checkCompatibility", at = @At("TAIL"), cancellable = true)
//    public void isCompatibleWith(Enchantment enchantment, CallbackInfoReturnable<Boolean> callback) {
//        if(Config.DEFAULT_AGILITY.get() && enchantment == AllEnchantments.AGILITY.get()) callback.setReturnValue(false);
//        if(Config.DEFAULT_JAB.get() && enchantment == AllEnchantments.JAB.get()) callback.setReturnValue(false);
//        if(Config.DEFAULT_SWEET_SPOT.get() && enchantment == AllEnchantments.SWEET_SPOT.get()) callback.setReturnValue(false);
//    }
//}
