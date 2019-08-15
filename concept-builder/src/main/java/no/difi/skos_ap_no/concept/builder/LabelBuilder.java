package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.SKOSXL;

import java.time.LocalDate;


public abstract class LabelBuilder {

    private ConceptBuilder parent;
    private Resource resource;


    LabelBuilder(final ConceptBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource(SKOSXL.Label);
    }

    public LabelBuilder label(final String labelText, final String language) {
        if (labelText != null) {
            resource.addProperty(SKOSXL.literalForm, labelText, language);
        }
        return this;
    }

    public LabelBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, parent.getModel().createTypedLiteral(date, XSDDateType.XSDdate));
        }
        return this;
    }

    public Resource getResource() {
        return resource;
    }

    public ConceptBuilder getParent() {
        return parent;
    }

}
