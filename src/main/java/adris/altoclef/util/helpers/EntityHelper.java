package adris.altoclef.util.helpers;

import adris.altoclef.AltoClef;
import adris.altoclef.util.slots.PlayerSlot;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;  // For accessing the server world
import net.minecraft.server.MinecraftServer;  // For getting the server instance
import net.minecraft.client.MinecraftClient;  // For getting the client instance\
import adris.altoclef.ItemInfo.ArmorToughnessUtility;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Items;

import java.util.List;
import java.util.Objects;

/**
 * Helper functions to interpret entity state
 */
public class EntityHelper {
    public static final double ENTITY_GRAVITY = 0.08; // per second

    public static boolean isAngryAtPlayer(AltoClef mod, Entity entity) {
        return isGenerallyHostileToPlayer(mod, entity);
    }

    public static boolean isGenerallyHostileToPlayer(AltoClef mod, Entity entity) {
        if (entity instanceof Tameable tameable) {
            LivingEntity owner = tameable.getOwner();
            if (owner != null && owner.getUuid() != null && owner.getUuid().equals(mod.getPlayer().getUuid())) {
                return false;
            }
        }

        if (entity instanceof SlimeEntity slime && mod.getPlayer().isInRange(slime, 3)) return true;
        if (entity instanceof RaiderEntity raider && mod.getPlayer().isInRange(raider, 16)) return true;
        if (entity instanceof WardenEntity warden && mod.getPlayer().isInRange(warden, 16)) return true;
        if (entity instanceof EndermanEntity enderman && enderman.canSee(mod.getPlayer()) && enderman.isAttacking())
            return true;
        if (entity instanceof BlazeEntity blaze && mod.getPlayer().isInRange(blaze, 3)) return true;
        if (entity instanceof SlimeEntity || entity instanceof RaiderEntity || entity instanceof WardenEntity
                || entity instanceof EndermanEntity || entity instanceof BlazeEntity) return false;
        if (entity instanceof MobEntity mob && !mob.isAttacking()) return false;
        return !isTradingPiglin(entity);
    }

    public static boolean isTradingPiglin(Entity entity) {
        if (entity instanceof PiglinEntity pig) {
            if (pig.getMainHandStack() != null) {
                if (pig.getMainHandStack().getItem().equals(Items.GOLD_INGOT)) {
                    // We're trading with this one, ignore it.
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Calculate the resulting damage dealt to a player as a result of some damage.
     * If this player were to receive this damage, the player's health will be subtracted by the resulting value.
     */
    public static double calculateResultingPlayerDamage(PlayerEntity player, DamageSource source, double damageAmount) {
        // Copied logic from `PlayerEntity.applyDamage`
        ServerWorld serverWorld = ((MinecraftServer) MinecraftClient.getInstance().getServer()).getOverworld();
        if (player.isInvulnerableTo(serverWorld, source))
            return 0;

        // Armor Base
        float armorToughness = 0.0f;
        Inventory inv = player.getInventory();
        List<ItemStack> armorItems = List.of(
                inv.getStack(PlayerSlot.ARMOR_HELMET_SLOT.getInventorySlot()), // Helmet
                inv.getStack(PlayerSlot.ARMOR_CHESTPLATE_SLOT.getInventorySlot()), // Chestplate
                inv.getStack(PlayerSlot.ARMOR_LEGGINGS_SLOT.getInventorySlot()), // Leggings
                inv.getStack(PlayerSlot.ARMOR_BOOTS_SLOT.getInventorySlot())  // Boots
        );
        for (ItemStack itemStack : armorItems) {
            boolean IsArmorItem = Registries.ITEM.getEntry(itemStack.getItem()).isIn(ItemTags.ARMOR_ENCHANTABLE);
            if (IsArmorItem) {
                Item armorItem = itemStack.getItem();
                armorToughness += ArmorToughnessUtility.getArmorToughness(armorItem); // Add toughness of the equipped armor
            }
        }
        if (!source.isIn(DamageTypeTags.BYPASSES_ARMOR)) {
            damageAmount = DamageUtil.getDamageLeft(player, (float) damageAmount, source, (float) player.getArmor(), (float) armorToughness);
        }

        // Enchantments & Potions
        if (!source.isIn(DamageTypeTags.BYPASSES_SHIELD)) {
            float k;
            if (player.hasStatusEffect(StatusEffects.RESISTANCE) && source.isOf(DamageTypes.OUT_OF_WORLD)) {
                //noinspection ConstantConditions
                k = (player.getStatusEffect(StatusEffects.RESISTANCE).getAmplifier() + 1) * 5;
                float j = 25 - k;
                double f = damageAmount * (double) j;
                double g = damageAmount;
                damageAmount = Math.max(f / 25.0F, 0.0F);
            }

            if (damageAmount <= 0.0) {
                damageAmount = 0.0;
            } else {
                k = EnchantmentHelper.getProtectionAmount(Objects.requireNonNull(player.getServer()).getWorld(player.getWorld().getRegistryKey()), player, source);
                if (k > 0) {
                    damageAmount = DamageUtil.getInflictedDamage((float) damageAmount, k);
                }
            }
        }

        // Absorption
        damageAmount = Math.max(damageAmount - player.getAbsorptionAmount(), 0.0F);
        return damageAmount;
    }
}
