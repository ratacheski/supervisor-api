package br.com.ratacheski.core.entity;

import br.com.ratacheski.core.enums.ModbusObjectType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class ModbusTcpConnectionParams implements ConnectionParams {
    private String host;
    private Integer port;
    private Integer offset;
    private Integer quantity;
    @Field(name = "object_type")
    private ModbusObjectType objectType;
}
