package com.example.FIS_project_training.dao.jdbc;

import com.example.FIS_project_training.dao.IDAOCriminalDetective;
import com.example.FIS_project_training.model.CriminalDetective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalDetective implements IDAOCriminalDetective {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalDetective.class);
    @Override
    public CriminalDetective save(CriminalDetective criminalDetective) {
        return null;
    }



    @Override
    public Optional<CriminalDetective> findById(Long id) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("SELECT * FROM criminal_detective WHERE criminal_detective_id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            CriminalDetective criminalDetective = null;
            if(rs.next()) {
                criminalDetective = DBMapper.getCriminalDetective(rs);
            }
            Optional<CriminalDetective> opt = Optional.of(criminalDetective);
            if(opt.isPresent())
                return Optional.of(opt.get());

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<CriminalDetective> findAll() {
        List<CriminalDetective> criminalDetectiveList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM criminal_detective");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CriminalDetective criminalDetective = DBMapper.getCriminalDetective(rs);
                if(criminalDetective != null)
                    criminalDetectiveList.add(criminalDetective);
            } // end of while
            return criminalDetectiveList;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(CriminalDetective CriminalDetective) {

    }

    @Override
    public CriminalDetective delete(CriminalDetective CriminalDetective) {
        return null;
    }
}
