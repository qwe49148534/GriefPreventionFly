package main;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveEvent implements Listener {

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();

        if (player.hasPermission("GriefPreventionFly.use") && !player.hasPermission("GriefPreventionFly.admin")) {
            final Claim claimAt = GriefPreventionFly.getGriefPreventionPlugin().dataStore.getClaimAt(
                    player.getLocation(),
                    true,
                    null
            );

            if (claimAt != null && claimAt.hasExplicitPermission(player , ClaimPermission.Access)) {

                if (!player.getAllowFlight()) {
                    player.setAllowFlight(true);
                    player.sendMessage(GriefPreventionFly.translateAlternateColorCodes(
                            GriefPreventionFly.getPlugin().getPluginConfig().getJoinMessage()));
                }

            } else {
                if (player.isFlying()) {
                    Util.tpPlayerToSafeLocation(player);

                    player.setAllowFlight(false);
                    player.sendMessage(GriefPreventionFly.translateAlternateColorCodes(
                            GriefPreventionFly.getPlugin().getPluginConfig().getLeaveMessage()));
                }
            }
        }
    }




}
