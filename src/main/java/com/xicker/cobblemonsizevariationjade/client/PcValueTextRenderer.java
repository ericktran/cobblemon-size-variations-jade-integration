package com.xicker.cobblemonsizevariationjade.client;

import com.cobblemon.mod.common.client.CobblemonResources;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.Locale;

import static com.cobblemon.mod.common.client.render.RenderHelperKt.drawScaledText;

public final class PcValueTextRenderer {
    private PcValueTextRenderer() {}

    public static void drawSizeValue(GuiGraphics context, float scale, float x, float y) {
        String text = String.format(Locale.ROOT, "%.3f", scale);

        drawScaledText(
            context,
            CobblemonResources.INSTANCE.getDEFAULT_LARGE(),
            Component.literal(text),
            x,
            y,
            0.7f,
            1.0f,
            Integer.MAX_VALUE,
            0xFFE0E0E0,
            false,
            true,
            null,
            null
        );
    }
}