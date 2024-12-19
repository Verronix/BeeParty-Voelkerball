package net.beeparty.voelkerball;

import net.beeparty.voelkerball.commands.CMD_Voelkerball;
import net.beeparty.voelkerball.countdown.LobbyCountdown;
import net.beeparty.voelkerball.gamestate.GameStates;
import net.beeparty.voelkerball.listener.*;
import net.beeparty.voelkerball.manager.*;
import net.beeparty.voelkerball.utils.Ball;
import net.beeparty.voelkerball.utils.Team;
import org.bukkit.plugin.java.JavaPlugin;

public final class Voelkerball extends JavaPlugin {


    private static Voelkerball instance;
    private SpawnManager spawnManager;
    private MapManager mapManager;
    private InventoryManager inventoryManager;
    private DataManager dataManager;
    private MapVoteManager mapVoteManager;

    @Override
    public void onEnable() {
        instance = this;

        registerEvents();
        initManager();

        this.dataManager.setGameState(GameStates.LOBBYPHASE);
        this.mapManager.loadMaps();
        this.mapVoteManager = new MapVoteManager(mapManager.getMaps());

        System.out.println("Voelkerball gestartet!");
        DataManager.teamSizeMap.put(Team.BLAU, 0);
        DataManager.teamSizeMap.put(Team.ROT, 0);

    }

    @Override
    public void onDisable()
    {

    }

    private void registerEvents()
    {
        //COMMANDS
        this.getCommand("vb").setExecutor(new CMD_Voelkerball());

        //LISTENER
        getServer().getPluginManager().registerEvents(new LISTENER_PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new LISTENER_PlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new LISTENER_Canceled(), this);
        getServer().getPluginManager().registerEvents(new LISTENER_PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new LISTENER_InventoryClick(), this);

    }

    private void initManager()
    {
        this.spawnManager = new SpawnManager();
        this.mapManager = new MapManager();
        this.inventoryManager = new InventoryManager();
        this.dataManager = new DataManager();
    }

    public static Voelkerball getInstance() {
        return instance;
    }

    public SpawnManager getSpawnManager() {
        return spawnManager;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public MapVoteManager getMapVoteManager() {
        return mapVoteManager;
    }
}
