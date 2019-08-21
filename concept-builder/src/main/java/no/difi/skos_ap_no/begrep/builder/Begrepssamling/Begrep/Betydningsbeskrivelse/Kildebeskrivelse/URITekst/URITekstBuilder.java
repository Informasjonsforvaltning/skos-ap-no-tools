package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Kildebeskrivelse.URITekst;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Kildebeskrivelse.KildebeskrivelseBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.SourcedescriptionBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.URIText.URITextBuilder;


public class URITekstBuilder {

    private KildebeskrivelseBuilder parent;
    private URITextBuilder uriTextBuilder;


    public URITekstBuilder(final KildebeskrivelseBuilder kildebeskrivelseBuilder, final SourcedescriptionBuilder sourcedescriptionBuilder) {
        this.parent = kildebeskrivelseBuilder;
        uriTextBuilder = sourcedescriptionBuilder.sourceBuilder();
    }

    public URITekstBuilder tekst(final String tekst, final String språk) {
        uriTextBuilder.label(tekst, språk);
        return this;
    }

    public URITekstBuilder seOgså(final String seOgsåUrl) {
        uriTextBuilder.seeAlso(seOgsåUrl);
        return this;
    }

    public KildebeskrivelseBuilder build() {
        uriTextBuilder.build();
        return parent;
    }

}