package main.yaml;

import main.GriefPreventionFly;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * 代表檔案處禮物建
 */
public class PluginYamlObject {

    protected final File file;

    protected YamlConfiguration configuration;

    public PluginYamlObject(final @NotNull String fileName) {
        final GriefPreventionFly plugin = GriefPreventionFly.getPlugin();

        this.file = new File(plugin.getDataFolder(), fileName);
        if (!this.exists())
            plugin.saveResource(fileName, false);

        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    /**
     * 實體檔案載入記憶體
     */
    public final void load() {
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    /**
     * 記憶體保存至實體檔案
     */
    public final void save() {
        try {
            this.configuration.save(this.file);
        } catch (IOException e) { e.printStackTrace(); }
    }


    public final void set(final @NotNull String path, final @NotNull Object obj) {
        this.configuration.set(path, obj);
    }

    public final boolean exists() {
        return this.file.exists();
    }

    @NotNull
    public final File getFile() {
        return file;
    }

    @NotNull
    public final YamlConfiguration getConfiguration() {
        return configuration;
    }

}
