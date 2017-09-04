package com.clashnia.superpluginkt.modules.homes

import com.clashnia.superpluginkt.SuperPluginKT
import com.clashnia.superpluginkt.modules.BaseModule

class HomesModule (plugin : SuperPluginKT) : BaseModule(plugin, "HomesModule") {
    override fun registerModule() {
        super.registerModule()

        this.getPlugin().server.logger.info("Starting Register of " + getName())


    }
}