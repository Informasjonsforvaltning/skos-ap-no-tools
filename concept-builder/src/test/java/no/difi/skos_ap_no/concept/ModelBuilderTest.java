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

        Model model =
                ModelBuilder.builder()
                    .collectionBuilder("http://my.org/collectino/first")
                        .name("CollectionName1")
                        .publisher("Publisher1")
                        .description("Description1")
                        .contactPointBuilder()
                            .organizationUnit("ContactPointOrg1")
                            .email("org1@invalid.org")
                            .telephone("1")
                            .build()
                        .conceptBuilder("Concept1")
                            .publisher("Publisher1.1")
                            .subject("Subject1", "en")
                            .subject("Fagområde1", "nb")
                            .domainOfUse("domainOfUse1", "en")
                            .domainOfUse("bruksområde1", "nb")
                            .periodOfTimeBuilder()
                                .validFromIncluding(LocalDate.of(2017, 10, 20))
                                .validToIncluding(LocalDate.of(2037, 10, 19))
                                .build()
                            .contactPointBuilder()
                                .organizationUnit("ContactPointOrg1.1")
                                .email("org1.1@invalid.org")
                                .telephone("11")
                                .build()
                            .modified(LocalDate.of(2019, 8, 22))
                            .prefLabelBuilder()
                                .label("PrefLabel1", "en")
                                .label("AnbefaltTerm1", "nb")
                                .modified(LocalDate.of(2017, 10, 31))
                                .build()
                            .altLabelBuilder()
                                .label("AltLabel1", "en")
                                .label("TillattTerm1", "nb")
                                .build()
                            .hiddenLabelBuilder()
                                .label("HiddenLabel1", "en")
                                .label("FrarådetTerm1", "nb")
                                .build()
                            .definitionBuilder()
                                .text("Definition1", "en")
                                .text("Definisjon1", "nb")
                                .sourcedescriptionBuilder()
                                    .sourceBuilder()
                                        .seeAlso("http://invalid.org/concept2")
                                        .label("Source1", "en")
                                        .label("Kilde1", "nb")
                                        .build()
                                    .sourcetype(SourceType.Source.BasedOn)
                                    .build()
                                .scopeNote("ScopeNote1", "en")
                                .scopeNote("Merknad1", "nb")
                                .audience("Audience1", "en")
                                .audience("Målgruppe1", "nb")
                                .modified(LocalDate.of(2018, 10, 31))
                                .build()
                            .alternativeWordingBuilder()
                                .text("AlternativeWording1", "en")
                                .build()
                            .build()
                        .conceptBuilder("Concept2")
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

        Model model =
                ModellBuilder.builder()
                    .begrepssamlingBuilder("http://my.org/collectino/first")
                        .navn("CollectionName1")
                        .ansvarligVirksomhet("Publisher1")
                        .beskrivelse("Description1")
                        .kontaktpunktBuilder()
                            .organisasjonsenhet("ContactPointOrg1")
                            .epost("org1@invalid.org")
                            .telefon("1")
                            .build()
                        .begrepBuilder("Concept1")
                            .ansvarligVirksomhet("Publisher1.1")
                            .fagområde("Subject1", "en")
                            .fagområde("Fagområde1", "nb")
                            .bruksområde("domainOfUse1", "en")
                            .bruksområde("bruksområde1", "nb")
                            .gyldighetsperiodeBuilder()
                                .gyldigFraOgMed(LocalDate.of(2017, 10, 20))
                                .gyldigTilOgMed(LocalDate.of(2037, 10, 19))
                                .build()
                            .kontaktpunktBuilder()
                                .organisasjonsenhet("ContactPointOrg1.1")
                                .epost("org1.1@invalid.org")
                                .telefon("11")
                                .build()
                            .sistOppdatert(LocalDate.of(2019, 8, 22))
                            .anbefaltTermBuilder()
                                .term("PrefLabel1", "en")
                                .term("AnbefaltTerm1", "nb")
                                .sistOppdatert(LocalDate.of(2017, 10, 31))
                                .build()
                            .tillattTermBuilder()
                                .term("AltLabel1", "en")
                                .term("TillattTerm1", "nb")
                                .build()
                            .frarådetTermBuilder()
                                .term("HiddenLabel1", "en")
                                .term("FrarådetTerm1", "nb")
                                .build()
                            .definisjonBuilder()
                                .tekst("Definition1", "en")
                                .tekst("Definisjon1", "nb")
                                .kildebeskrivelseBuilder()
                                    .kildeBuilder()
                                        .seOgså("http://invalid.org/concept2")
                                        .tekst("Source1", "en")
                                        .tekst("Kilde1", "nb")
                                        .build()
                                    .forholdTilKilde(ForholdTilKilde.Forhold.BasertPåKilde)
                                    .build()
                                .merknad("ScopeNote1", "en")
                                .merknad("Merknad1", "nb")
                                .målgruppe("Audience1", "en")
                                .målgruppe("Målgruppe1", "nb")
                                .sistOppdatert(LocalDate.of(2018, 10, 31))
                                .build()
                            .alternativFormuleringBuilder()
                                .tekst("AlternativeWording1", "en")
                                .build()
                            .build()
                        .begrepBuilder("Concept2")
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
