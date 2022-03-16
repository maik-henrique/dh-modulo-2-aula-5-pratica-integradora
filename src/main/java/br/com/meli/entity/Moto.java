package br.com.meli.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Moto extends Veiculo {
    public static final int NUMERO_RODAS = 4;
    public static final int PESO = 300;

    public Moto(double velocidade, double aceleracao, double anguloGiro, String placa) {
        super(velocidade, aceleracao, anguloGiro, placa, NUMERO_RODAS, PESO);
    }
}
