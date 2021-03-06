package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.Kildebeskrivelse.URITekst;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.Kildebeskrivelse.KildebeskrivelseBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.SourceDescription.SourcedescriptionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.SourceDescription.URIText.URITextBuilder;


public class URITekstBuilder extends no.norge.data.skos_ap_no.concept.builder.generelt.URITekstBuilder<URITekstBuilder> {

    private KildebeskrivelseBuilder parent;
    private URITextBuilder uriTextBuilder;


    public URITekstBuilder(final KildebeskrivelseBuilder kildebeskrivelseBuilder, final SourcedescriptionBuilder sourcedescriptionBuilder) {
        this.parent = kildebeskrivelseBuilder;
        uriTextBuilder = sourcedescriptionBuilder.sourceBuilder();
    }

    public KildebeskrivelseBuilder build() {
        uriTextBuilder.build();
        return parent;
    }

    public no.norge.data.skos_ap_no.concept.builder.generic.URITextBuilder getURITextBuilder() {
        return uriTextBuilder;
    }

}