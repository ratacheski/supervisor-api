package br.com.ratacheski.core.entity;

import br.com.ratacheski.core.enums.RequestMethod;
import lombok.Data;

@Data
public class RestConnectionParams implements ConnectionParams {
    private String host;
    private Integer port;
    private RequestMethod requestMethod;
}
