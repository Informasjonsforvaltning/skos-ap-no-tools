package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning;

import no.difi.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;


public class URITextBuilder {

    private DefinitionBuilder parent;
    private Resource resource;


    URITextBuilder(final DefinitionBuilder definitionBuilder) {
        this.parent = definitionBuilder;
        resource = definitionBuilder.getModel().createResource();
    }

    public URITextBuilder uri(final String uri) {
        if (resource.hasProperty(SKOSNO.omfang)) {
            resource.removeAll(SKOSNO.omfang);
        }
        if (uri != null) {
            resource.addProperty(SKOSNO.omfang, uri);
        }
        return this;
    }

    public URITextBuilder text(final String text) {
        if (resource.hasProperty(SKOSNO.omfang)) {
            resource.removeAll(SKOSNO.omfang);
        }
        if (text != null) {
            resource.addProperty(SKOSNO.omfang, text);
        }

        return this;
    }

    public DefinitionBuilder build() {
        parent.getResource().addProperty(DCTerms.source, resource);
        return parent;
    }

}
