package network.ranked.rankedachievements.api.interfaces;

import network.ranked.rankedachievements.api.AchievementSetup;
import network.ranked.rankedachievements.api.abstracts.Achievement;
import org.bukkit.entity.Player;

import java.util.List;

public interface AchievementAPI {

    Achievement getById(String id);

    void registerAchievement(Achievement achievement);

    void registerAchievements(Achievement... achievements);

    void registerAchievements(List<Achievement> achievements);

    void unregisterAchievement(Achievement achievement);

    void addAchievement(Player player, Achievement achievement);

    boolean hasAchievement(Player player, Achievement achievement);

    void registerSetup(AchievementSetup setup);

    List<Achievement> getAchievements();

    List<Achievement> getAchievementsByGameMode(String gameMode);

}
