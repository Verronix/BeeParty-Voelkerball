package net.beeparty.voelkerball.countdown;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.gamestate.GameStates;
import net.beeparty.voelkerball.manager.DataManager;
import net.beeparty.voelkerball.manager.TeleportManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyCountdown
{

    public void startLobbyCountdown()
    {

        Bukkit.getScheduler().cancelTask(Voelkerball.getInstance().getDataManager().waiting);

        if(Bukkit.getOnlinePlayers().size() < 6)
        {
            Bukkit.getScheduler().cancelTask(Voelkerball.getInstance().getDataManager().lobbyCount);
            Voelkerball.getInstance().getDataManager().lobbyCount=60;


            Voelkerball.getInstance().getDataManager().waiting = Bukkit.getScheduler().scheduleSyncRepeatingTask(Voelkerball.getInstance(), new Runnable() {
                @Override
                public void run() {
                    for(Player all : Bukkit.getOnlinePlayers())
                    {
                        all.setLevel(Voelkerball.getInstance().getDataManager().lobbyCount);
                        all.setExp((float)Voelkerball.getInstance().getDataManager().lobbyCount/60);
                        all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Warten auf weitere Spieler"));
                    }
                }
            },0,20);

        } else if(Bukkit.getOnlinePlayers().size() > 5)
        {
            Bukkit.getScheduler().cancelTask(Voelkerball.getInstance().getDataManager().waiting);
            Bukkit.getScheduler().cancelTask(Voelkerball.getInstance().getDataManager().lobbyCancel);

            Voelkerball.getInstance().getDataManager().lobbyCancel = Bukkit.getScheduler().scheduleSyncRepeatingTask(Voelkerball.getInstance(), new Runnable() {
                @Override
                public void run() {
                        switch (Voelkerball.getInstance().getDataManager().lobbyCount)
                        {
                            case 60:
                            case 45:
                            case 30:
                            case 15:
                            case 5:
                            case 4:
                            case 3:
                            case 2:
                                for(Player all : Bukkit.getOnlinePlayers())
                                {
                                    all.setLevel(Voelkerball.getInstance().getDataManager().lobbyCount);
                                    all.setExp((float)Voelkerball.getInstance().getDataManager().lobbyCount/60);
                                    all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Die Runde beginnt in §6"
                                            + Voelkerball.getInstance().getDataManager().lobbyCount + " §7Sekunden"));
                                    all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING,3,2);
                                }
                                break;
                            case 10:
                                for(Player all : Bukkit.getOnlinePlayers())
                                {
                                    all.setLevel(Voelkerball.getInstance().getDataManager().lobbyCount);
                                    all.setExp((float)Voelkerball.getInstance().getDataManager().lobbyCount/60);
                                    all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Die Runde beginnt in §6"
                                            + Voelkerball.getInstance().getDataManager().lobbyCount + " §7Sekunden"));
                                    all.playSound(all.getLocation(), Sound.BLOCK_ANVIL_BREAK,3,2);
                                }
                                break;
                            case 1:
                                for(Player all : Bukkit.getOnlinePlayers())
                                {
                                    all.setLevel(Voelkerball.getInstance().getDataManager().lobbyCount);
                                    all.setExp((float)Voelkerball.getInstance().getDataManager().lobbyCount/60);
                                    all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Die Runde beginnt in §6"
                                            + Voelkerball.getInstance().getDataManager().lobbyCount + " §7Sekunde"));
                                    all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING,3,2);
                                }
                                break;
                            case 0:
                                Bukkit.getScheduler().cancelTasks(Voelkerball.getInstance());
                                Voelkerball.getInstance().getDataManager().setGameState(GameStates.PREGAME);
                                new TeleportManager().teleportPlayers();
                                break;
                            default:
                                for(Player all : Bukkit.getOnlinePlayers())
                                {
                                    all.setLevel(Voelkerball.getInstance().getDataManager().lobbyCount);
                                    all.setExp((float)Voelkerball.getInstance().getDataManager().lobbyCount/60);
                                    all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Die Runde beginnt in §6"
                                            + Voelkerball.getInstance().getDataManager().lobbyCount + " §7Sekunden"));
                                }
                                break;

                        }
                        Voelkerball.getInstance().getDataManager().lobbyCount--;
                    }
            },0,20);
        }
    }

}
