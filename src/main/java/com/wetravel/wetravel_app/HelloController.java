package com.wetravel.wetravel_app;

import com.wetravel.wetravel_pidev.Entities.Hotel;
import com.wetravel.wetravel_pidev.Repositories.HotelCrudImpl;
import com.wetravel.wetravel_pidev.Services.HotelsService;
import com.wetravel.wetravel_pidev.Utils.DataSource;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws SQLException {
        DataSource ds = DataSource.getInstance();
        HotelCrudImpl hotelCrud = new HotelCrudImpl(ds.getCon());
        HotelsService hotelService = new HotelsService(hotelCrud);

            Hotel hotels = hotelService.get(1);


        welcomeText.setText(hotels.toString());
    }
}