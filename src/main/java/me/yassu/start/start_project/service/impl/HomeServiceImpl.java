package me.yassu.start.start_project.service.impl;

import me.yassu.start.start_project.dto.HomeRequestDTO;
import me.yassu.start.start_project.dto.HomeResponseDTO;
import me.yassu.start.start_project.entity.Home;
import me.yassu.start.start_project.exception.UserNotFoundException;
import me.yassu.start.start_project.repository.HomeRepository;
import me.yassu.start.start_project.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);

    private final HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public HomeResponseDTO addHome(HomeRequestDTO homeRequest){
        Home newHome = homeRepository.save(new Home(
                homeRequest.getOwnerName(),
                homeRequest.getCityName(),
                homeRequest.getStateName(),
                homeRequest.getNumberOfPeople(),
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis())
        ));
        return new HomeResponseDTO(
                newHome.getHomeId().toString(),
                newHome.getOwnerName(),
                newHome.getCityName(),
                newHome.getStateName(),
                String.valueOf(newHome.getNumberOfPeople())
        );
    }

    public List<Home> getAllHomes(int pageSize, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Order.asc("homeId")));
        return homeRepository.findAll(pageable).getContent();
    }

    @CachePut(cacheNames = "homes", key = "#id")
    public HomeResponseDTO updateHome(int id, HomeRequestDTO homeRequest){
        Home oldHome = homeRepository.findById(id).orElseThrow(() -> new RuntimeException("Home not found"));

        oldHome.setOwnerName(homeRequest.getOwnerName());
        oldHome.setCityName(homeRequest.getCityName());
        oldHome.setStateName(homeRequest.getStateName());
        oldHome.setNumberOfPeople(homeRequest.getNumberOfPeople());

        Home newHome = homeRepository.save(oldHome);

        return  new HomeResponseDTO(
                newHome.getHomeId().toString(),
                newHome.getOwnerName(),
                newHome.getCityName(),
                newHome.getStateName(),
                String.valueOf(newHome.getNumberOfPeople())
        );
    }

    @CacheEvict(cacheNames = "homes", key = "#id")
    public String deleteHome(int id){
        Home home = homeRepository.findById(id).orElseThrow(() -> new RuntimeException("Home not found"));

        homeRepository.delete(home);

        return "Successfully Deleted";
    }

    @Cacheable(cacheNames = "homes", key = "#id")
    public HomeResponseDTO getHomeById(int id) {
        Home home = homeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not found"));
        return new HomeResponseDTO(
                home.getHomeId().toString(),
                home.getOwnerName(),
                home.getCityName(),
                home.getStateName(),
                String.valueOf(home.getNumberOfPeople())
        );
    }
}
