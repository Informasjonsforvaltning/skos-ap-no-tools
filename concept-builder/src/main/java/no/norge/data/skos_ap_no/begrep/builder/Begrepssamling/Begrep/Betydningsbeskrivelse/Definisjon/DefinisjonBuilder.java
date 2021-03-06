package no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon;

import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.BegrepBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.Kildebeskrivelse.KildebeskrivelseBuilder;
import no.norge.data.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Definisjon.URITekst.URITekstBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.DefinitionBuilder;
import no.norge.data.skos_ap_no.concept.builder.generelt.MålgruppeType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.time.LocalDate;


public class DefinisjonBuilder {

    private BegrepBuilder parent;
    private DefinitionBuilder definitionBuilder;


    public DefinisjonBuilder(final BegrepBuilder begrepBuilder, final ConceptBuilder conceptBuilder) {
        this.parent = begrepBuilder;
        definitionBuilder = conceptBuilder.definitionBuilder();
    }

    public Model getModel() {
        return definitionBuilder.getModel();
    }

    public Resource getResource() {
        return definitionBuilder.getResource();
    }

    public KildebeskrivelseBuilder kildebeskrivelseBuilder() {
        return new KildebeskrivelseBuilder(this, definitionBuilder);
    }

    public DefinisjonBuilder tekst(final String tekst, final String språk) {
        definitionBuilder.text(tekst, språk);
        return this;
    }

    public DefinisjonBuilder eksempel(final String tekst, final String språk) {
        definitionBuilder.example(tekst, språk);
        return this;
    }

    public DefinisjonBuilder merknad(final String tekst, final String språk) {
        definitionBuilder.scopeNote(tekst, språk);
        return this;
    }

    public DefinisjonBuilder målgruppe(final MålgruppeType.Målgruppe målgruppe) {
        definitionBuilder.audience(målgruppe.toAudience());
        return this;
    }

    public URITekstBuilder omfangBuilder() {
        return new URITekstBuilder(this, definitionBuilder);
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
