package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.AssociativeRelationBuilder;

import java.time.LocalDate;


public class AssosiativRelasjonBuilder {

    private BegrepBuilder parent;
    private AssociativeRelationBuilder associativeRelationBuilder;


    public AssosiativRelasjonBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        associativeRelationBuilder = conceptBuilder.associativeRelationBuilder();
    }

    public AssosiativRelasjonBuilder beskrivelse(final String beskrivelseTekst, final String språk) {
        associativeRelationBuilder.description(beskrivelseTekst, språk);
        return this;
    }

    public AssosiativRelasjonBuilder sistOppdatert(final LocalDate dato) {
        associativeRelationBuilder.modified(dato);
        return this;
    }

    public BegrepBuilder build() {
        associativeRelationBuilder.build();
        return parent;
    }

}
