package com.codegnan.Controller;

import java.util.List;

import com.codegnan.Players.Players;
import com.codegnan.PlayersDao.PlayersNotFoundException;
import com.codegnan.Service.PlayersService;
import com.codegnan.Service.PlayersServiceImpl;

public class PlayerAPP {

	public static void main(String[] args) {
		PlayersService serv = new PlayersServiceImpl();
//		
//		serv.addPlayers(new Players(18, "Virat Kohli", 85000, "India", 1800000000.00));
//		serv.addPlayers(new Players(7, "Faf du Plessis", 82000, "South Africa", 70000000.00));
//		serv.addPlayers(new Players(10, "Glenn Maxwell", 78000, "Australia", 110000000.00));
//		serv.addPlayers(new Players(42, "Cameron Green", 65000, "Australia", 175000000.00));
//		serv.addPlayers(new Players(19, "Dinesh Karthik", 60000, "India", 55000000.00));
//		serv.addPlayers(new Players(32, "Rajat Patidar", 50000, "India", 40000000.00));
//		serv.addPlayers(new Players(25, "Mahipal Lomror", 45000, "India", 30000000.00));
//		serv.addPlayers(new Players(63, "Karn Sharma", 40000, "India", 25000000.00));
//		serv.addPlayers(new Players(13, "Mohammed Siraj", 48000, "India", 80000000.00));
//		serv.addPlayers(new Players(33, "Lockie Ferguson", 52000, "New Zealand", 90000000.00));
//		serv.addPlayers(new Players(44, "Yash Dayal", 35000, "India", 45000000.00));
//		
//		System.out.println("Players saved sucessfully in database");
		
		
		
		System.out.println("ID\tNAME\t\tRUNS\tCOUNTRY\t\tSALARY");
		System.out.println("-----------------------------------------------------------");

		// 2. Fetch all players
		List<Players> allPlayers = serv.getAllPlayers();
		List<Players>allPlayer=serv.getAllPlayers();
		for(Players all:allPlayers) {
				System.out.println(all);
			}
		
		System.out.println("\nFetch player with ID 18:");
		try {
		    Players player = serv.getPlayersById(18);
		    System.out.println("Found: " + player);
		} catch (PlayersNotFoundException e) {
		    e.printStackTrace();
		}
		System.out.println("\nUpdate player with ID 33:");
		try {
		    serv.updatePlayers(new Players(33, "Lockie Ferguson", 53000, "New Zealand", 95000000.00));
		    System.out.println("Player successfully updated. Check database records.");
		} catch (PlayersNotFoundException  e) {
		    e.printStackTrace();
		}
		
		
		System.out.println("\nDelete player with ID 44:");
		try {
		    serv.deletePlayersById(44);
		    System.out.println("Player deleted successfully. Check database records.");
		} catch (PlayersNotFoundException e) {
		    e.printStackTrace();
		}


	}

}
