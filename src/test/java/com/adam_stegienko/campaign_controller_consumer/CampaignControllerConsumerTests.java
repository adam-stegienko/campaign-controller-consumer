package com.adam_stegienko.campaign_controller_consumer;

import com.adam_stegienko.campaign_controller_consumer.services.GoogleApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
class CampaignControllerConsumerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoogleApiService googleApiService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    void shouldReturnCampaignControllerApp() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk());
    }
}
