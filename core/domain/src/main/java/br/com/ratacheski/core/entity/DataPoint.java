package br.com.ratacheski.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;

@Document(collection = "datapoint")
@Data
@NoArgsConstructor
public class DataPoint {
    @Id
    private String id;

    @DocumentReference(lazy = true)
    private DataSource dataSource;

    private String lastValue;

    private String maxCurrDayValue;

    private LocalDate dateOfMaxValue;

    public DataPoint(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
