package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDFS;


public class SourceBuilder {

    private DefinitionBuilder parent;
    private Resource resource;


    SourceBuilder(final DefinitionBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource();
    }

    public SourceBuilder label(final String label, final String language) {
        resource.addProperty(RDFS.label, label, language);
        return this;
    }

    public SourceBuilder seeAlso(final String seeAlsoUrl) {
        resource.addProperty(RDFS.seeAlso, parent.getModel().createResource(seeAlsoUrl));
        return this;
    }

    public DefinitionBuilder build() {
        parent.getResource().addProperty(DCTerms.source, resource);
        return parent;
    }

}
