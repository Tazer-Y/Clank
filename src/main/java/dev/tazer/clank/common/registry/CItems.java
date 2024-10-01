package dev.tazer.clank.common.registry;

import com.jsburg.clash.event.CreativeModeTabEvents;
import com.jsburg.clash.weapons.SpearItem;
import dev.tazer.clank.Clank;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class CItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Clank.ID);

    public static final RegistryObject<Item> FLINT_SPEAR = register("flint_spear", () -> new SpearItem(3, 2.0F, (new Item.Properties()).durability(95)));
    public static final RegistryObject<Item> IRON_SPEAR = register("iron_spear", () -> new SpearItem(5, 2.0F, (new Item.Properties()).durability(250)));
    public static final RegistryObject<Item> GOLDEN_SPEAR = register("golden_spear", () -> new SpearItem(3, 2.0F, (new Item.Properties()).durability(32)));
    public static final RegistryObject<Item> DIAMOND_SPEAR = register("diamond_spear", () -> new SpearItem(6, 2.0F, (new Item.Properties()).durability(1561)));
    public static final RegistryObject<Item> NETHERITE_SPEAR = register("netherite_spear", () -> new SpearItem(7, 2.0F, (new Item.Properties()).durability(2031)));

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier) {
        return register(name, supplier, CreativeModeTabs.COMBAT);
    }
    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier, ResourceKey<CreativeModeTab> tab) {
        var i = ITEMS.register(name, supplier);
        CreativeModeTabEvents.assignItemToTab(i, tab);
        return i;
    }
}
