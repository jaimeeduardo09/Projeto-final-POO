
package Main;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Equipamentos.Generico.Equipamento;
import Producao.ExcecaoProducao;
import Producao.LinhaDeProducao;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final PedidoArquivo PEDIDO_ARQUIVO =
            new PedidoArquivo();

    private static final String[] CODIGOS_EQUIPAMENTOS = {
            "ANTENA",
            "FIBRA OPTICA",
            "ROTEADOR"
    };

    private static final String[] NOMES_EQUIPAMENTOS = {
            "Antena de telecomunicações",
            "Cabo de fibra óptica",
            "Roteador"
    };

    public static void main(String[] args) {

        System.out.println(
                "Sistema de Controle de Produção de Equipamentos de Telecomunicações"
        );

        boolean executando = true;

        while (executando) {

            exibirMenuPrincipal();

            int opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    criarPedido();
                    break;

                case 2:
                    listarEquipamentos();
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println(
                            "Opção inválida. Tente novamente."
                    );
            }
        }

        SCANNER.close();
    }

    private static void exibirMenuPrincipal() {

        System.out.println();
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1 - Criar pedido de produção");
        System.out.println("2 - Listar equipamentos disponíveis");
        System.out.println("0 - Sair");
        System.out.println("==========================");
    }

    private static void listarEquipamentos() {

        System.out.println();
        System.out.println("Equipamentos disponíveis:");

        for (int i = 0; i < NOMES_EQUIPAMENTOS.length; i++) {

            System.out.printf(
                    "%d - %s%n",
                    i + 1,
                    NOMES_EQUIPAMENTOS[i]
            );
        }
    }

    private static void criarPedido() {

        List<String> equipamentosPedido = new ArrayList<>();

        boolean adicionando = true;

        while (adicionando) {

            listarEquipamentos();

            System.out.println("0 - Finalizar pedido");

            int escolha = lerInteiro(
                    "Digite o número do equipamento desejado: "
            );

            if (escolha == 0) {

                adicionando = false;
                continue;
            }

            if (escolha < 1 ||
                    escolha > CODIGOS_EQUIPAMENTOS.length) {

                System.out.println(
                        "Equipamento inválido. Tente novamente."
                );

                continue;
            }

            int quantidade = lerInteiroPositivo(
                    "Digite a quantidade: "
            );

            adicionarEquipamentos(
                    equipamentosPedido,
                    CODIGOS_EQUIPAMENTOS[escolha - 1],
                    quantidade
            );

            System.out.println(
                    "Item adicionado: "
                            + NOMES_EQUIPAMENTOS[escolha - 1]
                            + " x"
                            + quantidade
            );

            adicionando = perguntarSimNao(
                    "Deseja adicionar outro equipamento? (S/N): "
            );
        }

        if (equipamentosPedido.isEmpty()) {

            System.out.println(
                    "Pedido cancelado. Nenhum equipamento foi adicionado."
            );

            return;
        }

        salvarPedido(equipamentosPedido);
    }

    private static void adicionarEquipamentos(
            List<String> equipamentosPedido,
            String codigoEquipamento,
            int quantidade
    ) {

        for (int i = 0; i < quantidade; i++) {

            equipamentosPedido.add(codigoEquipamento);
        }
    }

    private static void salvarPedido(
            List<String> equipamentosPedido
    ) {

        try {

            Path arquivoPedido =
                    PEDIDO_ARQUIVO.salvarPedido(
                            equipamentosPedido
                    );

            System.out.println();

            System.out.println(
                    "Pedido salvo em: "
                            + arquivoPedido.toAbsolutePath()
            );

            exibirResumoPedido(arquivoPedido);

            LinhaDeProducao linhaDeProducao =
                    new LinhaDeProducao();

            linhaDeProducao.carregarPedido(
                    arquivoPedido.toString()
            );

            linhaDeProducao.iniciarProducao();

            System.out.println();
            System.out.println(
                    "Pedido produzido com sucesso."
            );

        } catch (ExcecaoProducao e) {

            System.out.println(
                    "Erro durante a produção: " + e.getMessage()
            );

        } catch (IOException e) {

            System.out.println(
                    "Erro ao acessar o arquivo do pedido: "
                            + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Não foi possível processar o pedido: "
                            + e.getMessage()
            );

        } finally {

            Equipamento.resetContagem();

            System.out.println(
                    "Processamento do pedido encerrado."
            );
        }
    }

    private static void exibirResumoPedido(Path arquivoPedido)
            throws IOException {

        List<String> linhas =
                PEDIDO_ARQUIVO.lerPedido(arquivoPedido);

        System.out.println();
        System.out.println("Resumo do pedido:");

        for (String linha : linhas) {

            System.out.println("- " + linha);
        }
    }

    private static int lerInteiro(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String entrada = SCANNER.nextLine().trim();

            try {

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Entrada inválida. Digite apenas números."
                );
            }
        }
    }

    private static int lerInteiroPositivo(String mensagem) {

        while (true) {

            int valor = lerInteiro(mensagem);

            if (valor > 0) {

                return valor;
            }

            System.out.println(
                    "A quantidade deve ser maior que zero."
            );
        }
    }

    private static boolean perguntarSimNao(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String resposta = SCANNER.nextLine().trim();

            if (resposta.equalsIgnoreCase("S")) {

                return true;
            }

            if (resposta.equalsIgnoreCase("N")) {

                return false;
            }

            System.out.println(
                    "Resposta inválida. Digite S ou N."
            );
        }
    }
}
