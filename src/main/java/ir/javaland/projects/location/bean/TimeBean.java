package ir.javaland.projects.location.bean;



import com.ibm.icu.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

public class TimeBean {
    public static final String DEFAULT_DATE_PATTERN = "yyyy/MM/dd";

    private String locale = "en_US";



    public String getTodayDate(){
        Locale locale = new Locale(this.locale);
        return new SimpleDateFormat(DEFAULT_DATE_PATTERN,locale)
                .format(new Date());
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
