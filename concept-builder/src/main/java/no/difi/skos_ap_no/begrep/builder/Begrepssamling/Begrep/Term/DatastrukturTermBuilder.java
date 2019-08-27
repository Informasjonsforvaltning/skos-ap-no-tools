package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.DatastructureLabelBuilder;

import java.time.LocalDate;


public class DatastrukturTermBuilder {

    private BegrepBuilder parent;
    private DatastructureLabelBuilder datastructureLabelBuilder;


    public DatastrukturTermBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        datastructureLabelBuilder = conceptBuilder.datastructureLabelBuilder();
    }

    public DatastrukturTermBuilder term(final String tekst, final String språk) {
        datastructureLabelBuilder.label(tekst, språk);
        return this;
    }

    public DatastrukturTermBuilder sistOppdatert(final LocalDate date) {
        datastructureLabelBuilder.modified(date);
        return this;
    }

    public BegrepBuilder build() {
        datastructureLabelBuilder.build();
        return parent;
    }

}
