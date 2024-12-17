package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryManager
{

    public void setLobbyInventory(Player player)
    {
        player.getInventory().clear();

        player.getInventory().setItem(0, new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayName("§6Teamauswahl").build());
        player.getInventory().setItem(4, new ItemBuilder(Material.PAPER).setDisplayName("§6Mapauswahl").build());
        player.getInventory().setItem(8, new ItemBuilder(Material.SLIME_BALL).setDisplayName("§6Lobby").build());

    }

    public Inventory teamAuswahlInventory()
    {
        Inventory inv = Bukkit.createInventory(null, 9, "§6Teamauswahl");

        inv.setItem(3, new ItemBuilder(Material.LEATHER_CHESTPLATE).setColor(Color.BLUE).setDisplayName("§9Team Blau")
                .addLoreLine("HIER KOMMEN DIE TEAMMITGLIEDER HIN").build());
        inv.setItem(5, new ItemBuilder(Material.LEATHER_CHESTPLATE).setColor(Color.RED).setDisplayName("§cTeam Rot")
                .addLoreLine("HIER KOMMEN DIE TEAMMITGLIEDER HIN").build());

        return inv;
    }

    public Inventory mapAuswahlInventory()
    {
        Inventory inv = Bukkit.createInventory(null, 27, "§6Mapauswahl");

        for(int i = 0; i < DataManager.maps.size(); i++)
        {
            String all = DataManager.maps.get(i);
            System.out.println(all);
            inv.addItem(new ItemBuilder(Material.PAPER).setDisplayName("§6"+all).addLoreLine("§7Aktuelle Votes: §6" + Voelkerball.getInstance().getMapVoteManager().getMapVotes(all)).build());
        }


        return inv;
    }

}
