package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.ContactPointBuilder;


public class KontaktpunktBuilder {

    private BegrepBuilder parent;
    private ContactPointBuilder contactPointBuilder;


    KontaktpunktBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        contactPointBuilder = conceptBuilder.contactPointBuilder();
    }

    public KontaktpunktBuilder epost(final String epost) {
        contactPointBuilder.email(epost);
        return this;
    }

    public KontaktpunktBuilder telefon(final String telefon) {
        contactPointBuilder.telephone(telefon);
        return this;
    }

    public KontaktpunktBuilder organisasjonsenhet(final String orgEnhet) {
        contactPointBuilder.organizationUnit(orgEnhet);
        return this;
    }

    public BegrepBuilder build() {
        contactPointBuilder.build();
        return parent;
    }

}
