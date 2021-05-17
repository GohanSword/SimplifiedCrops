package fr.gohansword.simplifiedcrops;

import Commands.CommandGive;
import Events.BlockBreakE;
import Utils.ItemsManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplifiedCrops extends JavaPlugin {
    private static SimplifiedCrops plugin;

    public static LanguageConfig language = new LanguageConfig();

    private static SimplifiedCrops instance;

    public static SimplifiedCrops getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {
        ItemsManager.init();
        instance = this;
        this.saveDefaultConfig();
        language.createlanguageConfig();
        getCommand("givehoue").setExecutor(new CommandGive());
        getServer().getPluginManager().registerEvents((Listener)new BlockBreakE(), (Plugin)this);
        String newLine = System.getProperty("line.separator");
        Bukkit.getConsoleSender().sendMessage("   §a________" + newLine + "                   §a| | -- | |" + newLine + "                   §a| |-SC-| |" + newLine + "                   §a| |-->-| |     §8§l[§b§lSimplified§f§lCrops§8§l] §8>> §aLoaded successfully ! V 1.0.0 :)" + newLine + "                   §a| |-SC-| |" + newLine + "                   §a| | -- | |" + newLine + "                 §a§m--------------§r");
    }

    @Override
    public void onDisable() {
        String newLine = System.getProperty("line.separator");
        Bukkit.getConsoleSender().sendMessage("   §c________" + newLine + "                   §c| | -- | |" + newLine + "                   §c| |-SC-| |" + newLine + "                   §c| |-->-| |     §8§l[§b§lSimplified§f§lCrops§8§l] §8>> §cUnloaded successfully ! V 1.0.0 :)" + newLine + "                   §c| |-SC-| |" + newLine + "                   §c| | -- | |" + newLine + "                 §c§m--------------§r");
    }
}
