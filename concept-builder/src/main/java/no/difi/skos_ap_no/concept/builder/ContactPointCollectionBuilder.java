package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.vocabulary.DCAT;


public class ContactPointCollectionBuilder extends ContactPointBuilder {

    private CollectionBuilder parent;


    ContactPointCollectionBuilder(final CollectionBuilder parent) {
        super(parent.getModel());
        this.parent = parent;
    }

    public ContactPointCollectionBuilder email(final String email) {
        super.email(email);
        return this;
    }

    public ContactPointCollectionBuilder telephone(final String telephone) {
        super.telephone(telephone);
        return this;
    }

    public ContactPointCollectionBuilder organizationUnit(final String orgUnit) {
        super.organizationUnit(orgUnit);
        return this;
    }

    public CollectionBuilder build() {
        parent.getResource().addProperty(DCAT.contactPoint, getResource());
        return parent;
    }

}
