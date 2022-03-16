package br.com.meli.service;

import br.com.meli.entity.Carro;
import br.com.meli.entity.Veiculo;

public class SocorreCarroService implements SocorreService {
    @Override
    public void socorrer(Veiculo veiculo) {
        if (!(veiculo instanceof Carro)) {
            System.out.println("Só sei socorrer carro!");
            return;
        }

        System.out.printf("Socorrendo o carro: %s\n", veiculo.toString());
    }
}
