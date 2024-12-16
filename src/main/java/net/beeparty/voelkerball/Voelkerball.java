package src.main.java.net.beeparty.voelkerball;

import org.bukkit.plugin.java.JavaPlugin;
import src.main.java.net.beeparty.voelkerball.manager.MapManager;
import src.main.java.net.beeparty.voelkerball.manager.SpawnManager;

public final class Voelkerball extends JavaPlugin {


    private static Voelkerball instance;
    private SpawnManager spawnManager;
    private MapManager mapManager;

    @Override
    public void onEnable() {

        this.spawnManager = new SpawnManager();
        this.mapManager = new MapManager();
        System.out.println("Voelkerball gestartet!");

    }

    @Override
    public void onDisable() {

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
}
