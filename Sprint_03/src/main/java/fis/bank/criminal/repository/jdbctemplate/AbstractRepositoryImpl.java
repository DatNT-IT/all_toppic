package fis.bank.criminal.repository.jdbctemplate;

import fis.bank.criminal.model.AbstractEntity;
import fis.bank.criminal.model.Detective;
import fis.bank.criminal.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Set;

public class AbstractRepositoryImpl<T extends AbstractEntity> implements AbstractRepository<T> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public AbstractRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(T obj) {
        throw new RuntimeException("Not needed for this implementation.");
    }

    @Override
    public Set<Detective> getALl() {
        throw new RuntimeException("Not needed for this implementation.");
    }

    @Override
    public T findById(Long id) {
        throw new RuntimeException("Not needed for this implementation.");
    }

    @Override
    public T update(T obj) {
        throw new RuntimeException("Not needed for this implementation.");
    }

    @Override
    public void deleteById(Long id) {
        throw new RuntimeException("Not needed for this implementation.");
    }

    @Override
    public T finbyId(Long id) {
        throw new RuntimeException("Not needed for this implementation.");
    }
}
