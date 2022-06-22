package fis.bank.criminal.repository.jdbctemplate;

import fis.bank.criminal.model.Detective;
import fis.bank.criminal.model.enums.Rank;
import fis.bank.criminal.repository.DetectiveRepository;
import fis.bank.criminal.repository.jdbctemplate.mapper.DetectiveRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class DetectiveRepositoryImpl extends AbstractRepositoryImpl<Detective> implements DetectiveRepository {

    private RowMapper<Detective> rowMapper = new DetectiveRowMapper();

    public DetectiveRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    @Override
    public Detective save(Detective detective) {
        jdbcTemplate.update(
                "insert into tbl_detective(id, created_at, modified_at,version, armed, badgeNumber, " +
                        "status_detective, rank_detective,firstName,hiringDate,lastName,password,username) " +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?)",
                detective.getId(), detective.getCreatedAt(), detective.getCreatedAt(),detective.getVersion(),
                detective.getArmed(), detective.getBadgeNumber(),
                String.valueOf(detective.getStatus()),
                String.valueOf(detective.getRank()), detective.getFirstName(),detective.getHiringDate(),
                detective.getLastName(),detective.getPassword(),detective.getUsername()
        );
        return detective;
    }

    @Override
    public void delete(Detective detective) {

    }

    @Override
    public void deleteById(Long detectiveId) {
        jdbcTemplate.update("delete from tbl_detective where id =? ", detectiveId);
    }

    @Override
    public Set<Detective> findAll() {
        String sql = "select * from tbl_detective";
        return new HashSet<>(jdbcTemplate.query(sql, rowMapper));
    }

    @Override
    public Detective findById(Long detectiveId) {
        String sql = "select * from tbl_detective where id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper,detectiveId);
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        return Optional.empty();
    }

    @Override
    public Set<Detective> findbyRank(Rank rank) {
        return null;
    }
}
