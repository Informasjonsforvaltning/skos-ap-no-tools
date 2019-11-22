package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Label;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.generic.LocalDateToXSDDateTime;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.SKOSXL;

import java.time.LocalDate;


public class PrefLabelBuilder {

    private ConceptBuilder parent;
    private Resource resource;


    public PrefLabelBuilder(final ConceptBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource(SKOSXL.Label);
    }

    public PrefLabelBuilder label(final String labelText, final String language) {
        if (labelText != null) {
            resource.addProperty(SKOSXL.literalForm, labelText, language);
        }
        return this;
    }

    public PrefLabelBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, parent.getModel().createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSXL.prefLabel, resource);
        return parent;
    }

}
