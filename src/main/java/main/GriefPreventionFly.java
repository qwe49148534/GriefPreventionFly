package main;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class GriefPreventionFly
        extends JavaPlugin
        implements Listener {

    private static GriefPreventionFly plugin;

    @Override
    public final void onEnable() {
        GriefPreventionFly.plugin = this;
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public final void onDisable() {
    }

    @EventHandler
    public final void onPlayerMove(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();

        if (player.hasPermission("GriefPreventionFly.use")) {
            final Claim claimAt = GriefPreventionFly.getGriefPreventionPlugin().dataStore.getClaimAt(
                    player.getLocation(),
                    true,
                    null
            );

            if (player.hasPermission("GriefPreventionFly.admin"))
                return;

            if (claimAt != null && claimAt.hasExplicitPermission(player, ClaimPermission.Access)) {
                if (player.getAllowFlight())
                    return;

                player.setAllowFlight(true);
                player.sendMessage("你已經設置飛行");
            } else {
                if (!player.getAllowFlight())
                    return;

                this.tpPlayerToSafeLocation(player);
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage("你已經停止飛行");
            }
        }
    }

    public final void tpPlayerToSafeLocation(final @NotNull Player player) {
        final Location location = player.getLocation();
        for (int y = location.getBlockY(); y >= 20; y--) {
            final Block blockAt = player.getWorld().getBlockAt(new Location(player.getWorld(), location.getBlockX(), y, location.getBlockZ()));
            if (!blockAt.getType().equals(Material.AIR)) {
                player.teleport(new Location(player.getWorld(), location.getBlockX(), y + 1.0D, location.getBlockZ()));
                return;
            }
        }
    }

    @NotNull
    public static GriefPrevention getGriefPreventionPlugin() {
        return GriefPrevention.instance;
    }

    @NotNull
    public static GriefPreventionFly getInstance() {
        return GriefPreventionFly.plugin;
    }

}
