package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.Voelkerball;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapManager
{

    public void addMap(String mapName, Player player)
    {
        if(!DataManager.maps.contains(mapName))
        {
            DataManager.maps.add(mapName);
            Voelkerball.getInstance().getConfig().set("Maps", DataManager.maps);
            Voelkerball.getInstance().saveConfig();
            Voelkerball.getInstance().getMapVoteManager().setMapVotes(mapName, 0);
            player.sendMessage(DataManager.prefix + "§7Du hast die Map §6" + mapName + " §7erfolgreich hinzugefügt.");
        } else
        {
            player.sendMessage(DataManager.prefix + "§7Diese Map existiert bereits.");
        }
    }

    public List<String> getMaps()
    {
        return DataManager.maps;
    }

    public void loadMaps()
    {
        DataManager.maps = Voelkerball.getInstance().getConfig().getStringList("Maps");
    }

    public void forceMap(InventoryClickEvent event, Player player)
    {
        if(event.getCurrentItem() != null)
        {
            String name = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()).replace("", "");
            DataManager.getMap.clear();
            DataManager.getMap.put("MAP", name.replace(" ", ""));
            Bukkit.broadcastMessage(DataManager.prefix + "§7Die Map wurde auf §6" + name + " §7geändert.");
            DataManager.getInstance().mapAlreadyForced.add(player);
        }

        for(Player all : Bukkit.getOnlinePlayers())
        {
            all.playSound(all.getLocation(), Sound.BLOCK_ANVIL_USE, 3, 2);
        }

    }
}
