package no.difi.skos_ap_no.concept.builder.generic;


public class AudienceType {

    public enum Audience {
        Public("skosno:allmennheten"),
        Specialist("skosno:fagspesialist");

        private String uri;

        Audience(final String uri) {
            this.uri = uri;
        }

        @Override
        public String toString() {
            return uri;
        }
    }

}
