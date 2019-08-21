package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.DefinitionBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.URIText.URITextBuilder;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;


public class SourcedescriptionBuilder {

    private DefinitionBuilder parent;
    private Resource resource;


    public SourcedescriptionBuilder(final DefinitionBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource();
    }

    public URITextBuilder sourceBuilder() {
        return new URITextBuilder(this);
    }

    public SourcedescriptionBuilder sourcetype(final SourceType.Source source) {
        resource.addProperty(SKOSNO.forholdTilKilde, parent.getModel().createResource(source.toString()));
        return this;
    }

    public Model getModel() {
        return parent.getModel();
    }

    public Resource getResource() {
        return resource;
    }

    public DefinitionBuilder build() {
        parent.getResource().addProperty(DCTerms.source, resource);
        return parent;
    }

}
