package no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.URIText;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.Definition.DefinitionBuilder;
import org.apache.jena.rdf.model.Property;


public class URITextBuilder extends no.difi.skos_ap_no.concept.builder.generic.URITextBuilder<URITextBuilder> {

    private DefinitionBuilder parent;
    private Property propertyClass;


    public URITextBuilder(final DefinitionBuilder definitionBuilder, final Property propertyClass) {
        super(definitionBuilder.getModel());
        this.parent = definitionBuilder;
        this.propertyClass = propertyClass;
    }

    public DefinitionBuilder build() {
        parent.getResource().addProperty(propertyClass, getResource());
        return parent;
    }

}
