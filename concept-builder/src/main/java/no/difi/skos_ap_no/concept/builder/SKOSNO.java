package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;


public class SKOSNO {

    private static String NS = "http://difi.no/skosno#";

    private static Model model = ModelFactory.createDefaultModel();

    public static Property betydningsbeskrivelse = model.createProperty(NS, "betydningsbeskrivelse");

    public static Resource Definisjon = model.createResource(NS + "Definisjon");
    public static Resource AlternativFormulering = model.createResource(NS + "AlternativFormulering");

}
