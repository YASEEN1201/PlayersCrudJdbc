package com.codegnan.PlayersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.codegnan.Players.Players;
import com.codegnan.Util.DBConnectionUtil;

public class PlayersDaoImpl implements PlayersDao {

    @Override
    public void save(Players players) {
        String sql = "INSERT INTO playerss (id, name, runs, country, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setInt(1, players.getId());
            pst.setString(2, players.getName());
            pst.setInt(3, players.getRuns());
            pst.setString(4, players.getCountry());
            pst.setDouble(5, players.getSalary());
            pst.executeUpdate();

            System.out.println("Saved successfully: " + players);
        } catch (SQLException e) {
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    @Override
    public List<Players> findAll() {
        List<Players> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM playerss";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(sqlQuery)) {

            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
				list.add(new Players(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getDouble(5)
						));	
			}
			
			
		}catch(SQLException e) {
			System.out.println("Fetch all records failed :"+e.getMessage());
		}
		return list;
		
	}

    @Override
    public Players findById(int id) throws PlayersNotFoundException {
        String sqlQuery = "SELECT * FROM playerss WHERE id = ?";
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pst = connection.prepareStatement(sqlQuery)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Players(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getDouble(5)
                );
            } else {
                throw new PlayersNotFoundException("Id not found: " + id);
            }

        } catch (SQLException e) {
            throw new PlayersNotFoundException("Database error: " + e.getMessage());
        }
    }

    @Override
    public void update(Players players) throws PlayersNotFoundException {
        String sqlQuery = "UPDATE playerss SET name=?, runs=?, country=?, salary=? WHERE id=?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sqlQuery)) {

            pst.setString(1, players.getName());
            pst.setInt(2, players.getRuns());
            pst.setString(3, players.getCountry());
            pst.setDouble(4, players.getSalary());
            pst.setInt(5, players.getId());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new PlayersNotFoundException("Id not found for update: " + players.getId());
            } else {
                System.out.println("Updated successfully: " + players);
            }

        } catch (SQLException e) {
            System.out.println("Updation failed: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws PlayersNotFoundException {
        String sql = "DELETE FROM playerss WHERE id=?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new PlayersNotFoundException("Id not found for deletion: " + id);
            } else {
                System.out.println("Deleted successfully: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Deletion failed: " + e.getMessage());
        }
    }
}
