package net.beeparty.voelkerball.listener;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.countdown.LobbyCountdown;
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
        Voelkerball.getInstance().getInventoryManager().setLobbyInventory(player);
        player.teleport(Voelkerball.getInstance().getSpawnManager().getLobby());

        new LobbyCountdown().startLobbyCountdown();

    }

}
