package no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.SourceDescription;

import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.DefinitionBuilder;
import no.norge.data.skos_ap_no.concept.builder.Conceptcollection.Concept.Sourcedescription.Definition.SourceDescription.URIText.URITextBuilder;
import no.norge.data.skos_ap_no.concept.builder.generic.SourceType;
import no.norge.data.skos_ap_no.concept.builder.SKOSNO;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;


public class SourcedescriptionBuilder {

    private DefinitionBuilder parent;

    private SourceType.Source source;


    public SourcedescriptionBuilder(final DefinitionBuilder parent) {
        this.parent = parent;
    }

    public URITextBuilder sourceBuilder() {
        return new URITextBuilder(this);
    }

    public SourcedescriptionBuilder sourcetype(final SourceType.Source source) {
        this.source = source;
        return this;
    }

    public Model getModel() {
        return parent.getModel();
    }

    public Resource getResource() {
        return parent.getResource();
    }

    public DefinitionBuilder build() {
        if (source != null) {
            getResource().addProperty(SKOSNO.forholdTilKilde, parent.getModel().createResource(source.toString()));
        }

        return parent;
    }

}
