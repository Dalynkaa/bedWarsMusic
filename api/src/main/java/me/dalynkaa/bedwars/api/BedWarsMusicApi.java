package me.dalynkaa.bedwars.api;

import me.dalynkaa.bedwars.api.interfaces.IMusicManager;

public class BedWarsMusicApi {
    private static IMusicManager api;

    public static IMusicManager getApi() {
        if (api == null) {
            throw new IllegalStateException("API has not been set. Call setApi() first.");
        }
        return api;
    }

    public static void setApi(IMusicManager api1) {
        if (BedWarsMusicApi.api != null) {
            throw new IllegalStateException("API has already been set.");
        }
        System.out.println("API set ");
        api = api1;
    }
}
