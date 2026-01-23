package net.engineeringdigest.journalApp.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userRepositoryImplTests {

    @Autowired
    private userRepositoryImpl userRepository;

    @Test
    public void testSaveNewUser() {
        Assertions.assertNotNull(userRepository.getUserForSA());
    }
}
