package br.com.meli.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Corrida {
    private double distancia;
    private double premioDolares;
    private String nome;
    private int quantidadeVeiculosPermitidos;
    private final List<Veiculo> veiculos;

}
