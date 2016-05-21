package com.fast.prezi.core.utils;

import com.fast.prezi.data.model.Presentation;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by akshay.kesarwan on 22/05/16.
 */
@Slf4j
public class PresentationUtils {

    /**
     * Sorts the given presentations in ascending order of createdAt
     * @param presentations
     */
    public static void sortPresentationsByCreatedAt(List<Presentation> presentations) {
        presentations.sort(new Comparator<Presentation>() {
        @Override
        public int compare(Presentation o1, Presentation o2) {
            DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date o1Date = null;
            Date o2Date = null;
            try {
                o1Date = dateFormat.parse(o1.getCreatedAt());
                o2Date = dateFormat.parse(o2.getCreatedAt());
            } catch (ParseException e) {
                log.info("Error in parsing date");
            }
            if(o1Date.before(o2Date))
                return -1;
            else
                return 1;
        }
    });
    }
}
