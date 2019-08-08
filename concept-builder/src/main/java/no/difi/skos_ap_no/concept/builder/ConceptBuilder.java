package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.*;

import java.time.LocalDate;


public class ConceptBuilder {

    private CollectionBuilder parent;
    private Model model;
    private Resource resource;


    ConceptBuilder(final CollectionBuilder collectionBuilder, final Model model, final String uri) {
        this.parent = collectionBuilder;
        this.model = model;
        resource = model.createResource(uri).addProperty(RDF.type, SKOS.Concept);

        identifier(uri);
        publisher(collectionBuilder.getPublisher()); //Inherit publisher from Collection
    }

    public DefinitionBuilder definitionBuilder() {
        return new DefinitionBuilder(this, SKOSNO.Definisjon);
    }

    public DefinitionBuilder alternativeDefinitionBuilder() {
        return new DefinitionBuilder(this, SKOSNO.AlternativFormulering);
    }

    public ConceptBuilder identifier(final String identifier) {
        if (resource.hasProperty(DCTerms.identifier)) {
            resource.removeAll(DCTerms.identifier);
        }
        resource.addProperty(DCTerms.identifier, identifier);
        return this;
    }

    public ConceptBuilder publisher(final String organizationNumber) {
        if (resource.hasProperty(DCTerms.publisher)) {
            resource.removeAll(DCTerms.publisher);
        }
        Resource publisher = model.createResource("https://data.brreg.no/enhetsregisteret/api/enheter/" + organizationNumber);
        resource.addProperty(DCTerms.publisher, publisher);
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

    public ConceptBuilder subject(final String subject, final String language) {
        resource.addProperty(DCTerms.subject, subject, language);
        return this;
    }

    public ConceptBuilder domainOfUse(final String domainOfUse, final String language) {
        resource.addProperty(SKOSNO.bruksområde, domainOfUse, language);
        return this;
    }

    public ConceptBuilder example(final String example, final String language) {
        resource.addProperty(SKOS.example, example, language);
        return this;
    }

    public PeriodOfTimeBuilder periodOfTimeBuilder() {
        return new PeriodOfTimeBuilder(this);
    }

    public ContactPointConceptBuilder contactPointBuilder() {
        return new ContactPointConceptBuilder(this);
    }

    public ConceptBuilder modified(final LocalDate date) {
        if (resource.hasProperty(DCTerms.modified)) {
            resource.removeAll(DCTerms.modified);
        }
        resource.addProperty(DCTerms.modified, model.createTypedLiteral(date, XSDDateType.XSDdate));
        return this;
    }

    public ConceptBuilder replaces(final String uri) {
        resource.addProperty(DCTerms.replaces, uri);
        getModel().getResource(uri).addProperty(DCTerms.isReplacedBy, getResource().getURI());
        return this;
    }

    public ConceptBuilder replacedBy(final String uri) {
        resource.addProperty(DCTerms.isReplacedBy, uri);
        getModel().getResource(uri).addProperty(DCTerms.replaces, getResource().getURI());
        return this;
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

}
