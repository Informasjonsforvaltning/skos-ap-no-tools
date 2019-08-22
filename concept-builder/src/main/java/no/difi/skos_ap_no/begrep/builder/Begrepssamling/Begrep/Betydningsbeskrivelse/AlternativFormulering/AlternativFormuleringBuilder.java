package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering;

import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.AlternativFormulering.Kildebeskrivelse.KildebeskrivelseBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.time.LocalDate;


public class AlternativFormuleringBuilder {

    private BegrepBuilder parent;
    private AlternativeWordingBuilder alternativeWordingBuilder;


    public AlternativFormuleringBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder, final Resource definitionClass) {
        this.parent = begrepBuilder;
        alternativeWordingBuilder = conceptBuilder.alternativeWordingBuilder();
    }

    public Model getModel() {
        return alternativeWordingBuilder.getModel();
    }

    public Resource getResource() {
        return alternativeWordingBuilder.getResource();
    }

    public KildebeskrivelseBuilder kildebeskrivelseBuilder() {
        return new KildebeskrivelseBuilder(this, alternativeWordingBuilder);
    }

    public AlternativFormuleringBuilder tekst(final String tekst, final String språk) {
        alternativeWordingBuilder.text(tekst, språk);
        return this;
    }

    public AlternativFormuleringBuilder merknad(final String tekst, final String språk) {
        alternativeWordingBuilder.scopeNote(tekst, språk);
        return this;
    }

    public AlternativFormuleringBuilder målgruppe(final String tekst, final String språk) {
        alternativeWordingBuilder.audience(tekst, språk);
        return this;
    }

    public AlternativFormuleringBuilder sistOppdatert(final LocalDate dato) {
        alternativeWordingBuilder.modified(dato);
        return this;
    }

    public BegrepBuilder build() {
        alternativeWordingBuilder.build();
        return parent;
    }

}
