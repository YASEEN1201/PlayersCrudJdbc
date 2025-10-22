package com.codegnan.Service;

import java.util.List;

import com.codegnan.Players.Players;
import com.codegnan.PlayersDao.PlayersNotFoundException;

public interface PlayersService {
	
	void addPlayers(Players players);
	
	List<Players> getAllPlayers();
	
	Players getPlayersById(int id) throws PlayersNotFoundException;
	
	void updatePlayers(Players players)  throws PlayersNotFoundException;
	
	void deletePlayersById(int id) throws PlayersNotFoundException;
	
	

}
