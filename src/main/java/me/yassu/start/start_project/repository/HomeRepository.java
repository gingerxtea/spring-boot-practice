package me.yassu.start.start_project.repository;

import me.yassu.start.start_project.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {
}
