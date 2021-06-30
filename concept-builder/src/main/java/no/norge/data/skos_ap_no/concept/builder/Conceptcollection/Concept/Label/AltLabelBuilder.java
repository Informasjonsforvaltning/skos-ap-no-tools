package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.generic.AudienceType;
import no.norge.data.skos_ap_no.concept.builder.generic.LocalDateToXSDDateTime;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.SKOSXL;

import java.time.LocalDate;


public class AltLabelBuilder {

    private ConceptBuilder parent;
    private Resource resource;


    public AltLabelBuilder(final ConceptBuilder parent) {
        this.parent = parent;
        resource = parent.getModel().createResource(SKOSXL.Label);
    }

    public AltLabelBuilder label(final String labelText, final String language) {
        if (labelText != null) {
            resource.addProperty(SKOSXL.literalForm, labelText, language);
        }
        return this;
    }

    public AltLabelBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, parent.getModel().createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public AltLabelBuilder audience(final AudienceType.Audience audience) {
        resource.addProperty(DCTerms.audience, parent.getModel().createResource(audience.toString()));
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSXL.altLabel, resource);
        return parent;
    }

}
