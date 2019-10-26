package nl.bramkoene.minigameapi.Executors;

import nl.bramkoene.minigameapi.MiniGameAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateGame implements CommandExecutor {
    private final MiniGameAPI plugin;
    public CreateGame(MiniGameAPI pl){
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender.isOp()){
            Player player = (Player)sender;
//            plugin.getGameController().setupGame();
            plugin.getTitles().sendTitleToAllPlayers("A New game has been started", "Join now via /joingame");
//            plugin.getGameController().lobbyWait(player);
        }

        return false;
    }
}
