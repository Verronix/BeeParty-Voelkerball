package net.beeparty.voelkerball.manager;

import java.util.HashMap;
import java.util.List;

public class MapVoteManager
{

    HashMap<String, Integer> mapVotes = new HashMap<>();

    public MapVoteManager(List<String> maps)
    {
        for (String map : maps)
        {
            mapVotes.put(map, 0);
        }
    }

    public void addMapVote(String mapName)
    {
        if(mapVotes.containsKey(mapName))
        {
            mapVotes.replace(mapName,getMapVotes(mapName) + 1);
        }
    }

    public void removeMapVote(String mapName)
    {
        if(mapVotes.containsKey(mapName))
        {
            mapVotes.replace(mapName,getMapVotes(mapName) - 1);
        }
    }

    public void setMapVotes(String mapName,int votes)
    {
        if(mapVotes.containsKey(mapName))
        {
            mapVotes.replace(mapName, votes);
        }
    }

    public String getVotedMap()
    {
        String map = "";
        for(int i = 0; i < DataManager.maps.size(); i++)
        {
            if(getMapVotes(DataManager.maps.get(i)) > getMapVotes(map))
            {
                map = DataManager.maps.get(i);
            }
        }
        return map;
    }

    public int getMapVotes(String mapName)
    {
        if(mapVotes.containsKey(mapName))
            return mapVotes.get(mapName);
        return -1;
    }

}
