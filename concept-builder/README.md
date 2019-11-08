# skos-ap-no-tools concept-builder

A stand alone library to instantiate concepts, deserialize/serialize them in RDF and Json according to [DIFIs standard](https://doc.difi.no/data/forvaltningsstandard-begrepsbeskrivelser/)

See _Forvaltningsstandard for tilgjengeliggjøring av begrepsbeskrivelser_: [begrep-skos-ap-no](https://doc.difi.no/data/begrep-skos-ap-no/)

# ModelBuilder

Builds a model with various helper builders.

## ConceptCollection

```java
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
                            .partitiveRelationBuilder()
                                .divisioncriterion("divisioncriterion", "en")
                                .divisioncriterion("inndelingskriterium", "nb")
                                .modified(LocalDate.of(2019, 8, 21))
                                .narrowerConcept("http://my.org/concept/Concept2")
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

<http://my.second.org/concept/Concept%20with%20space>
        a               skos:Concept ;
        dct:identifier  "http://my.second.org/concept/Concept with space" ;
        dct:publisher   <https://data.brreg.no/enhetsregisteret/api/enheter/Publisher2> .

<http://my.org/concept/Concept3>
        a                       skos:Concept ;
        rdfs:seeAlso            "http://my.org/concept/Concept1" ;
        skosno:begrepsrelasjon  [ a                           skosno:PartitivRelasjon ;
                                  skosno:inndelingskriterium  "inndelingskriterium"@nb , "divisioncriterion"@en ;
                                  skosno:underordnetBegrep    <http://my.org/concept/Concept2> ;
                                  dct:modified                "2019-08-21"^^xsd:date
                                ] ;
        dct:identifier          "http://my.org/concept/Concept3" ;
        dct:publisher           <https://data.brreg.no/enhetsregisteret/api/enheter/Publisher1> .

<http://my.org/concept/Concept2>
        a                       skos:Concept ;
        rdfs:seeAlso            "http://my.org/concept/Concept1" ;
        skosno:begrepsrelasjon  [ a                           skosno:GeneriskRelasjon ;
                                  skosno:inndelingskriterium  "inndelingskriterium"@nb , "divisioncriterion"@en ;
                                  skosno:overordnetBegrep     <http://my.org/concept/Concept3> ;
                                  dct:modified                "2019-08-20"^^xsd:date
                                ] ;
        dct:identifier          "http://my.org/concept/Concept2" ;
        dct:publisher           <https://data.brreg.no/enhetsregisteret/api/enheter/Publisher1> .

<http://my.org/collection/second>
        a               skos:Collection ;
        rdfs:label      "CollectionName2" ;
        dct:identifier  "http://my.org/collection/second" ;
        dct:publisher   <https://data.brreg.no/enhetsregisteret/api/enheter/Publisher2> ;
        skos:member     <http://my.second.org/concept/Concept%20with%20space> .

<http://my.org/concept/Concept1>
        a                             skos:Concept ;
        skosno:begrepsrelasjon        [ a                       skosno:AssosiativRelasjon ;
                                        skosno:assosiertBegrep  <http://my.org/concept/Concept2> ;
                                        dct:description         "beskrivelse"@nb , "description"@en ;
                                        dct:modified            "2019-08-19"^^xsd:date
                                      ] ;
        skosno:betydningsbeskrivelse  [ a                       skosno:Definisjon ;
                                        rdfs:label              "Definisjon1"@nb , "Definition1"@en ;
                                        skosno:forholdTilKilde  skosno:basertPåKilde ;
                                        skosno:omfang           [ rdfs:label    "omfangTekst1"@nb , "scopeLabel1"@en ;
                                                                  rdfs:seeAlso  <http://invalid.org/scope/Scope1>
                                                                ] ;
                                        dct:audience            skosno:fagspesialist ;
                                        dct:modified            "2018-10-31"^^xsd:date ;
                                        skos:example            "Eksempel"@nb , "Example1"@en ;
                                        skos:scopeNote          "ScopeNote1"@en , "Merknad1"@nb ;
                                        dct:source              [ rdfs:label    "Kilde1"@nb , "Source1"@en ;
                                                                  rdfs:seeAlso  <http://invalid.org/concept2>
                                                                ]
                                      ] ;
        skosno:betydningsbeskrivelse  [ a           skosno:AlternativFormulering ;
                                        rdfs:label  "AlternativeWording1"@en
                                      ] ;
        skosno:bruksområde            "bruksområde1"@nb , "domainOfUse1"@en ;
        skosno:datastrukturterm       [ a                   skosxl:Label ;
                                        skosxl:literalForm  "DatastrukturTerm1"@nb , "DatastructureLabel1"@en
                                      ] ;
        dct:identifier                "http://my.org/concept/Concept1" ;
        dct:modified                  "2019-08-22"^^xsd:date ;
        dct:publisher                 <https://data.brreg.no/enhetsregisteret/api/enheter/Publisher1.1> ;
        dct:subject                   "Subject1"@en , "Fagområde1"@nb ;
        dct:temporal                  [ a                 dct:PeriodOfTime ;
                                        schema:endDate    "2037-10-19"^^xsd:date ;
                                        schema:startDate  "2017-10-20"^^xsd:date
                                      ] ;
        skosxl:altLabel               [ a                   skosxl:Label ;
                                        dct:audience        skosno:allmennheten ;
                                        skosxl:literalForm  "TillattTerm1"@nb , "AltLabel1"@en
                                      ] ;
        skosxl:hiddenLabel            [ a                   skosxl:Label ;
                                        skosxl:literalForm  "FrarådetTerm1"@nb , "HiddenLabel1"@en
                                      ] ;
        skosxl:prefLabel              [ a                   skosxl:Label ;
                                        dct:modified        "2017-10-31"^^xsd:date ;
                                        skosxl:literalForm  "AnbefaltTerm1"@nb , "PrefLabel1"@en
                                      ] ;
        dcat:contactPoint             [ a                          vcard:Organization ;
                                        vcard:hasEmail             <mailto:org1.1@invalid.org> ;
                                        vcard:hasOrganizationUnit  "ContactPointOrg1.1" ;
                                        vcard:hasTelephone         <tel:11>
                                      ] .

<http://my.org/collection/first>
        a                  skos:Collection ;
        rdfs:label         "CollectionName1" ;
        dct:description    "Description1" ;
        dct:identifier     "http://my.org/collection/first" ;
        dct:publisher      <https://data.brreg.no/enhetsregisteret/api/enheter/Publisher1> ;
        skos:member        <http://my.org/concept/Concept3> , <http://my.org/concept/Concept2> , <http://my.org/concept/Concept1> ;
        dcat:contactPoint  [ a                          vcard:Organization ;
                             vcard:hasEmail             <mailto:org1@invalid.org> ;
                             vcard:hasOrganizationUnit  "ContactPointOrg1" ;
                             vcard:hasTelephone         <tel:1>
                           ] .
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
