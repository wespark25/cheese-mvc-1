package org.launchcode.models;

import java.util.ArrayList;

public class UserData {
    static ArrayList<User> users = new ArrayList<>();

    public static void add(User user) {
        users.add(user);
    }

    public static User getById(int id){

        User theUser = null;

        for (User user : users) {
            if (user.getId() == id) {
                theUser = user;
                break;
            }
        }
        return theUser;
    }

    public static void remove(int id){
        User userToRemove = UserData.getById(id);
        users.remove(userToRemove);
    }

    public static ArrayList getAll(){return users;};


}
