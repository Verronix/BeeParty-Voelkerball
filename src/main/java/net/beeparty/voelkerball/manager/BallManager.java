package net.beeparty.voelkerball.manager;

public class BallManager
{

    String mapName;

    public BallManager(String mapName)
    {
        this.mapName = mapName;
    }

    public void spawnBalls()
    {
        for(int i = 0; i < DataManager.ballHashMap.get(mapName).size(); i++)
        {
            DataManager.ballHashMap.get(mapName).get(i).spawnBall();
        }
    }

}
