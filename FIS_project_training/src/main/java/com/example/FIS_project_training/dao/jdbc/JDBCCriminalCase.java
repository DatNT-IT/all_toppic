package com.example.FIS_project_training.dao.jdbc;

import com.example.FIS_project_training.dao.IDAOCriminalCase;
import com.example.FIS_project_training.model.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalCase implements IDAOCriminalCase {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCase.class);
    @Override
    public CriminalCase save(CriminalCase criminalCase) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("INSERT INTO criminal_case values (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setLong(1,criminalCase.getId());
            stmt.setInt(2,criminalCase.getVersion());
            stmt.setDate(3, Date.valueOf(criminalCase.getCreatedAt().toLocalDate()));
            stmt.setDate(4, Date.valueOf(criminalCase.getModifiedAt().toLocalDate()));
            stmt.setString(5,criminalCase.getNumber());
            stmt.setString(6, criminalCase.getType().toString());
            stmt.setString(7,criminalCase.getShortDescription());
            stmt.setString(8,criminalCase.getDetailedDescription());
            stmt.setString(9, criminalCase.getStatus().toString());
            stmt.setString(10, criminalCase.getNotes());
            stmt.setLong(11, criminalCase.getLeadInvestigator().getId());
            stmt.executeUpdate();
            return criminalCase;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    public Optional<CriminalCase> findById(Long id) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("SELECT * FROM criminal_case WHERE criminal_case_id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            CriminalCase criminalCase = null;
            if(rs.next()) {
                criminalCase = DBMapper.getCriminalCase(rs);
            }
            Optional<CriminalCase> opt = Optional.of(criminalCase);
            if(opt.isPresent())
                return Optional.of(opt.get());

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<CriminalCase> findAll() {
        List<CriminalCase> criminalCaseList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM criminal_case");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CriminalCase criminalCase = DBMapper.getCriminalCase(rs);
                if(criminalCase != null)
                    criminalCaseList.add(criminalCase);
            } // end of while
            return criminalCaseList;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(CriminalCase criminalCase) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE criminal_case " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, number = ?, type = ?, " +
                            "short_description = ?, detailed_description = ?" +
                            ",status = ?, notes = ?, lead_investigator = ? WHERE criminal_case_id = ?");
            stmt.setInt(1,criminalCase.getVersion());
            stmt.setDate(2, Date.valueOf(criminalCase.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(criminalCase.getModifiedAt().toLocalDate()));
            stmt.setString(4,criminalCase.getNumber());
            stmt.setString(5, criminalCase.getType().toString());
            stmt.setString(6,criminalCase.getShortDescription());
            stmt.setString(7,criminalCase.getDetailedDescription());
            stmt.setString(8, criminalCase.getStatus().toString());
            stmt.setString(9, criminalCase.getNotes());
            stmt.setLong(10, criminalCase.getLeadInvestigator().getId());
            stmt.setLong(11,criminalCase.getId());
            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public CriminalCase delete(CriminalCase criminalCase) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM criminal_case WHERE criminal_case_id = ?");
            stmt.setLong(1,criminalCase.getId());
            stmt.executeUpdate();
            return criminalCase;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }
}
