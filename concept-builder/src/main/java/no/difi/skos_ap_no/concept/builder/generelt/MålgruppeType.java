package no.difi.skos_ap_no.concept.builder.generelt;

import no.difi.skos_ap_no.concept.builder.generic.AudienceType;


public class MålgruppeType {

    public enum Målgruppe {
        Allmennheten,
        Fagspesialist;

        public AudienceType.Audience toAudience() {
            switch(this) {
                case Allmennheten: return AudienceType.Audience.Public;
                case Fagspesialist: return AudienceType.Audience.Specialist;
            }
            return null;
        }
    }

}
