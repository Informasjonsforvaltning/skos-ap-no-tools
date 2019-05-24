package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.SKOS;


public class CollectionBuilder {

    private ModelBuilder parent;
    private Model model;
    private Resource resource;


    CollectionBuilder(final ModelBuilder modelBuilder, final Model model, final String collectionUri) {

        this.parent = modelBuilder;
        this.model = model;
        resource = model.createResource(collectionUri)
                .addProperty(RDF.type, SKOS.Collection);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public ConceptBuilder conceptBuilder(final String conceptUri) {

        return new ConceptBuilder(this, this.model, conceptUri);
    }

    public CollectionBuilder publisher(final String organizationNumber) {
        Resource publisher = model.createResource("https://data.brreg.no/enhetsregisteret/api/enheter/" + organizationNumber);
        resource.addProperty(DCTerms.publisher, publisher);

        return this;
    }

    public ModelBuilder build() {
        return parent;
    }

}
