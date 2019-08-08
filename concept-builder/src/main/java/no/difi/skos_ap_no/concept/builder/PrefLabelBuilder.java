package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.vocabulary.SKOSXL;

import java.time.LocalDate;


public class PrefLabelBuilder extends LabelBuilder {

    PrefLabelBuilder(final ConceptBuilder parent) {
        super(parent);
    }

    public PrefLabelBuilder label(final String labelText, final String language) {
        super.label(labelText, language);
        return this;
    }

    public PrefLabelBuilder modified(final LocalDate date) {
        super.modified(date);
        return this;
    }

    public ConceptBuilder build() {
        getParent().getResource().addProperty(SKOSXL.prefLabel, getResource());
        return getParent();
    }

}
