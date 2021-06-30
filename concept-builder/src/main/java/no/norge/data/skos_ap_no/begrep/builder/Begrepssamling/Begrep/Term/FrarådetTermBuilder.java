package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.HiddenLabelBuilder;

import java.time.LocalDate;


public class FrarådetTermBuilder {

    private BegrepBuilder parent;
    private HiddenLabelBuilder hiddenLabelBuilder;


    public FrarådetTermBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        hiddenLabelBuilder = conceptBuilder.hiddenLabelBuilder();
    }

    public FrarådetTermBuilder term(final String tekst, final String språk) {
        hiddenLabelBuilder.label(tekst, språk);
        return this;
    }

    public FrarådetTermBuilder sistOppdatert(final LocalDate date) {
        hiddenLabelBuilder.modified(date);
        return this;
    }

    public BegrepBuilder build() {
        hiddenLabelBuilder.build();
        return parent;
    }

}
