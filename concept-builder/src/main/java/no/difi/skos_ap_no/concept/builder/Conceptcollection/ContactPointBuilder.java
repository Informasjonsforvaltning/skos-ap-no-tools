package no.difi.skos_ap_no.concept.builder.Conceptcollection;

import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCAT;
import org.apache.jena.vocabulary.VCARD4;


public class ContactPointBuilder {

    private CollectionBuilder parent;
    private Resource resource;


    ContactPointBuilder(final CollectionBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource(VCARD4.Organization);
    }

    public ContactPointBuilder email(final String email) {
        if (email != null) {
            resource.addProperty(VCARD4.hasEmail, emailResource(parent.getModel(), email));
        }
        return this;
    }

    public ContactPointBuilder telephone(final String telephone) {
        if (telephone != null) {
            resource.addProperty(VCARD4.hasTelephone, telephoneResource(parent.getModel(), telephone));
        }
        return this;
    }

    public ContactPointBuilder organizationUnit(final String orgUnit) {
        if (orgUnit != null) {
            resource.addProperty(VCARD4.hasOrganizationUnit, orgUnit);
        }
        return this;
    }

    public static Resource emailResource(final Model model, final String email) {
        return model.createResource(ModelBuilder.escapeURI("mailto:" + email));
    }

    public static Resource telephoneResource(final Model model, final String telephone) {
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
        return model.createResource(ModelBuilder.escapeURI("tel:" + sb.toString()));
    }

    public CollectionBuilder build() {
        parent.getResource().addProperty(DCAT.contactPoint, resource);
        return parent;
    }

}
