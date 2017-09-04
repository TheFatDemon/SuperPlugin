package com.clashnia.superpluginkt.dac.models

import com.iciql.Iciql
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

@Iciql.IQTable
class HomeModel {
    @Iciql.IQColumn(primaryKey = true)
    var id : UUID

    @Iciql.IQColumn
    var playerID : UUID

    @Iciql.IQColumn
    var x : Double

    @Iciql.IQColumn
    var y : Double

    @Iciql.IQColumn
    var z : Double

    @Iciql.IQColumn
    var pitch : Float

    @Iciql.IQColumn
    var yaw : Float

    @Iciql.IQColumn
    var name : String

    constructor(player: Player) {
        id = UUID.randomUUID()
        playerID = player.uniqueId
        x = player.location.x
        y = player.location.y
        z = player.location.z
        pitch = player.location.pitch
        yaw = player.location.yaw
        this.name = "Main"
    }

    constructor(id : UUID, location: Location, playerUUID : UUID, name : String = "Main") {
        this.id = id
        this.playerID = playerUUID
        this.x = location.x
        this.y = location.y
        this.z = location.z
        this.pitch = location.pitch
        this.yaw = location.yaw
        this.name = name
    }
}