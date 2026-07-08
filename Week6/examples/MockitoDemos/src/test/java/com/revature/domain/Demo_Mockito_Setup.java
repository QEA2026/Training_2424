package com.revature.domain;

//@ExtendWith(MockitoExtension.class) enables Mockito in JUnit6
//@Mock creates a mock object
//@InjectMocks creates the SUT and injects mocks into it
//Three ways to create mocks: @Mock, Mockito.mock(), MockitoAnnotations.openMocks()

//Required Dependencies
//mockito-core
//mockito-junit-jupiter

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Mockito Setup Demo")
public class Demo_Mockito_Setup {

    //Creating Mocks

    @Mock
    private UserRepository repository; // This is a mock!

    @Mock
    private EmailClient emailClient; //This is also a mock!

    //@InjectMocks creates the real object and injects mocks
    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Basic mock creating with @Mock annotation")
    void demonstrateMockCreation(){
        // The repository is a mock - not a real implementation
        assertNotNull(repository, "Mock should be created");

        //By Default, mocks return null/false/0/empty
        assertNull(repository.findById(1L).orElse(null),
                "Unstubbed mock returns empty optional");

        assertEquals(0, repository.count(),
                "Unstubbed mock return 0 for primitives");

        assertFalse(repository.existsByEmail("test@test.com"),
                "Unstubbed mock returns false for boolean");
    }




}
