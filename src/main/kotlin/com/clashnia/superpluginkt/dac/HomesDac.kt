package com.clashnia.superpluginkt.dac

import com.clashnia.superpluginkt.SuperPluginKT
import com.clashnia.superpluginkt.dac.models.HomeModel
import org.bukkit.Location
import org.bukkit.entity.Player

class HomesDac(plugin: SuperPluginKT) : BaseDac(plugin) {
    fun getHomes(player : Player) : Map<String, Location>? {
        val homes : HashMap<String, Location> = LinkedHashMap()

        val db = this.openDatabase()

        val dummyHome = HomeModel(player)

        val homesFromDB = db.from(dummyHome).where(dummyHome.playerID).`is`(player.uniqueId).select()

        for (dbHome in homesFromDB) {
            val location = Location(player.world, dbHome.x, dbHome.y, dbHome.z, dbHome.pitch, dbHome.yaw)
            homes.put(dbHome.name, location)
        }

        db.close()
        return if (homes.size == 0 ) {
            null
        } else {
            homes
        }
    }

    fun getHome(player: Player, name: String) : Location? {

        val db = this.openDatabase()

        val location : Location

        var homesModel = HomeModel(player)

        homesModel = db
                .from(homesModel)
                .where(homesModel.playerID)
                .`is`(player.uniqueId)
                .and(homesModel.name)
                .`is`(name)
                .selectFirst()

        return if (homesModel == null) {
            null
        } else {
            location = Location(player.world, homesModel.x, homesModel.y, homesModel.z, homesModel.yaw, homesModel.pitch)
            location
        }
    }

    fun deleteHome(player: Player, name : String) {
        val db = this.openDatabase()

        val homeModel = HomeModel(player)

        db.from(homeModel).where(homeModel.playerID).`is`(player.uniqueId).and(homeModel.name).`is`(name).delete()

        db.close()
    }
}