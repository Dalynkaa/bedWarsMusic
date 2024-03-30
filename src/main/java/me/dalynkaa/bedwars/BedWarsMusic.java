package me.dalynkaa.bedwars;

import me.dalynkaa.bedwars.api.interfaces.IMusicManager;
import me.dalynkaa.bedwars.api.BedWarsMusicApi;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedWarsMusic extends JavaPlugin{
    @Override
    public void onEnable() {
        MusicManager musicManager = new MusicManager();
        BedWarsMusicApi.setApi(musicManager);
    }

    @Override
    public void onDisable() {
        getLogger().info("BedWarsMusic has been disabled!");
    }
}