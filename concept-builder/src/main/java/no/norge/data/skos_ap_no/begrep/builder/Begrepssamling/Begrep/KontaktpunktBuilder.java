package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ContactPointBuilder;


public class KontaktpunktBuilder {

    private BegrepBuilder parent;
    private ContactPointBuilder contactPointConceptBuilder;


    public KontaktpunktBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        contactPointConceptBuilder = conceptBuilder.contactPointBuilder();
    }

    public KontaktpunktBuilder epost(final String epost) {
        contactPointConceptBuilder.email(epost);
        return this;
    }

    public KontaktpunktBuilder telefon(final String telefon) {
        contactPointConceptBuilder.telephone(telefon);
        return this;
    }

    public KontaktpunktBuilder organisasjonsenhet(final String orgEnhet) {
        contactPointConceptBuilder.organizationUnit(orgEnhet);
        return this;
    }

    public BegrepBuilder build() {
        contactPointConceptBuilder.build();
        return parent;
    }

}
