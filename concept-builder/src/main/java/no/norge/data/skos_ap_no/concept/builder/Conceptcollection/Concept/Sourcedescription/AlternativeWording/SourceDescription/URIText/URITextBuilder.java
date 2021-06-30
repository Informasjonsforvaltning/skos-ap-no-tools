package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.SourceDescription.URIText;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.SourceDescription.SourcedescriptionBuilder;
import org.apache.jena.vocabulary.DCTerms;


public class URITextBuilder extends no.norge.data.skos_ap_no.concept.builder.generic.URITextBuilder<URITextBuilder> {

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
