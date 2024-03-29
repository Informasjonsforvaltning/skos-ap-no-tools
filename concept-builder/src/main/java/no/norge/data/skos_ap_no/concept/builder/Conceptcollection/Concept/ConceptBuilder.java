package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.CollectionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.AssociativeRelationBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.GenericRelationBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Conceptrelation.PartitiveRelationBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.DatastructureLabelBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.DefinitionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.AltLabelBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.HiddenLabelBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Label.PrefLabelBuilder;
import no.norge.data.skos_ap_no.concept.builder.ModelBuilder;
import no.norge.data.skos_ap_no.concept.builder.SKOSNO;
import no.norge.data.skos_ap_no.concept.builder.generic.LocalDateToXSDDateTime;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.*;

import java.time.LocalDate;


public class ConceptBuilder {

    private CollectionBuilder parent;
    private ModelBuilder singleParent;
    private Model model;
    private Resource resource;


    public ConceptBuilder(final CollectionBuilder collectionBuilder, final Model model, final String uri) {
        this.parent = collectionBuilder;
        this.model = model;
        String escapedURI = ModelBuilder.escapeURI(uri);
        resource = model.createResource(escapedURI).addProperty(RDF.type, SKOS.Concept);

        identifier(escapedURI);
        publisher(collectionBuilder.getPublisher()); //Inherit publisher from Collection
    }


    public ConceptBuilder(final ModelBuilder modelBuilder, final Model model, final String uri) {
        this.singleParent = modelBuilder;
        this.model = model;
        String escapedURI = ModelBuilder.escapeURI(uri);
        resource = model.createResource(escapedURI).addProperty(RDF.type, SKOS.Concept);

        identifier(escapedURI);
    }

    public DefinitionBuilder definitionBuilder() {
        return new DefinitionBuilder(this);
    }

    public AlternativeWordingBuilder alternativeWordingBuilder() {
        return new AlternativeWordingBuilder(this);
    }

    public ConceptBuilder identifier(final String identifier) {
        if (resource.hasProperty(DCTerms.identifier)) {
            resource.removeAll(DCTerms.identifier);
        }
        if (identifier != null) {
            resource.addProperty(DCTerms.identifier, model.createLiteral(identifier));
        }
        return this;
    }

    public ConceptBuilder publisher(final String organizationNumber) {
        if (resource.hasProperty(DCTerms.publisher)) {
            resource.removeAll(DCTerms.publisher);
        }
        if (organizationNumber != null) {
            Resource publisher = model.createResource(ModelBuilder.escapeURI("https://data.brreg.no/enhetsregisteret/api/enheter/" + organizationNumber));
            resource.addProperty(DCTerms.publisher, publisher);
        }
        return this;
    }

    public PrefLabelBuilder prefLabelBuilder() {
        return new PrefLabelBuilder(this);
    }

    public AltLabelBuilder altLabelBuilder() {
        return new AltLabelBuilder(this);
    }

    public HiddenLabelBuilder hiddenLabelBuilder() {
        return new HiddenLabelBuilder(this);
    }

    public DatastructureLabelBuilder datastructureLabelBuilder() {
        return new DatastructureLabelBuilder(this);
    }

    public ConceptBuilder subject(final String subject, final String language) {
        if (subject != null) {
            resource.addProperty(DCTerms.subject, subject, language);
        }
        return this;
    }

    public ConceptBuilder domainOfUse(final String domainOfUse, final String language) {
        if (domainOfUse != null) {
            resource.addProperty(SKOSNO.bruksområde, domainOfUse, language);
        }
        return this;
    }

    public ConceptBuilder example(final String example, final String language) {
        if (example != null) {
            resource.addProperty(SKOS.example, example, language);
        }
        return this;
    }

    public PeriodOfTimeBuilder periodOfTimeBuilder() {
        return new PeriodOfTimeBuilder(this);
    }

    public ContactPointBuilder contactPointBuilder() {
        return new ContactPointBuilder(this);
    }

    public ConceptBuilder modified(final LocalDate date) {
        if (resource.hasProperty(DCTerms.modified)) {
            resource.removeAll(DCTerms.modified);
        }
        if (date != null) {
            resource.addProperty(DCTerms.modified, model.createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public ConceptBuilder seeAlso(final String uri) {
        if (uri != null) {
            resource.addProperty(RDFS.seeAlso, uri);
        }
        return this;
    }

    public ConceptBuilder replaces(final String uri) {
        if (uri != null) {
            resource.addProperty(DCTerms.replaces, uri);
            getModel().getResource(uri).addProperty(DCTerms.isReplacedBy, getResource().getURI());
        }
        return this;
    }

    public ConceptBuilder replacedBy(final String uri) {
        if (uri != null) {
            resource.addProperty(DCTerms.isReplacedBy, uri);
            getModel().getResource(uri).addProperty(DCTerms.replaces, getResource().getURI());
        }
        return this;
    }

    public AssociativeRelationBuilder associativeRelationBuilder() {
        return new AssociativeRelationBuilder(this);
    }

    public GenericRelationBuilder genericRelationBuilder() {
        return new GenericRelationBuilder(this);
    }

    public PartitiveRelationBuilder partitiveRelationBuilder() {
        return new PartitiveRelationBuilder(this);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public CollectionBuilder build() {
        if (!resource.hasProperty(DCTerms.publisher)) {
            throw new RuntimeException("Concept requires publisher");
        }

        parent.getResource().addProperty(SKOS.member, getResource());
        return parent;
    }

    public ModelBuilder buildSingleConcept() {
        if (!resource.hasProperty(DCTerms.publisher)) {
            throw new RuntimeException("Concept requires publisher");
        }
        return singleParent;
    }

}
