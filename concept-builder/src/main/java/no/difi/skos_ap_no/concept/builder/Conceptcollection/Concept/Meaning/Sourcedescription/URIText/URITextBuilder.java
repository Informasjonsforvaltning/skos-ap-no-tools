package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.URIText;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.SourcedescriptionBuilder;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDFS;


public class URITextBuilder {

    private SourcedescriptionBuilder parent;
    private Resource resource;


    public URITextBuilder(final SourcedescriptionBuilder sourcedescriptionBuilder) {
        this.parent = sourcedescriptionBuilder;
        resource = parent.getModel().createResource();
    }

    public URITextBuilder label(final String label, final String language) {
        if (label != null) {
            resource.addProperty(RDFS.label, label, language);
        }
        return this;
    }

    public URITextBuilder seeAlso(final String seeAlsoUrl) {
        if (seeAlsoUrl != null) {
            resource.addProperty(RDFS.seeAlso, parent.getModel().createResource(seeAlsoUrl));
        }
        return this;
    }

    public SourcedescriptionBuilder build() {
        parent.getResource().addProperty(DCTerms.source, resource);
        return parent;
    }

}
