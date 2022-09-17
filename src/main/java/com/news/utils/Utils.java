package com.news.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static String dateToString(String format, Date date) {
		date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat(format);
		String strDate = dateFormat.format(date);
		return strDate;
	}
	
	public static String encodeImage(String url) {
		try {
	        URL imageUrl = new URL(url);
	        URLConnection ucon = imageUrl.openConnection();
	        InputStream is = ucon.getInputStream();
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int read = 0;
	        while ((read = is.read(buffer, 0, buffer.length)) != -1) {
	            baos.write(buffer, 0, read);
	        }
	        baos.flush();
	        String data = Base64.getEncoder().encodeToString(baos.toByteArray());
	        return data;
	    } catch (Exception e) {
	        System.out.println("error");
	        return null;
	    }
	}

	public static void main(String[] args) {
		try {
	        URL imageUrl = new URL("http://localhost:8080/news/assets/images/blog/4by3/07.jpg");
	        URLConnection ucon = imageUrl.openConnection();
	        InputStream is = ucon.getInputStream();
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int read = 0;
	        while ((read = is.read(buffer, 0, buffer.length)) != -1) {
	            baos.write(buffer, 0, read);
	        }
	        baos.flush();
	        String data = Base64.getEncoder().encodeToString(baos.toByteArray());
	        System.out.println("Data: "+data);
	    } catch (Exception e) {
	        System.out.println("error");
	    }
	}
	
}
