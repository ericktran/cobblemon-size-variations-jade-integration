package com.xicker.cobblemonsizevariationjade.jade;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class CsvJadePlugin implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(PokemonSizeCategoryProvider.INSTANCE, PokemonEntity.class);
    }
}
