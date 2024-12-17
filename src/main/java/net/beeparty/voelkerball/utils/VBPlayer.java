package net.beeparty.voelkerball.utils;

import net.beeparty.voelkerball.manager.DataManager;
import org.bukkit.entity.Player;

public class VBPlayer
{
    private final Player player;
    private Team team;
    private Role role;

    public VBPlayer(Player player)
    {
        this.player = player;
        this.role = Role.Player;
    }

    public boolean setTeam(Team team)
    {
        if(!playerHasTeam())
        {
            if(DataManager.teamSizeMap.get(team) < 5)
            {
                this.team=team;
                if(team == Team.BLAU)
                {
                    DataManager.teamBlue.add(this);
                    DataManager.teamSizeMap.replace(team, DataManager.teamSizeMap.get(team)+1);
                } else
                {
                    DataManager.teamRed.add(this);
                    DataManager.teamSizeMap.replace(team, DataManager.teamSizeMap.get(team)+1);
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean removeTeam()
    {
        if(playerHasTeam())
        {
            if(team == Team.BLAU)
            {
                DataManager.teamBlue.remove(this);
            } else
            {
                DataManager.teamRed.remove(this);
            }
            return true;
        }
        return false;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Team getTeam()
    {
        return team;
    }

    private boolean playerHasTeam()
    {
        return DataManager.teamBlue.contains(player) || DataManager.teamRed.contains(player);
    }
}
