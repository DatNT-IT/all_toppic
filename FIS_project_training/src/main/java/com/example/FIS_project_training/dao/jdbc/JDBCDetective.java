package com.example.FIS_project_training.dao.jdbc;

import com.example.FIS_project_training.dao.IDAODetective;
import com.example.FIS_project_training.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetective implements IDAODetective {
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetective.class);

    public JDBCDetective() {
    }

    @Override
    public Detective save(Detective detective) {
        return null;
    }

    public Optional<Detective> findById(Long id) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("SELECT * FROM detective WHERE detective_id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            Detective detective = null;
            if(rs.next()) {
                detective = DBMapper.getDetective(rs);
            }
            Optional<Detective> opt = Optional.of(detective);
            if(opt.isPresent())
                return Optional.of(opt.get());

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<Detective> findAll() {
        List<Detective> detectiveList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Detective Detective = DBMapper.getDetective(rs);
                if(Detective != null)
                    detectiveList.add(Detective);
            } // end of while
            return detectiveList;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(Detective detective) {

    }

    @Override
    public Detective delete(Detective detective) {
        return null;
    }
}
