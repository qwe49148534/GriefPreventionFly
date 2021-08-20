package main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("GriefPreventionFly.admin")) {
                if (args.length == 0) {
                    GriefPreventionFly.getPlugin().getPluginConfig().load();
                    player.sendMessage(GriefPreventionFly.translateAlternateColorCodes(
                            GriefPreventionFly.getPlugin().getPluginConfig().getReloadMessage()));
                }
                return true;
            }
            else {
                player.sendMessage(GriefPreventionFly.translateAlternateColorCodes(
                        GriefPreventionFly.getPlugin().getPluginConfig().getNoPermission()
                ));
            }
        }

        return false;
    }
}
