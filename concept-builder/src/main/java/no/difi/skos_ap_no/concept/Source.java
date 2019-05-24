package no.difi.skos_ap_no.concept;


public class Source {

    private String uri;
    private LanguageLiteral prefLabel;


    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    public LanguageLiteral getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final LanguageLiteral prefLabel) {
        this.prefLabel = prefLabel;
    }

}
