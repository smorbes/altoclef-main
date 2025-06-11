package adris.altoclef.ItemInfo;


import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.HashMap;
import java.util.Map;

public class ArmorToughnessUtility {

    // Create a map to store individual armor items (helmet, chestplate, leggings, boots) and their corresponding toughness values
    private static final Map<String, Float> armorToughnessMap = new HashMap<>();

    static {
        // Populate the map with specific armor types and their toughness values
        armorToughnessMap.put("leather_helmet", 0.0f); // Leather Helmet
        armorToughnessMap.put("leather_chestplate", 0.0f); // Leather Chestplate
        armorToughnessMap.put("leather_leggings", 0.0f); // Leather Leggings
        armorToughnessMap.put("leather_boots", 0.0f); // Leather Boots

        armorToughnessMap.put("chainmail_helmet", 2.0f); // Chainmail Helmet
        armorToughnessMap.put("chainmail_chestplate", 2.0f); // Chainmail Chestplate
        armorToughnessMap.put("chainmail_leggings", 2.0f); // Chainmail Leggings
        armorToughnessMap.put("chainmail_boots", 2.0f); // Chainmail Boots

        armorToughnessMap.put("iron_helmet", 2.0f); // Iron Helmet
        armorToughnessMap.put("iron_chestplate", 2.0f); // Iron Chestplate
        armorToughnessMap.put("iron_leggings", 2.0f); // Iron Leggings
        armorToughnessMap.put("iron_boots", 2.0f); // Iron Boots

        armorToughnessMap.put("diamond_helmet", 3.0f); // Diamond Helmet
        armorToughnessMap.put("diamond_chestplate", 3.0f); // Diamond Chestplate
        armorToughnessMap.put("diamond_leggings", 3.0f); // Diamond Leggings
        armorToughnessMap.put("diamond_boots", 3.0f); // Diamond Boots

        armorToughnessMap.put("netherite_helmet", 3.0f); // Netherite Helmet
        armorToughnessMap.put("netherite_chestplate", 3.0f); // Netherite Chestplate
        armorToughnessMap.put("netherite_leggings", 3.0f); // Netherite Leggings
        armorToughnessMap.put("netherite_boots", 3.0f); // Netherite Boots

        armorToughnessMap.put("golden_helmet", 1.0f); // Golden Helmet
        armorToughnessMap.put("golden_chestplate", 1.0f); // Golden Chestplate
        armorToughnessMap.put("golden_leggings", 1.0f); // Golden Leggings
        armorToughnessMap.put("golden_boots", 1.0f); // Golden Boots
    }

    // Method to get armor toughness based on the armor item name (e.g., "diamond_helmet")
    public static float getArmorToughness(String armorName) {
        return armorToughnessMap.getOrDefault(armorName.toLowerCase(), 0.0f); // Return 0 if not found
    }

    // You can also directly use the ArmorItem material if needed
    public static float getArmorToughness(Item armorItem) {
        // Fetch the armor's translation key (e.g., "minecraft:diamond_helmet")
        String armorName = armorItem.getTranslationKey();
        return getArmorToughness(armorName);
    }
}
