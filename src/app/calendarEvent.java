package app;

import java.time.LocalDate;
public class calendarEvent {
    private int id;
    private LocalDate startDateTime;
    private int lengthInMinutes;
    private static int count = 0;
    public calendarEvent(LocalDate startDateTime, int lengthInMinutes){
        this.startDateTime = startDateTime;
        this.lengthInMinutes = lengthInMinutes;
        this.id = count;
        System.out.println("Event number " + id + " created.");
        count++;
    }

    public int getEventID(){
        return id;
    }
    public LocalDate getStartDateTime(){
        return startDateTime;
    }

    public int getLengthInMinutes(){
        return lengthInMinutes;
    }

    public int getCount(){
        return count;
    }

    public void setStartDateTime(LocalDate date) {this.startDateTime = date;}

    public void setLengthInMinutes(int length) {this.lengthInMinutes = length;}


}
