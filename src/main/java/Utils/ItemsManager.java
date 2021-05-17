package Utils;

import fr.gohansword.simplifiedcrops.SimplifiedCrops;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager {
    private static final SimplifiedCrops plugin = SimplifiedCrops.getInstance();
    public static ItemStack houe;

    public static void init() {
        createHoue();

    }
    private static void createHoue() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&yy"));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', plugin.language.getLanguageConfig().getString("Nomdelahoue")));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&yy"));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        houe = item;
    }
}
