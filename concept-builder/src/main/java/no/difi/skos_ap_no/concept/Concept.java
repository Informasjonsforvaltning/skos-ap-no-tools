package no.difi.skos_ap_no.concept;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class Concept {

    @ApiModelProperty("The uri of the concept [dct:identifier]")
    private String uri;

    @ApiModelProperty("identifier")
    private String identifier;

    private Publisher publisher;

    @ApiModelProperty("The definition [skosno:Definisjon]")
    private Definition definition;

    @ApiModelProperty("The alternative definition [skosno:Definisjon]")
    private Definition alternativeDefinition;

    @ApiModelProperty("Subject [dct:subject]")
    private LanguageLiteral subject;

    @ApiModelProperty("Preferred labels [skosxl:prefLabel]")
    private LanguageLiteral prefLabel;

    @ApiModelProperty("Alternative labels [skos:altLabel]")
    private List<LanguageLiteral> altLabel;

    @ApiModelProperty("Hidden labels [skos:hiddenLabel]")
    private List<LanguageLiteral> hiddenLabel;

    @ApiModelProperty("Contact point [dcat:contactPoint]")
    private ContactPoint contactPoint;

    @ApiModelProperty("Example text [skos:example]")
    private LanguageLiteral example;


    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(final Publisher publisher) {
        this.publisher = publisher;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(final Definition definition) {
        this.definition = definition;
    }

    public Definition getAlternativeDefinition() {
        return alternativeDefinition;
    }

    public void setAlternativeDefinition(final Definition alternativeDefinition) {
        this.alternativeDefinition = alternativeDefinition;
    }

    public LanguageLiteral getSubject() {
        return subject;
    }

    public void setSubject(final LanguageLiteral subject) {
        this.subject = subject;
    }

    public LanguageLiteral getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final LanguageLiteral prefLabel) {
        this.prefLabel = prefLabel;
    }

    public List<LanguageLiteral> getAltLabel() {
        return altLabel;
    }

    public void setAltLabel(final List<LanguageLiteral> altLabel) {
        this.altLabel = altLabel;
    }

    public List<LanguageLiteral> getHiddenLabel() {
        return hiddenLabel;
    }

    public void setHiddenLabel(final List<LanguageLiteral> hiddenLabel) {
        this.hiddenLabel = hiddenLabel;
    }

    public ContactPoint getContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(final ContactPoint contactPoint) {
        this.contactPoint = contactPoint;
    }

    public LanguageLiteral getExample() {
        return example;
    }

    public void setExample(final LanguageLiteral example) {
        this.example = example;
    }

}