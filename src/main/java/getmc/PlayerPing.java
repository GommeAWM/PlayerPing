package getmc;

import cn.nukkit.Server;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import getmc.Command.PingCMD;
import getmc.Util.PingConfig;

public class PlayerPing extends PluginBase {

    public static PlayerPing instance;
    public static PingConfig pingConfig;

    @Override
    public void onEnable() {
        instance = this;
        register();
        pingConfig = new PingConfig(this);
        pingConfig.createDefaultConfig();
        this.getLogger().info("§fEnable: §a§lPlayerPing");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§fDisable: §c§lPlayerPing");

    }

    private void register(){
        SimpleCommandMap simpleCommandMap = getServer().getCommandMap();
        simpleCommandMap.register("ping", new PingCMD());
    }

    public static PlayerPing getInstance(){
        return instance;
    }

    public static PingConfig getPingConfig(){
        return pingConfig;
    }

}
