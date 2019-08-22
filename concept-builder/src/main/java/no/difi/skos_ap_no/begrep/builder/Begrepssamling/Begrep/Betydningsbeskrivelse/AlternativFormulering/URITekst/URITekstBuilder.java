package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.URITekst;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.AlternativFormuleringBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.URIText.URITextBuilder;


public class URITekstBuilder extends no.difi.skos_ap_no.concept.builder.generelt.URITekstBuilder<URITekstBuilder> {

    private AlternativFormuleringBuilder parent;
    private URITextBuilder uriTextBuilder;


    public URITekstBuilder(final AlternativFormuleringBuilder alternativFormuleringBuilder, final AlternativeWordingBuilder alternativeWordingBuilder) {
        this.parent = alternativFormuleringBuilder;
        uriTextBuilder = alternativeWordingBuilder.scope();
    }

    public AlternativFormuleringBuilder build() {
        uriTextBuilder.build();
        return parent;
    }

    public no.difi.skos_ap_no.concept.builder.generic.URITextBuilder getURITextBuilder() {
        return uriTextBuilder;
    }

}