package no.difi.skos_ap_no.begrep.builder;

import no.difi.skos_ap_no.concept.builder.CollectionBuilder;
import no.difi.skos_ap_no.concept.builder.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;


public class BegrepBuilder {

    private BegrepssamlingBuilder parent;
    private ConceptBuilder conceptBuilder;


    BegrepBuilder(final BegrepssamlingBuilder begrepssamlingBuilder, final CollectionBuilder collectionBuilder, final String identifikatorUri) {
        this.parent = begrepssamlingBuilder;
        conceptBuilder = collectionBuilder.conceptBuilder(identifikatorUri);
    }

    public BegrepBuilder identifikator(final String identifikator) {
        conceptBuilder.identifier(identifikator);
        return this;
    }

    public BegrepBuilder ansvarligVirksomhet(final String orgNr) {
        conceptBuilder.publisher(orgNr);
        return this;
    }

    public BegrepBuilder anbefaltTerm(final String tekst, final String språk) {
        conceptBuilder.preferredTerm(tekst, språk);
        return this;
    }

    public BegrepBuilder tillattTerm(final String tekst, final String språk) {
        conceptBuilder.alternativeTerm(tekst, språk);
        return this;
    }

    public BegrepBuilder frarådetTerm(final String tekst, final String språk) {
        conceptBuilder.deprecatedTerm(tekst, språk);
        return this;
    }

    public BegrepBuilder fagområde(final String tekst, final String språk) {
        conceptBuilder.subject(tekst, språk);
        return this;
    }

    public BegrepBuilder bruksområde(final String tekst, final String språk) {
        conceptBuilder.domainOfUse(tekst, språk);
        return this;
    }

    public BegrepBuilder eksempel(final String tekst, final String språk) {
        conceptBuilder.example(tekst, språk);
        return this;
    }

    public DefinisjonBuilder definisjonBuilder() {
        return new DefinisjonBuilder(this, conceptBuilder, SKOSNO.Definisjon);
    }

    public DefinisjonBuilder alternativFormuleringBuilder() {
        return new DefinisjonBuilder(this, conceptBuilder, SKOSNO.AlternativFormulering);
    }

    public KontaktpunktBegrepBuilder kontaktpunktBuilder() {
        return new KontaktpunktBegrepBuilder(this, conceptBuilder);
    }

    public Model getModel() {
        return conceptBuilder.getModel();
    }

    public Resource getResource() {
        return conceptBuilder.getResource();
    }

    public BegrepssamlingBuilder build() {
        if (!getResource().hasProperty(DCTerms.publisher)) {
            throw new RuntimeException("Begrep krever ansvarligVirksomhet");
        }

        conceptBuilder.build();
        return parent;
    }

}
