package net.shibacraft.simplechunkteleport.module;

import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.files.FileManager;
import net.shibacraft.simplechunkteleport.api.loader.Loader;

public class MainModule implements Loader {

    private final SimpleChunkTeleport plugin;

    public MainModule(SimpleChunkTeleport plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        Loader loader = new FileManager(plugin);
        loader.load();
        loader = new CommandModule(plugin);
        loader.load();

    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
