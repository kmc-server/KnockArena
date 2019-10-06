package nl.bramkoene.knockarena.Executors;

import nl.bramkoene.knockarena.KnockArena;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetGameSpawnPoints implements CommandExecutor {
    public KnockArena plugin;
    public SetGameSpawnPoints(KnockArena pl){
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if((sender.isOp() || sender.hasPermission("KnockArena.Builder") || sender.getName() == "minestarnl") && sender instanceof Player){
            Player player = (Player)sender;
            List<Location> locations = new ArrayList<Location>();
            if(plugin.getConfigManager().getCollectors().contains("GameSpawn")) {
                List<Location> locs = (List<Location>) plugin.getConfigManager().getCollectors().getList("GameSpawn");
                for (Location location : locs) {
                    locations.add(location);
                }
            }
            locations.add(player.getLocation());
            plugin.getConfigManager().getCollectors().set("GameSpawn", locations);
            plugin.getConfigManager().saveCollectors();
        }

        return false;
    }
}