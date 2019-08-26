package no.difi.skos_ap_no.concept.builder.generic;


import no.difi.skos_ap_no.concept.builder.SKOSNO;

public class SourceType {

    public enum Source {
        QuoteFrom(SKOSNO.NS + "sitatFraKilde"),
        BasedOn(SKOSNO.NS + "basertPåKilde"),
        Userdefined(SKOSNO.NS + "egendefinert");

        private String uri;

        Source(final String uri) {
            this.uri = uri;
        }

        @Override
        public String toString() {
            return uri;
        }

        public Source fromString(final String uri) {
            if (QuoteFrom.uri.equals(uri)) {
                return QuoteFrom;
            } else if (BasedOn.uri.equals(uri)) {
                return BasedOn;
            } else if (Userdefined.uri.equals(uri)) {
                return Userdefined;
            }
            return null;
        }
    }

}
