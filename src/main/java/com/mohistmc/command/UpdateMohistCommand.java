package com.mohistmc.command;

import com.mohistmc.configuration.MohistConfig;
import static com.mohistmc.configuration.MohistConfigUtil.bMohist;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class UpdateMohistCommand extends Command {

    public UpdateMohistCommand(String name) {
        super(name);
        this.description = "Update Mohist to the latest build.";
        this.usageMessage = "/updatemohist";
        this.setPermission("mohist.command.updatemohist");
    }

    @Override
    public boolean execute(CommandSender sender, String currentAlias, String[] args) {
        if(sender.isOp()) {
            boolean val = bMohist("check_update_auto_download");
            MohistConfig.setValueMohist("mohist.check_update_auto_download", !val);
            if(!val) System.out.println("[Mohist] Auto update is now enabled. To update Mohist, you need to restart the server.");
            else System.out.println("[Mohist] Auto update is now disabled.");
        }
        return true;
    }
}
