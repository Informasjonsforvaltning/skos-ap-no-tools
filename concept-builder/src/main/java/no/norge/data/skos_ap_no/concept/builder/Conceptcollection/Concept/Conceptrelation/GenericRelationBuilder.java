package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.ModelBuilder;
import no.norge.data.skos_ap_no.concept.builder.SKOSNO;
import no.norge.data.skos_ap_no.concept.builder.XKOS;
import no.norge.data.skos_ap_no.concept.builder.generic.LocalDateToXSDDateTime;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;

import java.time.LocalDate;


public class GenericRelationBuilder {

    private ConceptBuilder parent;
    private Model model;
    private Resource resource;


    public GenericRelationBuilder(final ConceptBuilder conceptBuilder) {
        parent = conceptBuilder;
        model = conceptBuilder.getModel();
        resource = model.createResource(SKOSNO.GeneriskRelasjon);
    }

    public GenericRelationBuilder divisioncriterion(final String divisioncriterionText, final String language) {
        if (divisioncriterionText != null) {
            resource.addProperty(SKOSNO.inndelingskriterium, divisioncriterionText, language);
        }
        return this;
    }

    public GenericRelationBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, model.createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public GenericRelationBuilder broaderConcept(final String uri) {
        if (uri != null) {
            resource.addProperty(XKOS.specializes, model.createResource(ModelBuilder.escapeURI(uri)));
        }
        return this;
    }

    public GenericRelationBuilder narrowerConcept(final String uri) {
        if (uri != null) {
            resource.addProperty(XKOS.generalizes, model.createResource(ModelBuilder.escapeURI(uri)));
        }
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSNO.generiskRelasjon, resource);
        return parent;
    }

}
