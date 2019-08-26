package com.museri;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	 public static void main(String[] args) throws Exception {
	        String x =  "aaaa{ID},{JONY},{Pedro}aaaa";
	        Pattern logEntry = Pattern.compile("\\{(.*?)\\}");
	        Matcher matchPattern = logEntry.matcher(x);

	        while(matchPattern.find()) {
	            System.out.println(matchPattern.group(1));
	        }

	    }

}
