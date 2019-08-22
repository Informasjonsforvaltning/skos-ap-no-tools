package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.URIText;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import org.apache.jena.vocabulary.DCTerms;


public class URITextBuilder extends no.difi.skos_ap_no.concept.builder.generic.URITextBuilder<URITextBuilder> {

    private AlternativeWordingBuilder parent;


    public URITextBuilder(final AlternativeWordingBuilder alternativeWordingBuilder) {
        super(alternativeWordingBuilder.getModel());
        this.parent = alternativeWordingBuilder;
    }

    public AlternativeWordingBuilder build() {
        parent.getResource().addProperty(DCTerms.source, getResource());
        return parent;
    }

}
