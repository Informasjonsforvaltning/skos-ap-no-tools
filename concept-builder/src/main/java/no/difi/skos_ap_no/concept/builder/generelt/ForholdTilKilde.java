package no.difi.skos_ap_no.concept.builder.generelt;


import no.difi.skos_ap_no.concept.builder.generic.SourceType;

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
