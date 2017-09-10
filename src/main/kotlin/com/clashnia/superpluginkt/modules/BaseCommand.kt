package com.clashnia.superpluginkt.modules

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

abstract class BaseCommand (protected val module: BaseModule) : CommandExecutor {
    enum class CommandResult {
        NO_PERMISSIONS,
        PLAYER_ONLY,
        CONSOLE_ONLY,
        ERROR,
        SILENT_ERROR,
        SUCCESS
    }

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        when (this.runCommand(sender!!, command!!, args)) {

            BaseCommand.CommandResult.NO_PERMISSIONS -> {
                sender.sendMessage(ChatColor.RED + "[" + module.getName() + "] You're not allowed!")
            }
            BaseCommand.CommandResult.PLAYER_ONLY -> {
                sender.sendMessage(ChatColor.RED + "[" + module.getName() + "] Silly!")
            }
            BaseCommand.CommandResult.CONSOLE_ONLY -> {
                sender.sendMessage(ChatColor.RED + "[" + module.getName() + "] You should know better!")
            }
            BaseCommand.CommandResult.ERROR -> {
                sender.sendMessage(ChatColor.RED + "[" + module.getName() + "] Lol oops")
            }
            BaseCommand.CommandResult.SILENT_ERROR,
            BaseCommand.CommandResult.SUCCESS -> {
                // Do Nothing
            }
        }

        return true
    }

    abstract fun runCommand(sender : CommandSender, command : Command, args : Array<out String>?) : CommandResult
}

operator fun ChatColor.plus(s: String) : String = this.toString() + s
