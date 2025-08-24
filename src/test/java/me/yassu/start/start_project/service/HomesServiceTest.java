package me.yassu.start.start_project.service;

import me.yassu.start.start_project.dto.HomeRequestDTO;
import me.yassu.start.start_project.dto.HomeResponseDTO;
import me.yassu.start.start_project.entity.Home;
import me.yassu.start.start_project.repository.HomeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HomesServiceTest {

    @Mock
    private HomeRepository homeRepository;

    @InjectMocks
    private HomeService homeService;

    @Test
    public void testGetAllHomesService(){
        Home home = new Home(
                "Yassu",
                "Pamuru",
                "Andhra",
                5,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        );

        List<Home> homes = List.of(home);
        Page<Home> pages = new PageImpl<>(homes);
        Pageable pageable = PageRequest.of(1, 5, Sort.by(Sort.Order.asc("homeId")));


        when(homeRepository.findAll(pageable)).thenReturn(pages);

        List<Home> homeList = homeService.getAllHomes(5, 1);
        assertNotNull(homeList);
    }

    @Test
    public void testAddHomeService() {
        HomeRequestDTO requestDTO = new HomeRequestDTO();
        requestDTO.setOwnerName("Yassu");
        requestDTO.setCityName("Pamuru");
        requestDTO.setStateName("Andhra");
        requestDTO.setNumberOfPeople(5);

        Home newHome = new Home(
                "Yassu",
                "Pamuru",
                "Andhra",
                5,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        );
        newHome.setHomeId(1);

        HomeResponseDTO responseDTO = new HomeResponseDTO();
        responseDTO.setId(String.valueOf(newHome.getHomeId()));
        responseDTO.setOwnerName(newHome.getOwnerName());
        responseDTO.setCityName(newHome.getCityName());
        responseDTO.setStateName(newHome.getStateName());
        responseDTO.setNumberOfPeople(String.valueOf(newHome.getNumberOfPeople()));

        when(homeRepository.save(any(Home.class))).thenReturn(newHome);

        HomeResponseDTO homeResponseDTO = homeService.addHome(requestDTO);
        assertEquals(responseDTO.getOwnerName(), homeResponseDTO.getOwnerName());
    }

    @Test
    public void testUpdateHomeService(){
        HomeRequestDTO homeRequestDTO = new HomeRequestDTO(
                "Yassu",
                "Pamuru",
                "Andhra",
                6
        );

        Home home = new Home(
                "Yassu",
                "Pamuru",
                "Andhra",
                5,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        );
        home.setHomeId(1);

        Home newHome = new Home(
                "Yassu",
                "Pamuru",
                "Andhra",
                6,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        );
        newHome.setHomeId(1);

        when(homeRepository.findById(1)).thenReturn(Optional.of(home));

        when(homeRepository.save(any(Home.class))).thenReturn(newHome);

        HomeResponseDTO homeResponseDTO = homeService.updateHome(1, homeRequestDTO);

        assertNotNull(homeResponseDTO);
        assertEquals(String.valueOf(homeRequestDTO.getNumberOfPeople()), homeResponseDTO.getNumberOfPeople());
    }

    @Test
    public void testDeleteHomeService(){
        Home home = new Home(
                "Yassu",
                "Pamuru",
                "Andhra",
                5,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        );
        home.setHomeId(1);
        when(homeRepository.findById(1)).thenReturn(Optional.of(home));
        String message = homeService.deleteHome(1);
        assertNotNull(message);
        assertEquals("Successfully Deleted", message);
    }
}
