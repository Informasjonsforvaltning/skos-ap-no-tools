package no.difi.skos_ap_no.concept;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import no.difi.skos_ap_no.concept.builder.ModelBuilder;
import no.difi.skos_ap_no.concept.reader.ModelReader;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class ModelReaderTest {

    @Test
    void readAConcept() {
        Model conceptModel = ModelBuilder.builder()
            .collectionBuilder("http://my.org/collectino/first")
                .name("name")
                .publisher("123456789")
                .conceptBuilder("http://my.org/concept/application")
                    .definitionBuilder()
                        .text("an application is a program", "en")
                        .sourcedescriptionBuilder()
                            .sourceBuilder()
                                .label("see the law", "en")
                                .seeAlso("https://lovdata.no/NL/lov/1980-02-08-2/5-1")
                                .build()
                            .build()
                        .audience("allmenheten", "nb")
                        .scopeNote("dette gjelder intill videre", "nb")
                        .modified(LocalDate.of(2017, 10, 20))
                        .build()
                    .alternativeDefinitionBuilder()
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
                        .email("me@org.no")
                        .telephone("+4755555555")
                        .build()
                    .build()
                .build()
            .build();

        ModelReader reader = new ModelReader(conceptModel);

        List<Concept> concepts = reader.getConcepts();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //System.out.println(gson.toJson(concepts));
    }

    @Test
    void readFromFile() {

        Model model = ModelFactory.createDefaultModel();

        model.read("concept-model.ttl");

        List<Concept> concepts = new ModelReader(model).getConcepts();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //System.out.println(gson.toJson(concepts));
    }
}
