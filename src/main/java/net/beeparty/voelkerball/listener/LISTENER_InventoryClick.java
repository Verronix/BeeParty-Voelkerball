package net.beeparty.voelkerball.listener;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.manager.DataManager;
import net.beeparty.voelkerball.manager.MapVoteManager;
import net.beeparty.voelkerball.utils.ItemBuilder;
import net.beeparty.voelkerball.utils.Team;
import net.beeparty.voelkerball.utils.VBPlayer;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LISTENER_InventoryClick implements Listener
{

    @EventHandler
    public void onClick(InventoryClickEvent event)
    {
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        VBPlayer vbPlayer = VBPlayer.getVBPlayerBySpigot(player);
        if(event.getView().getTitle().equalsIgnoreCase("§6Teamauswahl"))
        {
            if(event.getCurrentItem() != null)
            {
                if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Team Blau §7(§9"+ DataManager.teamSizeMap.get(Team.BLAU) + "§7/§95§7)"))
                {
                    if(vbPlayer.hasTeam() && vbPlayer.getTeam() == Team.ROT && DataManager.teamSizeMap.get(Team.BLAU) < 5|| !vbPlayer.hasTeam() && DataManager.teamSizeMap.get(Team.BLAU) < 5 )
                    {
                        vbPlayer.removeTeam();
                        vbPlayer.setTeam(Team.BLAU);
                        player.closeInventory();
                        player.getInventory().setItem(0, null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setItem(0, new ItemBuilder(Material.LEATHER_CHESTPLATE).setColor(Color.BLUE).setDisplayName("§6Teamauswahl").build());
                        player.sendMessage(DataManager.prefix + "§7Du bist Team §9Blau §7beigetreten.");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3,2);
                    } else
                    {
                        player.closeInventory();
                        player.sendMessage(DataManager.prefix + "§7Du kannst diesem Team nicht beittreten.");
                    }
                } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeam Rot §7(§c"+DataManager.teamSizeMap.get(Team.ROT) + "§7/§c5§7)"))
                {
                    if(vbPlayer.hasTeam() && vbPlayer.getTeam() == Team.BLAU && DataManager.teamSizeMap.get(Team.ROT) < 5 || !vbPlayer.hasTeam() && DataManager.teamSizeMap.get(Team.ROT) < 5 )
                    {
                        vbPlayer.removeTeam();
                        vbPlayer.setTeam(Team.ROT);
                        player.closeInventory();
                        player.getInventory().setItem(0, null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setItem(0, new ItemBuilder(Material.LEATHER_CHESTPLATE).setColor(Color.RED).setDisplayName("§6Teamauswahl").build());
                        player.sendMessage(DataManager.prefix + "§7Du bist Team §cRot §7beigetreten.");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3,2);
                    } else
                    {
                        player.closeInventory();
                        player.sendMessage(DataManager.prefix + "§7Du kannst diesem Team nicht beittreten.");
                    }
                }
            }
        } else if(event.getView().getTitle().equalsIgnoreCase("§6Mapauswahl"))
        {

            if(event.getCurrentItem() != null) {
                if (!vbPlayer.hasVoted()) {
                    Voelkerball.getInstance().getMapVoteManager().addMapVote(event.getCurrentItem().getItemMeta().getDisplayName()
                            .replaceAll("§", "").replaceAll("6", ""));
                    vbPlayer.setVotedMap(event.getCurrentItem().getItemMeta().getDisplayName()
                            .replaceAll("§", "").replaceAll("6", ""));
                    vbPlayer.setVoted(true);
                    player.closeInventory();
                    player.sendMessage(DataManager.prefix + "§7Du hast für die Map " + event.getCurrentItem().getItemMeta().getDisplayName()
                                        + " §7gevoted.");
                } else {
                    if (!vbPlayer.getVotedMap().equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName()
                            .replaceAll("§", "").replaceAll("6", "")))
                    {
                        Voelkerball.getInstance().getMapVoteManager().removeMapVote(vbPlayer.getVotedMap());
                        Voelkerball.getInstance().getMapVoteManager().addMapVote(event.getCurrentItem().getItemMeta().getDisplayName()
                                .replaceAll("§", "").replaceAll("6", ""));
                        vbPlayer.setVotedMap(event.getCurrentItem().getItemMeta().getDisplayName()
                                .replaceAll("§", "").replaceAll("6", ""));
                        vbPlayer.setVoted(true);
                        player.closeInventory();
                        player.sendMessage(DataManager.prefix + "§7Du hast für die Map " + event.getCurrentItem().getItemMeta().getDisplayName()
                                + " §7gevoted.");
                    } else
                    {
                        Voelkerball.getInstance().getMapVoteManager().removeMapVote(vbPlayer.getVotedMap());
                        vbPlayer.setVotedMap("");
                        vbPlayer.setVoted(false);
                        player.closeInventory();
                        player.sendMessage(DataManager.prefix + "§7Du hast deinen Vote entfernt.");
                    }
                }
            }
        }
    }



}
