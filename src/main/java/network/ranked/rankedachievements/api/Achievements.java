package network.ranked.rankedachievements.api;

import network.ranked.rankedachievements.api.interfaces.AchievementAPI;

public class Achievements {

    private static AchievementAPI instance;

    public static AchievementAPI getApi() {
        if (instance == null) throw new IllegalStateException("AchievementAPI is null.");
        return instance;
    }

    public static void setInstance(AchievementAPI api) {
        instance = api;
    }

}
