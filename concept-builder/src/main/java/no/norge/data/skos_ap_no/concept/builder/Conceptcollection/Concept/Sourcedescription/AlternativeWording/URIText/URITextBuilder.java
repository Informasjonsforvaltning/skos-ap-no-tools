package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.URIText;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.AlternativeWording.AlternativeWordingBuilder;
import org.apache.jena.rdf.model.Property;


public class URITextBuilder extends no.norge.data.skos_ap_no.concept.builder.generic.URITextBuilder<URITextBuilder> {

    private AlternativeWordingBuilder parent;
    private Property propertyClass;


    public URITextBuilder(final AlternativeWordingBuilder alternativeWordingBuilder, final Property propertyClass) {
        super(alternativeWordingBuilder.getModel());
        this.parent = alternativeWordingBuilder;
        this.propertyClass = propertyClass;
    }

    public AlternativeWordingBuilder build() {
        parent.getResource().addProperty(propertyClass, getResource());
        return parent;
    }

}
