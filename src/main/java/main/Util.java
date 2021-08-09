package main;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 有關對於插件可用的幫助方法
 */
public final class Util {

    /**
     * 將玩家傳送到有效的安全位置
     * @param player 運行玩家
     */
    public static void tpPlayerToSafeLocation(final @NotNull Player player) {
        // 獲取玩家當前位置
        final Location location = player.getLocation();

        // 迴圈判斷有效位置
        for (int y = location.getBlockY(); y >= 0; y--) {

            // 獲取所在位置的方塊
            final Block blockAt =
                    player.getWorld().getBlockAt
                            (new Location(player.getWorld(), location.getBlockX(), y , location.getBlockZ()));

            // 如果方塊不是空氣，代表是安全位置
            if (!blockAt.getType().equals(Material.AIR)) {
                // 將玩家傳送至此
                player.teleport(new Location(player.getWorld(), location.getBlockX(), y + 1.0D , location.getBlockZ()));

                // 產生特效
                player.spawnParticle(Particle.REDSTONE, location.add(player.getLocation().getBlockX() + 0.5D , player.getLocation().getBlockY() + 0.5D , player.getLocation().getBlockZ() + 0.5D), 10, new Particle.DustTransition(Color.RED, Color.AQUA, 2f));
                return; // 返回
            }

        }

    }

}
