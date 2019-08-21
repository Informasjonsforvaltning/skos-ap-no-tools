package no.difi.skos_ap_no.begrep.builder.Begrepssamling.Begrep.Betydningsbeskrivelse.Kildebeskrivelse;

import no.difi.skos_ap_no.concept.builder.Conceptcollection.Concept.Meaning.Sourcedescription.SourceType;


public class ForholdTilKilde {

    public enum Forhold {
        SitatFraKilde,
        BasertPåKilde,
        Egendefinert;

        public SourceType.Source toSource() {
            switch(this) {
                case SitatFraKilde: return SourceType.Source.QuoteFrom;
                case BasertPåKilde: return SourceType.Source.BasedOn;
                case Egendefinert: return SourceType.Source.Userdefined;
            }
            return null;
        }
    }

}
