package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.utils.Role;
import net.beeparty.voelkerball.utils.Team;
import net.beeparty.voelkerball.utils.VBPlayer;

import java.util.ArrayList;
import java.util.List;

public class TeamManager
{
    private Team teamRed;
    private Team teamBlue;

    public TeamManager()
    {
        this.teamBlue = Team.BLAU;
        this.teamRed = Team.ROT;
    }

    public boolean teamHasKing(Team team)
    {
        if(team == teamBlue && !teamBlueIsEmpty())
        {
            for(int i =0; i < DataManager.teamSizeMap.get(teamBlue); i++)
            {
                if(DataManager.teamBlue.get(i).getRole() == Role.King)
                    return true;
            }
        } else if(team == teamRed && !teamRedIsEmpty())
        {
            for(int i =0; i < DataManager.teamSizeMap.get(teamRed); i++)
            {
                if(DataManager.teamRed.get(i).getRole() == Role.King)
                    return true;
            }
        }
        return false;
    }

    public VBPlayer getKing(Team team)
    {
        VBPlayer player = null;
        if(team == teamBlue && !teamBlueIsEmpty())
        {
            for(int i =0; i < DataManager.teamSizeMap.get(teamBlue); i++)
            {
                if(DataManager.teamBlue.get(i).getRole() == Role.King)
                {
                    player = DataManager.teamBlue.get(i);
                }
            }
        } else if(team == teamRed && !teamRedIsEmpty())
        {
            for(int i =0; i < DataManager.teamSizeMap.get(teamRed); i++)
            {
                if(DataManager.teamRed.get(i).getRole() == Role.King)
                {
                    player = DataManager.teamRed.get(i);
                }
            }
        }
        return player;
    }

    public ArrayList<String> getTeamPlayerNamesInStringList(Team team)
    {
        ArrayList<String> playerNames = new ArrayList<>();

        if(team == teamBlue)
        {
            for(int i =0; i < DataManager.teamSizeMap.get(teamBlue); i++)
            {
                playerNames.add(DataManager.teamBlue.get(i).getPlayer().getName());
            }
        } else
        {
            for(int i =0; i < DataManager.teamSizeMap.get(teamRed); i++)
            {
                playerNames.add(DataManager.teamRed.get(i).getPlayer().getName());
            }
        }
        return playerNames;
    }

    private boolean teamRedIsEmpty()
    {
        return (DataManager.teamSizeMap.get(teamRed) == 0);
    }

    private boolean teamBlueIsEmpty()
    {
        return (DataManager.teamSizeMap.get(teamBlue) == 0);
    }

}
