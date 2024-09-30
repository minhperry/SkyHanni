package at.hannibal2.skyhanni.features.inventory

import at.hannibal2.skyhanni.SkyHanniMod
import at.hannibal2.skyhanni.data.model.SkyblockStat
import at.hannibal2.skyhanni.events.LorenzToolTipEvent
import at.hannibal2.skyhanni.skyhannimodule.SkyHanniModule
import at.hannibal2.skyhanni.utils.LorenzUtils
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@SkyHanniModule
object ColoredItemStats {
    private val config get() = SkyHanniMod.feature.inventory.coloredItemStats
    private val replacText = config.replaceTextColor
    private val replaceValue = config.replaceValueColor

    @SubscribeEvent
    fun onItemTooltipRendered(event: LorenzToolTipEvent) {
        if (!isEnabled()) return

        val tooltip = event.toolTip
        tooltip.replaceAll { line ->
            line.replaceLine()
        }
    }

    private fun String.replaceLine(): String {
        return "a"
    }

    private fun isEnabled() = LorenzUtils.inSkyBlock && config.enabled
}
