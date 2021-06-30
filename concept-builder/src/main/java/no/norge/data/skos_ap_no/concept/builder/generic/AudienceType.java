package no.norge.data.skos_ap_no.concept.builder.generic;


import no.norge.data.skos_ap_no.concept.builder.SKOSNO;

public class AudienceType {

    public enum Audience {
        Public(SKOSNO.allmennheten.getURI()),
        Specialist(SKOSNO.fagspesialist.getURI());

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
