package network.ranked.rankedachievements.api.abstracts;

import com.google.gson.InstanceCreator;
import network.ranked.rankedachievements.api.Achievements;
import org.bukkit.entity.Player;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Achievement {

    private final String id;
    private final String name;
    private final String[] description;
    private final String gameMode;
    private final int requiredAmount;
    private final String[] commands;
    private final int points;
    private final int weight;
    private final Map<UUID, Integer> counter;

    public Achievement(String id, String name, String[] description, String gameMode, int requiredAmount, String[] commands, int points, int weight, Map<UUID, Integer> counter) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.gameMode = gameMode;
        this.requiredAmount = requiredAmount;
        this.commands = commands;
        this.points = points;
        this.weight = weight;
        this.counter = counter;
    }

    /**
     * The unique id of this achievement
     * @return The unique id of this achievement
     */
    public String getId() {
        return id;
    }

    /**
     * The name of this achievement, used for item names and stuff
     * @return The name of this achievement
     */
    public String getName() {
        return name;
    }


    /**
     * The description of the achievement.
     * Gets auto split with \n
     * @return A description of the achievement.
     */
    public String[] getDescription() {
        return description;
    }

    /**
     * The game mode of the achievement.
     * Used for styling GUI's
     * @return The game mode of the achievement.
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     * The required amount of counters ( see map above ) needed to complete the achievement.
     * @return An integer of the required amount of counters needed to complete the achievement.
     */
    public int getRequiredAmount() {
        return requiredAmount;
    }

    /**
     * The commands to be executed once this achievement is achieved.
     * @return The commands needed to be executed.
     */
    public String[] getCommands() {
        return commands;
    }

    /**
     * The amount of achievement points you get.
     * @return The amount of achievement points you get.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Just for the menu
     * @return The weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Used for counting the required amount.
     * @return A map that contains a UUID and an Integer
     */
    public Map<UUID, Integer> getCounter() {
        return counter;
    }

    /**
     * This should be called once someone does something within the achievement.
     * @param player - The player
     */
    public void trigger(Player player) {
        if (Achievements.getApi().hasAchievement(player, this)) return;
        if (!getCounter().containsKey(player.getUniqueId())) getCounter().put(player.getUniqueId(), 0);
        getCounter().replace(player.getUniqueId(), getCounter().get(player.getUniqueId()),  (getCounter().get(player.getUniqueId()) + 1));
        if (getRequiredAmount() != getCounter().get(player.getUniqueId())) return;
        onComplete(player);
    }

    /**
     * Called when someone completes the achievement.
     * @param player - The player.
     */
    public void onComplete(Player player) {
        Achievements.getApi().addAchievement(player, this);
    }

}
