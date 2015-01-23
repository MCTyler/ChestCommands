package com.gmail.filoghost.chestcommands.bridge.bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.gmail.filoghost.chestcommands.ChestCommands;
import java.util.logging.Level;

public class BungeeCordUtils {

	public static boolean connect(Player player, String server) {
		
		try {
			
			if (server.length() == 0) {
				player.sendMessage("Target server was \"\" (empty string) cannot connect to it.");
				return false;
			}
		
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(byteArray);
		 
			out.writeUTF("Connect");
			out.writeUTF(server); // Target Server.
		    
			player.sendPluginMessage(ChestCommands.getInstance(), "BungeeCord", byteArray.toByteArray());
			
		} catch (Exception ex) {
			player.sendMessage(ChatColor.RED + "An unexpected exception has occurred. Please notify the server's staff about this. (They should look at the console).");
			ChestCommands.getInstance().getLogger().log(Level.WARNING, "Could not connect \"{0}\" to the server \"{1}\".", new Object[]{player.getName(), server});
			return false;
		}
		
		return true;
	}
	
}
