package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.CollectionBuilder;
import no.difi.skos_ap_no.concept.builder.ContactPointCollectionBuilder;


public class KontaktpunktBegrepssamlingBuilder {

    private BegrepssamlingBuilder parent;
    private ContactPointCollectionBuilder contactPointCollectionBuilder;


    KontaktpunktBegrepssamlingBuilder(final BegrepssamlingBuilder begrepssamlingBuilder, final CollectionBuilder collectionBuilder) {
        this.parent = begrepssamlingBuilder;
        contactPointCollectionBuilder = collectionBuilder.contactPointBuilder();
    }

    public KontaktpunktBegrepssamlingBuilder epost(final String epost) {
        contactPointCollectionBuilder.email(epost);
        return this;
    }

    public KontaktpunktBegrepssamlingBuilder telefon(final String telefon) {
        contactPointCollectionBuilder.telephone(telefon);
        return this;
    }

    public KontaktpunktBegrepssamlingBuilder organisasjonsenhet(final String orgEnhet) {
        contactPointCollectionBuilder.organizationUnit(orgEnhet);
        return this;
    }

    public BegrepssamlingBuilder build() {
        contactPointCollectionBuilder.build();
        return parent;
    }

}
