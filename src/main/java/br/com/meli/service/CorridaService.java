package br.com.meli.service;

import br.com.meli.entity.Carro;
import br.com.meli.entity.Corrida;
import br.com.meli.entity.Moto;
import br.com.meli.entity.Veiculo;
import lombok.Builder;



@Builder
public class CorridaService {

    private final Corrida corrida;
    private final SocorreService<Carro> socorreCarroService;
    private final SocorreService<Moto> socorreMotoService;

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
            socorreCarroService.socorrer((Carro) veiculo);

        if (veiculo instanceof Moto)
            socorreMotoService.socorrer((Moto) veiculo);
    }

    public Veiculo getVencedor() {
        Veiculo veiculo = corrida.getVeiculos().stream().max((a, b) -> {
            double pontuacaoA = calcularPontuacao(a);
            double pontuacaoB = calcularPontuacao(b);
            return Double.compare(pontuacaoA, pontuacaoB);
        }).get();
        return veiculo;
    }

    public void imprimirCompetidores() {
        System.out.println("Lista de competidores inscritos:");
        corrida.getVeiculos().forEach(System.out::println);
    }

    private double calcularPontuacao(Veiculo a) {
        return a.getVelocidade() * 1 / 2 * a.getAceleracao() / (a.getAnguloGiro() * (a.getPeso() - (a.getRodas() / 100.0f)));
    }


}
