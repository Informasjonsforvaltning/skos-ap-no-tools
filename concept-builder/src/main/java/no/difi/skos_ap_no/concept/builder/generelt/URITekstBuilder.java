package no.difi.skos_ap_no.concept.builder.generelt;


import no.difi.skos_ap_no.concept.builder.generic.URITextBuilder;

public abstract class URITekstBuilder<T> {


    public T tekst(final String tekst, final String språk) {
        getURITextBuilder().label(tekst, språk);
        return (T)this;
    }

    public T seOgså(final String seOgsåUrl) {
        getURITextBuilder().seeAlso(seOgsåUrl);
        return (T)this;
    }

    public abstract URITextBuilder getURITextBuilder();

}