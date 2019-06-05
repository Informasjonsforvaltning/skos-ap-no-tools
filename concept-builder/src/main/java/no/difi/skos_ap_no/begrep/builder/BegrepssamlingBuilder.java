package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.CollectionBuilder;
import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDFS;


public class BegrepssamlingBuilder {

    private ModellBuilder parent;
    private CollectionBuilder collectionBuilder;


    BegrepssamlingBuilder(final ModellBuilder modellBuilder, final ModelBuilder modelBuilder, final String identifikatorUri) {
        this.parent = modellBuilder;
        collectionBuilder = modelBuilder.collectionBuilder(identifikatorUri);
    }

    public BegrepBuilder begrepBuilder(final String begrepUri) {
        return begrepBuilder(begrepUri, collectionBuilder.getPublisher());
    }

    public BegrepBuilder begrepBuilder(final String begrepUri, final String ansvarligVirksomhet) {
        return new BegrepBuilder(this, collectionBuilder, begrepUri, ansvarligVirksomhet);
    }

    public BegrepssamlingBuilder navn(final String navn, final String språk) {
        collectionBuilder.name(navn, språk);
        return this;
    }

    public BegrepssamlingBuilder ansvarligVirksomhet(final String orgNr) {
        collectionBuilder.publisher(orgNr);
        return this;
    }

    public KontaktpunktBegrepssamlingBuilder kontaktpunktBuilder() {
        return new KontaktpunktBegrepssamlingBuilder(this, collectionBuilder);
    }

    public Model getModel() {
        return collectionBuilder.getModel();
    }

    public Resource getResource() {
        return collectionBuilder.getResource();
    }

    public ModellBuilder build() {
        if (!getResource().hasProperty(RDFS.label)) {
            throw new RuntimeException("Begrepssamling krever navn");
        }
        if (!getResource().hasProperty(DCTerms.publisher)) {
            throw new RuntimeException("Begrepssamling krever ansvarligVirksomhet");
        }
        return parent;
    }

}
