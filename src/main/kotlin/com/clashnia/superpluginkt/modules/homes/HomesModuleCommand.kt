package com.clashnia.superpluginkt.modules.homes

import com.clashnia.superpluginkt.dac.HomesDac
import com.clashnia.superpluginkt.modules.BaseCommand
import com.clashnia.superpluginkt.modules.BaseCommand.CommandResult.*
import com.clashnia.superpluginkt.modules.plus
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HomesModuleCommand (module : HomesModule) : BaseCommand(module) {
    override fun runCommand(sender: CommandSender, command: Command, args: Array<out String>?): CommandResult {

        if (command.name == "home") {
            // Handle /home

            // We need to check if a Player
            if (sender !is Player) {
                return PLAYER_ONLY
            }

            // sender is now automatically a Player (Kotlin Magic)

            // We Check for Player Permission
            if (!sender.hasPermission("superplugin.home.home")) {
                return NO_PERMISSIONS
            }

            val homeDac = HomesDac(this.module.getPlugin())

            val home = homeDac.getHome(sender)

            home?.let { location ->
                sender.sendMessage(ChatColor.AQUA + "Home Sweet Home")
                sender.teleport(location)
                return SUCCESS
            }

            sender.sendMessage(ChatColor.AQUA + "No Home Set")
            return SILENT_ERROR

//            return if (home != null) {
//                sender.sendMessage(ChatColor.AQUA + "Home Sweet Home")
//                sender.teleport(home)
//                SUCCESS
//            } else {
//                sender.sendMessage(ChatColor.AQUA + "No Home Set")
//                SILENT_ERROR
//            }

        } else if (command.name == "homes") {
            // Handle /homes
            // Player Check
            if (sender !is Player) {
                return PLAYER_ONLY
            }

            // Handle Listing Homes

            if (!sender.hasPermission("superplugin.home.homes")) {
                return NO_PERMISSIONS
            }

            val homesDac = HomesDac(this.module.getPlugin())

            sender.sendMessage(ChatColor.AQUA + "List of Homes")
            homesDac.getHomes(sender)?.forEach { homes ->
                sender.sendMessage(ChatColor.AQUA + homes.key)
            }
            return SUCCESS
        } else if (command.name == "sethome") {
            // Handle /sethome
            // Player Check
            if (sender !is Player) {
                return PLAYER_ONLY
            }

            // Handle setting Home

            if (!sender.hasPermission("superplugin.home.sethome")) {
                return NO_PERMISSIONS
            }



        } else if (command.name == "delhome") {
            // Handle /delhome
            // Player Check
            if (sender !is Player) {
                return PLAYER_ONLY
            }

            if (!sender.hasPermission("superplugin.home.delhome")) {
                return NO_PERMISSIONS
            }

            val homesDac = HomesDac(this.module.getPlugin())


        }

        return SILENT_ERROR
    }
}