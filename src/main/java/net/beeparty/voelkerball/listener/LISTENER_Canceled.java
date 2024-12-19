package net.beeparty.voelkerball.listener;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.gamestate.GameStates;
import net.beeparty.voelkerball.manager.DataManager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class LISTENER_Canceled implements Listener
{

    @EventHandler
    public void onWeatherChance(WeatherChangeEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event)
    {
        if(event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL)
            event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event)
    {
        if(Voelkerball.getInstance().getDataManager().getGameState() == GameStates.LOBBYPHASE)
         event.setCancelled(true);
    }

}
