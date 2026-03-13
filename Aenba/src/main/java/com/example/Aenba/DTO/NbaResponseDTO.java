package com.example.Aenba.DTO;

import lombok.Data;

import java.util.List;
@Data
public class NbaResponseDTO {
    private List<ResultSetDTO> resultSets;

    @Data
    public static class ResultSetDTO {
        private String name;
        private List<String> headers;
        private List<List<Object>> rowSet;
    }
}

    /*
    Para proxima etapa do projeto e conseguir fazer o primeiro teste de API da NBA preciso concertar o seguinte erro
    COMENTARIO PARA NÃO ESQUECER

    Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2026-03-11T01:42:29.308-03:00 ERROR 18032 --- [Aenba] [  restartedMain] o.s.b.d.LoggingFailureAnalysisReporter   :

***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 2 of constructor in com.example.Aenba.Service.NbaService required a bean of type 'com.fasterxml.jackson.databind.ObjectMapper' that could not be found.


Action:

Consider defining a bean of type 'com.fasterxml.jackson.databind.ObjectMapper' in your configuration.


Process finished with exit code 0

     */
