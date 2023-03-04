
# RankedAchievementsAPI

Not like you can do anything with it.


## Installation

```xml
<dependency>
    <groupId>com.github.JustReddy7397</groupId>
    <artifactId>RankedAchievementsAPI</artifactId>
    <version>1.1</version>
</dependency>

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
## Usage
**Ok, now that you've installed it, let's use it!**

**First, we need to register an achievement setup**
```java
// String (Name, Will auto lowercase) - ItemStack (Icon) - Integer (Inventory Slot)
AchievementSetup setup = new AchievementSetup("SkyWars", new ItemStack(Material.BOW), 17);
Achievements.getApi().registerSetup(setup);
```

**Okay, now that we've registered a setup, we can create an achievement :D**
```java
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestAchievement extends Achievement{

    /**
     * @param id - String - The unique ID of this achievement ( all lowercase )
     * @param name - String - The name of this achievement
     * @param description - String[] - The description of this achievement
     * @param gameMode - String - The gamemode of this achievement ( all lowercase )
     * @param requiredAmount - int - The required amount to get this achievement ( 1 for single time )
     * @param commands - String[] - The commands needed to be executed once the player gets this achievement
     * @param points - int - The achievement points of this achievement
     * @param weight - int - The weight of this achievement ( used for styling the gui )
     * @param counter - Map<UUID, Integer> - The counter Map, used for counting the amount of this
     *                achievement has been triggered, if the counters integer is greater or equals to the required
     *                amount, it adds the achievement to the player.
     *                Recommend: new HashMap<>();
     */
    public TestAchievement() {
        super(
                "test",
                "Test",
                new String[]{"This is a test achievement", "Believe it or not"},
                "test", 
                1,
                new String[]{}, 
                69, 
                420, 
                new HashMap<>());
    }
}
```
**So we've created our achievement, but it isn't actually registered yet.. lets do that now**
```java
@Override
public void onEnable() {
    Achievements.getApi().registerAchievement(new TestAchievement());
}
```
**We've registered our achievement YAY! But it does nothing? Let's fix that.**
```java
// We'll use a player join event as an example here
@EventHandler
public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    // Getting the achievement by its unique id
    Achievements.getApi().getById("test").trigger(player);
    // This triggers the achievement, adding a +1 to the counter we created above.
}
```

**PHEW, that was all...**



## Support
**If you still don't get it, contact me on discord: Reddy#4766**
**And no, I won't be giving you the actual plugin this api depends on :)**