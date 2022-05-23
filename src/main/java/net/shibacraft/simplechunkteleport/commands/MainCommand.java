package net.shibacraft.simplechunkteleport.commands;

import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.api.loader.Loader;
import net.shibacraft.simplechunkteleport.files.FileManager;
import net.shibacraft.simplechunkteleport.files.messages.Messages;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    private final SimpleChunkTeleport plugin;

    public MainCommand(SimpleChunkTeleport plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof ConsoleCommandSender){
            sender.sendMessage("This command can only be used in-game.");
            return false;
        } else {
            Player p = (Player)sender;
            if(p.hasPermission("sct.use") || p.isOp()){
                if (args.length > 0) {
                    Loader loader;
                    if (args[0].equalsIgnoreCase("reload")) {
                        loader = new FileManager(plugin);
                        loader.reload();
                        sender.sendMessage(Messages.RELOAD.get());
                    } else if((args.length == 3) && (args[0].equalsIgnoreCase("tp"))){

                        try {

                            double a = Double.parseDouble(args[1]);
                            double b = Double.parseDouble(args[2]);

                            double locationA = a*16;
                            double locationB = b*16;
                            Block block = p.getWorld().getHighestBlockAt((int) locationA, (int) locationB);
                            Location l = block.getLocation();
                            Chunk chunk = l.getChunk();
                            chunk.load(true);
                            Location safeLocation = new Location(p.getWorld(), locationA, block.getY()+1, locationB);

                            if (block.isLiquid()) {
                                block.setType(Material.STONE);
                                p.teleport(safeLocation);
                            } else {
                                p.teleport(safeLocation);
                            }
                            sender.sendMessage(Messages.TELEPORT.get().replace("{location}", safeLocation.getX()+" | "+safeLocation.getY()+" | "+safeLocation.getZ()));

                        } catch (NumberFormatException ex){
                            sender.sendMessage(Messages.INVALID_CHUNK.get());
                        }
                    } else {
                        sender.sendMessage(Messages.INVALID_ARGUMENT.get());
                    }
                } else {
                    sender.sendMessage(Messages.NEED_ARGUMENTS.get());
                }
            } else {
                sender.sendMessage(Messages.NO_PERMISSION.get());
            }
        }
        return true;
    }
}