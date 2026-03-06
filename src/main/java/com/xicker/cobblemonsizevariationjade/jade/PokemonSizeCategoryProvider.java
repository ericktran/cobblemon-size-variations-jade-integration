package com.xicker.cobblemonsizevariationjade.jade;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import dev.cudzer.cobblemonsizevariation.CobblemonSizeVariation;
import dev.cudzer.cobblemonsizevariation.config.Size;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public class PokemonSizeCategoryProvider implements IEntityComponentProvider {

    public static final PokemonSizeCategoryProvider INSTANCE = new PokemonSizeCategoryProvider();
    public static final ResourceLocation ID =
            ResourceLocation.fromNamespaceAndPath("cobblemonsizevariationjade", "pokemon_size_category");

    private PokemonSizeCategoryProvider() {}

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config) {
        if (!(accessor.getEntity() instanceof PokemonEntity pokemonEntity)) {
            return;
        }

        if (CobblemonSizeVariation.SIZER == null) {
            return;
        }

        float scale = pokemonEntity.getPokemon().getScaleModifier();
        Size sizeInfo = CobblemonSizeVariation.SIZER.getSizeInformation(scale);

        if (sizeInfo == null) {
            return;
        }

        float min = Float.parseFloat(sizeInfo.min());
        float max = Float.parseFloat(sizeInfo.max());
        float displayed = Math.max(min, Math.min(max, scale));

        String hex = sizeInfo.color();
        int rgb = Integer.parseInt(hex.substring(1), 16);

        tooltip.add(Component.literal("Size Category: ")
                .append(Component.literal(
                        String.format("%s (~%.3f)", sizeInfo.name(), displayed)).withColor(rgb)
        ));
    }
}