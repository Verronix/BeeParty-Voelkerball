package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.utils.ItemBuilder;
import net.beeparty.voelkerball.utils.Role;
import net.beeparty.voelkerball.utils.Team;
import net.beeparty.voelkerball.utils.VBPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Random;


public class TeleportManager
{

    public void teleportPlayersToGame()
    {

        Random random = new Random();

        for(VBPlayer all : DataManager.playingPlayers)
        {
            setIngameInventory(all);
            int spawnid = random.nextInt(4);
            if(all.getTeam() == Team.BLAU)
            {
                if(all.getRole() == Role.Player)
                {
                    all.getPlayer().teleport(Voelkerball.getInstance().getSpawnManager().getSpawn(spawnid,
                            Voelkerball.getInstance().getMapVoteManager().getVotedMap(), "Blau"));
                } else if(all.getRole() == Role.King)
                {
                    all.getPlayer().teleport(Voelkerball.getInstance().getSpawnManager().getSpawn(5,
                            Voelkerball.getInstance().getMapVoteManager().getVotedMap(), "Blau"));
                }
            } else if(all.getTeam() == Team.ROT)
            {
                if(all.getRole() == Role.Player)
                {
                    all.getPlayer().teleport(Voelkerball.getInstance().getSpawnManager().getSpawn(spawnid,
                            Voelkerball.getInstance().getMapVoteManager().getVotedMap(), "Rot"));
                } else if(all.getRole() == Role.King)
                {
                    all.getPlayer().teleport(Voelkerball.getInstance().getSpawnManager().getSpawn(5,
                            Voelkerball.getInstance().getMapVoteManager().getVotedMap(), "Rot"));
                }
            }
        }
    }


    private void setIngameInventory(VBPlayer vbplayer)
    {
        if(vbplayer.getRole() == Role.Player)
            vbplayer.getPlayer().getInventory().clear();
        if(vbplayer.getRole() == Role.King)
        {
            Player player = vbplayer.getPlayer();
            player.getInventory().setItem(8, new ItemBuilder(Material.POTION).setDisplayName("§6Resitenztrank").setAmount(1).build());
        }
    }

}
