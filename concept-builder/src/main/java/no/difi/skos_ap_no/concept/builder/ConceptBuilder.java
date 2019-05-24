package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.SKOS;
import org.apache.jena.vocabulary.SKOSXL;


public class ConceptBuilder {

    private CollectionBuilder parent;
    private Model model;
    private Resource resource;


    ConceptBuilder(final CollectionBuilder collectionBuilder, final Model model, final String uri) {
        this.parent = collectionBuilder;
        this.model = model;

        resource = model.createResource(uri)
                .addProperty(RDF.type, SKOS.Concept);
    }

    public Model getModel() {
        return model;
    }

    public Resource getResource() {
        return resource;
    }

    public CollectionBuilder build() {
        parent.getResource().addProperty(SKOS.member, getResource());

        return parent;
    }

    public DefinitionBuilder definitionBuilder() {
        return new DefinitionBuilder(this, SKOSNO.Definisjon);
    }

    public DefinitionBuilder alternativeDefinitionBuilder() {
        return new DefinitionBuilder(this, SKOSNO.AlternativFormulering);
    }

    public ConceptBuilder publisher(final String organizationNumber) {
        Resource publisher = model.createResource("https://data.brreg.no/enhetsregisteret/api/enheter/" + organizationNumber);
        resource.addProperty(DCTerms.publisher, publisher);

        return this;
    }

    public ConceptBuilder identifier(final String identifier) {
        resource.addProperty(DCTerms.identifier, identifier);

        return this;
    }

    public ConceptBuilder preferredTerm(final String term, final String language) {

        model.add(resource, SKOSXL.prefLabel, createSkosxlLabel(term, language));

        return this;
    }

    public ConceptBuilder alternativeTerm(final String term, final String language) {

        resource.addProperty(SKOSXL.altLabel, createSkosxlLabel(term, language));

        return this;
    }

    public ConceptBuilder deprecatedTerm(final String term, final String language) {

        resource.addProperty(SKOSXL.hiddenLabel, createSkosxlLabel(term, language));

        return this;
    }

    public ConceptBuilder subject(final String subject, final String language) {
        resource.addProperty(DCTerms.subject, subject, language);

        return this;
    }

    public ConceptBuilder example(final String example, final String language) {
        resource.addProperty(SKOS.example, example, language);

        return this;
    }

    public ContactPointBuilder contactPointBuilder() {

        return new ContactPointBuilder(this);
    }

    private Resource createSkosxlLabel(final String labelText, final String language) {
        Resource resource = model.createResource(SKOSXL.Label);
        resource.addProperty(SKOSXL.literalForm, labelText, language);
        return resource;
    }

}
