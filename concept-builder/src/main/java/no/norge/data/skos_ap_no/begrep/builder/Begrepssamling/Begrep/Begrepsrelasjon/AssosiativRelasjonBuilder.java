package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.AssociativeRelationBuilder;

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

    public AssosiativRelasjonBuilder assosiertBegrep(final String uri) {
        associativeRelationBuilder.associatedConcept(uri);
        return this;
    }

    public BegrepBuilder build() {
        associativeRelationBuilder.build();
        return parent;
    }

}
