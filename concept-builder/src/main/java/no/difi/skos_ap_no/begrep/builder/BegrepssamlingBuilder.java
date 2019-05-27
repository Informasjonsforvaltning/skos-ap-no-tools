package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.CollectionBuilder;
import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;


public class BegrepssamlingBuilder {

    private ModellBuilder parent;
    private CollectionBuilder collectionBuilder;


    BegrepssamlingBuilder(final ModellBuilder modellBuilder, final ModelBuilder modelBuilder, final String identifikatorUri) {
        this.parent = modellBuilder;
        collectionBuilder = modelBuilder.collectionBuilder(identifikatorUri);
    }

    public BegrepBuilder begrepBuilder(final String begrepUri) {
        return new BegrepBuilder(this, collectionBuilder, begrepUri);
    }

    public BegrepssamlingBuilder ansvarligVirksomhet(final String orgNr) {
        collectionBuilder.publisher(orgNr);
        return this;
    }

    public Model getModel() {
        return collectionBuilder.getModel();
    }

    public Resource getResource() {
        return collectionBuilder.getResource();
    }

    public ModellBuilder build() {
        return parent;
    }

}
