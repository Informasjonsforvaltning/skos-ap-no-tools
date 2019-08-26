# skos-ap-no-tools concept-builder

A stand alone library to instantiate concepts, deserialize/serialize them in RDF and Json according to [DIFIs standard](https://doc.difi.no/data/forvaltningsstandard-begrepsbeskrivelser/)

See _Forvaltningsstandard for tilgjengeliggjøring av begrepsbeskrivelser_: [begrep-skos-ap-no](https://doc.difi.no/data/begrep-skos-ap-no/)

# ModelBuilder

Builds a model with various helper builders.

## ConceptCollection

```java
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

        conceptModel.write(System.out, "TURTLE");
```

### Example output (Turtle)

```turtle
@prefix schema: <http://schema.org/> .
@prefix iso:   <http://iso.org/25012/2008/dataquality/> .
@prefix spdx:  <http://spdx.org/rdf/terms#> .
@prefix adms:  <http://www.w3.org/ns/adms#> .
@prefix skosxl: <http://www.w3.org/2008/05/skos-xl#> .
@prefix owl:   <http://www.w3.org/2002/07/owl#> .
@prefix skosno: <http://difi.no/skosno#> .
@prefix dqv:   <http://www.w3.org/ns/dqv#> .
@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .
@prefix skos:  <http://www.w3.org/2004/02/skos/core#> .
@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .
@prefix vcard: <http://www.w3.org/2006/vcard/ns#> .
@prefix xkos:  <http://rdf-vocabulary.ddialliance.org/xkos#> .
@prefix oa:    <http://www.w3.org/ns/prov#> .
@prefix dct:   <http://purl.org/dc/terms/> .
@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix dcatno: <http://difi.no/dcatno#> .
@prefix dcat:  <http://www.w3.org/ns/dcat#> .
@prefix foaf:  <http://xmlns.com/foaf/0.1/> .

<https://my.org/concept/rest>
        a                skos:Concept ;
        skosxl:altLabel  [ a                   skosxl:Label ;
                           skosxl:literalForm  "Representational State Transfer"@en
                         ] .

<http://my.org/concept/application>
        a                             skos:Concept ;
        skosno:betydningsbeskrivelse  [ a               skosno:Definisjon ;
                                        rdfs:label      "an application is a program"@en ;
                                        dct:audience    "allmenheten"@nb ;
                                        dct:modified    "2017-10-20"^^xsd:date ;
                                        dct:source      [ rdfs:label    "see the law"@en ;
                                                          rdfs:seeAlso  <https://lovdata.no/NL/lov/1980-02-08-2/5-1>
                                                        ] ;
                                        skos:scopeNote  "dette gjelder intill videre"@nb
                                      ] ;
        skosno:betydningsbeskrivelse  [ a           skosno:AlternativFormulering ;
                                        rdfs:label  "can be a program also"@en
                                      ] ;
        dct:identifier                "t3:application" ;
        dct:publisher                 <https://data.brreg.no/enhetsregisteret/api/enheter/123456789> ;
        dct:subject                   "tjenester 3.0"@no ;
        skosxl:altLabel               [ a                   skosxl:Label ;
                                        skosxl:literalForm  "app"@en
                                      ] ;
        skosxl:hiddenLabel            [ a                   skosxl:Label ;
                                        skosxl:literalForm  "tjeneste"@no
                                      ] ;
        skosxl:hiddenLabel            [ a                   skosxl:Label ;
                                        skosxl:literalForm  "service"@en
                                      ] ;
        skosxl:prefLabel              [ a                   skosxl:Label ;
                                        skosxl:literalForm  "applikasjon"@no
                                      ] ;
        skosxl:prefLabel              [ a                   skosxl:Label ;
                                        skosxl:literalForm  "application"@en
                                      ] ;
        dcat:contactPoint             [ a                          vcard:Organization ;
                                        vcard:hasEmail             <mailto:me@org.no> ;
                                        vcard:hasOrganizationUnit  "Contact Dep" ;
                                        vcard:hasTelephone         <tel:+4755555555>
                                      ] .

<http://my.org/collectino/first>
        a              skos:Collection ;
        dct:publisher  <https://data.brreg.no/enhetsregisteret/api/enheter/123456789> ;
        skos:member    <https://my.org/concept/rest> , <https://my.org/concept/term> , <http://my.org/concept/application> .

<https://my.org/concept/term>
        a                 skos:Concept ;
        skosxl:prefLabel  [ a                   skosxl:Label ;
                            skosxl:literalForm  "term"@en
                          ] .
```

# ModelReader

Takes a Jena Model object and extracts the concepts in the RDF model.

```java
        Model conceptModel = ...

        ModelReader reader = new ModelReader(conceptModel);

        List<Concept> concepts = reader.getConcepts();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(concepts));
```

## JSON Representation

```json
[
  {
    "uri": "http://my.org/concept/application",
    "identifier": "t3:application",
    "definition": {
      "text": {
        "en": "an application is a program"
      },
      "scopeNote": {
        "nb": "dette gjelder intill videre"
      },
      "source": {
        "prefLabel": {
          "en": "see the law"
        }
      }
    },
    "subject": {
      "no": "tjenester 3.0"
    },
    "prefLabel": {
      "en": "application",
      "no": "applikasjon"
    },
    "altLabel": [
      {
        "en": "app"
      }
    ],
    "hiddenLabel": [
      {
        "no": "tjeneste",
        "en": "service"
      }
    ],
    "contactPoint": {
      "email": "me@org.no",
      "telephone": "+4755555555"
    }
  }
]
```

# Usage

Our goal is to publish this library to a official Maven repository. However, we are not there yet. Therefore you must include our jar in your project by following these steps:

The following assumes you are using Spring Boot.

1. Download our jar from the lib-directory.
2. Add a dependency to the downloaded jar in your pom as a system dependency:

  ```
  <!-- The local jar for the concept-builder -->
   <dependency>
       <groupId>concept-builder.group</groupId>
       <artifactId>fdk-concept-builder</artifactId>
       <version>${version.fdk-concept-builder}</version>
       <scope>system</scope>
       <systemPath>${basedir}/libs/fdk-concept-builder-1.0-SNAPSHOT.jar</systemPath>
   </dependency>
  ```

3. Tell Spring Boot to include system dependencies:

  ```
  <plugin>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-maven-plugin</artifactId>
  <configuration>
  <includeSystemScope>true</includeSystemScope>
  </configuration>
  </plugin>
  ```

# References

- [Felles datakatalog](https://github.com/Informasjonsforvaltning)
- [Forvaltningsstandard for begrepsbeskrivelser](https://doc.difi.no/data/forvaltningsstandard-begrepsbeskrivelser/)
- [Tilgjengeliggjøring av begrepsbeskrivelser basert på SKOS](https://doc.difi.no/data/begrep-skos-ap-no/)
