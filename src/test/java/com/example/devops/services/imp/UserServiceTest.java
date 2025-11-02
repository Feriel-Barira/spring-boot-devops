package com.example.devops.services.imp;

import com.example.devops.models.User;
import com.example.devops.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        // Arrange
        User user = new User(1, "Ferial", "feriel@example.com");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User saved = userService.saveUser(user);

        // Assert
        assertNotNull(saved);
        assertEquals("Ferial", saved.getUsername());
        assertEquals("feriel@example.com", saved.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        // Arrange
        User user = new User(1, "Ferial", "feriel@example.com");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        // Act
        Optional<User> result = userService.getUserById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Ferial", result.get().getUsername());
        assertEquals("feriel@example.com", result.get().getEmail());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<User> mockUsers = List.of(
                new User(1, "A", "a@a.com"),
                new User(2, "B", "b@b.com")
        );
        when(userRepository.findAll()).thenReturn(mockUsers);

        // Act
        List<User> users = userService.getAllUsers();

        // Assert
        assertNotNull(users);
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser() {
        // Arrange
        doNothing().when(userRepository).deleteById(1);

        // Act
        userService.deleteUser(1);

        // Assert
        verify(userRepository, times(1)).deleteById(1);
    }
}