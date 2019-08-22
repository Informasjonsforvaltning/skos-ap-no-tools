package no.difi.skos_ap_no.concept.builder.generic;


public class SourceType {

    public enum Source {
        QuoteFrom("skosno:sitatFraKilde"),
        BasedOn("skosno:basertPåKilde "),
        Userdefined("skosno:egendefinert");

        private String uri;

        Source(final String uri) {
            this.uri = uri;
        }

        @Override
        public String toString() {
            return uri;
        }
    }

}
