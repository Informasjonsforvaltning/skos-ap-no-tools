package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.DefinitionBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.SourceBuilder;


public class KildeBuilder {

    private DefinisjonBuilder parent;
    private SourceBuilder sourceBuilder;


    KildeBuilder(final DefinisjonBuilder definisjonBuilder, final DefinitionBuilder definitionBuilder) {
        this.parent = definisjonBuilder;
        sourceBuilder = definitionBuilder.sourceBuilder();
    }

    public KildeBuilder tekst(final String tekst, final String språk) {
        sourceBuilder.label(tekst, språk);
        return this;
    }

    public KildeBuilder seOgså(final String seOgsåUrl) {
        sourceBuilder.seeAlso(seOgsåUrl);
        return this;
    }

    public DefinisjonBuilder build() {
        sourceBuilder.build();
        return parent;
    }

}
