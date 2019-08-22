package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.Kildebeskrivelse;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.DefinisjonBuilder;
import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.Kildebeskrivelse.URITekst.URITekstBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.DefinitionBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.SourceDescription.SourcedescriptionBuilder;
import no.difi.skos_ap_no.concept.builder.generelt.ForholdTilKilde;


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

    public KildebeskrivelseBuilder forholdTilKilde(final ForholdTilKilde.Forhold forhold) {
        sourcedescriptionBuilder.sourcetype(forhold.toSource());
        return this;
    }

    public DefinisjonBuilder build() {
        sourcedescriptionBuilder.build();
        return parent;
    }

}
