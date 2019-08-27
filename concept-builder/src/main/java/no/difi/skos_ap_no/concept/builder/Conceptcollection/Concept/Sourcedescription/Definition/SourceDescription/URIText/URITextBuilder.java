package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.SourceDescription.URIText;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.SourceDescription.SourcedescriptionBuilder;
import org.apache.jena.vocabulary.DCTerms;


public class URITextBuilder extends no.difi.skos_ap_no.concept.builder.generic.URITextBuilder<URITextBuilder> {

    private SourcedescriptionBuilder parent;


    public URITextBuilder(final SourcedescriptionBuilder sourcedescriptionBuilder) {
        super(sourcedescriptionBuilder.getModel());
        this.parent = sourcedescriptionBuilder;
    }

    public SourcedescriptionBuilder build() {
        parent.getResource().addProperty(DCTerms.source, getResource());
        return parent;
    }

}
