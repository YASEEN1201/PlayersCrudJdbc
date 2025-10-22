package com.codegnan.Service;

import java.util.List;

import com.codegnan.Players.Players;
import com.codegnan.PlayersDao.PlayersDao;
import com.codegnan.PlayersDao.PlayersDaoImpl;
import com.codegnan.PlayersDao.PlayersNotFoundException;

public class PlayersServiceImpl implements PlayersService {
	PlayersDao  dao = new PlayersDaoImpl();

	@Override
	public void addPlayers(Players players) {
		// TODO Auto-generated method stub
		dao.save(players);
	}

	@Override
	public List<Players> getAllPlayers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Players getPlayersById(int id) throws PlayersNotFoundException {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void updatePlayers(Players players) throws PlayersNotFoundException {
		// TODO Auto-generated method stub
		dao.update(players);
		
	}

	@Override
	public void deletePlayersById(int id) throws PlayersNotFoundException {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}
	
	
	


	
	

}
