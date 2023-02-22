package network.ranked.rankedachievements.api;

import lombok.Data;
import org.bukkit.inventory.ItemStack;

@Data
public class AchievementSetup {

    private final String gamemode;
    private final ItemStack icon;
    private final int inventoryPosition;

}
