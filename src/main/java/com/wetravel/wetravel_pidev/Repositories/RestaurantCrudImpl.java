package com.wetravel.wetravel_pidev.Repositories;

import com.wetravel.wetravel_pidev.Entities.Restaurant;

import com.wetravel.wetravel_pidev.Repositories.Interfaces.RestaurantCrudInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantCrudImpl implements RestaurantCrudInterface {
    private Connection con;
    private Statement ste;
    private PreparedStatement prs;

    public Connection getCon() {
        return con;
    }

    public RestaurantCrudImpl(Connection con) {
        this.con = con;
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantCrudImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Restaurant restaurants) throws SQLException {
        String req="INSERT INTO restaurants ( name, capacity, adresse, ville, pays) VALUES(?,?,?,?,?)";
        prs = con.prepareStatement(req);

        prs.setString(1, restaurants.getName());
        prs.setInt(2,restaurants.getCapacity());
        prs.setString(3, restaurants.getAdresse());
        prs.setString(4, restaurants.getVille());
        prs.setString(5, restaurants.getPays());

        prs.executeUpdate();
    }

    @Override
    public Restaurant find(int id) throws SQLException {
        String req = "select * from restaurants where id = ?";
        prs = con.prepareStatement(req);
        prs.setInt(1,id);
        ResultSet rs = prs.executeQuery();

        Restaurant restaurant = new Restaurant();
        while(rs.next()){
            restaurant =
                    new Restaurant(
                        rs.getInt("id"),rs.getInt("capacity"),rs.getString("adresse"),
                        rs.getString("ville"),rs.getString("pays"),rs.getString("name"));
        }
        return restaurant;
    }

    @Override
    public ArrayList<Restaurant> findAll() throws SQLException {
        String req = "select * from restaurants";
        ArrayList<Restaurant> list = new ArrayList<>();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()){
            list.add(new Restaurant(
                            rs.getInt("id"),rs.getInt("capacity"),rs.getString("adresse")
                            ,rs.getString("ville"),rs.getString("pays"),rs.getString("name")));
        }

        return list;
    }

    @Override
    public void delete(int id) throws SQLException {
        String req ="delete from restaurants where id = ?";
        prs = con.prepareStatement(req);
        prs.setInt(1, id);
        prs.execute();
        System.out.println("Restaurant deleted successfully");
    }

    @Override
    public void update(int id, Restaurant restaurants) throws SQLException {
        String req ="UPDATE restaurants SET name = ?, capacity = ?, adresse = ?, ville = ?, pays = ? WHERE id = ?;";
        prs = con.prepareStatement(req);

        prs.setString(1, restaurants.getName());
        prs.setInt(2,restaurants.getCapacity());
        prs.setString(3, restaurants.getAdresse());
        prs.setString(4, restaurants.getVille());
        prs.setString(5, restaurants.getPays());
        prs.setInt(6, id);

        prs.executeUpdate();
        System.out.println("Restaurant updated successfully");
    }
    @Override
    public ArrayList<Restaurant> findByVille(String ville) throws SQLException{
        ArrayList<Restaurant> list = new ArrayList<>();
        String query ="select * from restaurants where ville = ?;";
        prs = con.prepareStatement(query);
        prs.setString(1,ville);
        ResultSet rs = prs.executeQuery();

        while (rs.next()){
            list.add(new Restaurant(
                    rs.getInt("id"),rs.getInt("capacity"),rs.getString("adresse")
                    ,rs.getString("ville"),rs.getString("pays"),rs.getString("name")));
        }

        return list;
    }
}
