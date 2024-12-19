package net.beeparty.voelkerball.utils;

import net.beeparty.voelkerball.Voelkerball;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Ball
{

    private final int ballID;
    private final String mapName;

    private ItemStack ball;

    public Ball(int ballID, String mapName)
    {
        this.ballID=ballID;
        this.mapName = mapName;
    }

    public void spawnBall()
    {
        Location location = Voelkerball.getInstance().getSpawnManager().getBallID(ballID, mapName);
        ball = new ItemBuilder(Material.SNOWBALL).setDisplayName("§7Ball §6" + ballID).build();
        location.getWorld().dropItem(location, ball);
    }

    public void despawnBall()
    {
        ball.setType(Material.AIR);
    }

    public int getBallID() {
        return ballID;
    }

}
