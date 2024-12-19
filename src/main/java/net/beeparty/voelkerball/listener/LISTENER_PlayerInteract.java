package net.beeparty.voelkerball.listener;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.gamestate.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LISTENER_PlayerInteract implements Listener
{

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        event.setCancelled(true);
        Player player = event.getPlayer();

        if(Voelkerball.getInstance().getDataManager().getGameState() == GameStates.LOBBYPHASE)
        {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
            {

                if(event.getItem() != null)
                {
                    switch (event.getItem().getType())
                    {
                        case LEATHER_CHESTPLATE:
                            event.setCancelled(true);
                            player.getInventory().setChestplate(null);
                            player.openInventory(Voelkerball.getInstance().getInventoryManager().teamAuswahlInventory());
                            break;
                        case PAPER:
                            event.setCancelled(true);
                            player.openInventory(Voelkerball.getInstance().getInventoryManager().mapAuswahlInventory());
                            break;
                        case SLIME_BALL:
                            event.setCancelled(true);
                            player.performCommand("lobby");
                            break;
                        default:
                            break;
                    }
                } else
                    event.setCancelled(true);
            }
        } else if(Voelkerball.getInstance().getDataManager().getGameState() == GameStates.INGAME)
        {

            /*

                TODO
                Werfen

             */


        } else
        {
            event.setCancelled(true);
        }
    }
}
