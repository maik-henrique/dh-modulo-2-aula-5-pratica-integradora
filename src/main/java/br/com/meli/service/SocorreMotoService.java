package br.com.meli.service;

import br.com.meli.entity.Moto;
import br.com.meli.entity.Veiculo;

public class SocorreMotoService implements SocorreService {
    @Override
    public void socorrer(Veiculo veiculo) {
        if (!(veiculo instanceof Moto)) {
            System.out.println("Só sei socorrer moto!");
            return;
        }
        System.out.printf("Socorrendo a moto: %s\n", veiculo.toString());
    }
}
