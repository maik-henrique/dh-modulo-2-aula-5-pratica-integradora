package br.com.meli.service;

import br.com.meli.entity.Moto;

public class SocorreMotoService implements SocorreService<Moto> {
    @Override
    public void socorrer(Moto veiculo) {
        System.out.printf("Socorrendo a moto: %s\n", veiculo.toString());
    }
}
