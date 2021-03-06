package com.wetravel.wetravel_pidev;

import com.wetravel.wetravel_pidev.Entities.User;
import com.wetravel.wetravel_pidev.Entities.Hotel;
import com.wetravel.wetravel_pidev.Repositories.HotelCrudImpl;
import com.wetravel.wetravel_pidev.Services.HotelsService;
import com.wetravel.wetravel_pidev.Repositories.RestaurantCrudImpl;
import com.wetravel.wetravel_pidev.Entities.Restaurant;
import com.wetravel.wetravel_pidev.Repositories.Interfaces.RestaurantCrudInterface;
import com.wetravel.wetravel_pidev.Repositories.UserCrudImpl;
import com.wetravel.wetravel_pidev.Services.RestaurantService;
import com.wetravel.wetravel_pidev.Services.UserService;
import com.wetravel.wetravel_pidev.Utils.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author m.rhouma
 */
public class WeTravel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // Init Data source
        DataSource ds = DataSource.getInstance();

        // Init repositories
        UserCrudImpl userCrud = new UserCrudImpl(ds.getCon());
        HotelCrudImpl hotelCrud = new HotelCrudImpl(ds.getCon());
        RestaurantCrudInterface restaurantsCrud = new RestaurantCrudImpl(ds.getCon());

        // Init services
        UserService userService = new UserService(userCrud);
        RestaurantService restaurantService = new RestaurantService(restaurantsCrud);
        HotelsService hotelService = new HotelsService(hotelCrud);


        // Tests
        User user = new User("Mohamed", "ADMIN", "moihamed@wetravel.com", "mohamed123", "22001002");
        userService.create(user);
        ArrayList users = userService.getAll();

        System.out.println(users);
        // Tests d'hotel
        Hotel hotel = new Hotel("el mouradi", 4, 100, "elmouradi@Sousse.com", "Sousse", "Tunisie");
        hotelService.create(hotel);
        ArrayList hotelss = hotelService.getAll();
        System.out.println(hotelss);

        Restaurant restaurant = new Restaurant(70,"Lac 2", "Tunis", "Tunisie", "via mercato");
        Restaurant restaurant2 = new Restaurant(50,"Lac 1", "Tunis", "Tunisie", "New Food");
        Restaurant restaurant3 = new Restaurant(60,"Lac 1", "Tunis", "Tunisie", "Good Food");

        restaurantService.createRestaurant(restaurant);
        restaurantService.createRestaurant(restaurant2);
        restaurantService.updateRestaurants(2, restaurant3);
        restaurantService.deleteRestaurants(3);

        Restaurant resto = restaurantService.findRestaurants(1);
        restaurantService.updateRestaurants(2,restaurant3);
//        restaurantService.findByVille("Tunis");
        restaurantService.deleteRestaurants(3);
        ArrayList restaurants = restaurantService.findByVille("Tunis");

        System.out.println(resto);
        System.out.println(restaurants);
    }
    
}
