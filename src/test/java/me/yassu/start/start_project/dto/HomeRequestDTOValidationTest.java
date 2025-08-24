package me.yassu.start.start_project.dto;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HomeRequestDTOValidationTest {

    @Autowired
    private static Validator validator;

    @BeforeAll
    public static void setUp(){
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Home Request DTO Owner Name Validation")
    @Link(url = "https://x.com/home")
    public void testHomeRequestDTOOwnerNameValidation(){
        HomeRequestDTO requestDTO = new HomeRequestDTO(
                "",
                "Pamuru",
                "Andhra",
                5
        );

        Set<ConstraintViolation<HomeRequestDTO>> errors = validator.validate(requestDTO);
        assertNotNull(errors);
        assertFalse(errors.isEmpty());
        errors.forEach(error -> {
            assertEquals("Owner Name should not be empty",error.getMessage());
        });
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Home Request DTO City Name Validation")
    @Link(url = "https://x.com/home")
    public void testHomeRequestDTOCityNameValidation(){
        HomeRequestDTO requestDTO = new HomeRequestDTO(
                "Yassu",
                "",
                "Andhra",
                5
        );

        Set<ConstraintViolation<HomeRequestDTO>> errors = validator.validate(requestDTO);
        assertNotNull(errors);
        assertFalse(errors.isEmpty());
        errors.forEach(error -> {
            assertEquals("City Name should not be empty",error.getMessage());
        });
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Home Request DTO State Name Validation")
    @Link(url = "https://x.com/home")
    public void testHomeRequestDTOStateNameValidation(){
        HomeRequestDTO requestDTO = new HomeRequestDTO(
                "Yassu",
                "Pamuru",
                "",
                5
        );

        Set<ConstraintViolation<HomeRequestDTO>> errors = validator.validate(requestDTO);
        assertNotNull(errors);
        assertFalse(errors.isEmpty());
        errors.forEach(error -> {
            assertEquals("State Name should not be empty",error.getMessage());
        });
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Home Request DTO Number of People Validation")
    @Link(url = "https://x.com/home")
    public void testHomeRequestDTONumberOfPeopleValidation(){
        HomeRequestDTO requestDTO = new HomeRequestDTO(
                "Yassu",
                "Pamuru",
                "Andhra",
                0
        );

        Set<ConstraintViolation<HomeRequestDTO>> errors = validator.validate(requestDTO);
        assertNotNull(errors);
        assertFalse(errors.isEmpty());
        errors.forEach(error -> {
            assertEquals("Number of people must be greater than 0",error.getMessage());
        });
    }


}
