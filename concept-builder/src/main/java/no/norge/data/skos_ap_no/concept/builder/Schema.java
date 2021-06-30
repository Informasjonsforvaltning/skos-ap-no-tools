package no.norge.data.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;


public class Schema {

    private static String NS = "http://schema.org/";

    private static Model model = ModelFactory.createDefaultModel();

    public static Property startDate = model.createProperty(NS, "startDate");
    public static Property endDate = model.createProperty(NS, "endDate");

}
