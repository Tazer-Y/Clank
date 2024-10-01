package dev.tazer.clank;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Clank.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{

    public static ForgeConfigSpec SERVER_CONFIG;
    public static final ForgeConfigSpec.BooleanValue DEFAULT_SWEET_SPOT;
    public static final ForgeConfigSpec.BooleanValue DEFAULT_AGILITY;
    public static final ForgeConfigSpec.BooleanValue DEFAULT_JAB;



    public static ForgeConfigSpec CLIENT_CONFIG;

    static {

        ForgeConfigSpec.Builder serverBuilder = new ForgeConfigSpec.Builder();

        DEFAULT_SWEET_SPOT = serverBuilder.comment("Removes the sweet spot enchantment and makes it default functionality for spears")
                .define("enableDefaultSweetSpot", false);

        DEFAULT_AGILITY = serverBuilder.comment("Removes the agility enchantment and makes it default functionality for spears")
                .define("enableDefaultAgility", false);

        DEFAULT_JAB = serverBuilder.comment("Removes the jab enchantment and makes it default functionality for spears")
                .define("enableDefaultJab", false);

        SERVER_CONFIG = serverBuilder.build();

        ForgeConfigSpec.Builder clientBuilder = new ForgeConfigSpec.Builder();

        CLIENT_CONFIG = clientBuilder.build();
    }

}
