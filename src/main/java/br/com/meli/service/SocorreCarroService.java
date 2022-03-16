package br.com.meli.service;

import br.com.meli.entity.Carro;

public class SocorreCarroService implements SocorreService<Carro> {
    @Override
    public void socorrer(Carro veiculo) {
        System.out.printf("Socorrendo o carro: %s\n", veiculo.toString());
    }
}
