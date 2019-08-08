package no.difi.skos_ap_no.concept;


public class Publisher {

    private String uri;
    private String identifier;
    private String name;
    private LanguageLiteral prefLabel;


    public Publisher(String orgnr) {
        this.identifier = orgnr;
        this.uri = "https://data.brreg.no/enhetsregisteret/api/enheter/" + orgnr;
    }

    public Publisher(String orgnr, String uri) {
        this.identifier = orgnr;
        this.uri = uri;
    }

    public Publisher() {
        // Default constructor needed for frameworks
    }

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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LanguageLiteral getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final LanguageLiteral prefLabel) {
        this.prefLabel = prefLabel;
    }

}