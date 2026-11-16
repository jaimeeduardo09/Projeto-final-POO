package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Configuracao;
import Equipamentos.Interfaces.Inspecao;
import Equipamentos.Interfaces.Teste;

public class Roteador extends Equipamento implements Configuracao, Inspecao, Teste {

    public Roteador() {
        super("Roteador");
    }

    @Override
    public String getTipo() {
        return "Roteador";
    }

    @Override
    public void configurando() {
        System.out.println("Gravando e verificando o firmware do roteador...");
        System.out.println("Configurando parametros básicos de rede e Wi-Fi...");
        System.out.println("Roteador (ID: " + getId() + ") configurado.");
    }

    @Override
    public void inspecionando() {
        System.out.println("Inspecionando carcaça e acabamento do roteador...");
        System.out.println("Verificando conectores WAN/LAN, botões e antenas...");
        System.out.println("Inspecao concluída para roteador, equipamento número " + getId() + ".");
    }

    @Override
    public void testandoFuncionamento() {
        System.out.println("Testando inicialização do roteador...");
        System.out.println("Testando portas Ethernet e conectividade Wi-Fi...");
        System.out.println("Testando estabilidade basica da conexão...");
        System.out.println("Testes concluídos para roteador, equipamento número " + getId() + ".");
    }
}
