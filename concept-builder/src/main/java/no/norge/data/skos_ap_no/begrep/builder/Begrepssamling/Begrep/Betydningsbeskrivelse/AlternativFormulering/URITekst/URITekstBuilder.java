package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.URITekst;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.AlternativFormuleringBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.URIText.URITextBuilder;


public class URITekstBuilder extends no.norge.data.skos_ap_no.concept.builder.generelt.URITekstBuilder<URITekstBuilder> {

    private AlternativFormuleringBuilder parent;
    private URITextBuilder uriTextBuilder;


    public URITekstBuilder(final AlternativFormuleringBuilder alternativFormuleringBuilder, final AlternativeWordingBuilder alternativeWordingBuilder) {
        this.parent = alternativFormuleringBuilder;
        uriTextBuilder = alternativeWordingBuilder.scopeBuilder();
    }

    public AlternativFormuleringBuilder build() {
        uriTextBuilder.build();
        return parent;
    }

    public no.norge.data.skos_ap_no.concept.builder.generic.URITextBuilder getURITextBuilder() {
        return uriTextBuilder;
    }

}