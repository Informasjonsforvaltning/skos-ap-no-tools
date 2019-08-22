package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.SourceDescription;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.SourceDescription.URIText.URITextBuilder;
import no.difi.skos_ap_no.concept.builder.generic.SourceType;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;


public class SourcedescriptionBuilder {

    private AlternativeWordingBuilder parent;
    private Resource resource;


    public SourcedescriptionBuilder(final AlternativeWordingBuilder parent) {
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

    public AlternativeWordingBuilder build() {
        parent.getResource().addProperty(SKOSNO.betydningsbeskrivelse, resource);
        return parent;
    }

}
