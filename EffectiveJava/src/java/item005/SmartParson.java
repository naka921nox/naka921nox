package java.item005;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

// staticブロックで必要なインスタンスは一度酒作成
public class SmartParson {
	private final Date birthDate = new Date();

    private static final Date BOOM_START;
    private static final Date BOOM_END;
    
	static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
	}
	
	public boolean isBabyBoomer() {

	        return birthDate.compareTo(BOOM_START) >=  birthDate.compareTo(BOOM_END);
	    }
}
