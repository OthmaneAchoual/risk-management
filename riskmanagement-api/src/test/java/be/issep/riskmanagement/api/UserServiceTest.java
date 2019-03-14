package be.issep.riskmanagement.api;

import be.issep.riskmanagement.api.entities.User;
import be.issep.riskmanagement.api.entities.dtos.UserDTO;
import be.issep.riskmanagement.api.repositories.UserRepository;
import be.issep.riskmanagement.api.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    @Spy
    UserService service;

    @Mock
    UserRepository repository;

    @Before
    /* Initialized mocks */
    public void setup() {
        initMocks(this);
    }

    @Test
    public void saveMethodCalledOnRepoWhenAddingUser() {
        UserDTO user = new UserDTO();
        when(repository.save(any())).thenReturn(new User());

        service.add(user);
        verify(repository, times(1)).save(any());
    }
}
