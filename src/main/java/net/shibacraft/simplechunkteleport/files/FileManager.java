package net.shibacraft.simplechunkteleport.files;

import de.leonhard.storage.Yaml;
import de.leonhard.storage.internal.settings.ConfigSettings;
import de.leonhard.storage.internal.settings.DataType;
import de.leonhard.storage.internal.settings.ReloadSettings;
import lombok.Getter;
import net.shibacraft.simplechunkteleport.SimpleChunkTeleport;
import net.shibacraft.simplechunkteleport.api.loader.Loader;
import net.shibacraft.simplechunkteleport.api.utils.FileUtils;
import net.shibacraft.simplechunkteleport.files.messages.Messages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileManager implements Loader {

    private final SimpleChunkTeleport plugin;

    @Getter
    private static final Map<String, Yaml> filesYaml = new HashMap<>();
    private static final Set<String> filesCheck = new HashSet<>();

    public FileManager(SimpleChunkTeleport plugin) {
        this.plugin = plugin;
    }


    @Override
    public void load() {
        filesCheck.add("Messages.yml");
        FileUtils.checkFiles(filesCheck);
        filesCheck.clear();

        filesYaml.put("Messages", new Yaml("Messages.yml", plugin.getDataFolder().getPath(), null,
                ReloadSettings.INTELLIGENT, ConfigSettings.PRESERVE_COMMENTS, DataType.SORTED));
        Messages.load();
    }

    @Override
    public void unload() {
        filesYaml.clear();
        filesCheck.clear();
    }

    @Override
    public void reload() {
        Messages.load();
    }
}
