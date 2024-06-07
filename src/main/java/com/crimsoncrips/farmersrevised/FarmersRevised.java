package com.crimsoncrips.farmersrevised;

import com.crimsoncrips.farmersrevised.event.FarmersRevisedEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmersRevised.MODID)
public class FarmersRevised {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "farmersrevised";


    public FarmersRevised() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(new FarmersRevisedEvents());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
