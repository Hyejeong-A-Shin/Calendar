package app;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class calendar {
    private int id;
    private ArrayList<calendarEvent> events;
    private Boolean isPublic;
    private static int count = 0;

    public calendar(Boolean isPublic){
        this.events = new ArrayList<calendarEvent>();
        this.isPublic = isPublic;
        this.id = count;
        System.out.println("Calendar Created");
        count++;
    }
    public int getCalendarID(){
        return id;
    }
    public void setCalendarID(int id){
        this.id = id;
    }
    public ArrayList<calendarEvent> getEvents(){
        return events;
    }
    public Boolean getIsPublic(){
        return isPublic;
    }
    public void setIsPublic(Boolean isPublic){
        this.isPublic = isPublic;
    }
    public int getCount(){
        return count;
    }
    public calendarEvent create(){
        // Get user inputs
        Scanner reader = new Scanner(System.in);
        System.out.println("When would you like to plan the event? (yyyy-MM-dd HH:mm:ss)");
        String dateTime = reader.nextLine();
        System.out.println("How long is the event? (integer in mintues)");
        String minutes = reader.nextLine();

        //Setup Event
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date = LocalDate.parse(dateTime, formatter);
        calendarEvent event = new calendarEvent(date, Integer.parseInt(minutes));
        events.add(event);
        System.out.println("Event created");
        return event;

    }
    public calendarEvent remove(Integer event){
        for (calendarEvent e : events){
            if (e.getEventID() == event){
                events.remove(e);
                System.out.println("Event removed");
                return e;
            }
        }
        System.out.println("Event not in calendar. Are you sure that is the correct number for the event?");
        return null;
    }

    public calendarEvent update(int event){
        for (calendarEvent e : events){
            if (e.getEventID() == event){
                Scanner reader = new Scanner(System.in);
                System.out.println("What would you like to update? (Enter: DT to change dateTime or L to change length in minutes)");
                String option = reader.nextLine();
                if(option.equals("DT")){
                    System.out.println("When would you like to plan the event? (yyyy-MM-dd HH:mm:ss)");
                    String dateTime = reader.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDate date = LocalDate.parse(dateTime, formatter);

                    e.setStartDateTime(date);
                    System.out.println("Event updated.");
                    return e;
                }else if (option.equals("L")){
                    System.out.println("How long is the event? (integer in minutes)");
                    String minutes = reader.nextLine();

                    e.setLengthInMinutes(Integer.parseInt(minutes));
                    System.out.println("Event updated.");
                    return e;
                }
            }
        }
        System.out.println("There is no such event, try a different number");
        return null;

    }
}
