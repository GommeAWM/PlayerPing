package getmc.Util;

import cn.nukkit.utils.Config;
import getmc.PlayerPing;

import java.io.File;

public class PingConfig {

    private PlayerPing playerPing;
    private File file;
    private Config config;

    public PingConfig(PlayerPing playerPing){
        this.playerPing = playerPing;
        this.file = new File(playerPing.getDataFolder() + "/config.yml");
        this.config = new Config(this.file, Config.YAML);
    }

    public void createDefaultConfig(){
        this.addDefault("command.messages.description", "Check own ping or players");
        this.addDefault("command.messages.usageMessage", "/ping <player> or /ping");
        this.addDefault("command.messages.success", "Your ping {ping}");
        this.addDefault("command.messages.success1", "Ping {nick} {ping}");
        this.addDefault("command.messages.permission", "You don't have permission to use it");
        this.addDefault("command.messages.playernotonline", "player is not online");
        this.addDefault("command.options.permission", false);
    }

    public String descr(){
        return this.config.getString("command.messages.description");
    }

    public String usage(){
        return this.config.getString("command.messages.usageMessage");
    }

    public boolean perm(){
        return this.config.getBoolean("command.options.permission");
    }

    public String suc(){
        return this.config.getString("command.messages.success");
    }

    public String permmsg(){
        return this.config.getString("command.messages.permission");
    }

    public String plnoton(){
        return this.config.getString("command.messages.playernotonline");
    }

    public String suc1(){
        return this.config.getString("command.messages.success1");
    }

    public void addDefault(String path, Object object){
        if (!this.config.exists(path)){
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

}
