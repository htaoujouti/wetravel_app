package com.wetravel.wetravel_pidev.Repositories.Interfaces;

import com.wetravel.wetravel_pidev.Entities.Restaurant;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RestaurantCrudInterface extends CrudRepository<Restaurant>{
    public ArrayList<Restaurant> findByVille(String ville) throws SQLException;
}
