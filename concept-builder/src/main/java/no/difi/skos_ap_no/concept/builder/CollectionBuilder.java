package no.difi.skos_ap_no.concept.builder;

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


    CollectionBuilder(final ModelBuilder modelBuilder, final Model model, final String collectionUri, final String publisher) {
        this.parent = modelBuilder;
        this.model = model;
        resource = model.createResource(collectionUri).addProperty(RDF.type, SKOS.Collection);
        publisher(publisher);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public ConceptBuilder conceptBuilder(final String conceptUri) {
        return conceptBuilder(conceptUri, this.publisher);
    }

    public ConceptBuilder conceptBuilder(final String conceptUri, final String publisher) {
        return new ConceptBuilder(this, this.model, conceptUri, publisher);
    }

    public CollectionBuilder name(final String name, final String language) {
        if (resource.hasProperty(RDFS.label)) {
            resource.removeAll(RDFS.label);
        }
        resource.addProperty(RDFS.label, name, language);
        return this;
    }

    public CollectionBuilder publisher(final String organizationNumber) {
        if (resource.hasProperty(DCTerms.publisher)) {
            resource.removeAll(DCTerms.publisher);
        }
        this.publisher = organizationNumber;
        resource.addProperty(DCTerms.publisher, model.createResource("https://data.brreg.no/enhetsregisteret/api/enheter/" + organizationNumber));
        return this;
    }

    public ContactPointCollectionBuilder contactPointBuilder() {
        return new ContactPointCollectionBuilder(this);
    }

    public ModelBuilder build() {
        return parent;
    }

    public String getPublisher() {
        return publisher;
    }
}
