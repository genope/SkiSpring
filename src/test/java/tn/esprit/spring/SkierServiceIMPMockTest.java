package tn.esprit.spring;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.SkierServicesImpl;



@SpringBootTest
public class SkierServiceIMPMockTest {

    @Mock
    private Skier skier;

    @InjectMocks
    private SkierServicesImpl skierServicesImpl;

    @Mock
    private ISkierRepository iSkierRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetterAndSetterForNomSkier() {
        Skier skier = new Skier("hassen");
        String nom = skier.getFirstName();
        assertEquals("hassen", nom);
    }

    @Test
    public void testCreateSkier() {
             Skier skier = new Skier("hassen MABROUK");

        when(iSkierRepository.save(any(Skier.class))).thenReturn(skier);

        Skier savedSkier = skierServicesImpl.addSkier(skier);
        System.out.println(skier);
        assertNotNull(savedSkier);
        assertEquals("hassen MABROUK", savedSkier.getFirstName());
    }

    @Test
    public void testDeleteSkier() {
        Skier skier = new Skier("hassen MABROUK");
        skier.setNumSkier(1L);

        when(iSkierRepository.findById(1L)).thenReturn(Optional.of(skier));

        skierServicesImpl.removeSkier(1L);

        verify(iSkierRepository, times(1)).deleteById(1L);
    }
    
}
