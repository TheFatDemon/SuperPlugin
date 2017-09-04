package com.clashnia.superpluginkt

import com.clashnia.superpluginkt.modules.BaseModule
import com.clashnia.superpluginkt.modules.playerlog.PlayerLogModule
import org.bukkit.plugin.java.JavaPlugin

class SuperPluginKT : JavaPlugin() {

    var modules = arrayListOf<BaseModule>()

    override fun onEnable() {
        logger.info("Starting SuperPluginKT")

        modules.add(PlayerLogModule(this))

        for (module in modules) {
            module.registerModule()
        }
    }

    override fun onDisable() {
        logger.info("Shutting Down")
    }
}