package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.DefinitionBuilder;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.time.LocalDate;


public class DefinisjonBuilder {

    private BegrepBuilder parent;
    private DefinitionBuilder definitionBuilder;


    DefinisjonBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder, final Resource definitionClass) {
        this.parent = begrepBuilder;
        definitionBuilder = definitionClass == SKOSNO.Definisjon ? conceptBuilder.definitionBuilder() : conceptBuilder.alternativeDefinitionBuilder();
    }

    public Model getModel() {
        return definitionBuilder.getModel();
    }

    public Resource getResource() {
        return definitionBuilder.getResource();
    }

    public KildeBuilder kildeBuilder() {
        return new KildeBuilder(this, definitionBuilder);
    }

    public DefinisjonBuilder tekst(final String tekst, final String språk) {
        definitionBuilder.text(tekst, språk);
        return this;
    }

    public DefinisjonBuilder merknad(final String tekst, final String språk) {
        definitionBuilder.scopeNote(tekst, språk);
        return this;
    }

    public DefinisjonBuilder målgruppe(final String tekst, final String språk) {
        definitionBuilder.audience(tekst, språk);
        return this;
    }

    public DefinisjonBuilder sistOppdatert(final LocalDate dato) {
        definitionBuilder.modified(dato);
        return this;
    }

    public BegrepBuilder build() {
        definitionBuilder.build();
        return parent;
    }

}
