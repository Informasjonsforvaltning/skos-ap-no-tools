package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.Kildebeskrivelse;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.DefinisjonBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.Kildebeskrivelse.URITekst.URITekstBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.DefinitionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.SourceDescription.SourcedescriptionBuilder;
import no.norge.data.skos_ap_no.concept.builder.generelt.ForholdTilKildeType;


public class KildebeskrivelseBuilder {

    private DefinisjonBuilder parent;
    private SourcedescriptionBuilder sourcedescriptionBuilder;


    public KildebeskrivelseBuilder(final DefinisjonBuilder definisjonBuilder, final DefinitionBuilder definitionBuilder) {
        this.parent = definisjonBuilder;
        sourcedescriptionBuilder = definitionBuilder.sourcedescriptionBuilder();
    }

    public URITekstBuilder kildeBuilder() {
        return new URITekstBuilder(this, sourcedescriptionBuilder);
    }

    public KildebeskrivelseBuilder forholdTilKilde(final ForholdTilKildeType.ForholdTilKilde forhold) {
        sourcedescriptionBuilder.sourcetype(forhold.toSource());
        return this;
    }

    public DefinisjonBuilder build() {
        sourcedescriptionBuilder.build();
        return parent;
    }

}
