package br.com.meli;

import br.com.meli.entity.Carro;
import br.com.meli.entity.Corrida;
import br.com.meli.entity.Moto;
import br.com.meli.entity.Veiculo;
import br.com.meli.service.CorridaService;
import br.com.meli.service.SocorreCarroService;
import br.com.meli.service.SocorreMotoService;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Corrida corrida = Corrida.builder().distancia(32.12d)
                .nome("Corrida maluca")
                .premioDolares(311313)
                .quantidadeVeiculosPermitidos(5)
                .veiculos(new LinkedList<>())
                .build();

        CorridaService corridaService = CorridaService.builder()
                .corrida(corrida)
                .socorreCarroService(new SocorreCarroService())
                .socorreMotoService(new SocorreMotoService())
                .build();

        Veiculo fusca = new Carro(80.0f, 10.0f, 40.0f, "NULL-1343");
        Veiculo kawasakiNinja = new Moto(120.0f, 20.0f, 20.0f, "PRPR-1222");

        corridaService.adicionarVeiculo(fusca);
        corridaService.adicionarVeiculo(kawasakiNinja);

        Veiculo vencedor = corridaService.getVencedor();
        System.out.println("Vencedor:");
        System.out.println(vencedor);

        corridaService.socorrer(fusca);

        corridaService.imprimirCompetidores();

        System.out.println("Removendo carro");
        corridaService.removeVeiculo(fusca);

        corridaService.imprimirCompetidores();

        System.out.println("Removendo moto");
        corridaService.removeVeiculoByPlaca(kawasakiNinja.getPlaca());

        corridaService.imprimirCompetidores();

    }
}
