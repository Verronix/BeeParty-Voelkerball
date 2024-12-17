package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.utils.ItemBuilder;
import net.beeparty.voelkerball.utils.Team;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

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

        ItemStack teamBlau = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta teamBlauMeat = teamBlau.getItemMeta();

        ((LeatherArmorMeta)teamBlauMeat).setColor(Color.BLUE);
        teamBlauMeat.setDisplayName("§9Team Blau §7(§9"+DataManager.teamSizeMap.get(Team.BLAU) + "§7/§95§7)");
        teamBlauMeat.setLore(returnFinishedLore(Team.BLAU));

        teamBlau.setItemMeta(teamBlauMeat);


        ItemStack teamRot = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta teamrotMeta = teamRot.getItemMeta();

        ((LeatherArmorMeta)teamrotMeta).setColor(Color.RED);
        teamrotMeta.setDisplayName("§cTeam Rot §7(§c"+DataManager.teamSizeMap.get(Team.ROT) + "§7/§c5§7)");
        teamrotMeta.setLore(returnFinishedLore(Team.ROT));

        teamRot.setItemMeta(teamrotMeta);

        inv.setItem(3, teamBlau);
        inv.setItem(5, teamRot);

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

    private List<String> returnFinishedLore(Team team)
    {
        List<String> list = new ArrayList<>();

        if(team == Team.BLAU)
        {
            for(int i =0; i < DataManager.teamSizeMap.get(team); i++)
            {
                list.add("§7-§9 " + DataManager.teamBlue.get(i).getPlayer().getName());
            }
            for(int i = 0; i < 5-DataManager.teamSizeMap.get(team);i++)
            {
                list.add("§7-");
            }

        } else if(team == Team.ROT)
        {
            for(int i =0; i < DataManager.teamSizeMap.get(team); i++)
            {
                list.add("§7-§c " + DataManager.teamRed.get(i).getPlayer().getName());
            }
            for(int i = 0; i < 5-DataManager.teamSizeMap.get(team);i++)
            {
                list.add("§7-");
            }
        }
        return list;
    }

}
