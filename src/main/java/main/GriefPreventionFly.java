package main;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class GriefPreventionFly extends JavaPlugin {

    private static GriefPreventionFly plugin;

    @Override
    public void onEnable() {
        GriefPreventionFly.plugin = this;
        getServer().getPluginManager().registerEvents(new MoveEvent(),this);
    }

    @NotNull
    public static GriefPrevention getGriefPreventionPlugin() {
        return GriefPrevention.instance;
    }

}
