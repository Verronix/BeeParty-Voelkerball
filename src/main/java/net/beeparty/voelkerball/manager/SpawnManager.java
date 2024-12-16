package net.beeparty.voelkerball.manager;

import net.beeparty.voelkerball.Voelkerball;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SpawnManager {

    public void setLobbySpawn(Player player, Location location)
    {
        Voelkerball.getInstance().getConfig().set("Spawn.Lobby.X", location.getX());
        Voelkerball.getInstance().getConfig().set("Spawn.Lobby.Y", location.getY());
        Voelkerball.getInstance().getConfig().set("Spawn.Lobby.Z", location.getZ());
        Voelkerball.getInstance().getConfig().set("Spawn.Lobby.Yaw", location.getYaw());
        Voelkerball.getInstance().getConfig().set("Spawn.Lobby.Pitch", location.getPitch());
        Voelkerball.getInstance().getConfig().set("Spawn.Lobby.World", location.getWorld().getName());

        Voelkerball.getInstance().saveConfig();
        player.sendMessage(DataManager.prefix + "§8Du hast den LobbySpawn erflogreicxh gesetzt.");
    }

    public void setTeamSpawn(String team, int spawnID, String mapName, Player player, Location location)
    {
        Voelkerball.getInstance().getConfig().set("Spawn."+ mapName + "." + team + "." + spawnID + ".X", location.getX());
        Voelkerball.getInstance().getConfig().set("Spawn."+ mapName + "." + team + "." + spawnID + ".Y", location.getY());
        Voelkerball.getInstance().getConfig().set("Spawn."+ mapName + "." + team + "." + spawnID + ".Z", location.getZ());
        Voelkerball.getInstance().getConfig().set("Spawn."+ mapName + "." + team + "." + spawnID + ".Yaw", location.getYaw());
        Voelkerball.getInstance().getConfig().set("Spawn."+ mapName + "." + team + "." + spawnID + ".Pitch", location.getPitch());
        Voelkerball.getInstance().getConfig().set("Spawn."+ mapName + "." + team + "." + spawnID + ".World", location.getWorld().getName());

        Voelkerball.getInstance().saveConfig();
        player.sendMessage(DataManager.prefix + "§8Du hast den Spawnpunkt " + spawnID +  " für Team " + team + " erfolgreich gesetzt.");
    }

    public void setDeathSpawns(String team, int spawnID, String mapName, Player player, Location location)
    {
        Voelkerball.getInstance().getConfig().set("DSpawn."+ mapName + "." + team + "." + spawnID + ".X", location.getX());
        Voelkerball.getInstance().getConfig().set("DSpawn."+ mapName + "." + team + "." + spawnID + ".Y", location.getY());
        Voelkerball.getInstance().getConfig().set("DSpawn."+ mapName + "." + team + "." + spawnID + ".Z", location.getZ());
        Voelkerball.getInstance().getConfig().set("DSpawn."+ mapName + "." + team + "." + spawnID + ".Yaw", location.getYaw());
        Voelkerball.getInstance().getConfig().set("DSpawn."+ mapName + "." + team + "." + spawnID + ".Pitch", location.getPitch());
        Voelkerball.getInstance().getConfig().set("DSpawn."+ mapName + "." + team + "." + spawnID + ".World", location.getWorld().getName());

        Voelkerball.getInstance().saveConfig();
        player.sendMessage(DataManager.prefix + "§8Du hast den Außenspawnpunkt " + spawnID +  " für Team " + team + " erfolgreich gesetzt.");
    }

    public Location getLobby()
    {

        double x = Voelkerball.getInstance().getConfig().getDouble("Spawn.Lobby.X");
        double y = Voelkerball.getInstance().getConfig().getDouble("Spawn.Lobby.Y");
        double z = Voelkerball.getInstance().getConfig().getDouble("Spawn.Lobby.Z");
        double yaw = Voelkerball.getInstance().getConfig().getDouble("Spawn.Lobby.Yaw");
        double pitch = Voelkerball.getInstance().getConfig().getDouble("Spawn.Lobby.Pitch");
        String worldn = Voelkerball.getInstance().getConfig().getString("Spawn.Lobby.World");
        World world = Bukkit.getWorld(worldn);
        Location loc = new Location(world, x, y, z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);

        return loc;

    }

    public Location getSpawn(int spawnID, String mapName, String team)
    {

        double x = Voelkerball.getInstance().getConfig().getDouble("Spawn."+ mapName + "." + team + "." + spawnID + ".X");
        double y = Voelkerball.getInstance().getConfig().getDouble("Spawn."+ mapName + "." + team + "." + spawnID + ".Y");
        double z = Voelkerball.getInstance().getConfig().getDouble("Spawn."+ mapName + "." + team + "." + spawnID + ".Z");
        double yaw = Voelkerball.getInstance().getConfig().getDouble("Spawn."+ mapName + "." + team + "." + spawnID + ".Yaw");
        double pitch = Voelkerball.getInstance().getConfig().getDouble("Spawn."+ mapName + "." + team + "." + spawnID + ".Pitch");
        String worldn = Voelkerball.getInstance().getConfig().getString("Spawn."+ mapName + "." + team + "." + spawnID + ".World");
        World world = Bukkit.getWorld(worldn);
        Location loc = new Location(world, x, y, z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);


        return loc;
    }


}
