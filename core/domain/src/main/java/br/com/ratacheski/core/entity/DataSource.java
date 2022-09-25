package br.com.ratacheski.core.entity;

import br.com.ratacheski.core.enums.DataProtocol;
import br.com.ratacheski.core.enums.DataType;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "datasource")
@Data
public class DataSource {
    @Id
    private String id;
    private String name;
    @CreatedDate
    private LocalDateTime createdAt;
    @Field(name = "data_protocol")
    private DataProtocol dataProtocol;
    @Field(name = "fetch_interval")
    private Integer fetchInterval;
    private DataType dataType;
    private ConnectionParams connectionParams;
}
