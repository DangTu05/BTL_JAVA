package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {
	public static Date convertDateFromDB(String dateStrFromDB) {
		Date dateFromDB = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false); // chính xác về ngày tháng
		try {
			dateFromDB = sdf.parse(dateStrFromDB);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateFromDB;
	}
}
