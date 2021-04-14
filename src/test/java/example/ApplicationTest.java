package example;

import example.model.User;
import example.service.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

    @Test
    void noResultReturnedWithNoData() {
        DataService mockDataService = mock(DataService.class);
        Application application = new Application(mockDataService);

        when(mockDataService.getComments()).thenReturn(emptyList());
        when(mockDataService.getPosts()).thenReturn(emptyList());
        when(mockDataService.getUsers()).thenReturn(emptyList());

        List<User> results =  application.getUsersWithPopularPosts(0);

        Assertions.assertTrue(results.isEmpty());
    }
}
