package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.AltLabelBuilder;
import no.norge.data.skos_ap_no.concept.builder.generelt.MålgruppeType;

import java.time.LocalDate;


public class TillattTermBuilder {

    private BegrepBuilder parent;
    private AltLabelBuilder altLabelBuilder;


    public TillattTermBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        altLabelBuilder = conceptBuilder.altLabelBuilder();
    }

    public TillattTermBuilder term(final String tekst, final String språk) {
        altLabelBuilder.label(tekst, språk);
        return this;
    }

    public TillattTermBuilder sistOppdatert(final LocalDate date) {
        altLabelBuilder.modified(date);
        return this;
    }

    public TillattTermBuilder målgruppe(final MålgruppeType.Målgruppe målgruppe) {
        altLabelBuilder.audience(målgruppe.toAudience());
        return this;
    }

    public BegrepBuilder build() {
        altLabelBuilder.build();
        return parent;
    }

}
