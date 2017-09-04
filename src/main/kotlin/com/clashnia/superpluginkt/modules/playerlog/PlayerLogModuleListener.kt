package com.clashnia.superpluginkt.modules.playerlog

import com.clashnia.superpluginkt.SuperPluginKT
import com.clashnia.superpluginkt.dac.PlayerDac
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerLoginEvent

class PlayerLogModuleListener constructor(val plugin : SuperPluginKT) : Listener {

    @EventHandler
    fun playerLoggedIn(event : PlayerLoginEvent) {
        val playerDac = PlayerDac(plugin)


        try {
            if (playerDac.addPlayer(event.player)) {
                // Player Joined for first time
            } else {
                // Player has been here before
            }
        } catch (e: Exception) {
            // Something Happened...
        }

    }
}