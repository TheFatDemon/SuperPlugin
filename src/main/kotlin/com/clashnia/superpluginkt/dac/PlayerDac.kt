package com.clashnia.superpluginkt.dac

import com.clashnia.superpluginkt.SuperPluginKT
import com.clashnia.superpluginkt.dac.models.PlayerModel
import org.bukkit.entity.Player
import java.util.*

class PlayerDac (plugin : SuperPluginKT) : BaseDac(plugin) {

    fun addPlayer(player : Player): Boolean {
        val db = this.openDatabase()

        val playerModel = PlayerModel(player)

        return if (db
                .from(playerModel)
                .where(playerModel.playerUUID)
                .`is`(player.uniqueId).select()
                .size == 0) {

            // Player joined for the first time
            db.insert(playerModel)
            db.close()
            true
        } else {
            // Player has been here before
            db
                .from(playerModel)
                .set(playerModel.lastSeen)
                .to(Date())
                .set(playerModel.lastKnownName)
                .to(player.displayName)
                .where(playerModel.playerUUID)
                .`is`(player.uniqueId)
                .update()
            db.close()
            false
        }
    }


}