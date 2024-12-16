package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.gamestate.GameStates;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager
{


    // INSTANCE
    private static final DataManager instance = new DataManager();


    //PREFIX

    public static final String prefix = "§6§lVölkerball §7§l>> ";

    //
    public int lobbyCount = 60;
    public int restartCount = 15;
    public int preMatchCount = 10;

    // STATE
    private GameStates gameState;

    // MAP DATA
    public static List<String> maps = new ArrayList<>();
    public static HashMap<String, String> getMap = new HashMap<>();
    public static HashMap<String, String> setupMap = new HashMap<>();
    public ArrayList<Player> mapAlreadyForced = new ArrayList<>();



    public static DataManager getInstance() {
        return instance;
    }

    public GameStates getGameState() {
        return gameState;
    }

    public void setGameState(GameStates gameState) {
        this.gameState = gameState;
    }
}
