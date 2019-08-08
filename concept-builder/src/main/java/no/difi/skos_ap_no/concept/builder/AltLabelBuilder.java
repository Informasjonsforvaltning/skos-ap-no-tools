package no.difi.skos_ap_no.concept.builder;

import org.apache.jena.vocabulary.SKOSXL;

import java.time.LocalDate;


public class AltLabelBuilder extends LabelBuilder {

    AltLabelBuilder(final ConceptBuilder parent) {
        super(parent);
    }

    public AltLabelBuilder label(final String labelText, final String language) {
        super.label(labelText, language);
        return this;
    }

    public AltLabelBuilder modified(final LocalDate date) {
        super.modified(date);
        return this;
    }

    public ConceptBuilder build() {
        getParent().getResource().addProperty(SKOSXL.altLabel, getResource());
        return getParent();
    }

}
