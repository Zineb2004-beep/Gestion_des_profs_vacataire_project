/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.User;

/**
 *
 * @author User
 */
public interface IDaoUser {
    boolean addUser(User u); 
    User findUserByLogin(String login); 
    boolean authentificate(String login, String password);
}
