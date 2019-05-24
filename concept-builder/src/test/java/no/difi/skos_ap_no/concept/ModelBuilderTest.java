package no.difi.skos_ap_no.concept;


import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.Test;

class ModelBuilderTest {

    @Test
    void testBuilder() {

        Model model = ModelBuilder.builder()
            .collectionBuilder("http://my.org/collectino/first")
                .publisher("123456789")
                .conceptBuilder("http://my.org/concept/application")
                    .publisher("123456789")
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
}
