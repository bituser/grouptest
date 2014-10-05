package com.example.grouptest;

import java.sql.Time;
import java.util.Calendar;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CalendarContract.Events;
import android.provider.Telephony.Sms.Conversations;
import android.util.Log;
import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author batman
 * 
 */
public class TimeTableController {

	private static final String DEBUG_TAG = "TimeTableController";
	long eventID = 0;

//	public void addCourse(Course toAdd, ContentResolver cr, Context context) {
//		Calendar durationStartCal = toAdd.getStartDate();
//		int durationStartYear = durationStartCal.get(Calendar.YEAR);
//		int durationStartMonth = durationStartCal.get(Calendar.MONTH);
//		int durationStartsdDay = durationStartCal.get(Calendar.DAY_OF_WEEK);
//
//		Calendar durationEndCal = toAdd.getEndDate();
//		int durationEndYear = durationEndCal.get(Calendar.YEAR);
//		int durationEndMonth = durationEndCal.get(Calendar.MONTH);
//		int durationEndDay = durationEndCal.get(Calendar.DATE);
//
//		// TODO: Make this get the persons CalID
//		long calID = 2;
//
//		for (Event event : toAdd.getEvents()) {
//			Time eventTime = event.getTime();
//
//			String[] time = eventTime.toString().split(":");
//			int eventStartHour = Integer.parseInt(time[0]);
//			int eventStartMin = Integer.parseInt(time[1]);
//
//			int eventEndHour = eventStartHour + event.getDuration();
//
//			String eventDayOfWeek = getDayFromInt(event.getDay());
//
//			Calendar beginTime = Calendar.getInstance();
//			beginTime.set(durationStartYear, durationStartMonth, durationStartDay, eventStartHour, eventStartMin);
//			long startMillis = beginTime.getTimeInMillis();
//
//			Calendar endTime = Calendar.getInstance();
//			endTime.set(durationStartYear, durationStartMonth, durationStartDay, eventEndHour, eventStartMin);
//			long endMillis = endTime.getTimeInMillis();
//
//			ContentValues values = new ContentValues();
//			values.put(Events.DTSTART, startMillis);
//			values.put(Events.DTEND, endMillis);
//			values.put(Events.TITLE, toAdd.getCourseName() + " " + event.getType());
//			values.put(Events.DESCRIPTION, toAdd.getCourseName() + " " + event.getType() + " " + event.getRoom());
//			values.put(Events.CALENDAR_ID, calID);
//			values.put(Events.EVENT_LOCATION, event.getRoom());
//			values.put(Events.EVENT_TIMEZONE, "Pacific/Auckland");
//
//			values.put(Events.RRULE, "FREQ=WEEKLY;BYDAY=" + eventDayOfWeek + ";UNTIL=" + durationEndYear
//					+ durationEndMonth + durationEndDay);
//			Uri uri = cr.insert(Events.CONTENT_URI, values);
//
//			// get the event ID that is the last element in the Uri
//			eventID = Long.parseLong(uri.getLastPathSegment());
//
//			// TODO something with eventID
//
//			new AlertDialog.Builder(context).setTitle("Event Probably Added").setMessage("EventID: " + eventID).show();
//		}
//	}

	private String getDayFromInt(int day) {
		switch (day) {
		case 1:
			return "SU";
		case 2:
			return "MO";
		case 3:
			return "TU";
		case 4:
			return "WE";
		case 5:
			return "TH";
		case 6:
			return "FR";
		case 7:
			return "SA";
		}
		return null;
	}

}
