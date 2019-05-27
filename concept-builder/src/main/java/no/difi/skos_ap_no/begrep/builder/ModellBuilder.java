package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;


public class ModellBuilder {

    private ModelBuilder modelBuilder;


    public static ModellBuilder builder() {
        ModellBuilder modellBuilder = new ModellBuilder();
        modellBuilder.modelBuilder = ModelBuilder.builder();
        return modellBuilder;
    }

    public BegrepssamlingBuilder begrepssamlingBuilder(final String identifikatorUri) {
        return new BegrepssamlingBuilder(this, modelBuilder, identifikatorUri);
    }

    public Model getModel() {
        return modelBuilder.getModel();
    }

    public Model build() {
        return modelBuilder.build();
    }
}
