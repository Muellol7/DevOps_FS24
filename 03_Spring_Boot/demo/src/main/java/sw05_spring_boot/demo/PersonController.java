package sw05_spring_boot.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

@RestController
public class PersonController {

    @GetMapping("/test")
    public String test() {
        return "Hello World app is up and running! \n greetings Muellol7 :D";
    }

    private Map<Integer, Person> persons = new HashMap<>();
    
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.persons.put(1,new Person(1, "Barack Obama"));
        this.persons.put(2,new Person(2, "Donald Trump"));
        this.persons.put(3,new Person(3, "Joe Biden"));
        System.out.println("Init Data");
    }
    
    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return this.persons.get(id);
    }

    @PostMapping("/person")
        public void createPerson(@RequestBody Person person) {
        var newId = this.persons.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        person.setId(newId);
        this.persons.put(newId, person);
    }

    @PutMapping("/person/{id}")
        public void updatePerson(@PathVariable Integer id, @RequestBody Person person) {
        person.setId(id);
        this.persons.put(id, person);
    }

    @DeleteMapping("/person/{id}")
        public Person deletePerson(@PathVariable Integer id) {
        return this.persons.remove(id);
    }

}

