package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.Kildebeskrivelse;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.AlternativFormuleringBuilder;
import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.Kildebeskrivelse.URITekst.URITekstBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.SourceDescription.SourcedescriptionBuilder;
import no.difi.skos_ap_no.concept.builder.generelt.ForholdTilKildeType;


public class KildebeskrivelseBuilder {

    private AlternativFormuleringBuilder parent;
    private SourcedescriptionBuilder sourcedescriptionBuilder;


    public KildebeskrivelseBuilder(final AlternativFormuleringBuilder alternativFormuleringBuilder, final AlternativeWordingBuilder alternativeWordingBuilder) {
        this.parent = alternativFormuleringBuilder;
        sourcedescriptionBuilder = alternativeWordingBuilder.sourcedescriptionBuilder();
    }

    public URITekstBuilder kildeBuilder() {
        return new URITekstBuilder(this, sourcedescriptionBuilder);
    }

    public KildebeskrivelseBuilder forholdTilKilde(final ForholdTilKildeType.ForholdTilKilde forhold) {
        sourcedescriptionBuilder.sourcetype(forhold.toSource());
        return this;
    }

    public AlternativFormuleringBuilder build() {
        sourcedescriptionBuilder.build();
        return parent;
    }

}
