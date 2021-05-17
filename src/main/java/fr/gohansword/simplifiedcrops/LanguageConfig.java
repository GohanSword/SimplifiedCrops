package fr.gohansword.simplifiedcrops;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguageConfig {


    private File languageConfigFile;
    private FileConfiguration languageConfig;


    public FileConfiguration getLanguageConfig() {
        return this.languageConfig;
    }

    void createlanguageConfig() {
        languageConfigFile = new File(SimplifiedCrops.getInstance().getDataFolder(), "language/"+SimplifiedCrops.getInstance().getConfig().getString("language")+".yml");
        if (!languageConfigFile.exists()) {
            languageConfigFile.getParentFile().mkdirs();
            SimplifiedCrops.getInstance().saveResource("language/"+SimplifiedCrops.getInstance().getConfig().getString("language")+".yml", false);
        }

        languageConfig= new YamlConfiguration();
        try {
            languageConfig.load(languageConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
