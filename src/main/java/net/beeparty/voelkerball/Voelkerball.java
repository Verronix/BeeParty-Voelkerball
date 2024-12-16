package net.beeparty.voelkerball;

import net.beeparty.voelkerball.commands.CMD_Voelkerball;
import net.beeparty.voelkerball.manager.MapManager;
import net.beeparty.voelkerball.manager.SpawnManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Voelkerball extends JavaPlugin {


    private static Voelkerball instance;
    private SpawnManager spawnManager;
    private MapManager mapManager;

    @Override
    public void onEnable() {
        instance = this;

        this.getCommand("vb").setExecutor(new CMD_Voelkerball());

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
