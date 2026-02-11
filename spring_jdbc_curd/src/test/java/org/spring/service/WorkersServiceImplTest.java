package org.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.spring.dao.WorkersDao;
import org.spring.model.Workers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkersServiceImplTest {

    @Mock
    private WorkersDao workersDao;

    @InjectMocks
    private WorkersServiceImpl workersService;

    @Test
    void findAll_shouldDelegateToDao() {
        Workers workers = new Workers();
        workers.setId(1);
        workers.setName("Alice");
        when(workersDao.findAll()).thenReturn(List.of(workers));

        List<Workers> result = workersService.findAll();

        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
        verify(workersDao, times(1)).findAll();
    }

    @Test
    void add_shouldDelegateToDao() {
        Workers workers = new Workers();
        workers.setName("Bob");
        workersService.add(workers);
        verify(workersDao).add(workers);
    }
}
