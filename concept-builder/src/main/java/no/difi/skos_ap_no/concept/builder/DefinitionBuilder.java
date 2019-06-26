package no.difi.skos_ap_no.concept.builder;

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


    DefinitionBuilder(final ConceptBuilder conceptBuilder, final Resource definitionClass) {
        parent = conceptBuilder;
        model = conceptBuilder.getModel();
        resource = model.createResource(definitionClass);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public SourceBuilder sourceBuilder() {
        return new SourceBuilder(this);
    }

    public DefinitionBuilder text(final String text, final String language) {
        resource.addProperty(RDFS.label, text, language);
        return this;
    }

    public DefinitionBuilder scopeNote(final String scopeText, final String language) {
        resource.addProperty(SKOS.scopeNote, scopeText, language);
        return this;
    }

    public DefinitionBuilder audience(final String audienceText, final String language) {
        resource.addProperty(DCTerms.audience, audienceText, language);
        return this;
    }

    public DefinitionBuilder modified(final LocalDate date) {
        resource.addProperty(DCTerms.modified, model.createTypedLiteral(date, XSDDateType.XSDdate));
        return this;
    }

    public ConceptBuilder build() {
        parent.getResource().addProperty(SKOSNO.betydningsbeskrivelse, resource);
        return parent;
    }

}
