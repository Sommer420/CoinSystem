package com.sommer.coinsystem;

import com.sommer.coinsystem.coins.CoinCommand;
import com.sommer.coinsystem.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {
    public static Config coinConfig, data, items, license;
    public static FileConfiguration coinConfigYML, itemsYML, dataYML, licenseYML;
    public static Main instance;
    @Override
    public void onEnable() {
        //Opretter configs:
        instance = this;
        //Playerdata filer til coins:
        if (!(new File(getDataFolder(), "playerdata.yml")).exists())saveResource("playerdata.yml", false);
        coinConfig = new Config(this, null, "playerdata.yml");
        coinConfigYML = coinConfig.getConfig();
        //new GuiManager();
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
        getCommand("coins").setExecutor(new CoinCommand(this));
        System.out.println("Pluginet starter..");
    }


    public static Main getInstance(){return instance;}

    @Override
    public void onDisable() {System.out.println("Pluginet slået fra..");}





}
