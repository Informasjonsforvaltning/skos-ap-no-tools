package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.GenericRelationBuilder;

import java.time.LocalDate;


public class GeneriskRelasjonBuilder {

    private BegrepBuilder parent;
    private GenericRelationBuilder genericRelationBuilder;


    public GeneriskRelasjonBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        genericRelationBuilder = conceptBuilder.genericRelationBuilder();
    }

    public GeneriskRelasjonBuilder inndelingskriterium(final String inndelingskriteriumTekst, final String språk) {
        genericRelationBuilder.divisioncriterion(inndelingskriteriumTekst, språk);
        return this;
    }

    public GeneriskRelasjonBuilder sistOppdatert(final LocalDate dato) {
        genericRelationBuilder.modified(dato);
        return this;
    }

    public GeneriskRelasjonBuilder overordnetBegrep(final String uri) {
        genericRelationBuilder.broaderConcept(uri);
        return this;
    }

    public GeneriskRelasjonBuilder underordnetBegrep(final String uri) {
        genericRelationBuilder.narrowerConcept(uri);
        return this;
    }

    public BegrepBuilder build() {
        genericRelationBuilder.build();
        return parent;
    }

}
