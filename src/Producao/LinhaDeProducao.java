package Producao;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Especificos.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LinhaDeProducao {

    private ArrayList<Equipamento> equipamentos;

    public LinhaDeProducao() {

        equipamentos = new ArrayList<>();
    }

    public void carregarPedido(String arquivo)
            throws Exception {

        List<String> linhas =
                Files.readAllLines(
                        Path.of(arquivo)
                );

        for (String linha : linhas) {

            linha = linha.trim();
            if (linha.isEmpty()) continue;

            switch (linha.toUpperCase()) {

                case "ANTENA":

                    equipamentos.add(
                            new Antena()
                    );
                    break;

                case "FIBRA OPTICA":

                    equipamentos.add(
                            new FibraOptica()
                    );
                    break;

                case "ROTEADOR":

                    equipamentos.add(
                            new Roteador()
                    );
                    break;

                default:

                    throw new ExcecaoProducao(
                            "Equipamento inválido: "
                                    + linha
                    );
            }
        }

        if (equipamentos.isEmpty()) {

            throw new ExcecaoProducao(
                    "Pedido vazio."
            );
        }
    }

    public void iniciarProducao() throws ExcecaoProducao {
        if (equipamentos.isEmpty()) {
            throw new ExcecaoProducao("Nenhum equipamento carregado para produção.");
        }

        System.out.println("\n===== INICIANDO PRODUÇÃO =====");
        for (Equipamento equipamento : equipamentos) {
            EsteiraProducao esteira = new EsteiraProducao(equipamento);
            esteira.produzir(); // Executa as etapas e só então passa ao próximo.
        }
        System.out.println("\n===== PRODUÇÃO FINALIZADA =====");
    }
}
