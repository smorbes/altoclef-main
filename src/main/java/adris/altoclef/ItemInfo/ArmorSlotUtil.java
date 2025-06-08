package adris.altoclef.ItemInfo;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ArmorItem;

public class ArmorSlotUtil {

    public static EquipmentSlot getArmorSlot(ArmorItem armorItem) {
        if (armorItem == null) {
            return EquipmentSlot.HEAD; // Default to HEAD if not recognized
        }

        String itemName = armorItem.getTranslationKey().toLowerCase();

        // Map armor types to EquipmentSlot
        if (itemName.contains("helmet") || itemName.contains("head")) {
            return EquipmentSlot.HEAD;
        } else if (itemName.contains("chestplate") || itemName.contains("chest")) {
            return EquipmentSlot.CHEST;
        } else if (itemName.contains("leggings") || itemName.contains("legs")) {
            return EquipmentSlot.LEGS;
        } else if (itemName.contains("boots") || itemName.contains("feet")) {
            return EquipmentSlot.FEET;
        }

        return EquipmentSlot.HEAD; // Default to HEAD if unrecognized
    }
}
