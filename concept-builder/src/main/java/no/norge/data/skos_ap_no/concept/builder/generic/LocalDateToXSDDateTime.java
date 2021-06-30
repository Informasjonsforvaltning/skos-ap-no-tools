package no.norge.data.skos_ap_no.concept.builder.generic;

import org.apache.jena.datatypes.xsd.XSDDateTime;

import java.time.LocalDate;


public class LocalDateToXSDDateTime {

    public static XSDDateTime toXSDDate(final LocalDate localDate) {
        int[] o = new int[9];
        o[0] = localDate.getYear();
        o[1] = localDate.getMonthValue();
        o[2] = localDate.getDayOfMonth();
        return new XSDDateTime(o, XSDDateTime.YEAR_MASK|XSDDateTime.MONTH_MASK|XSDDateTime.DAY_MASK);
    }

}
