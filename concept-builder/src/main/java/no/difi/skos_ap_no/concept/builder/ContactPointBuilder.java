package no.difi.skos_ap_no.concept.builder;

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
        resource.addProperty(VCARD4.hasEmail, emailResource(email));
        return this;
    }

    public ContactPointBuilder telephone(final String telephone) {
        resource.addProperty(VCARD4.hasTelephone, telephoneResource(telephone));

        return this;
    }

    public ContactPointBuilder organizationUnit(final String orgUnit) {
        resource.addProperty(VCARD4.hasOrganizationUnit, orgUnit);

        return this;
    }

    private Resource emailResource(final String email) {
        return parent.getModel().createResource("mailto:" + email);
    }

    private Resource telephoneResource(final String telephone) {
        String phoneTextToParse = telephone.trim();
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        //Really bad parsing of "telephone-subscriber" from https://tools.ietf.org/html/rfc3966 ABNF
        for (int i=0; i<phoneTextToParse.length(); i++) {
            char ch = phoneTextToParse.charAt(i);
            if (first && ch=='+') {
                //global-number-digits
                sb.append(ch);
                first = false;
            } else if (ch>='0' && ch<='9') {
                //DIGIT
                sb.append(ch);
            }
            //else skip visual-separator and other content
        }
        return parent.getModel().createResource("tel:" + sb.toString());
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(DCAT.contactPoint, resource);

        return parent;
    }

}
