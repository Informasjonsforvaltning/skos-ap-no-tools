package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon.AssosiativRelasjonBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon.GeneriskRelasjonBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Begrepsrelasjon.PartitivRelasjonBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.AlternativFormuleringBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.DefinisjonBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term.AnbefaltTermBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term.DatastrukturTermBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term.FrarådetTermBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Term.TillattTermBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.BegrepssamlingBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.CollectionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;

import java.time.LocalDate;


public class BegrepBuilder {

    private BegrepssamlingBuilder parent;
    private ConceptBuilder conceptBuilder;


    public BegrepBuilder(final BegrepssamlingBuilder begrepssamlingBuilder, final CollectionBuilder collectionBuilder, final String identifikatorUri) {
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

    public AnbefaltTermBuilder anbefaltTermBuilder() {
        return new AnbefaltTermBuilder(this, conceptBuilder);
    }

    public TillattTermBuilder tillattTermBuilder() {
        return new TillattTermBuilder(this, conceptBuilder);
    }

    public FrarådetTermBuilder frarådetTermBuilder() {
        return new FrarådetTermBuilder(this, conceptBuilder);
    }

    public DatastrukturTermBuilder datastrukturTermBuilder() {
        return new DatastrukturTermBuilder(this, conceptBuilder);
    }

    public BegrepBuilder fagområde(final String tekst, final String språk) {
        conceptBuilder.subject(tekst, språk);
        return this;
    }

    public BegrepBuilder fagområde(final String uri) {
        conceptBuilder.subject(uri);
        return this;
    }

    public BegrepBuilder eksempel(final String tekst, final String språk) {
        conceptBuilder.example(tekst, språk);
        return this;
    }

    public DefinisjonBuilder definisjonBuilder() {
        return new DefinisjonBuilder(this, conceptBuilder);
    }

    public AlternativFormuleringBuilder alternativFormuleringBuilder() {
        return new AlternativFormuleringBuilder(this, conceptBuilder);
    }

    public GyldighetsperiodeBuilder gyldighetsperiodeBuilder() {
        return new GyldighetsperiodeBuilder(this, conceptBuilder);
    }

    public KontaktpunktBuilder kontaktpunktBuilder() {
        return new KontaktpunktBuilder(this, conceptBuilder);
    }

    public BegrepBuilder sistOppdatert(final LocalDate dato) {
        conceptBuilder.modified(dato);
        return this;
    }

    public BegrepBuilder seOgså(final String identifikatorUri) {
        conceptBuilder.seeAlso(identifikatorUri);
        return this;
    }

    public BegrepBuilder erstatter(final String identifikatorUri) {
        conceptBuilder.replaces(identifikatorUri);
        return this;
    }

    public BegrepBuilder erstattesAv(final String identifikatorUri) {
        conceptBuilder.replacedBy(identifikatorUri);
        return this;
    }

    public AssosiativRelasjonBuilder assosiativRelasjonBuilder() {
        return new AssosiativRelasjonBuilder(this, conceptBuilder);
    }

    public GeneriskRelasjonBuilder generiskRelasjonBuilder() {
        return new GeneriskRelasjonBuilder(this, conceptBuilder);
    }

    public PartitivRelasjonBuilder partitivRelasjonBuilder() {
        return new PartitivRelasjonBuilder(this, conceptBuilder);
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
