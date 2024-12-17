package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.gamestate.GameStates;
import net.beeparty.voelkerball.utils.Team;
import net.beeparty.voelkerball.utils.VBPlayer;
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

    public int waiting;
    public int lobbyCancel;

    // STATE
    private GameStates gameState;

    // MAP DATA
    public static List<String> maps = new ArrayList<>();
    public static HashMap<String, String> getMap = new HashMap<>();
    public ArrayList<Player> mapAlreadyForced = new ArrayList<>();


    // PLAYER DATA
    public static List<VBPlayer> playingPlayers= new ArrayList<>();

    // TEAM DATA
    public static HashMap<Team, Integer> teamSizeMap = new HashMap<>();
    public static ArrayList<VBPlayer> teamRed = new ArrayList<>();
    public static ArrayList<VBPlayer> teamBlue = new ArrayList<>();


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
