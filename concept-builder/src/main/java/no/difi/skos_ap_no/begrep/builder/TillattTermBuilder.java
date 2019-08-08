package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.*;

import java.time.LocalDate;


public class TillattTermBuilder {

    private BegrepBuilder parent;
    private AltLabelBuilder altLabelBuilder;


    TillattTermBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        altLabelBuilder = conceptBuilder.altLabelBuilder();
    }

    public TillattTermBuilder term(final String tekst, final String språk) {
        altLabelBuilder.label(tekst, språk);
        return this;
    }

    public TillattTermBuilder modified(final LocalDate date) {
        altLabelBuilder.modified(date);
        return this;
    }

    public BegrepBuilder build() {
        altLabelBuilder.build();
        return parent;
    }

}
