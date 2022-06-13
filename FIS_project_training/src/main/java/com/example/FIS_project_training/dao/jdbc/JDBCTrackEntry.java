package com.example.FIS_project_training.dao.jdbc;

import com.example.FIS_project_training.dao.IDAOTrackEntry;
import com.example.FIS_project_training.model.TrackEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCTrackEntry implements IDAOTrackEntry {
    private final static Logger logger = LoggerFactory.getLogger(JDBCTrackEntry.class);
    
    @Override
    public TrackEntry save(TrackEntry trackEntry) {
        return null;
    }

    @Override
    public Optional<TrackEntry> findById(Long id) {
        try(Connection con = DBConnect.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("SELECT * FROM track_entry WHERE track_entry_id = ?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            TrackEntry trackEntry = null;
            if(rs.next()) {
                trackEntry = DBMapper.getTrackEntry(rs);
            }
            Optional<TrackEntry> opt = Optional.of(trackEntry);
            if(opt.isPresent())
                return Optional.of(opt.get());

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<TrackEntry> findAll() {
        List<TrackEntry> trackEntryList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM track_entry");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TrackEntry trackEntry = DBMapper.getTrackEntry(rs);
                if(trackEntry != null)
                    trackEntryList.add(trackEntry);
            } // end of while

            return trackEntryList;
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(TrackEntry trackEntry) {

    }

    @Override
    public TrackEntry delete(TrackEntry trackEntry) {
        return null;
    }
}
