package edu.unca.nrodrigu.Quest6;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
 * This is a sample CommandExectuor
 */
public class Quest6CommandExecutor implements CommandExecutor {
	@SuppressWarnings("unused")
	private final Quest6 plugin;

	/*
	 * This command executor needs to know about its plugin from which it came
	 * from
	 */
	public Quest6CommandExecutor(Quest6 plugin) {
		this.plugin = plugin;
	}

	/*
	 * On command set the sample message
	 */
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			// player receives cake
		if (command.getName().equalsIgnoreCase("cake")) {
			Player fred = (Player) sender;
			fred.getInventory().addItem(new ItemStack(Material.CAKE, 1));
			return true;
			
			// changes the next 10 blocks below player to air
		} else if (command.getName().equalsIgnoreCase("pit")) {
			sender.sendMessage("Ahhhhhh!!!");
			Player fred = (Player) sender;
			Location loc = fred.getLocation();
			World w = loc.getWorld();
			for (int i = 0; i < 10; i++) {
				loc.setY(loc.getY() - 1);
				Block b = w.getBlockAt(loc);
				b.setTypeId(0);
			}
			return true;
			
			// the block below the player turns to gold
		} else if (command.getName().equalsIgnoreCase("midas")) {
			sender.sendMessage("The floor below you turns to gold!");
			Player fred = (Player) sender;
			Location loc = fred.getLocation();
			World w = loc.getWorld();
			loc.setY(loc.getY() - 1);
			Block b = w.getBlockAt(loc);
			b.setTypeId(41);
			return true;
		
			// spawn 10 zombies in random locations around the player
			// and spawn a diamond sword in the player's inventory
		} else if (command.getName().equalsIgnoreCase("zdefend")){
			sender.sendMessage("Look out for the Zombies!");
			Player fred = (Player) sender;
			for (int i = 0; i < 10; ++i) {
				Location loc = fred.getLocation();
				World w = loc.getWorld();
				int x = (-20) + (int)(Math.random() * ((20 - (-20)) + 1));
				int y = (-20) + (int)(Math.random() * ((20 - (-20)) + 1));
				loc.setX(loc.getX() + x);
				loc.setZ(loc.getZ() + y);
				w.spawnCreature(loc, EntityType.ZOMBIE);
			}
			fred.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
			return true;
		} else {
			return false;
		}
	}

}