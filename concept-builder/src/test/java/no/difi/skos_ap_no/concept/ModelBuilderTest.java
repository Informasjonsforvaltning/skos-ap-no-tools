package no.difi.skos_ap_no.concept;


import no.difi.skos_ap_no.concept.builder.generelt.ForholdTilKilde;
import no.difi.skos_ap_no.begrep.builder.ModellBuilder;
import no.difi.skos_ap_no.concept.builder.generic.SourceType;
import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RIOT;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

class ModelBuilderTest {

    private Reader resourceAsReader(final String resourceName) {
        return new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourceName), StandardCharsets.UTF_8);
    }

    @BeforeAll
    static void init() {
        RIOT.init();
    }

    @Test
    void testBuilder() {

        Model model = ModelBuilder.builder()
            .collectionBuilder("http://my.org/collectino/first")
                .name("Collection1")
                .publisher("123456789")
                .conceptBuilder("http://my.org/concept/application")
                    .definitionBuilder()
                        .text("an application is a program", "en")
                        .sourcedescriptionBuilder()
                            .sourceBuilder()
                                .label("see the law", "en")
                                .seeAlso("https://lovdata.no/NL/lov/1980-02-08-2/5-1")
                                .build()
                            .sourcetype(SourceType.Source.BasedOn)
                            .build()
                        .audience("allmenheten", "nb")
                        .scopeNote("dette gjelder intill videre", "nb")
                        .modified(LocalDate.of(2017, 10, 20))
                        .build()
                    .alternativeWordingBuilder()
                        .text("can be a program also", "en")
                        .build()
                    .subject("tjenester 3.0", "no")
                    .identifier("t3:application")
                    .prefLabelBuilder()
                        .label("application", "en")
                        .label("applikasjon", "no")
                        .build()
                    .altLabelBuilder()
                        .label("app", "en")
                        .build()
                    .hiddenLabelBuilder()
                        .label("service", "en")
                        .label("tjeneste", "no")
                        .build()
                    .contactPointBuilder()
                        .organizationUnit("Contact Dep")
                        .email("æ}me@org.no")
                        .telephone("+4755555555")
                        .build()
                    .periodOfTimeBuilder()
                        .validFromIncluding(LocalDate.of(2017, 1, 1))
                        .validToIncluding(LocalDate.of(2017, 12, 31))
                        .build()
                    .modified(LocalDate.now())
                    .build()
                .conceptBuilder("https://my.org/concept/term")
                    .prefLabelBuilder()
                        .label("term", "en")
                        .build()
                    .build()
                .conceptBuilder("https://my.org/concept/rest")
                    .altLabelBuilder()
                        .label("Representational State Transfer", "en")
                        .build()
                    .replaces("https://my.org/concept/term")
                    .replacedBy("http://my.org/collectino/first")
                    .build()
                .build()
            .build();

        Model fasitModel = ModelFactory.createDefaultModel();
        fasitModel.read(resourceAsReader("fasit.ttl"), "", "text/turtle");

        Writer writer = new StringWriter();
        model.write(writer, "TURTLE");
        Assert.isTrue(model.isIsomorphicWith(fasitModel), "\nModels are not isomorphic. Got actual:\n" + writer.toString());
    }

    @Test
    void norwegianTestBuilder() {

        Model model = ModellBuilder.builder()
            .begrepssamlingBuilder("http://my.org/collectino/first")
                .navn("Samling1")
                .ansvarligVirksomhet("123456789")
                .kontaktpunktBuilder()
                    .organisasjonsenhet("asdf")
                    .build()
                .begrepBuilder("http://my.org/concept/application")
                    .definisjonBuilder()
                        .tekst("an application is a program", "en")
                        .kildebeskrivelseBuilder()
                            .kildeBuilder()
                                .tekst("see the law", "en")
                                .seOgså("https://lovdata.no/NL/lov/1980-02-08-2/5-1")
                                .build()
                            .forholdTilKilde(ForholdTilKilde.Forhold.BasertPåKilde)
                            .build()
                        .målgruppe("allmenheten", "nb")
                        .merknad("dette gjelder intill videre", "nb")
                        .sistOppdatert(LocalDate.of(2017, 10, 20))
                        .build()
                    .alternativFormuleringBuilder()
                        .tekst("can be a program also", "en")
                        .build()
                    .fagområde("tjenester 3.0", "no")
                    .identifikator("t3:application")
                    .anbefaltTermBuilder()
                        .term("application", "en")
                        .term("applikasjon", "no")
                        .sistOppdatert(LocalDate.of(2016, 5, 17))
                        .build()
                    .tillattTermBuilder()
                        .term("app", "en")
                        .build()
                    .frarådetTermBuilder()
                        .term("service", "en")
                        .term("tjeneste", "no")
                        .build()
                    .kontaktpunktBuilder()
                        .organisasjonsenhet("Contact Dep")
                        .epost("me@org.no")
                        .telefon("+4755555555")
                        .build()
                    .gyldighetsperiodeBuilder()
                        .gyldigFraOgMed(LocalDate.of(2017, 1, 1))
                        .gyldigTilOgMed(LocalDate.of(2017, 12, 31))
                        .build()
                    .sistOppdatert(LocalDate.now())
                    .build()
                .begrepBuilder("https://my.org/concept/term")
                    .anbefaltTermBuilder()
                        .term("term", "en")
                        .build()
                    .build()
                .begrepBuilder("https://my.org/concept/rest")
                    .tillattTermBuilder()
                        .term("Representational State Transfer", "en")
                        .build()
                    .erstatter("https://my.org/concept/term")
                    .erstattesAv("http://my.org/collectino/first")
                    .build()
                .build()
            .build();

        Model fasitModel = ModelFactory.createDefaultModel();
        fasitModel.read(resourceAsReader("fasit.ttl"), "", "text/turtle");

        Writer writer = new StringWriter();
        model.write(writer, "TURTLE");
        Assert.isTrue(model.isIsomorphicWith(fasitModel), "\nModels are not isomorphic. Got actual:\n" + writer.toString());
    }
}
