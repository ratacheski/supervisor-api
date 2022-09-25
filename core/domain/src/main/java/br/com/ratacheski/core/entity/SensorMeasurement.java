package br.com.ratacheski.core.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.TimeSeries;
import org.springframework.data.mongodb.core.timeseries.Granularity;

import java.time.Instant;

@TimeSeries(granularity = Granularity.MINUTES,collection = "sensor_measurement",timeField = "timestamp",metaField = "dataPoint")
@Data
public class SensorMeasurement {
    private String id;
    private Instant timestamp;
    @DocumentReference(lazy = true)
    private DataPoint dataPoint;
    private String value;

}
