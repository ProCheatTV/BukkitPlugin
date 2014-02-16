package com.github.procheattv.TutorialPlugin.Listener;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.procheattv.TutorialPlugin.TutorialPlugin;

public class TutorialLoginListener implements Listener 
{
	TutorialPlugin plugin;
	
	public TutorialLoginListener(TutorialPlugin pl)
	{
		plugin = pl;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		event.setJoinMessage(ChatColor.GOLD + "Hey " + event.getPlayer().getDisplayName() + ", willkommen auf dem Server!");
		
		Player p = event.getPlayer();
		Inventory inv = p.getInventory();
		
		ItemStack itemGeschenk = new ItemStack(Material.GOLDEN_APPLE, 20);
		ItemMeta gesMeta = itemGeschenk.getItemMeta();
		gesMeta.setDisplayName("¤b¤lGeschenk des Himmels");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("¤o¤l¤4Heilt fast alle¤a Herzen auf einmal!");
		gesMeta.setLore(lore);
		itemGeschenk.setItemMeta(gesMeta);
		
		ItemStack itemRules = new ItemStack(Material.BOOK, 1);
		BookMeta rulesM = (BookMeta)itemRules.getItemMeta();
		rulesM.setTitle("¤6¤l¤oRegeln des Servers");
		rulesM.setAuthor("¤l¤o¤1von ¤2Pro¤4Cheat¤5TV");
		ArrayList<String> pages = new ArrayList<String>();
		String newLine = "\n";
		pages.add("Willkommen auf dem Server, " + p.getDisplayName() + newLine + 
				  "Halte dich an die ¤4Regeln¤r ");
		pages.add("");
		
	}
}
