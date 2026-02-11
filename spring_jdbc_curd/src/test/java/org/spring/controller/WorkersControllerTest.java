package org.spring.controller;

import org.junit.jupiter.api.Test;
import org.spring.model.Workers;
import org.spring.service.WorkersService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class WorkersControllerTest {

    @Test
    void listEndpoint_shouldReturnJsonArray() throws Exception {
        WorkersService workersService = mock(WorkersService.class);
        Workers workers = new Workers();
        workers.setId(1);
        workers.setName("Tom");
        workers.setSalary(5000);
        workers.setAge(30);
        when(workersService.findAll()).thenReturn(List.of(workers));

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new WorkersController(workersService))
                .build();

        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Tom"));
    }
}
