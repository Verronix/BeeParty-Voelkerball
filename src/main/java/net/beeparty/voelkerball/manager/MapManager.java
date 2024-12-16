package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.Voelkerball;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Random;

public class MapManager
{

    public void generateMap()
    {
        DataManager.maps = Voelkerball.getInstance().getConfig().getStringList("Maps");

        for(String s : DataManager.maps)
        {
            Bukkit.createWorld(new WorldCreator(s));
        }

        if(!DataManager.maps.isEmpty())
        {
            Random random = new Random();
            int randomInt = random.nextInt(DataManager.maps.size());
            String randomMap = DataManager.maps.get(randomInt);

            DataManager.maps.clear();
            DataManager.getMap.clear();
            DataManager.getMap.put("MAP", randomMap);
        }
    }

    public void addMap(String mapName, Player player)
    {

        DataManager.maps.add(mapName);
        Voelkerball.getInstance().getConfig().set("Maps", DataManager.maps);
        Voelkerball.getInstance().saveConfig();
        player.sendMessage(DataManager.prefix + "§7Du hast die Map §6" + mapName + " §7erfolgreich hinzugefügt.");

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
