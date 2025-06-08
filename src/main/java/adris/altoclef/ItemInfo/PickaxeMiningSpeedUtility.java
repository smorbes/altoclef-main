package adris.altoclef.ItemInfo;

import java.util.HashMap;
import java.util.Map;

public class PickaxeMiningSpeedUtility {

    // Map to store pickaxe names and their mining speed multipliers
    private static final Map<String, Float> pickaxeSpeedMap = new HashMap<>();

    static {
        // Populate the map with pickaxe names and their mining speed multipliers
        pickaxeSpeedMap.put("wooden_pickaxe", 2.0f);
        pickaxeSpeedMap.put("stone_pickaxe", 4.0f);
        pickaxeSpeedMap.put("iron_pickaxe", 6.0f);
        pickaxeSpeedMap.put("diamond_pickaxe", 8.0f);
        pickaxeSpeedMap.put("netherite_pickaxe", 9.0f);
        pickaxeSpeedMap.put("golden_pickaxe", 12.0f);
    }

    // Method to get the mining speed based on the pickaxe name
    public static float getMiningSpeed(String pickaxeName) {
        return pickaxeSpeedMap.getOrDefault(pickaxeName.toLowerCase(), 0.0f); // Return 0 if not found
    }
}
