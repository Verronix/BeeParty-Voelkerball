package net.beeparty.voelkerball.commands;

import net.beeparty.voelkerball.Voelkerball;
import net.beeparty.voelkerball.manager.DataManager;
import net.beeparty.voelkerball.utils.Ball;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class CMD_Voelkerball implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if(player.hasPermission("vb.use"))
            {
                if(args.length == 0)
                {
                    printCommandInfo(player);
                } else if(args.length == 1)
                {
                    if(args[0].equalsIgnoreCase("setlobby"))
                    {
                        Voelkerball.getInstance().getSpawnManager().setLobbySpawn(player, player.getLocation());
                    } else
                    {
                        printCommandInfo(player);
                    }
                } else if(args.length == 2)
                {
                    if(args[0].equalsIgnoreCase("addmap"))
                    {
                        Voelkerball.getInstance().getMapManager().addMap(args[1], player);
                    } else
                    {
                        printCommandInfo(player);
                    }
                } else if(args.length== 3)
                {
                    if(args[0].equalsIgnoreCase("setball"))
                    {
                        String mapName = args[1];
                        if(Integer.parseInt(args[2]) > 0 && Integer.parseInt(args[2]) < 4)
                        {
                            Voelkerball.getInstance().getSpawnManager().setBallSpawn(Integer.parseInt(args[2]), mapName, player, player.getLocation());
                            if(!DataManager.ballHashMap.containsKey(mapName))
                            {

                                ArrayList<Ball> ballList = new ArrayList<>();
                                ballList.add(new Ball(Integer.parseInt(args[2]), mapName));
                                DataManager.ballHashMap.put(mapName, ballList);
                            } else
                            {
                                ArrayList<Ball> oldBall = DataManager.ballHashMap.get(mapName);
                                ArrayList<Ball> newBall = oldBall;
                                if(oldBall.size() == 3)
                                {
                                    for(int i = 0; i < oldBall.size(); i++)
                                    {
                                        if(oldBall.get(i).getBallID() == Integer.parseInt(args[2]))
                                            oldBall.remove(i);
                                    }
                                    newBall.add(new Ball(Integer.parseInt(args[2]), mapName));
                                    DataManager.ballHashMap.replace(mapName, oldBall, newBall);
                                } else
                                {
                                    for (Ball ball : oldBall) {
                                        if (ball.getBallID() != Integer.parseInt(args[2])) {
                                            newBall.add(new Ball(Integer.parseInt(args[2]), mapName));
                                            break;
                                        }
                                    }
                                    DataManager.ballHashMap.replace(mapName, oldBall, newBall);
                                }
                            }
                        } else
                        {
                            printCommandInfo(player);
                        }
                    } else
                    {
                        printCommandInfo(player);
                    }
                } else if(args.length == 4)
                {
                    if(args[0].equalsIgnoreCase("setspawn"))
                    {
                        String inputMap = args[1];
                        String inputTeam = args[2];
                        int inputSpawnID = Integer.parseInt(args[3]);
                        if(args[2].equals("Blau") || args[2].equals("Rot"))
                        {
                            if(inputSpawnID > 0 && inputSpawnID <= 5)
                            {
                                Voelkerball.getInstance().getSpawnManager().setTeamSpawn(inputTeam, inputSpawnID, inputMap, player, player.getLocation());
                            } else
                            {
                                printCommandInfo(player);
                            }
                        } else
                        {
                            printCommandInfo(player);
                        }
                    } else if(args[0].equalsIgnoreCase("setdspawn"))
                    {
                        String inputMap = args[1];
                        String inputTeam = args[2];
                        int inputSpawnID = Integer.parseInt(args[3]);
                        if(args[2].equals("Blau") || args[2].equals("Rot"))
                        {
                            if(inputSpawnID > 0 && inputSpawnID <= 5)
                            {
                                Voelkerball.getInstance().getSpawnManager().setDeathSpawns(inputTeam, inputSpawnID, inputMap, player, player.getLocation());
                            } else
                            {
                                printCommandInfo(player);
                            }
                        } else
                        {
                            printCommandInfo(player);
                        }
                    }
                } else
                {
                    printCommandInfo(player);
                }
            } else
            {
                player.sendMessage(DataManager.prefix + "§cDazu hast du nicht die Befugnis!");
            }
        }
        return false;
    }

    private void printCommandInfo(Player player)
    {
        player.sendMessage("§7-------§6Völkerball§7-§6Setup§7-------");
        player.sendMessage("§7/vb addmap <Map> - Setzte den Lobbyspawn");
        player.sendMessage("§7/vb setlobby - Setzte den Lobbyspawn");
        player.sendMessage("§7/vb setspawn <Map> <team> <1-5>- Setzte den Spawnpunkt im Spielfeld");
        player.sendMessage("§7/vb setdspawn <Map> <team> <1-5> - Setzte den Spawnpunkt außerhalb des Spielfeldes");
        player.sendMessage("§7/vb setball <Map> <1-3> - Setzte den Spawnpunkt der Spielbälle");
        player.sendMessage("§7-------§6Völkerball§7-§6Setup§7-------");
    }
}
