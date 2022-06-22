package fis.bank.criminal.repository;

import fis.bank.criminal.model.CriminalCase;
import fis.bank.criminal.model.Detective;
import fis.bank.criminal.model.enums.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

public interface DetectiveRepository extends AbstractRepository<Detective>{

    Detective save(Detective detective);

    void delete(Detective detective);

    void deleteById(Long detectiveId);

    Set<Detective> findAll();

    Optional<Detective> findByBadgeNumber(String badgeNumber);

    Set<Detective> findbyRank(Rank rank);

    Detective findById(Long detectiveId);
}
