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


public class PartitiveRelationBuilder {

    private ConceptBuilder parent;
    private Model model;
    private Resource resource;


    public PartitiveRelationBuilder(final ConceptBuilder conceptBuilder) {
        parent = conceptBuilder;
        model = conceptBuilder.getModel();
        resource = model.createResource(SKOSNO.PartitivRelasjon);
    }

    public PartitiveRelationBuilder divisioncriterion(final String divisioncriterionText, final String language) {
        if (divisioncriterionText != null) {
            resource.addProperty(DCTerms.description, divisioncriterionText, language);
        }
        return this;
    }

    public PartitiveRelationBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, model.createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public PartitiveRelationBuilder broaderConcept(final String uri) {
        if (uri != null) {
            resource.addProperty(DCTerms.isPartOf, model.createResource(ModelBuilder.escapeURI(uri)));
        }
        return this;
    }

    public PartitiveRelationBuilder narrowerConcept(final String uri) {
        if (uri != null) {
            resource.addProperty(DCTerms.hasPart, model.createResource(ModelBuilder.escapeURI(uri)));
        }
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSNO.partitivRelasjon, resource);
        return parent;
    }

}
