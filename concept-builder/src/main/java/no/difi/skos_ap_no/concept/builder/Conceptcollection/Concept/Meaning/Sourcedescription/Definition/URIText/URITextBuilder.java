package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.URIText;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.DefinitionBuilder;
import org.apache.jena.vocabulary.DCTerms;


public class URITextBuilder extends no.difi.skos_ap_no.concept.builder.generic.URITextBuilder<URITextBuilder> {

    private DefinitionBuilder parent;


    public URITextBuilder(final DefinitionBuilder definitionBuilder) {
        super(definitionBuilder.getModel());
        this.parent = definitionBuilder;
    }

    public DefinitionBuilder build() {
        parent.getResource().addProperty(DCTerms.source, getResource());
        return parent;
    }

}
