package com.example.FIS_project_training.dao.jdbc;

import com.example.FIS_project_training.dao.IDAOEvidence;
import com.example.FIS_project_training.model.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCEvidence implements IDAOEvidence {
    private final static Logger logger = LoggerFactory.getLogger(JDBCEvidence.class);
    @Override
    public Evidence save(Evidence evidence) {
        return null;
    }

    public Optional<Evidence> findById(Long id) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("SELECT * FROM evidence WHERE evidence_id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            Evidence evidence = null;
            if(rs.next()) {
                evidence = DBMapper.getEvidence(rs);
            }
            Optional<Evidence> opt = Optional.of(evidence);
            if(opt.isPresent())
                return Optional.of(opt.get());

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<Evidence> findAll() {
        List<Evidence> evidenceList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM evidence");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evidence evidence = DBMapper.getEvidence(rs);
                if(evidence != null)
                    evidenceList.add(evidence);
            } // end of while

            return evidenceList;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(Evidence evidence) {

    }

    @Override
    public Evidence delete(Evidence evidence) {
        return null;
    }
}
