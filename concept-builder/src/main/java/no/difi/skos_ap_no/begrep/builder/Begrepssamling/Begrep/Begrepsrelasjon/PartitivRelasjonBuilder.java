package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.PartitiveRelationBuilder;

import java.time.LocalDate;


public class PartitivRelasjonBuilder {

    private BegrepBuilder parent;
    private PartitiveRelationBuilder partitiveRelationBuilder;


    public PartitivRelasjonBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        partitiveRelationBuilder = conceptBuilder.partitiveRelationBuilder();
    }

    public PartitivRelasjonBuilder inndelingskriterium(final String inndelingskriteriumTekst, final String språk) {
        partitiveRelationBuilder.divisioncriterion(inndelingskriteriumTekst, språk);
        return this;
    }

    public PartitivRelasjonBuilder sistOppdatert(final LocalDate dato) {
        partitiveRelationBuilder.modified(dato);
        return this;
    }

    public PartitivRelasjonBuilder overordnetBegrep(final String uri) {
        partitiveRelationBuilder.broaderConcept(uri);
        return this;
    }

    public PartitivRelasjonBuilder underordnetBegrep(final String uri) {
        partitiveRelationBuilder.narrowerConcept(uri);
        return this;
    }

    public BegrepBuilder build() {
        partitiveRelationBuilder.build();
        return parent;
    }

}
