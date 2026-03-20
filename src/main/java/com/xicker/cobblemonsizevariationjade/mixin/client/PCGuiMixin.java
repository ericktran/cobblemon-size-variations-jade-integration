package com.xicker.cobblemonsizevariationjade.mixin.client;

import com.cobblemon.mod.common.client.gui.pc.PCGUI;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.xicker.cobblemonsizevariationjade.client.PcValueTextRenderer;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PCGUI.class)
public class PCGuiMixin {

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screens/Screen;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V"
        )
    )
    private void csvjade$displaySizeValue(GuiGraphics context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        PCGUI pcgui = (PCGUI) (Object) this;

        int x = (pcgui.width - PCGUI.BASE_WIDTH) / 2;
        int y = (pcgui.height - PCGUI.BASE_HEIGHT) / 2;

        Pokemon pokemon = pcgui.getPreviewPokemon$common();
        if (pokemon == null) {
            return;
        }

        float scale = pokemon.getScaleModifier();

        // CobblemonSizeVariation draws category at x + 10, y + 22.
        // This puts the raw value just to the right of it
        PcValueTextRenderer.drawSizeValue(context, scale, x + 10, y + 27);
    }
}