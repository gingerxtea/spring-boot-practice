package me.yassu.start.start_project.controller;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.validation.Valid;
import me.yassu.start.start_project.dto.HomeRequestDTO;
import me.yassu.start.start_project.dto.HomeResponseDTO;
import me.yassu.start.start_project.entity.Home;
import me.yassu.start.start_project.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping( path = "/home")
public class HomeController {

    Logger logger = LoggerFactory.getLogger("home controller");

    private final HomeService homeService;
    private final DataSource dataSource;

    public HomeController(
            HomeService homeService,
            DataSource dataSource
    ) {
        this.homeService = homeService;
        this.dataSource = dataSource;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Home>> greetings(
            @RequestParam(
                    name = "pageSize", defaultValue = "5"
            ) int pageSize,
            @RequestParam(
                    name = "pageNumber", defaultValue = "0"
            ) int pageNumber
    ){
        return ResponseEntity.ok(homeService.getAllHomes(pageSize, pageNumber));
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HomeResponseDTO> getHomeById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(homeService.getHomeById(id));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public ResponseEntity<HomeResponseDTO> addNewHome(@Valid @RequestBody HomeRequestDTO homeRequest){
        return ResponseEntity.ok(homeService.addHome(homeRequest));
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HomeResponseDTO> updateHome(
            @PathVariable(name = "id") int id,
            @Valid @RequestBody HomeRequestDTO homeRequest
    ){
        return ResponseEntity.ok(homeService.updateHome(id, homeRequest));
    }

    @DeleteMapping(
            path = "/{id}"
    )
    public ResponseEntity<String> deleteHome(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(homeService.deleteHome(id));
    }

    @PostMapping(path = "/db-info")
    public ResponseEntity<HikariDataSource> getDBInfo(){
        HikariDataSource hds = (HikariDataSource) dataSource;
        logger.info("url: {}",hds.getJdbcUrl());
        logger.info("username: {}",hds.getUsername());
        logger.info("max pool size; {}", hds.getMaximumPoolSize());
        logger.info("idle size; {}", hds.getMinimumIdle());
        logger.info("test query: {}",hds.getConnectionTestQuery());
        return ResponseEntity.ok(hds);
    }
}
