package me.yassu.start.start_project.service;

import me.yassu.start.start_project.dto.HomeRequestDTO;
import me.yassu.start.start_project.dto.HomeResponseDTO;
import me.yassu.start.start_project.entity.Home;

import java.util.List;

public interface HomeService {
    public HomeResponseDTO addHome(HomeRequestDTO homeRequest);
    public List<Home> getAllHomes(int pageSize, int pageNumber);
    public HomeResponseDTO updateHome(int id, HomeRequestDTO homeRequest);
    public String deleteHome(int id);
    public HomeResponseDTO getHomeById(int id);
}
