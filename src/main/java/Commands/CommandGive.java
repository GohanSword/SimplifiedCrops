package Commands;

import Utils.ItemsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandGive implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cSeulement les joueurs sont autoriser a utiliser cette commande");
            return true;
        }
        Player player = (Player) sender;
            ItemStack loot = ItemsManager.houe;
            // ItemStack loot = items.get(ThreadLocalRandom.current().nextInt());


            player.getInventory().addItem(loot);
            player.sendMessage("§cVous avez reçu un emeraude raffiné");
            return true;
        }

    }

