package com.revature.domain;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Verification techniques - Confirming Mock Interactions

//verify() confirms methods were called
//verification modes: times(), never(), atLeast(), atMost()
//ArgumentCaptor: Capture and Inspect what was passed
//InOrder: verify call sequence
//verifyNoMoreInteractions: Strict verification


@ExtendWith(MockitoExtension.class)
@DisplayName("Verification Techniques Demo")
public class Demo_Verification_Techniques {

    @Mock
    private UserRepository repository;

    @Mock
    private EmailClient emailClient;

    @InjectMocks
    private UserService userService;

    //verify()

    @Nested
    @DisplayName("Basic Verify")
    class BasicVerification {

        @Test
        @DisplayName("Verify method was called")
        void basicVerify(){
            //Setup
            when(repository.findById(1L))
                    .thenReturn(Optional.of(new User(1L,"John","john@test.com")));
            //Act
            userService.getUser(1L);

            //Verify the mock was colled
            verify(repository).findById(1L);

        }

        @Test
        @DisplayName("Verify Method was called with specific argument")
        void verifyWithArgument(){
            when(repository.existsByEmail(anyString())).thenReturn(false);
            when(repository.save(any())).thenReturn(new User(1L,"John","john@test.com"));
            when(emailClient.send(anyString(),anyString(),anyString())).thenReturn(true);

            userService.createUser("John","john@test.com");

            //verify specific argument
            verify(repository).existsByEmail("john@test.com");
            verify(emailClient).send(eq("john@test.com"),anyString(),anyString());
        }
    }


}
