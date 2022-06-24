package no.norge.data.skos_ap_no.concept.builder.Conceptcollection;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.SKOS;


public class CollectionBuilder {

    private ModelBuilder parent;
    private Model model;
    private Resource resource;

    private String publisher;


    public CollectionBuilder(final ModelBuilder modelBuilder, final Model model, final String collectionUri) {
        this.parent = modelBuilder;
        this.model = model;
        String escapedURI = ModelBuilder.escapeURI(collectionUri);
        resource = model.createResource(escapedURI).addProperty(RDF.type, SKOS.Collection);

        identifier(escapedURI);
    }

    public ConceptBuilder conceptBuilder(final String conceptUri) {
        return new ConceptBuilder(this, this.model, conceptUri);
    }

    public CollectionBuilder name(final String name) {
        if (resource.hasProperty(RDFS.label)) {
            resource.removeAll(RDFS.label);
        }
        if (name != null) {
            resource.addProperty(RDFS.label, name);
        }
        return this;
    }

    public CollectionBuilder identifier(final String identifier) {
        if (resource.hasProperty(DCTerms.identifier)) {
            resource.removeAll(DCTerms.identifier);
        }
        if (identifier != null) {
            resource.addProperty(DCTerms.identifier, model.createLiteral(identifier));
        }
        return this;
    }

    public CollectionBuilder publisher(final String organizationNumber) {
        if (resource.hasProperty(DCTerms.publisher)) {
            resource.removeAll(DCTerms.publisher);
        }
        if (organizationNumber != null) {
            this.publisher = organizationNumber;
            resource.addProperty(DCTerms.publisher, model.createResource(ModelBuilder.escapeURI("https://data.brreg.no/enhetsregisteret/api/enheter/" + organizationNumber)));
        }
        return this;
    }

    public CollectionBuilder description(final String description) {
        if (resource.hasProperty(DCTerms.description)) {
            resource.removeAll(DCTerms.description);
        }
        if (description != null) {
            resource.addProperty(DCTerms.description, description);
        }
        return this;
    }

    public ContactPointBuilder contactPointBuilder() {
        return new ContactPointBuilder(this);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public ModelBuilder build() {
        if (!resource.hasProperty(RDFS.label)) {
            throw new RuntimeException("Collection requires name");
        }
        if (!resource.hasProperty(DCTerms.publisher)) {
            throw new RuntimeException("Collection requires publisher");
        }
        return parent;
    }

    public String getPublisher() {
        return publisher;
    }
}
