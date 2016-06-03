package ch.lgt.test;

import java.util.Date;
import java.util.List;

import com.joestelmach.natty.Parser;

public class DateTest {

	public static void main(String args[]) throws Exception {

		Date date = new Parser().parse("14 Aug 2003 00:03:19 +1200").get(0).getDates().get(0);
		System.out.println(date);
	}

}
