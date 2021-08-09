package main;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import static main.GriefPreventionFly.getPlugin;

public class Config {
    private static  File file;
    private static FileConfiguration customFile;
//
//    public static void Setup() {
//        //檔案路徑讀取位置
//        File file = new File(GriefPreventionFly.getPlugin().getDataFolder() + File.pathSeparator + "config.yml");
//
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException ignored) {}
//        }
//        customFile = YamlConfiguration.loadConfiguration(file);
//
//    }
    public static @NotNull YamlConfiguration getFile(String FileName){
        File  file = new File(getPlugin().getDataFolder(), FileName);
        if (!file.exists()){
            getPlugin().saveResource(FileName , false);
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void createFiles(){
        Configuration config = getFile("config.yml");
    }

}
