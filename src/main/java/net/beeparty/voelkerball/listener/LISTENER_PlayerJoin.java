package net.beeparty.voelkerball.listener;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.countdown.LobbyCountdown;
import net.beeparty.voelkerball.manager.DataManager;
import net.beeparty.voelkerball.utils.Ball;
import net.beeparty.voelkerball.utils.VBPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LISTENER_PlayerJoin implements Listener
{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        player.getInventory().clear();
        DataManager.playingPlayers.add(new VBPlayer(player));

        Voelkerball.getInstance().getInventoryManager().setLobbyInventory(player);
        player.teleport(Voelkerball.getInstance().getSpawnManager().getLobby());

        new LobbyCountdown().startLobbyCountdown();

    }

}
