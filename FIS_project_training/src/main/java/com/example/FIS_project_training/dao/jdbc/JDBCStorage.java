package com.example.FIS_project_training.dao.jdbc;

import com.example.FIS_project_training.dao.IDAOStorage;
import com.example.FIS_project_training.model.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCStorage implements IDAOStorage {
    private final static Logger logger = LoggerFactory.getLogger(JDBCStorage.class);
    @Override
    public Storage save(Storage storage) {
        return null;
    }

    public Optional<Storage> findById(Long id) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("SELECT * FROM storage WHERE storage_id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            Storage storage = null;
            if(rs.next()) {
                storage = DBMapper.getStorage(rs);
            }
            Optional<Storage> opt = Optional.of(storage);
            if(opt.isPresent())
                return Optional.of(opt.get());

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<Storage> findAll() {
        List<Storage> storageList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM storage");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Storage storage = DBMapper.getStorage(rs);
                if(storage != null)
                    storageList.add(storage);
            } // end of while
            return storageList;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(Storage storage) {

    }

    @Override
    public Storage delete(Storage storage) {
        return null;
    }
}
