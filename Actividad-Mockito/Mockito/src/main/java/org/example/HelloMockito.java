package org.example;

import java.util.Optional;

public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito";
    //Dependencias
    private final PersonRepository personRepository;
    private final TranslationService translationService;

    //Constructor de injeccion de dependencias

    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }

    // Methodo we want to test
    public String greet(int id, String sourceLang, String targetLang) {
        Optional<Person> person = personRepository.findById(id);
        String name = person.map(Person::getFirts).orElse("World");
        return translationService.translate(String.format(greeting,name),sourceLang,targetLang);
    }
}
