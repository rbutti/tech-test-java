package example;

import example.model.User;
import example.service.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

    @Test
    void noResultReturnedWithNoData() {
        var mockDataService = mock(DataService.class);
        var application = new Application(mockDataService);

        when(mockDataService.getComments()).thenReturn(emptyList());
        when(mockDataService.getPosts()).thenReturn(emptyList());
        when(mockDataService.getUsers()).thenReturn(emptyList());

        var results =  application.getUsersWithPopularPosts(0);

        Assertions.assertTrue(results.isEmpty());
    }
}
