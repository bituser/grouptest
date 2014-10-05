package com.example.grouptest;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
 
                //add event to calendar
                addCalendarCourseAndEvent();
            	//addCalendarEvent();
            }
 
        });
        
}
    
    protected void addCalendarCourseAndEvent() {
		// TODO Auto-generated method stub
    	Calendar startDateCal = new GregorianCalendar();
    	startDateCal.set(Calendar.YEAR, 2014);
    	startDateCal.set(Calendar.MONTH, Calendar.JANUARY); // 11 = december
    	startDateCal.set(Calendar.DAY_OF_MONTH, 1); // new years eve
    	
    	Calendar endDateCal = new GregorianCalendar();
    	endDateCal.set(Calendar.YEAR, 2014);
    	endDateCal.set(Calendar.MONTH, 11); // 11 = december
    	endDateCal.set(Calendar.DAY_OF_MONTH, 1);
    	
	//	Course course = new Course("COMP666-14D", startDateCal, endDateCal);
		
		Time time11 = Time.valueOf("11:00:00");
		Time time02 = Time.valueOf("11:30:00");
		Time time1530 = Time.valueOf("15:30:00");
		Time time1430 = Time.valueOf("14:30:00");
//		
//		Event lab = new Event(Calendar.MONDAY, "LAB", time11, 3, "GB.1.666", "Waikato");
//		Event lec = new Event(Calendar.FRIDAY, "LEC", time02, 1, "GB.1.666", "Waikato");
//		Event lec1 = new Event(Calendar.TUESDAY, "LAB", time1530, 1, "GB.1.666", "Waikato");
//		Event tut = new Event(Calendar.WEDNESDAY, "LAB", time1430, 1, "GB.1.666", "Waikato");
//		
//		course.addEvents(lab);
//		course.addEvents(lec);
//		course.addEvents(lec1);
//		course.addEvents(tut);
		
		TimeTableController con = new TimeTableController();
			
//		con.addCourse(course, getContentResolver(), this);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void addCalendarEvent(){   	
    	long calID = 1;
    	long startMillis = 0; 
    	long endMillis = 0;     
    	Calendar beginTime = Calendar.getInstance();
    	beginTime.set(2014, 9, 4, 7, 30);
    	startMillis = beginTime.getTimeInMillis();
    	Calendar endTime = Calendar.getInstance();
    	endTime.set(2014, 9, 4, 8, 45);
    	endMillis = endTime.getTimeInMillis();
    	

    	ContentResolver cr = getContentResolver();
    	ContentValues values = new ContentValues();
    	values.put(Events.DTSTART, startMillis);
    	values.put(Events.DTEND, endMillis);
    	values.put(Events.TITLE, "Phil is the greatest");
    	values.put(Events.DESCRIPTION, "Meetign with Phil");
    	values.put(Events.CALENDAR_ID, calID);
    	values.put(Events.EVENT_TIMEZONE, "America/Los_Angeles");
    	Uri uri = cr.insert(Events.CONTENT_URI, values);

    	// get the event ID that is the last element in the Uri
    	float eventID = Long.parseLong(uri.getLastPathSegment());

        new AlertDialog.Builder(this)
        .setTitle("Event Maybe Added")
        .setMessage("EventID: " + eventID)
         .show();
    }
}
