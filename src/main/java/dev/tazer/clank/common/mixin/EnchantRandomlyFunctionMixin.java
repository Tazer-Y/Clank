//package dev.tazer.clashextended.mixin;
//
//import com.jsburg.clash.registry.AllEnchantments;
//import dev.tazer.clashextended.Config;
//import dev.tazer.clashextended.util.EnchantmentUtil;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Mutable;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import java.util.List;
//
//import static dev.tazer.clashextended.util.EnchantmentUtil.ENCHANTMENT_BLACKLIST;
//
//@Mixin(EnchantRandomlyFunction.class)
//public class EnchantRandomlyFunctionMixin {
//
//    @Shadow @Mutable @Final
//    List<Enchantment> enchantments;
//
//    @Inject(method = "<init>", at = @At("TAIL"))
//    private void modifyEnchantmentList(CallbackInfo ci) {
//        if(Config.DEFAULT_AGILITY.get()) ENCHANTMENT_BLACKLIST.add(AllEnchantments.AGILITY.get());
//        if(Config.DEFAULT_JAB.get()) ENCHANTMENT_BLACKLIST.add(AllEnchantments.JAB.get());
//        if(Config.DEFAULT_SWEET_SPOT.get()) ENCHANTMENT_BLACKLIST.add(AllEnchantments.SWEET_SPOT.get());
//        enchantments = enchantments.stream().filter(enchantment -> !ENCHANTMENT_BLACKLIST.contains(enchantment)).toList();
//    }
//}
