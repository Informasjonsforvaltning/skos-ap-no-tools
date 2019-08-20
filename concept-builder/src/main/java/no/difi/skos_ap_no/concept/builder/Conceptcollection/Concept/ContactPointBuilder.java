package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCAT;
import org.apache.jena.vocabulary.VCARD4;


public class ContactPointBuilder {

    private ConceptBuilder parent;
    private Resource resource;


    ContactPointBuilder(final ConceptBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource(VCARD4.Organization);
    }

    public ContactPointBuilder email(final String email) {
        if (email != null) {
            resource.addProperty(VCARD4.hasEmail, no.difi.skos_ap_no.concept.builder.Conceptcollection.ContactPointBuilder.emailResource(parent.getModel(), email));
        }
        return this;
    }

    public ContactPointBuilder telephone(final String telephone) {
        if (telephone != null) {
            resource.addProperty(VCARD4.hasTelephone, no.difi.skos_ap_no.concept.builder.Conceptcollection.ContactPointBuilder.telephoneResource(parent.getModel(), telephone));
        }
        return this;
    }

    public ContactPointBuilder organizationUnit(final String orgUnit) {
        if (orgUnit != null) {
            resource.addProperty(VCARD4.hasOrganizationUnit, orgUnit);
        }
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(DCAT.contactPoint, resource);
        return parent;
    }

}
