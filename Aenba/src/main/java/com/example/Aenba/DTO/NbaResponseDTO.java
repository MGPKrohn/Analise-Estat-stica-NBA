package com.example.Aenba.DTO;

import lombok.Data;

import java.util.List;

public class NbaResponseDTO {
    private List<ResultSetDTO> resultSets;
}
@Data
class ResultSetDTO {
    private List<String> headers;
    private List<List<Object>> rowSet;
}