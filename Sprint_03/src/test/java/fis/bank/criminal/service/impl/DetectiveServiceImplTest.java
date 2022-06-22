package fis.bank.criminal.service.impl;

import fis.bank.criminal.model.Detective;
import fis.bank.criminal.model.enums.EmploymentStatus;
import fis.bank.criminal.model.enums.Rank;
import fis.bank.criminal.service.DetectiveService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DetectiveServiceImplTest {

    @Autowired
    DetectiveService detectiveService;

    @Test
    @Order(1)
    void getALl() {
        System.out.println(detectiveService.findALl());
        assertEquals(6, detectiveService.findALl().size());
    }

    @Test
    @Order(2)
    void findById() {
        Detective detective = detectiveService.findById(1L);
        assertEquals("512334", detective.getBadgeNumber());
    }

    @Test
    @Order(3)
    void save() {

        Detective detective = new Detective();
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setBadgeNumber("1241245");
        detective.setArmed(true);
        detective.setFirstName("Nguyen");
        detective.setHiringDate(LocalDateTime.now());
        detective.setLastName("van a");
        detective.setPassword("123123");
        detective.setRank(Rank.JUNIOR);
        detective.setStatus(EmploymentStatus.ACTIVE);
        detective.setUsername("nguyevana");
        detectiveService.save(detective);
        assertEquals(7, detectiveService.findALl().size());
    }

    @Test
    @Order(4)
    void deleteById() {
        detectiveService.deleteById(7L);
        assertEquals(6, detectiveService.findALl().size());
    }
}