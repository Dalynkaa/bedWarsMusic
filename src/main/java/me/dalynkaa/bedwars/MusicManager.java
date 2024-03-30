package me.dalynkaa.bedwars;

import me.dalynkaa.bedwars.api.interfaces.IMusicManager;

public class MusicManager implements IMusicManager {

    @Override
    public Integer getPluginVersion() {
        return 1;
    }

    @Override
    public Integer getCoreVersion() {
        return 1;
    }

    @Override
    public String getPluginName() {
        return "null";
    }
}
