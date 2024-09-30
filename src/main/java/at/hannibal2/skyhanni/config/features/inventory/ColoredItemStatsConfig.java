package at.hannibal2.skyhanni.config.features.inventory;

import at.hannibal2.skyhanni.config.FeatureToggle;
import com.google.gson.annotations.Expose;
import io.github.notenoughupdates.moulconfig.annotations.ConfigEditorBoolean;
import io.github.notenoughupdates.moulconfig.annotations.ConfigOption;

public class ColoredItemStatsConfig {
    @Expose
    @ConfigOption(name = "Enabled", desc = "Enables the coloring of item stats.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean enabled = true;

    @Expose
    @ConfigOption(name = "Replace Text Color", desc = "Replacing the text of the stat.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean replaceTextColor = true;

    @Expose
    @ConfigOption(name = "Replace Value Color", desc = "Replacing the value of the stat.")
    @ConfigEditorBoolean
    @FeatureToggle
    public boolean replaceValueColor = true;

}
