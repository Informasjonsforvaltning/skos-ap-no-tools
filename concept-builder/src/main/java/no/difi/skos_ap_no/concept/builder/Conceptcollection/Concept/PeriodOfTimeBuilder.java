package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept;

import no.difi.skos_ap_no.concept.builder.Schema;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;

import java.time.LocalDate;


public class PeriodOfTimeBuilder {

    private ConceptBuilder parent;
    private LocalDate validFromIncluding;
    private LocalDate validToIncluding;


    PeriodOfTimeBuilder(final ConceptBuilder conceptBuilder) {
        this.parent = conceptBuilder;
    }

    public PeriodOfTimeBuilder validFromIncluding(final LocalDate validFromIncluding) {
        this.validFromIncluding = validFromIncluding;
        return this;
    }

    public PeriodOfTimeBuilder validToIncluding(final LocalDate validToIncluding) {
        this.validToIncluding = validToIncluding;
        return this;
    }

    public ConceptBuilder build() {
        Model model = parent.getModel();
        Resource validPeriodOfTimeResource = model.createResource(DCTerms.PeriodOfTime);

        if (validFromIncluding != null) {
            validPeriodOfTimeResource.addProperty(Schema.startDate, model.createTypedLiteral(validFromIncluding, XSDDateType.XSDdate));
        }

        if (validToIncluding != null) {
            validPeriodOfTimeResource.addProperty(Schema.endDate, model.createTypedLiteral(validToIncluding, XSDDateType.XSDdate));
        }

        parent.getResource().addProperty(DCTerms.temporal, validPeriodOfTimeResource);
        return parent;
    }

}
