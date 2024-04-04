package jfs.backend.java8.collectionenhancement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateExample {
	

	public static void main(String[] args) {
		
		LocalDateTime localDate = LocalDateTime.now();
		
		System.out.println(localDate);
		
		System.out.println(LocalTime.now());
		
		System.out.println(LocalDateTime.now());
		
		
		System.out.println(localDate.plusDays(10)); // plus and minus days
		
		System.out.println(localDate.plusDays(-10));
		
		
		// create manual date objecr
		
		// 2023-Des-21
		
		LocalDateTime d1 = LocalDateTime.of(2023, Month.NOVEMBER, 11,04,02);
		
		System.out.println(d1);
		
		// Difference between to dates
		
		Duration between = Duration.between(d1,localDate);
		
		System.out.println(between.toDays()+ ": Day's" );
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		
		System.out.println("Date and Time Format :"+ dtf);
		
		
		String datetime = localDate.format(dtf);
		System.err.println(datetime);
		
		String dateTime="2023-12-21 04:58";
		LocalDateTime formatDateTime=LocalDateTime.parse(datetime,dtf);
		
		System.out.println(formatDateTime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  // set default format of date 
		
		String date="2023-12-22";
		
		LocalDate parse = LocalDate.parse(date, formatter);
		System.out.println(parse);
		
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("India/Colcutta :" +zonedDateTime);         
		
		// now convert zonedatetime into America/Nuw_York
		
		ZonedDateTime withZoneSameInstant = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println("America/New_York :" +withZoneSameInstant);
		
		
		
	}

	private static ZoneId ZoneId(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
