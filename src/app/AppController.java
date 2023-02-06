package app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AppController {
    public ArrayList<User> users;
    public User activeUser;

    public AppController(){
        users = new ArrayList<User>();
    }
    public User getactiveUser(){
        return activeUser;
    }
    public void setActiveUser(User user){
        activeUser = user;
    }

    public void showSettingScreen(){
        System.out.println("What would you like to do?");
        System.out.println("1. Create User");
        System.out.println("2. Change Active User");
        System.out.println("3. Make Calendar");
        System.out.println("4. Remove Calendar");
        System.out.println("5. Update Calendar");
        System.out.println("6. Make Event");
        System.out.println("7. Remove Event");
        System.out.println("8. Update Event");
        System.out.println("9. Exit");
    }

    public int collectUserInput(){
        Scanner reader = new Scanner(System.in);
        showSettingScreen();
        String option = reader.nextLine();
        return Integer.parseInt(option);
    }

    public ArrayList<String> getUserNames(){
        ArrayList<String> names = new ArrayList<String>();
        for(User u : users){
            names.add(u.getUsername());
        }
        return names;
    }

    public void Menu(){
        Scanner reader = new Scanner(System.in);
        int option = collectUserInput();
        while(option != 9){
            switch(option){
                case 1:
                    System.out.println("What is the new user's name?: ");
                    String name = reader.nextLine();
                    User user = new User(name);
                    users.add(user);
                    activeUser= user;
                    System.out.println("User made");
                    break;
                case 2:
                    System.out.println("Which user would you like to change to?: ");
                    System.out.println(getUserNames());
                    String change = reader.nextLine();
                    for(User u : users){

                        if (u.getUsername().equals(change)){
                            activeUser = u;
                            System.out.println("User changed to "+change);
                            break;
                        }
                    }

                case 3:
                    activeUser.createCalendar();
                    break;
                case 4:
                    System.out.println("Which calendar number would you like to remove?: ");
                    String calendar = reader.nextLine();
                    activeUser.removeCalendar(Integer.parseInt(calendar));
                    break;
                case 5:
                    System.out.println("Which calendar number would you like to update?: ");
                    String update = reader.nextLine();
                    activeUser.updateCalendar(Integer.parseInt(update));
                    break;
                case 6:
                    System.out.println("Which calendar number would you like to create Event?: ");
                    String ce = reader.nextLine();
                    activeUser.createEvent(Integer.parseInt(ce));
                    break;
                case 7:
                    System.out.println("Which calendar number would you like to remove Event?: ");
                    String re = reader.nextLine();
                    activeUser.removeEvent(Integer.parseInt(re));
                    break;
                case 8:
                    System.out.println("Which calendar number would you like to update Event?: ");
                    String ue = reader.nextLine();
                    activeUser.updateEvent(Integer.parseInt(ue));
                    break;

            }
            option = collectUserInput();
        }
    }


}
