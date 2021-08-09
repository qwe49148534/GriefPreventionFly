package main;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class GriefPreventionFly extends JavaPlugin {

    private static GriefPreventionFly plugin;
    public static GriefPreventionFly getPlugin() { return plugin; }

    @Override
    public void onEnable() {
        GriefPreventionFly.plugin = this;
        getServer().getPluginManager().registerEvents(new MoveEvent(),this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Config.createFiles();
    }

    @NotNull
    public static GriefPrevention getGriefPreventionPlugin() {
        return GriefPrevention.instance;
    }


}
