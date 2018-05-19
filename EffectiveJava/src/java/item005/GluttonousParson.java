package java.item005;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

// メソッド呼び出し都度、不要な一時インスタンスを生成する人
public class GluttonousParson {
	private final Date birthDate = new Date();

	public boolean isBabyBoomer() {
	        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
	        Date boomStart = gmtCal.getTime();
	        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
	        Date boomEnd = gmtCal.getTime();
	        return birthDate.compareTo(boomStart) >=  birthDate.compareTo(boomEnd);
	    }
}
