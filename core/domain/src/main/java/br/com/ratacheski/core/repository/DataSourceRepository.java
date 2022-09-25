package br.com.ratacheski.core.repository;

import br.com.ratacheski.core.entity.DataSource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataSourceRepository extends MongoRepository<DataSource, String> {
    Optional<DataSource> findByName(String name);
}
