package getmc.Command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import getmc.PlayerPing;

public class PingCMD extends Command {

    public PingCMD(){
        super("ping");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (PlayerPing.getPingConfig().perm() == true){
                if (player.hasPermission("cmd.ping")){
                    if (args.length == 0){
                        player.sendMessage(PlayerPing.getPingConfig().suc().replace("{ping}", String.valueOf(player.getPing())));
                    } else if (args.length == 1){
                        String getmsg = args[0];
                        if (Server.getInstance().getPlayerExact(getmsg) == null){
                            player.sendMessage(PlayerPing.getPingConfig().plnoton().replace("{playernick}", getmsg));
                        } else {
                            player.sendMessage(PlayerPing.getPingConfig().suc1().replace("{nick}", getmsg).replace("{ping}", String.valueOf(player.getPing())));
                        }
                    } else {
                        getUsage();
                    }
                } else {
                    player.sendMessage(PlayerPing.getPingConfig().permmsg());
                }
            } else {
                if (args.length == 0){
                    player.sendMessage(PlayerPing.getPingConfig().suc().replace("{ping}", String.valueOf(player.getPing())));
                } else if (args.length == 1){
                    String getmsg = args[0];
                    if (Server.getInstance().getPlayerExact(getmsg) == null){
                        player.sendMessage(PlayerPing.getPingConfig().plnoton().replace("{playernick}", getmsg));
                    } else {
                        player.sendMessage(PlayerPing.getPingConfig().suc1().replace("{playernick}", getmsg).replace("{ping}", String.valueOf(player.getPing())));
                    }
                } else {
                    player.sendMessage(PlayerPing.getPingConfig().usage());
                }
            }
        }

        return true;
    }
}
