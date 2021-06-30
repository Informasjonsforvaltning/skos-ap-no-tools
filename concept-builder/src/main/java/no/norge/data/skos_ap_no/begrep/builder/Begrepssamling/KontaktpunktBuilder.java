package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.CollectionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.ContactPointBuilder;


public class KontaktpunktBuilder {

    private BegrepssamlingBuilder parent;
    private ContactPointBuilder contactPointCollectionBuilder;


    public KontaktpunktBuilder(final BegrepssamlingBuilder begrepssamlingBuilder, final CollectionBuilder collectionBuilder) {
        this.parent = begrepssamlingBuilder;
        contactPointCollectionBuilder = collectionBuilder.contactPointBuilder();
    }

    public KontaktpunktBuilder epost(final String epost) {
        contactPointCollectionBuilder.email(epost);
        return this;
    }

    public KontaktpunktBuilder telefon(final String telefon) {
        contactPointCollectionBuilder.telephone(telefon);
        return this;
    }

    public KontaktpunktBuilder organisasjonsenhet(final String orgEnhet) {
        contactPointCollectionBuilder.organizationUnit(orgEnhet);
        return this;
    }

    public BegrepssamlingBuilder build() {
        contactPointCollectionBuilder.build();
        return parent;
    }

}
