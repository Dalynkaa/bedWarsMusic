package me.dalynkaa.bedwars;

import me.dalynkaa.bedwars.api.interfaces.IMusicManager;
import me.dalynkaa.bedwars.api.BedWarsMusicApi;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedWarsMusic extends JavaPlugin implements IMusicManager{
    @Override
    public void onEnable() {
        BedWarsMusicApi.setApi(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("BedWarsMusic has been disabled!");
    }

    @Override
    public Integer getPluginVersion() {
        return 1;
    }

    @Override
    public String getPluginName() {
        return "BedWarsMusic";
    }
}