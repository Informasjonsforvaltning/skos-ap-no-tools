package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.SourceDescription;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.SourceDescription.URIText.URITextBuilder;
import no.norge.data.skos_ap_no.concept.builder.generic.SourceType;
import no.norge.data.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;


public class SourcedescriptionBuilder {

    private AlternativeWordingBuilder parent;

    private SourceType.Source source;

    public SourcedescriptionBuilder(final AlternativeWordingBuilder parent) {
        this.parent = parent;
    }

    public URITextBuilder sourceBuilder() {
        return new URITextBuilder(this);
    }

    public SourcedescriptionBuilder sourcetype(final SourceType.Source source) {
        this.source = source;
        return this;
    }

    public Model getModel() {
        return parent.getModel();
    }

    public Resource getResource() {
        return parent.getResource();
    }

    public AlternativeWordingBuilder build() {
        if (source != null) {
            getResource().addProperty(SKOSNO.forholdTilKilde, parent.getModel().createResource(source.toString()));
        }

        return parent;
    }

}
