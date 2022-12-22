package com.example.demo.dto;

import com.example.demo.model.Refeicao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter @Setter
public class DietaDTO {

    private List<Refeicao> dia;

    private Long nutriID;

    private Long patientID;

    public DietaDTO(List<Refeicao> dia, Long nutriID, Long patientID) {
        this.dia = dia;
        this.nutriID = nutriID;
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "DietaDTO{" +
                "dia=" + dia +
                ", nutri=" + nutriID +
                ", patient=" + patientID +
                '}';
    }
}
