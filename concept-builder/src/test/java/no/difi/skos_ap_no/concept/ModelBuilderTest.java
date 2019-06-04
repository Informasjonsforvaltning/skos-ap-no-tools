package no.difi.skos_ap_no.concept;


import no.difi.skos_ap_no.begrep.builder.ModellBuilder;
import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.Test;

class ModelBuilderTest {

    @Test
    void testBuilder() {

        Model model = ModelBuilder.builder()
            .collectionBuilder("http://my.org/collectino/first", "123456789")
                .name("Collection1", "nb")
                .conceptBuilder("http://my.org/concept/application")
                    .definitionBuilder()
                        .text("an application is a program", "en")
                        .sourceBuilder()
                            .label("see the law", "en")
                            .seeAlso("https://lovdata.no/NL/lov/1980-02-08-2/5-1")
                            .build()
                        .audience("allmenheten", "nb")
                        .scopeNote("dette gjelder intill videre", "nb")
                        .modified("2017-10-20")
                        .build()
                    .alternativeDefinitionBuilder()
                        .text("can be a program also", "en")
                        .build()
                    .subject("tjenester 3.0", "no")
                    .identifier("t3:application")
                    .preferredTerm("application", "en")
                    .preferredTerm("applikasjon", "no")
                    .alternativeTerm("app", "en")
                    .deprecatedTerm("service", "en")
                    .deprecatedTerm("tjeneste", "no")
                    .contactPointBuilder()
                        .organizationUnit("Contact Dep")
                        .email("me@org.no")
                        .telephone("+4755555555")
                        .build()
                    .build()
                    .conceptBuilder("https://my.org/concept/term")
                        .preferredTerm("term", "en")
                    .build()
                    .conceptBuilder("https://my.org/concept/rest")
                        .alternativeTerm("Representational State Transfer", "en")
                    .build()
                .build()
            .build();

        model.write(System.out, "TURTLE");
    }

    @Test
    void norwegianTestBuilder() {

        Model model = ModellBuilder.builder()
            .begrepssamlingBuilder("http://my.org/collectino/first", "123456789")
                .navn("Samling1", "nb")
                .kontaktpunktBuilder()
                    .organisasjonsenhet("asdf")
                    .build()
                .begrepBuilder("http://my.org/concept/application")
                    .definisjonBuilder()
                        .tekst("an application is a program", "en")
                        .kildeBuilder()
                            .tekst("see the law", "en")
                            .seOgså("https://lovdata.no/NL/lov/1980-02-08-2/5-1")
                            .build()
                        .målgruppe("allmenheten", "nb")
                        .merknad("dette gjelder intill videre", "nb")
                        .sistOppdatert("2017-10-20")
                        .build()
                    .alternativFormuleringBuilder()
                        .tekst("can be a program also", "en")
                        .build()
                    .fagområde("tjenester 3.0", "no")
                    .identifikator("t3:application")
                    .anbefaltTerm("application", "en")
                    .anbefaltTerm("applikasjon", "no")
                    .tillattTerm("app", "en")
                    .frarådetTerm("service", "en")
                    .frarådetTerm("tjeneste", "no")
                    .kontaktpunktBuilder()
                        .organisasjonsenhet("Contact Dep")
                        .epost("me@org.no")
                        .telefon("+4755555555")
                        .build()
                    .build()
                    .begrepBuilder("https://my.org/concept/term")
                        .anbefaltTerm("term", "en")
                    .build()
                    .begrepBuilder("https://my.org/concept/rest")
                        .tillattTerm("Representational State Transfer", "en")
                    .build()
                .build()
            .build();

        model.write(System.out, "TURTLE");
    }
}
