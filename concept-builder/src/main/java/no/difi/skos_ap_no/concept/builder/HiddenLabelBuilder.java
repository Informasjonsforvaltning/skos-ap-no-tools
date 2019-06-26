package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.vocabulary.SKOSXL;

import java.time.LocalDate;


public class HiddenLabelBuilder extends LabelBuilder {

    HiddenLabelBuilder(final ConceptBuilder parent) {
        super(parent);
    }

    public HiddenLabelBuilder label(final String labelText, final String language) {
        super.label(labelText, language);
        return this;
    }

    public HiddenLabelBuilder modified(final LocalDate date) {
        super.modified(date);
        return this;
    }

    public ConceptBuilder build() {
        getParent().getResource().addProperty(SKOSXL.hiddenLabel, getResource());
        return getParent();
    }

}
