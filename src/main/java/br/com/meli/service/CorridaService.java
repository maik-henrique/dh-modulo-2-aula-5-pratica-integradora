package br.com.meli.service;

import br.com.meli.entity.Carro;
import br.com.meli.entity.Corrida;
import br.com.meli.entity.Moto;
import br.com.meli.entity.Veiculo;
import lombok.Builder;


import java.util.Optional;

@Builder
public class CorridaService {

    private Corrida corrida;
    private SocorreService socorreCarroService;
    private SocorreService socorreMotoService;

    public void adicionarVeiculo(Veiculo veiculo) {
        corrida.getVeiculos().add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo) {
        corrida.getVeiculos().removeIf(veiculoItem -> veiculoItem.equals(veiculo));
    }

    public void removeVeiculoByPlaca(String placa) {
        corrida.getVeiculos().removeIf(veiculo -> veiculo.getPlaca().equals(placa));
    }

    public void socorrer(Veiculo veiculo) {
        if (veiculo instanceof Carro)
            socorreCarroService.socorrer(veiculo);

        if (veiculo instanceof Moto)
            socorreMotoService.socorrer(veiculo);
    }

    public Veiculo getVencedor() {
        Optional<Veiculo> vencedor = corrida.getVeiculos().stream().max((a, b) -> {
            double pontuacaoA = calcularPontuacao(a);
            double pontuacaoB = calcularPontuacao(b);
            return Double.compare(pontuacaoA, pontuacaoB);
        });

        return vencedor.get();
    }

    public void imprimirCompetidores() {
        System.out.println("Lista de competidores inscritos:");
        corrida.getVeiculos().forEach(System.out::println);
    }

    private double calcularPontuacao(Veiculo a) {
        return a.getVelocidade() * 1 / 2 * a.getAceleracao() / (a.getAnguloGiro() * (a.getPeso() - (a.getRodas() / 100.0f)));
    }


}
