package me.yassu.start.start_project.controller;

import io.qameta.allure.*;
import me.yassu.start.start_project.dto.HomeRequestDTO;
import me.yassu.start.start_project.dto.HomeResponseDTO;
import me.yassu.start.start_project.entity.Home;
import me.yassu.start.start_project.service.HomeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {

    @Mock
    private HomeService homeService;

    @InjectMocks
    private HomeController homeController;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Sample Test")
    @Link(url = "https://medium.com/")
    @Epic(value = "Sample Test Epic")
    @Feature(value = "Sample Test Feature")
    @Story(value = "Sample Test Story")
    public void sampleTest(){
        assertEquals(2,1+1);
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Controller GET Test")
    @Link(url = "https://x.com/home")
    public void testControllerGetMethod(){
        List<Home> homes = new ArrayList<>();
        homes.add(
                new Home(
                        "Yassu",
                        "Pamuru",
                        "Andhra",
                        5,
                        new Date(System.currentTimeMillis()),
                        new Date(System.currentTimeMillis())
                )
        );
        when(homeService.getAllHomes(5, 1)).thenReturn(homes);

        List<Home> homeList = homeController.greetings(5, 1).getBody();
        assertNotNull(homeList);
        assertEquals(homes.getFirst().getOwnerName(), homeList.getFirst().getOwnerName());
        assertEquals(homes.getFirst().getCityName(), homeList.getFirst().getCityName());
        assertEquals(homes.getFirst().getStateName(), homeList.getFirst().getStateName());
        assertEquals(homes.getFirst().getNumberOfPeople(), homeList.getFirst().getNumberOfPeople());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Controller POST Test")
    @Link(url = "https://www.youtube.com/")
    public void testControllerPostMethod(){
        HomeRequestDTO requestDTO = new HomeRequestDTO();
        requestDTO.setOwnerName("Yassu");
        requestDTO.setCityName("Pamuru");
        requestDTO.setStateName("Andhra");
        requestDTO.setNumberOfPeople(5);

        HomeResponseDTO responseDTO = new HomeResponseDTO(
                "1",
                "Yassu",
                "Pamuru",
                "Andhra",
                "5"
        );

        when(homeService.addHome(requestDTO)).thenReturn(responseDTO);

        HomeResponseDTO homeResponseDTO = homeController.addNewHome(requestDTO).getBody();
        assertNotNull(homeResponseDTO);
        assertEquals(responseDTO.getOwnerName(), homeResponseDTO.getOwnerName());
        assertEquals(responseDTO.getCityName(), homeResponseDTO.getCityName());
        assertEquals(responseDTO.getStateName(), homeResponseDTO.getStateName());
        assertEquals(responseDTO.getNumberOfPeople(), homeResponseDTO.getNumberOfPeople());
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Controller Put Test")
    @Link(url = "https://chatgpt.com/")
    public void testControllerPutMethod(){
        HomeRequestDTO requestDTO = new HomeRequestDTO(
                "Yassu",
                "Pamuru",
                "Andhra",
                6
        );

        HomeResponseDTO responseDTO = new HomeResponseDTO();
        responseDTO.setId("1");
        responseDTO.setOwnerName("Yassu");
        responseDTO.setCityName("Pamuru");
        responseDTO.setStateName("Andhra");
        responseDTO.setNumberOfPeople("6");

        when(homeService.updateHome(1, requestDTO)).thenReturn(responseDTO);

        HomeResponseDTO homeResponseDTO = homeController.updateHome(1, requestDTO).getBody();
        assertNotNull(homeResponseDTO);
        assertEquals(responseDTO.getOwnerName(), homeResponseDTO.getOwnerName());
        assertEquals(responseDTO.getCityName(), homeResponseDTO.getCityName());
        assertEquals(responseDTO.getStateName(), homeResponseDTO.getStateName());
        assertEquals(responseDTO.getNumberOfPeople(), homeResponseDTO.getNumberOfPeople());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Controller Delete Test")
    @Link(url = "https://www.google.com/")
    public void testControllerDeleteMethod(){
        when(homeService.deleteHome(1)).thenReturn("Successfully Deleted");

        ResponseEntity<String> response = homeController.deleteHome(1);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Successfully Deleted", response.getBody());
    }
}
