package no.norge.data.skos_ap_no.concept.builder;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.CollectionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;


public class ModelBuilder {

    private Model model = createModel();

    /**
     * Creates a new model of which the builder can add resource.
     * @return the model builder
     */
    public static ModelBuilder builder() {
        return new ModelBuilder();
    }

    public CollectionBuilder collectionBuilder(final String collectionUri) {
        return new CollectionBuilder(this, model, collectionUri);
    }

    public ConceptBuilder conceptBuilder(final String conceptUri) {
        return new ConceptBuilder(this, this.model, conceptUri);
    }

    public Model getModel() {
        return model;
    }

    public Model build() {
        return getModel();
    }

    private Model createModel() {
        Model model = ModelFactory.createDefaultModel();

        model.setNsPrefix("adms", "http://www.w3.org/ns/adms#");
        model.setNsPrefix("dcat", "http://www.w3.org/ns/dcat#");
        model.setNsPrefix("dct", "http://purl.org/dc/terms/");
        model.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
        model.setNsPrefix("owl", "http://www.w3.org/2002/07/owl#");
        model.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        model.setNsPrefix("schema", "http://schema.org/");
        model.setNsPrefix("skos", "http://www.w3.org/2004/02/skos/core#");
        model.setNsPrefix("spdx", "http://spdx.org/rdf/terms#");
        model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
        model.setNsPrefix("vcard", "http://www.w3.org/2006/vcard/ns#");
        model.setNsPrefix("dqv", "http://www.w3.org/ns/dqv#");
        model.setNsPrefix("iso", "http://iso.org/25012/2008/dataquality/");
        model.setNsPrefix("oa", "http://www.w3.org/ns/prov#");
        model.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");

        model.setNsPrefix("skosxl", "http://www.w3.org/2008/05/skos-xl#");

        model.setNsPrefix("skosno", SKOSNO.NS);
        model.setNsPrefix("xkos", XKOS.NS);

        return model;
    }

    public static String escapeURI(final String uri) {
        if (uri==null) {
            return null;
        }

        final String legalCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-._~:/?#[]@!$&'()*+,;="; // and 0xA0->
        final String hex = "0123456789ABCDEF";

        StringBuilder sb = new StringBuilder();
        char c;
        for (int i=0; i<uri.length(); i++) {
            c = uri.charAt(i);
            if (legalCharacters.indexOf(c)!=-1 || c>=0xA0) {
                sb.append(c);
            } else {
                sb.append('%');
                sb.append(hex.charAt((c&0x00F0)>>4));
                sb.append(hex.charAt((c&0x000F)));
            }
        }
        return sb.toString();
    }
}
