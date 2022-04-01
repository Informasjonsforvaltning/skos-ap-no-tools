package no.norge.data.skos_ap_no.concept;

import no.norge.data.skos_ap_no.concept.builder.generelt.ForholdTilKildeType;
import no.norge.data.skos_ap_no.begrep.builder.ModellBuilder;
import no.norge.data.skos_ap_no.concept.builder.generelt.MålgruppeType;
import no.norge.data.skos_ap_no.concept.builder.generic.AudienceType;
import no.norge.data.skos_ap_no.concept.builder.generic.SourceType;
import no.norge.data.skos_ap_no.concept.builder.ModelBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RIOT;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
                    .collectionBuilder("http://my.org/collection/first")
                        .name("CollectionName1")
                        .publisher("Publisher1")
                        .description("Description1")
                        .contactPointBuilder()
                            .organizationUnit("ContactPointOrg1")
                            .email("org1@invalid.org")
                            .telephone("1")
                            .build()
                        .conceptBuilder("http://my.org/concept/Concept1")
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
                                .audience(AudienceType.Audience.Public)
                                .build()
                            .hiddenLabelBuilder()
                                .label("HiddenLabel1", "en")
                                .label("FrarådetTerm1", "nb")
                                .build()
                            .datastructureLabelBuilder()
                                .label("DatastructureLabel1", "en")
                                .label("DatastrukturTerm1", "nb")
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
                                .example("Example1", "en")
                                .example("Eksempel", "nb")
                                .scopeNote("ScopeNote1", "en")
                                .scopeNote("Merknad1", "nb")
                                .audience(AudienceType.Audience.Specialist)
                                .scopeBuilder()
                                    .label("scopeLabel1", "en")
                                    .label("omfangTekst1", "nb")
                                    .seeAlso("http://invalid.org/scope/Scope1")
                                    .build()
                                .modified(LocalDate.of(2018, 10, 31))
                                .build()
                            .alternativeWordingBuilder()
                                .text("AlternativeWording1", "en")
                                .build()
                            .associativeRelationBuilder()
                                .description("description", "en")
                                .description("beskrivelse", "nb")
                                .modified(LocalDate.of(2019, 8, 19))
                                .associatedConcept("http://my.org/concept/Concept2")
                                .build()
                            .build()
                        .conceptBuilder("http://my.org/concept/Concept2")
                            .seeAlso("http://my.org/concept/Concept1")
                            .genericRelationBuilder()
                                .divisioncriterion("divisioncriterion", "en")
                                .divisioncriterion("inndelingskriterium", "nb")
                                .modified(LocalDate.of(2019, 8, 20))
                                .broaderConcept("http://my.org/concept/Concept3")
                                .build()
                            .build()
                        .conceptBuilder("http://my.org/concept/Concept3")
                            .seeAlso("http://my.org/concept/Concept1")
                            .genericRelationBuilder()
                                .divisioncriterion("divisioncriterion", "en")
                                .divisioncriterion("inndelingskriterium", "nb")
                                .modified(LocalDate.of(2019, 8, 21))
                                .narrowerConcept("http://my.org/concept/Concept2")
                                .build()
                            .build()
                        .conceptBuilder("http://my.org/concept/organisatoriskEnhet")
                            .prefLabelBuilder()
                                .label("organisatorisk enhet", "nb")
                                .modified(LocalDate.of(2017, 10, 31))
                                .build()
                            .partitiveRelationBuilder()
                                .divisioncriterion("divisioncriterion", "en")
                                .divisioncriterion("funksjon", "nb")
                                .modified(LocalDate.of(2022, 4, 1))
                                .broaderConcept("http://my.org/concept/virksomhet")
                                .build()
                            .build()
                        .conceptBuilder("http://my.org/concept/virksomhet")
                            .partitiveRelationBuilder()
                                .divisioncriterion("divisioncriterion", "en")
                                .divisioncriterion("funksjon", "nb")
                                .modified(LocalDate.of(2022, 4, 1))
                                .narrowerConcept("http://my.org/concept/organisatoriskEnhet")
                                .build()
                            .build()
                        .build()
                    .collectionBuilder("http://my.org/collection/second")
                        .name("CollectionName2")
                        .publisher("Publisher2")
                        .conceptBuilder("http://my.second.org/concept/Concept with space")
                            .build()
                        .build()
                    .build();

        Model fasitModel = ModelFactory.createDefaultModel();
        fasitModel.read(resourceAsReader("fasit.ttl"), "", "text/turtle");

        if (!model.isIsomorphicWith(fasitModel)) {
            Writer writer = new StringWriter();
            model.write(writer, "TURTLE");
            throw new RuntimeException("Models are not isomorphic. Got actual:\n\n" + writer.toString());
        }
    }

    @Test
    void norwegianTestBuilder() {

        Model model =
                ModellBuilder.builder()
                    .begrepssamlingBuilder("http://my.org/collection/first")
                        .navn("CollectionName1")
                        .ansvarligVirksomhet("Publisher1")
                        .beskrivelse("Description1")
                        .kontaktpunktBuilder()
                            .organisasjonsenhet("ContactPointOrg1")
                            .epost("org1@invalid.org")
                            .telefon("1")
                            .build()
                        .begrepBuilder("http://my.org/concept/Concept1")
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
                                .målgruppe(MålgruppeType.Målgruppe.Allmennheten)
                                .build()
                            .frarådetTermBuilder()
                                .term("HiddenLabel1", "en")
                                .term("FrarådetTerm1", "nb")
                                .build()
                            .datastrukturTermBuilder()
                                .term("DatastructureLabel1", "en")
                                .term("DatastrukturTerm1", "nb")
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
                                    .forholdTilKilde(ForholdTilKildeType.ForholdTilKilde.BasertPåKilde)
                                    .build()
                                .eksempel("Example1", "en")
                                .eksempel("Eksempel", "nb")
                                .merknad("ScopeNote1", "en")
                                .merknad("Merknad1", "nb")
                                .målgruppe(MålgruppeType.Målgruppe.Fagspesialist)
                                .omfangBuilder()
                                    .tekst("scopeLabel1", "en")
                                    .tekst("omfangTekst1", "nb")
                                    .seOgså("http://invalid.org/scope/Scope1")
                                    .build()
                                .sistOppdatert(LocalDate.of(2018, 10, 31))
                                .build()
                            .alternativFormuleringBuilder()
                                .tekst("AlternativeWording1", "en")
                                .build()
                            .assosiativRelasjonBuilder()
                                .beskrivelse("description", "en")
                                .beskrivelse("beskrivelse", "nb")
                                .sistOppdatert(LocalDate.of(2019, 8, 19))
                                .assosiertBegrep("http://my.org/concept/Concept2")
                                .build()
                            .build()
                        .begrepBuilder("http://my.org/concept/Concept2")
                            .seOgså("http://my.org/concept/Concept1")
                            .generiskRelasjonBuilder()
                                .inndelingskriterium("divisioncriterion", "en")
                                .inndelingskriterium("inndelingskriterium", "nb")
                                .sistOppdatert(LocalDate.of(2019, 8, 20))
                                .overordnetBegrep("http://my.org/concept/Concept3")
                                .build()
                            .build()
                        .begrepBuilder("http://my.org/concept/Concept3")
                            .seOgså("http://my.org/concept/Concept1")
                            .generiskRelasjonBuilder()
                                .inndelingskriterium("divisioncriterion", "en")
                                .inndelingskriterium("inndelingskriterium", "nb")
                                .sistOppdatert(LocalDate.of(2019, 8, 21))
                                .underordnetBegrep("http://my.org/concept/Concept2")
                                .build()
                            .build()
                        .begrepBuilder("http://my.org/concept/organisatoriskEnhet")
                            .anbefaltTermBuilder()
                                .term("organisatorisk enhet", "nb")
                                .sistOppdatert(LocalDate.of(2017, 10, 31))
                                .build()
                            .partitivRelasjonBuilder()
                                .inndelingskriterium("divisioncriterion", "en")
                                .inndelingskriterium("funksjon", "nb")
                                .sistOppdatert(LocalDate.of(2022, 4, 1))
                                .overordnetBegrep("http://my.org/concept/virksomhet")
                                .build()
                            .build()
                        .begrepBuilder("http://my.org/concept/virksomhet")
                            .partitivRelasjonBuilder()
                                .inndelingskriterium("divisioncriterion", "en")
                                .inndelingskriterium("funksjon", "nb")
                                .sistOppdatert(LocalDate.of(2022, 4, 1))
                                .underordnetBegrep("http://my.org/concept/organisatoriskEnhet")
                                .build()
                            .build()
                        .build()
                    .begrepssamlingBuilder("http://my.org/collection/second")
                        .navn("CollectionName2")
                        .ansvarligVirksomhet("Publisher2")
                        .begrepBuilder("http://my.second.org/concept/Concept with space")
                            .build()
                        .build()
                    .build();

        Model fasitModel = ModelFactory.createDefaultModel();
        fasitModel.read(resourceAsReader("fasit.ttl"), "", "text/turtle");

        if (!model.isIsomorphicWith(fasitModel)) {
            Writer writer = new StringWriter();
            model.write(writer, "TURTLE");
            throw new RuntimeException("Models are not isomorphic. Got actual:\n\n" + writer.toString());
        }
    }

    @Test
    void singleConceptTestBuilder() {

        Model model =
            ModelBuilder.builder()
                .conceptBuilder("http://my.org/concept/Concept1")
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
                    .audience(AudienceType.Audience.Public)
                    .build()
                .hiddenLabelBuilder()
                    .label("HiddenLabel1", "en")
                    .label("FrarådetTerm1", "nb")
                    .build()
                .datastructureLabelBuilder()
                    .label("DatastructureLabel1", "en")
                    .label("DatastrukturTerm1", "nb")
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
                    .example("Example1", "en")
                    .example("Eksempel", "nb")
                    .scopeNote("ScopeNote1", "en")
                    .scopeNote("Merknad1", "nb")
                    .audience(AudienceType.Audience.Specialist)
                    .scopeBuilder()
                        .label("scopeLabel1", "en")
                        .label("omfangTekst1", "nb")
                        .seeAlso("http://invalid.org/scope/Scope1")
                        .build()
                    .modified(LocalDate.of(2018, 10, 31))
                    .build()
                .alternativeWordingBuilder()
                    .text("AlternativeWording1", "en")
                    .build()
                .associativeRelationBuilder()
                    .description("description", "en")
                    .description("beskrivelse", "nb")
                    .modified(LocalDate.of(2019, 8, 19))
                    .associatedConcept("http://my.org/concept/Concept2")
                    .build()
                .buildSingleConcept()
            .build();

        Model fasitModel = ModelFactory.createDefaultModel();
        fasitModel.read(resourceAsReader("begrep.ttl"), "", "text/turtle");

        if (!model.isIsomorphicWith(fasitModel)) {
            Writer writer = new StringWriter();
            model.write(writer, "TURTLE");
            throw new RuntimeException("Models are not isomorphic. Got actual:\n\n" + writer.toString());
        }
    }

}
