package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.URITekst;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.DefinisjonBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.DefinitionBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.URIText.URITextBuilder;


public class URITekstBuilder extends no.difi.skos_ap_no.concept.builder.generelt.URITekstBuilder<URITekstBuilder> {

    private DefinisjonBuilder parent;
    private URITextBuilder uriTextBuilder;


    public URITekstBuilder(final DefinisjonBuilder definisjonBuilder, final DefinitionBuilder definitionBuilder) {
        this.parent = definisjonBuilder;
        uriTextBuilder = definitionBuilder.scope();
    }

    public DefinisjonBuilder build() {
        uriTextBuilder.build();
        return parent;
    }

    public no.difi.skos_ap_no.concept.builder.generic.URITextBuilder getURITextBuilder() {
        return uriTextBuilder;
    }

}