package Events;

import Utils.ItemsManager;
import fr.gohansword.simplifiedcrops.SimplifiedCrops;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Damageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BlockBreakE implements Listener {
    private static SimplifiedCrops plugin = SimplifiedCrops.getInstance();

    public static final List<Material> CROP_LIST = new ArrayList<>(Arrays.asList(new Material[]{Material.WHEAT, Material.CARROTS, Material.POTATOES, Material.NETHER_WART, Material.BEETROOTS}));


    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Block b = e.getClickedBlock();
        Player player = e.getPlayer();
        if (player.hasPermission("Simplifiedcrops.use")) {
            if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
                return;
            if (b == null)
                return;
            if (e.getItem() == null)
                return;
            ItemStack i = e.getItem();
            if (!e.getItem().getItemMeta().equals(ItemsManager.houe.getItemMeta()))
                return;
                if (!CROP_LIST.contains(b.getType()))
                    return;
                Ageable data = (Ageable) b.getBlockData();
                if (data.getAge() != data.getMaximumAge())
                    return;
                Material m = b.getType();
                b.breakNaturally(i);
                b.setType(m);
                data.setAge(0);
                if (SimplifiedCrops.getInstance().getConfig().getBoolean("use_durability") && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
                    Damageable damageableItem = (Damageable) i.getItemMeta();
                    if (i.getItemMeta().hasEnchant(Enchantment.DURABILITY)) {
                        Random r = new Random();
                        if (r.nextInt(i.getItemMeta().getEnchantLevel(Enchantment.DURABILITY) + 1) == 0)
                            damageableItem.setDamage(damageableItem.getDamage() + 1);
                    } else {
                        damageableItem.setDamage(damageableItem.getDamage() + 1);
                    }
                    i.setItemMeta((ItemMeta) damageableItem);
                }
            }
        }
    }


