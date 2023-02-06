package app;

import java.util.Calendar;
public class calendarEvent {
    private int id;
    private Calendar startDateTime;
    private int lengthInMinutes;
    private static int count = 0;
    public calendarEvent(Calendar startDateTime, int lengthInMinutes){
        this.startDateTime = startDateTime;
        this.lengthInMinutes = lengthInMinutes;
        this.id = count;
        count++;
    }


}
