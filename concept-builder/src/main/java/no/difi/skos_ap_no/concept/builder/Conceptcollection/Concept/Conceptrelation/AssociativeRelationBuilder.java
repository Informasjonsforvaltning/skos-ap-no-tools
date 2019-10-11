package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import no.difi.skos_ap_no.concept.builder.generic.LocalDateToXSDDateTime;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;

import java.time.LocalDate;


public class AssociativeRelationBuilder {

    private ConceptBuilder parent;
    private Model model;
    private Resource resource;


    public AssociativeRelationBuilder(final ConceptBuilder conceptBuilder) {
        parent = conceptBuilder;
        model = conceptBuilder.getModel();
        resource = model.createResource(SKOSNO.AssosiativRelasjon);
    }

    public AssociativeRelationBuilder description(final String descriptionText, final String language) {
        if (descriptionText != null) {
            resource.addProperty(DCTerms.description, descriptionText, language);
        }
        return this;
    }

    public AssociativeRelationBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, model.createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public AssociativeRelationBuilder associatedConcept(final String uri) {
        if (uri != null) {
            resource.addProperty(SKOSNO.assosiertBegrep, model.createResource(ModelBuilder.escapeURI(uri)));
        }
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSNO.begrepsrelasjon, resource);
        return parent;
    }

}
