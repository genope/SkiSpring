package tn.esprit.spring;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.services.ISkierServices;


@SpringBootTest
@Slf4j
public class SkierServiceIMPTest {

    @Autowired
  private ISkierServices skierServices;


    @Test
    public void shouldAddEtudiant() {
        Skier skier = new Skier("hassen");
        Skier savedskier = skierServices.addSkier(skier);

        assertNotNull(savedskier);
        assertNotNull(savedskier.getFirstName());
        assertEquals("hassen", savedskier.getFirstName());

        skierServices.removeSkier(savedskier.getNumSkier());
    }

    
}
