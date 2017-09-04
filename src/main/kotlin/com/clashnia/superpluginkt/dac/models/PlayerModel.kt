package com.clashnia.superpluginkt.dac.models

import com.iciql.Iciql
import org.bukkit.entity.Player
import java.util.*

@Iciql.IQTable
class PlayerModel constructor(player : Player) {
    @Iciql.IQColumn(primaryKey = true)
    val playerUUID : UUID = player.uniqueId

    @Iciql.IQColumn
    val lastKnownName: String = player.displayName

    @Iciql.IQColumn
    val joinDate : Date = Date()

    @Iciql.IQColumn
    val lastSeen : Date = Date()
}