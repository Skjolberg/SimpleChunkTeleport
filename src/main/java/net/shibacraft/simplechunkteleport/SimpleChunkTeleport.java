package net.shibacraft.simplechunkteleport;

import lombok.Getter;
import net.shibacraft.simplechunkteleport.api.loader.Loader;
import net.shibacraft.simplechunkteleport.module.MainModule;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleChunkTeleport extends JavaPlugin {

    @Getter
    static SimpleChunkTeleport plugin;
    private Loader loader;

    @Override
    public void onEnable() {
        SimpleChunkTeleport.plugin = this;
        loader = new MainModule(this);
        loader.load();
    }

    @Override
    public void onDisable() {
        loader.unload();
    }

}
