package com.codegnan.PlayersDao;

import java.util.List;

import com.codegnan.Players.Players;

public interface PlayersDao {
	
	void save(Players players);
	
	List<Players> findAll();
	
	Players findById(int id)throws PlayersNotFoundException;
	
	void update(Players players) throws PlayersNotFoundException;
	
	void deleteById(int id) throws PlayersNotFoundException;
	

}
