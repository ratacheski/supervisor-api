package br.com.ratacheski.core.repository;

import br.com.ratacheski.core.entity.SensorMeasurement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorMeasurementRepository extends MongoRepository<SensorMeasurement,String> {
}
