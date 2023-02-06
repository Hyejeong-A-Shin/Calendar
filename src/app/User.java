package app;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;
    private ArrayList<calendar> calendars;

    public User(String username){
        this.username = username;
        this.calendars = new ArrayList<calendar>();
    }
    public String getUsername(){
        return username;
    }

    public ArrayList<calendar> getCalendars(){
        return calendars;
    }

    public calendarEvent createEvent(int calendar){
        for(calendar c : calendars){
            if(c.getCalendarID() == calendar){
                return c.create();
            }
        }
        System.out.println("No calendar with that number");
        return null;
    }

    public calendarEvent removeEvent(int calendar){
        for(calendar c : calendars){
            if(c.getCalendarID() == calendar){
                Scanner reader = new Scanner(System.in);
                System.out.println("What event number would you like to remove?");
                String e = reader.nextLine();
                return c.remove(Integer.parseInt(e));
            }
        }
        System.out.println("No calendar with that number");
        return null;
    }

    public calendarEvent updateEvent(int calendar){
        for(calendar c : calendars){
            if(c.getCalendarID() == calendar){
                Scanner reader = new Scanner(System.in);
                System.out.println("What event number would you like to update?");
                String e = reader.nextLine();
                return c.update(Integer.parseInt(e));
            }
        }
        System.out.println("No calendar with that number");
        return null;
    }

    public calendar createCalendar(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Would you like this calendar to be public? (y/n)");
        String p = reader.nextLine();
        if(p.equals("y")){
            calendar cal = new calendar(true);
            calendars.add(cal);
            return cal;
        }else if(p.equals("n")) {
            calendar cal = new calendar(false);
            calendars.add(cal);
            return cal;
        }else {
            System.out.println("Wrong input, try again");
            return null;
        }
    }

    public calendar removeCalendar(int calendar){
        for (calendar c : calendars){
            if (c.getCalendarID() == calendar){
                calendars.remove(c);
                System.out.println("calendar removed");
                return c;
            }
        }
        System.out.println("No calendar found, try different number");
        return null;
    }

    public calendar updateCalendar(int cal){
        for (calendar c : calendars){
            if (c.getCalendarID() == cal){
                if(c.getIsPublic() == true){
                    c.setIsPublic(false);
                    System.out.println("Privacy of calendar set to private");
                }else{
                    c.setIsPublic(true);
                    System.out.println("Privacy of calendar set to public");
                }
                return c;
            }
        }
        System.out.println("No calendar found, try different number");
        return null;
    }

    public calendar getCalendarByID(int calendar){
        for (calendar c : calendars){
            if (c.getCalendarID() == calendar){
                return c;
            }
        }
        System.out.println("No calendar found, try different number");
        return null;
    }




}
