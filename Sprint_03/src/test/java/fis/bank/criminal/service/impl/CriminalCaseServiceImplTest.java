package fis.bank.criminal.service.impl;

import fis.bank.criminal.model.CriminalCase;
import fis.bank.criminal.model.Detective;
import fis.bank.criminal.model.enums.CaseStatus;
import fis.bank.criminal.model.enums.CaseType;
import fis.bank.criminal.service.CriminalCaseService;
import fis.bank.criminal.service.DetectiveService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CriminalCaseServiceImplTest {

    @Autowired
    CriminalCaseService criminalCaseService;

    @Autowired
    DetectiveService detectiveService;

    @Test
    @Order(1)
    void findAll() {
        assertEquals(2,criminalCaseService.findAll().size());
    }

    @Test
    @Order(2)
    void findById() {
        CriminalCase criminalCase = criminalCaseService.findById(1L);
        assertEquals("5234321",criminalCase.getNumber());
    }

    @Test
    @Order(3)
    void save() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(1);
        criminalCase.setDetailedDescription("criminal case 3");
        criminalCase.setNotes("notes 3");
        criminalCase.setNumber("123412");
        criminalCase.setShortDescription("criminal case 3");
        criminalCase.setStatus(CaseStatus.UNDER_INVESTIGATION);
        criminalCase.setType(CaseType.UNCATEGORIZED);
        Detective detective = detectiveService.findById(2L);
        criminalCase.setLeadInvestigator(detective);
        criminalCaseService.save(criminalCase);
        assertEquals(3,criminalCaseService.findAll().size());
    }

    @Test
    @Order(4)
    void deleteById() {
        criminalCaseService.deleteById(3L);
        assertEquals(2,criminalCaseService.findAll().size());
    }
}