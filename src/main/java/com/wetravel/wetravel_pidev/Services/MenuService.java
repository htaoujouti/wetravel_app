/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wetravel.wetravel_pidev.Services;

import com.wetravel.wetravel_pidev.Repositories.Interfaces.MenuCrudInterface;
import com.wetravel.wetravel_pidev.Entities.Menu;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author m.rhouma
 */
public class MenuService {

    private final MenuCrudInterface menuCrud;

    public MenuService(MenuCrudInterface menuCrud) {
        this.menuCrud = menuCrud;
    }

    public void createMenu(Menu menu) throws SQLException {
        menuCrud.create(menu);
    }

    public Menu findMenu(int id) throws SQLException {
        return menuCrud.find(id);
    }

    public ArrayList<Menu> findAllMenu() throws SQLException {
        return menuCrud.findAll();
    }

    public void deleteMenu(int id) throws SQLException {
        menuCrud.delete(id);
    }

    public void updateMenu(int id, Menu menu) throws SQLException {
        menuCrud.update(id, menu);
    }
}
