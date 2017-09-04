package com.clashnia.superpluginkt.modules

import com.clashnia.superpluginkt.SuperPluginKT

abstract class BaseModule constructor(
        private val plugin : SuperPluginKT,
        private val name : String = "") {

    private var enabled = true

    open fun registerModule() {}

    fun getPlugin() : SuperPluginKT {
        return this.plugin
    }

    fun getName() : String {
        return name
    }
}