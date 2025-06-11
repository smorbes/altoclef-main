package adris.altoclef.ItemInfo;

import java.util.HashMap;
import java.util.Map;

public class ToolDurabilityMapping {

    // Map of tool names to their durability values
    private static final Map<String, Integer> TOOL_DURABILITY_MAP = new HashMap<>();

    static {
        // Swords
        TOOL_DURABILITY_MAP.put("wooden_sword", 59);
        TOOL_DURABILITY_MAP.put("stone_sword", 131);
        TOOL_DURABILITY_MAP.put("iron_sword", 250);
        TOOL_DURABILITY_MAP.put("diamond_sword", 1561);
        TOOL_DURABILITY_MAP.put("netherite_sword", 2031);

        // Pickaxes
        TOOL_DURABILITY_MAP.put("wooden_pickaxe", 59);
        TOOL_DURABILITY_MAP.put("stone_pickaxe", 131);
        TOOL_DURABILITY_MAP.put("iron_pickaxe", 250);
        TOOL_DURABILITY_MAP.put("diamond_pickaxe", 1561);
        TOOL_DURABILITY_MAP.put("netherite_pickaxe", 2031);

        // Axes
        TOOL_DURABILITY_MAP.put("wooden_axe", 59);
        TOOL_DURABILITY_MAP.put("stone_axe", 131);
        TOOL_DURABILITY_MAP.put("iron_axe", 250);
        TOOL_DURABILITY_MAP.put("diamond_axe", 1561);
        TOOL_DURABILITY_MAP.put("netherite_axe", 2031);

        // Shovels
        TOOL_DURABILITY_MAP.put("wooden_shovel", 59);
        TOOL_DURABILITY_MAP.put("stone_shovel", 131);
        TOOL_DURABILITY_MAP.put("iron_shovel", 250);
        TOOL_DURABILITY_MAP.put("diamond_shovel", 1561);
        TOOL_DURABILITY_MAP.put("netherite_shovel", 2031);

        // Other tools can be added here...
    }

    public static int getDurability(String itemName) {
        return TOOL_DURABILITY_MAP.getOrDefault(itemName, 0);  // Default to 0 if item is not found
    }
}
