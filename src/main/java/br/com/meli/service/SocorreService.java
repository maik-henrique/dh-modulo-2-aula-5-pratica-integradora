package br.com.meli.service;

import br.com.meli.entity.Veiculo;

public interface SocorreService<T extends Veiculo> {

    void socorrer(T veiculo);
}
