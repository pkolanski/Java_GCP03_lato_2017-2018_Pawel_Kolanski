package webcrawler.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsersObserveList {
    private static ObservableList<User> userObservableList = FXCollections.observableArrayList(new User("","", 20, "Krakow", "M"));

    public static boolean searchUser(String login, String password)
    {
        boolean flag = false;

        for (User el: userObservableList)
        {
            if(el.getStringLoginProperty().equals(login))
            {
                if(el.getStringPasswordProperty().equals(password))
                {
                    flag = true;
                }
            }
        }


        return flag;
    }

    public static void addUser(String login, String password, int age, String address, String sex)
    {
        User user = new User(login, password, age, address, sex);
        userObservableList.add(user);
    }

}
