package com.clashnia.superpluginkt.modules.playerlog

import com.clashnia.superpluginkt.SuperPluginKT
import com.clashnia.superpluginkt.modules.BaseModule

class PlayerLogModule (plugin : SuperPluginKT, name : String) : BaseModule(plugin, name) {
    override fun registerModule() {
        this.getPlugin().logger.info("Starting Register of PlayerLogModule")

        this.getPlugin().server.pluginManager.registerEvents(PlayerLogModuleListener(this.getPlugin()), this.getPlugin())
    }
}