package net.beeparty.voelkerball.listener;

import net.beeparty.voelkerball.countdown.LobbyCountdown;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LISTENER_PlayerQuit implements Listener
{
    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        new LobbyCountdown().startLobbyCountdown();
    }

}
