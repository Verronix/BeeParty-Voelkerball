package net.beeparty.voelkerball.countdown;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.gamestate.GameStates;
import net.beeparty.voelkerball.manager.DataManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PreGameCountdown
{

    public void startPreGame()
    {

        Voelkerball.getInstance().getDataManager().preGameCancel = Bukkit.getScheduler().scheduleSyncRepeatingTask(Voelkerball.getInstance(), new Runnable()
        {
            @Override
            public void run()
            {
                switch (Voelkerball.getInstance().getDataManager().preMatchCount)
                {
                    case 0:
                        for(Player all : Bukkit.getOnlinePlayers())
                        {
                            all.setLevel(Voelkerball.getInstance().getDataManager().preMatchCount);
                            all.setExp((float)Voelkerball.getInstance().getDataManager().preMatchCount/30);
                            all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Lasset die Spiele beginnen!"));
                        }
                        Voelkerball.getInstance().getDataManager().setGameState(GameStates.INGAME);
                        Bukkit.getScheduler().cancelTask(Voelkerball.getInstance().getDataManager().preGameCancel);
                    case 1:
                    {
                        for(Player all : Bukkit.getOnlinePlayers())
                        {
                            all.setLevel(Voelkerball.getInstance().getDataManager().preMatchCount);
                            all.setExp((float)Voelkerball.getInstance().getDataManager().preMatchCount/30);
                            all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Die Runde beginnt in §6"
                                    + Voelkerball.getInstance().getDataManager().preMatchCount + " §7Sekunde"));
                        }
                    }
                    default:
                        for(Player all : Bukkit.getOnlinePlayers())
                        {
                            all.setLevel(Voelkerball.getInstance().getDataManager().preMatchCount);
                            all.setExp((float)Voelkerball.getInstance().getDataManager().preMatchCount/30);
                            all.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(DataManager.prefix + "§7Die Runde beginnt in §6"
                                    + Voelkerball.getInstance().getDataManager().preMatchCount + " §7Sekunden"));
                        }
                        break;

                }
                Voelkerball.getInstance().getDataManager().preMatchCount--;
            }
        }, 0,20);

    }

}
