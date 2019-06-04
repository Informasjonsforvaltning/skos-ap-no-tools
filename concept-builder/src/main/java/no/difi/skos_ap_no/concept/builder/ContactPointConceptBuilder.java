package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.vocabulary.DCAT;


public class ContactPointConceptBuilder extends ContactPointBuilder {

    private ConceptBuilder parent;


    ContactPointConceptBuilder(final ConceptBuilder parent) {
        super(parent.getModel());
        this.parent = parent;
    }

    public ContactPointConceptBuilder email(final String email) {
        super.email(email);
        return this;
    }

    public ContactPointConceptBuilder telephone(final String telephone) {
        super.telephone(telephone);
        return this;
    }

    public ContactPointConceptBuilder organizationUnit(final String orgUnit) {
        super.organizationUnit(orgUnit);
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(DCAT.contactPoint, getResource());
        return parent;
    }

}
