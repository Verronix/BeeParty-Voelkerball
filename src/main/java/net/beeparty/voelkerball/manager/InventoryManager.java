package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class InventoryManager
{

    public void setLobbyInventory(Player player)
    {
        player.getInventory().clear();

        player.getInventory().setItem(0, new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayName("§6").build());

    }

}
