package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.HiddenLabelBuilder;

import java.time.LocalDate;


public class FrarådetTermBuilder {

    private BegrepBuilder parent;
    private HiddenLabelBuilder hiddenLabelBuilder;


    FrarådetTermBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        hiddenLabelBuilder = conceptBuilder.hiddenLabelBuilder();
    }

    public FrarådetTermBuilder term(final String tekst, final String språk) {
        hiddenLabelBuilder.label(tekst, språk);
        return this;
    }

    public FrarådetTermBuilder modified(final LocalDate date) {
        hiddenLabelBuilder.modified(date);
        return this;
    }

    public BegrepBuilder build() {
        hiddenLabelBuilder.build();
        return parent;
    }

}
