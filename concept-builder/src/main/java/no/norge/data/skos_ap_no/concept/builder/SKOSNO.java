package no.norge.data.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;


public class SKOSNO {

    public static String NS = "https://data.norge.no/vocabulary/skosno#";

    private static Model model = ModelFactory.createDefaultModel();

    public static Property definisjon = model.createProperty(NS, "definisjon");
    public static Property alternativFormulering = model.createProperty(NS, "alternativFormulering");
    public static Property bruksområde = model.createProperty(NS, "bruksområde");
    public static Property forholdTilKilde = model.createProperty(NS, "forholdTilKilde");
    public static Property omfang = model.createProperty(NS, "omfang");
    public static Property datastrukturterm = model.createProperty(NS, "datastrukturterm");
    public static Property assosiativRelasjon = model.createProperty(NS, "assosiativRelasjon");
    public static Property partitivRelasjon = model.createProperty(NS, "partitivRelasjon");
    public static Property generiskRelasjon = model.createProperty(NS, "generiskRelasjon");
    public static Property inndelingskriterium = model.createProperty(NS, "inndelingskriterium");

    public static Property allmennheten = model.createProperty(NS, "allmennheten");
    public static Property fagspesialist = model.createProperty(NS, "fagspesialist");

    public static Resource Definisjon = model.createResource(NS + "Definisjon");
    public static Resource AlternativFormulering = model.createResource(NS + "AlternativFormulering");
    public static Resource AssosiativRelasjon = model.createResource(NS + "AssosiativRelasjon");
    public static Resource GeneriskRelasjon = model.createResource(NS + "GeneriskRelasjon");
    public static Resource PartitivRelasjon = model.createResource(NS + "PartitivRelasjon");

}
