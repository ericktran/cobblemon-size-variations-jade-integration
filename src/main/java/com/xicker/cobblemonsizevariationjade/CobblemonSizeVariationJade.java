package com.xicker.cobblemonsizevariationjade;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CobblemonSizeVariationJade.MODID)
public class CobblemonSizeVariationJade {
    public static final String MODID = "cobblemonsizevariationjade";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CobblemonSizeVariationJade(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("CobblemonSizeVariation-Jade Integration loaded");
    }
}
