package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.PeriodOfTimeBuilder;

import java.time.LocalDate;


public class GyldighetsperiodeBuilder {

    private BegrepBuilder parent;
    private PeriodOfTimeBuilder periodOfTimeBuilder;



    GyldighetsperiodeBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        periodOfTimeBuilder = conceptBuilder.periodOfTimeBuilder();
    }

    public GyldighetsperiodeBuilder gyldigFraOgMed(final LocalDate gyldigFraOgMed) {
        periodOfTimeBuilder.validFromIncluding(gyldigFraOgMed);
        return this;
    }

    public GyldighetsperiodeBuilder gyldigTilOgMed(final LocalDate gyldigTilOgMed) {
        periodOfTimeBuilder.validToIncluding(gyldigTilOgMed);
        return this;
    }

    public BegrepBuilder build() {
        periodOfTimeBuilder.build();
        return parent;
    }

}
