package adris.altoclef.ItemInfo;

import java.util.Set;
import java.util.HashSet;

public class ToolIdentifier {
    private static final Set<String> TOOL_NAMES = new HashSet<>();

    static {
        // Pickaxes
        TOOL_NAMES.add("wooden_pickaxe");
        TOOL_NAMES.add("stone_pickaxe");
        TOOL_NAMES.add("iron_pickaxe");
        TOOL_NAMES.add("diamond_pickaxe");
        TOOL_NAMES.add("netherite_pickaxe");

        // Axes
        TOOL_NAMES.add("wooden_axe");
        TOOL_NAMES.add("stone_axe");
        TOOL_NAMES.add("iron_axe");
        TOOL_NAMES.add("diamond_axe");
        TOOL_NAMES.add("netherite_axe");

        // Shovels
        TOOL_NAMES.add("wooden_shovel");
        TOOL_NAMES.add("stone_shovel");
        TOOL_NAMES.add("iron_shovel");
        TOOL_NAMES.add("diamond_shovel");
        TOOL_NAMES.add("netherite_shovel");
        // Hoes
        TOOL_NAMES.add("wooden_hoe");
        TOOL_NAMES.add("stone_hoe");
        TOOL_NAMES.add("iron_hoe");
        TOOL_NAMES.add("diamond_hoe");
        TOOL_NAMES.add("netherite_hoe");

        // Swords
        TOOL_NAMES.add("wooden_sword");
        TOOL_NAMES.add("stone_sword");
        TOOL_NAMES.add("iron_sword");
        TOOL_NAMES.add("diamond_sword");
        TOOL_NAMES.add("netherite_sword");

        // Shears
        TOOL_NAMES.add("shears");

        // Crossbows and Bows
        TOOL_NAMES.add("bow");
        TOOL_NAMES.add("crossbow");

        // Trident
        TOOL_NAMES.add("trident");

        // Flint and Steel
        TOOL_NAMES.add("flint_and_steel");

        // Fishing Rod
        TOOL_NAMES.add("fishing_rod");

        // Shield
        TOOL_NAMES.add("shield");

        // Mace (new tool in 1.21.4)
        TOOL_NAMES.add("mace");

        // Other tools
        TOOL_NAMES.add("carrot_on_a_stick");
    }

    public static boolean isTool(String itemName) {
        return TOOL_NAMES.contains(itemName);
    }
}
