package br.com.meli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private double velocidade;
    private double aceleracao;
    private double anguloGiro;
    private String placa;
    private int rodas;
    private double peso;
}
