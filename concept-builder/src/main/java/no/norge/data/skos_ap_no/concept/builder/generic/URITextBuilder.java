package no.norge.data.skos_ap_no.concept.builder.generic;

import no.norge.data.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;


public abstract class URITextBuilder<T> {

    private Model model;
    private Resource resource;


    public URITextBuilder(final Model model) {
        this.model = model;
        this.resource = model.createResource();
    }

    public T label(final String label, final String language) {
        if (label != null) {
            resource.addProperty(RDFS.label, label, language);
        }
        return (T)this;
    }

    public T seeAlso(final String seeAlsoUrl) {
        if (seeAlsoUrl != null) {
            resource.addProperty(RDFS.seeAlso, model.createResource(ModelBuilder.escapeURI(seeAlsoUrl)));
        }
        return (T)this;
    }

    public Resource getResource() {
        return resource;
    }

}
