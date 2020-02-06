//package menu;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import common.Info;
//
//public class Newer extends MenuItem {
//
//	public Newer() {
//
//		for(int i = 0; i<Info.cofnum; i++) {
//			SimpleDateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd");
//			String strStartDate = "2017-10-01";
//			Date startDate = currentDate.parse(strStartDate);
//			Calendar cal = Calendar.getInstance();
//			String nowDay = currentDate.format(cal.getTime());
//			Date endDate = currentDate.parse(nowDay);
//			String searchDate = Info.cofdate[i]; //cofdate배열의 i번쨰 값
//			Date shDate = currentDate.parse(searchDate);
//		
//		}
//	}
//
//}
