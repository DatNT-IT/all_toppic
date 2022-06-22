package fis.bank.criminal.repository.jdbctemplate;

import fis.bank.criminal.model.Detective;
import fis.bank.criminal.model.enums.EmploymentStatus;
import fis.bank.criminal.model.enums.Rank;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("extraDetectiveRepositoryImpl")
public class ExtraDetectiveRepositoryImpl extends DetectiveRepositoryImpl {

    public ExtraDetectiveRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    private class DetectiveExtractor implements ResultSetExtractor<Detective> {
        @Override
        public Detective extractData(ResultSet rs) throws SQLException {
            Detective detective = null;
            while (rs.next()) {
                if (detective == null) {
                    detective = new Detective();
                    // set internal entity identifier (primary key)
                    detective.setId(rs.getLong("id"));
                    detective.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    detective.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
                    detective.setVersion(rs.getInt("version"));
                    detective.setArmed(rs.getBoolean("armed"));
                    detective.setBadgeNumber(rs.getString("badgeNumber"));
                    detective.setUsername(rs.getString("username"));
                    detective.setFirstName(rs.getString("firstName"));
                    detective.setLastName(rs.getString("lastName"));
                    detective.setPassword(rs.getString("password"));
                    detective.setHiringDate(rs.getTimestamp("hiringDate").toLocalDateTime());
                    detective.setRank(Rank.valueOf(rs.getString("rank_detective")));
                    detective.setStatus(EmploymentStatus.valueOf(rs.getString("status_detective")));
                }
            }

            return detective;
        }
    }
}
