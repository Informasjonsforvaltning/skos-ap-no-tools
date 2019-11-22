package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.ConceptBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.SourceDescription.SourcedescriptionBuilder;
import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.URIText.URITextBuilder;
import no.difi.skos_ap_no.concept.builder.SKOSNO;
import no.difi.skos_ap_no.concept.builder.generic.AudienceType;
import no.difi.skos_ap_no.concept.builder.generic.LocalDateToXSDDateTime;
import org.apache.jena.datatypes.xsd.impl.XSDDateType;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.SKOS;

import java.time.LocalDate;


public class DefinitionBuilder {

    private ConceptBuilder parent;
    private Model model;
    private Resource resource;


    public DefinitionBuilder(final ConceptBuilder conceptBuilder) {
        parent = conceptBuilder;
        model = conceptBuilder.getModel();
        resource = model.createResource(SKOSNO.Definisjon);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public SourcedescriptionBuilder sourcedescriptionBuilder() {
        return new SourcedescriptionBuilder(this);
    }

    public DefinitionBuilder text(final String text, final String language) {
        if (text != null) {
            resource.addProperty(RDFS.label, text, language);
        }
        return this;
    }

    public DefinitionBuilder example(final String exampleText, final String language) {
        if (exampleText != null) {
            resource.addProperty(SKOS.example, exampleText, language);
        }
        return this;
    }

    public DefinitionBuilder scopeNote(final String scopeText, final String language) {
        if (scopeText != null) {
            resource.addProperty(SKOS.scopeNote, scopeText, language);
        }
        return this;
    }

    public DefinitionBuilder audience(final AudienceType.Audience audience) {
        resource.addProperty(DCTerms.audience, parent.getModel().createResource(audience.toString()));
        return this;
    }

    public URITextBuilder scopeBuilder() {
        return new URITextBuilder(this, SKOSNO.omfang);
    }

    public DefinitionBuilder modified(final LocalDate date) {
        if (date != null) {
            resource.addProperty(DCTerms.modified, model.createTypedLiteral(LocalDateToXSDDateTime.toXSDDate(date), XSDDateType.XSDdate));
        }
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSNO.betydningsbeskrivelse, resource);
        return parent;
    }

}
