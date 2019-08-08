package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.ContactPointConceptBuilder;


public class KontaktpunktBegrepBuilder {

    private BegrepBuilder parent;
    private ContactPointConceptBuilder contactPointConceptBuilder;


    KontaktpunktBegrepBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        contactPointConceptBuilder = conceptBuilder.contactPointBuilder();
    }

    public KontaktpunktBegrepBuilder epost(final String epost) {
        contactPointConceptBuilder.email(epost);
        return this;
    }

    public KontaktpunktBegrepBuilder telefon(final String telefon) {
        contactPointConceptBuilder.telephone(telefon);
        return this;
    }

    public KontaktpunktBegrepBuilder organisasjonsenhet(final String orgEnhet) {
        contactPointConceptBuilder.organizationUnit(orgEnhet);
        return this;
    }

    public BegrepBuilder build() {
        contactPointConceptBuilder.build();
        return parent;
    }

}
