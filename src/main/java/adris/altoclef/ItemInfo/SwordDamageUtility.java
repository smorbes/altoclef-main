package adris.altoclef.ItemInfo;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.HashMap;
import java.util.Map;

public class SwordDamageUtility {

    // Create a map to store the sword names and their corresponding attack damage
    private static final Map<String, Float> swordDamageMap = new HashMap<>();

    static {
        // Populate the map with sword names and their damage values
        swordDamageMap.put("wooden_sword", 4.0f);
        swordDamageMap.put("stone_sword", 5.0f);
        swordDamageMap.put("iron_sword", 6.0f);
        swordDamageMap.put("diamond_sword", 7.0f);
        swordDamageMap.put("netherite_sword", 8.0f);
        swordDamageMap.put("golden_sword", 4.0f);  // Golden swords typically have lower damage
    }

    public static float getSwordDamage(String swordName) {
        return swordDamageMap.getOrDefault(swordName.toLowerCase(), 0.0f); // Return 0 if not found
    }

}
