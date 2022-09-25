package br.com.ratacheski.core.repository;

import br.com.ratacheski.core.entity.DataPoint;
import br.com.ratacheski.core.entity.DataSource;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DataPointRepository extends MongoRepository<DataPoint, String> {
    Optional<DataPoint> findDataPointByDataSource(DataSource dataSource);
}

