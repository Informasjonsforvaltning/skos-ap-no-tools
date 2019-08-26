package no.difi.skos_ap_no.concept.builder.generic;


import no.difi.skos_ap_no.concept.builder.SKOSNO;

public class AudienceType {

    public enum Audience {
        Public(SKOSNO.NS + "allmennheten"),
        Specialist(SKOSNO.NS + "fagspesialist");

        private String uri;

        Audience(final String uri) {
            this.uri = uri;
        }

        @Override
        public String toString() {
            return uri;
        }

        public Audience fromString(final String uri) {
            if (Public.uri.equals(uri)) {
                return Public;
            } else if (Specialist.uri.equals(uri)) {
                return Specialist;
            }
            return null;
        }
    }

}
