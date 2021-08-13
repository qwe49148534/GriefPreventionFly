package main;

import main.yaml.PluginConfig;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class GriefPreventionFly extends JavaPlugin {

    private static GriefPreventionFly plugin;

    // 代表 Config 物件
    private PluginConfig config;

    @Override
    public void onEnable() {
        GriefPreventionFly.plugin = this;

        // 註冊檔案
        this.config = new PluginConfig();

        // 註冊事件
        getServer().getPluginManager().registerEvents(new MoveEvent(),this);
    }

    @NotNull
    public static GriefPrevention getGriefPreventionPlugin() {
        return GriefPrevention.instance;
    }

    @NotNull
    public static GriefPreventionFly getPlugin() { return plugin; }

    @NotNull
    public PluginConfig getPluginConfig() {
        return this.config;
    }

}
