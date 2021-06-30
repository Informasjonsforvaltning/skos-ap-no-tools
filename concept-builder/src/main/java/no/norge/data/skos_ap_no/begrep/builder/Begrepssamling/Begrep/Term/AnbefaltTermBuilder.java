package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.PrefLabelBuilder;

import java.time.LocalDate;


public class AnbefaltTermBuilder {

    private BegrepBuilder parent;
    private PrefLabelBuilder prefLabelBuilder;


    public AnbefaltTermBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        prefLabelBuilder = conceptBuilder.prefLabelBuilder();
    }

    public AnbefaltTermBuilder term(final String tekst, final String språk) {
        prefLabelBuilder.label(tekst, språk);
        return this;
    }

    public AnbefaltTermBuilder sistOppdatert(final LocalDate date) {
        prefLabelBuilder.modified(date);
        return this;
    }

    public BegrepBuilder build() {
        prefLabelBuilder.build();
        return parent;
    }

}
