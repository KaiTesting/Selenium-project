package java_basic;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

public class TimeDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date=new Date();
		
		SimpleDateFormat Dformat=new SimpleDateFormat("MM-dd-yyyy");
		
		String FormattedDate=Dformat.format(date);
		
		System.out.println(FormattedDate);
		System.out.println(new Date(2000, 2, 12).after(new Date (1999, 2, 18)));
		System.out.println(FormattedDate.compareTo("03-10-2017"));
		

	}
	

}
