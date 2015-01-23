package com.gmail.filoghost.chestcommands.internal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.filoghost.chestcommands.bridge.EconomyBridge;

public enum Variable {

	PLAYER("{player}") {
                @Override
		public String getReplacement(Player executor) {
			return executor.getName();
		}
	},
	
	ONLINE("{online}") {
                @Override
		public String getReplacement(Player executor) {
			return String.valueOf(Bukkit.getOnlinePlayers().length);
		}
	},
	
	MAX_PLAYERS("{max_players}") {
                @Override
		public String getReplacement(Player executor) {
			return String.valueOf(Bukkit.getMaxPlayers());
		}
	},
	
	MONEY("{money}") {
                @Override
		public String getReplacement(Player executor) {
			if (EconomyBridge.hasValidEconomy()) {
				return EconomyBridge.formatMoney(EconomyBridge.getMoney(executor));
			} else {
				return "[ECONOMY PLUGIN NOT FOUND]";
			}
		}
	},
	
	WORLD("{world}") {
                @Override
		public String getReplacement(Player executor) {
			return executor.getWorld().getName();
		}
	};
	
	private final String text;
	
	private Variable(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public abstract String getReplacement(Player executor);
}
