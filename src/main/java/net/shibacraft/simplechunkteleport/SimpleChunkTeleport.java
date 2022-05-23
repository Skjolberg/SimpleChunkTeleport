package net.shibacraft.simplechunkteleport;

import net.shibacraft.simplechunkteleport.module.MainModule;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleChunkTeleport extends JavaPlugin {

    private static SimpleChunkTeleport plugin;
    private MainModule mainModule;

    @Override
    public void onEnable() {
        plugin = this;
        mainModule = new MainModule(this);
        mainModule.load();
    }

    @Override
    public void onDisable() {
        mainModule.unload();
    }

    public static SimpleChunkTeleport getPlugin(){
        return plugin;
    }

}
