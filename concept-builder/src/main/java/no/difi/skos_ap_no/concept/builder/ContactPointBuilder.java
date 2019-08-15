package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD4;


public abstract class ContactPointBuilder {

    private Resource resource;
    private Model model;


    ContactPointBuilder(Model model) {
        this.model = model;
        resource = model.createResource(VCARD4.Organization);
    }

    public ContactPointBuilder email(final String email) {
        if (email != null) {
            resource.addProperty(VCARD4.hasEmail, emailResource(email));
        }
        return this;
    }

    public ContactPointBuilder telephone(final String telephone) {
        if (telephone != null) {
            resource.addProperty(VCARD4.hasTelephone, telephoneResource(telephone));
        }
        return this;
    }

    public ContactPointBuilder organizationUnit(final String orgUnit) {
        if (orgUnit != null) {
            resource.addProperty(VCARD4.hasOrganizationUnit, orgUnit);
        }
        return this;
    }

    private Resource emailResource(final String email) {
        return model.createResource("mailto:" + email);
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
        return model.createResource("tel:" + sb.toString());
    }

    Resource getResource() {
        return resource;
    }
}
