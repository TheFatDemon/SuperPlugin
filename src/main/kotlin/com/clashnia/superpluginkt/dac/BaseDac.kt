package com.clashnia.superpluginkt.dac

import com.clashnia.superpluginkt.SuperPluginKT
import com.iciql.Db

abstract class BaseDac constructor (private val plugin : SuperPluginKT) {

    fun openDatabase() : Db {
        val config = this.plugin.config

        return Db.open("jdbc:mysql://" +
                config.getString("mysql.host") +
                ":" + config.getString("mysql.port") +
                "/" + config.getString("mysql.database"),
                config.getString("mysql.user"),
                config.getString("mysql.pass"))
    }
}