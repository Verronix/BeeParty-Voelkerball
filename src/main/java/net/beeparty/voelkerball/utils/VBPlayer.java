package net.beeparty.voelkerball.utils;

import net.beeparty.voelkerball.manager.DataManager;
import org.bukkit.entity.Player;

import javax.xml.crypto.Data;

public class VBPlayer
{
    private final Player player;
    private Team team;
    private Role role;
    private boolean voted;
    private String votedMap;

    public VBPlayer(Player player)
    {
        this.player = player;
        this.role = Role.Player;
        this.voted = false;
        this.votedMap = "";
    }

    public boolean setTeam(Team team)
    {
        if(!hasTeam())
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
        if(hasTeam())
        {
            if(team == Team.BLAU)
            {
                DataManager.teamBlue.remove(this);
                DataManager.teamSizeMap.replace(team, DataManager.teamSizeMap.get(team)-1);
            } else
            {
                DataManager.teamRed.remove(this);
                DataManager.teamSizeMap.replace(team, DataManager.teamSizeMap.get(team)-1);
            }
            return true;
        }
        return false;
    }

    public static VBPlayer getVBPlayerBySpigot(Player player)
    {
        VBPlayer vbPlayer = null;
        for (int i = 0; i < DataManager.playingPlayers.size(); i++)
        {
            if(DataManager.playingPlayers.get(i).getPlayer().getUniqueId().equals(player.getUniqueId()))
                vbPlayer = DataManager.playingPlayers.get(i);
        }
        return vbPlayer;
    }

    public void setVotedMap(String votedMap) {
        this.votedMap = votedMap;
    }

    public String getVotedMap() {
        return votedMap;
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

    public void setVoted(boolean voted)
    {
        this.voted=voted;
    }

    public boolean hasVoted()
    {
        return voted;
    }

    public boolean hasTeam()
    {
        return DataManager.teamBlue.contains(this) || DataManager.teamRed.contains(this);
    }
}
