package no.norge.data.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

public class XKOS {

    public static String NS = "http://rdf-vocabulary.ddialliance.org/xkos#";

    private static Model model = ModelFactory.createDefaultModel();

    public static Property generalizes = model.createProperty(NS, "generalizes");
    public static Property specializes = model.createProperty(NS, "specializes");

}
