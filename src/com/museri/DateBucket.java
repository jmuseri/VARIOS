package com.museri;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class DateBucket {
    // Simplified for the example, should have getters at least for these fields
	final Instant from;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DateBucket [from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append("]");
		return builder.toString();
	}


	final Instant to;

	DateBucket(Instant from, Instant to) {
	    this.from = from;
	    this.to = to;
	}
	

	public static List<DateBucket> bucketize(ZonedDateTime fromDate, 
			ZonedDateTime toDate, 
			int bucketSize, 
			ChronoUnit bucketSizeUnit) {
	    List<DateBucket> buckets = new ArrayList<>();
	    boolean reachedDate = false;
	    for (int i = 0; !reachedDate; i++) {
	        ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
	        ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
	        reachedDate = toDate.isBefore(maxDate);
	        buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
	    }

	    return buckets;
	}
	
	
	public static List<DateBucket> bucketizeJava8(ZonedDateTime fromDate, ZonedDateTime toDate, int bucketSize,
			ChronoUnit bucketSizeUnit) {
		return LongStream.iterate(0, i -> i + 1).mapToObj(i -> {
			ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
			ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
			return new DateBucket(minDate.toInstant(), maxDate.toInstant());
		}).takeWhile(b -> {
			ZonedDateTime maxDate = b.to.atZone(toDate.getZone());
			ZonedDateTime limitDate = toDate.plus(bucketSize, bucketSizeUnit);
			return maxDate.isBefore(limitDate) || maxDate.isEqual(limitDate);
		}).collect(Collectors.toList());

	}
	
	
	public static void main(String[] args) {
		
		
		LocalDate date = LocalDate.of(2018, Month.NOVEMBER, 11); //1989-11-11
		System.out.println(date.getYear()); //1989
		System.out.println(date.getMonth()); //NOVEMBER
		System.out.println(date.getDayOfMonth()); //11
		
		LocalDate dateAhora = LocalDate.now();
		System.out.println(dateAhora.getYear()); //1989
		System.out.println(dateAhora.getMonth()); //NOVEMBER
		System.out.println(dateAhora.getDayOfMonth()); //11
		
		
		LocalTime time = LocalTime.of(5, 30, 45, 35); //05:30:45:35
		System.out.println(time.getHour()); //5
		System.out.println(time.getMinute()); //30
		System.out.println(time.getSecond()); //45
		System.out.println(time.getNano()); //35


		LocalTime timeAhora = LocalTime.now();
		System.out.println(timeAhora.getHour()); //5
		System.out.println(timeAhora.getMinute()); //30
		System.out.println(timeAhora.getSecond()); //45
		System.out.println(timeAhora.getNano()); //35

		
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		LocalDateTime dateTimeAhora = LocalDateTime.of(dateAhora, timeAhora);
		LocalDateTime dateTimehoraDirecto = LocalDateTime.now();
		System.out.println(dateTime.toString());
		System.out.println(dateTimeAhora.toString());
		System.out.println(dateTimehoraDirecto.toString());
		
		DateBucket db = new DateBucket(Instant.EPOCH ,Instant.now() );
		
		ZoneId.getAvailableZoneIds().forEach(System.out::println);

		List<DateBucket> lista = db.bucketize(ZonedDateTime.of(dateTime, ZoneId.of("America/Argentina/Buenos_Aires")), ZonedDateTime.of(dateTimeAhora, ZoneId.of("America/Argentina/Buenos_Aires")), 10, ChronoUnit.DAYS);
		lista.forEach(System.out::println);
		
		List<DateBucket> lista2 = db.bucketize(ZonedDateTime.of(dateTime, ZoneId.of("America/Argentina/Buenos_Aires")), ZonedDateTime.of(dateTimeAhora, ZoneId.of("America/Argentina/Buenos_Aires")), 10, ChronoUnit.DAYS);
		lista2.forEach(System.out::println);
		
		lista.removeAll(lista2);
		if (lista.isEmpty()) System.out.println("SON LISTAS IGUALES");

		
		
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DateBucket) {
			DateBucket db = (DateBucket)obj;
			if (this.to.equals(db.to) && this.from.equals(db.from))
				return true;
		}
		return false;
	}
	
}
