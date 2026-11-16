package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Configuracao;
import Equipamentos.Interfaces.Inspecao;
import Equipamentos.Interfaces.Teste;

public class Antena extends Equipamento implements Configuracao, Inspecao, Teste {

    public Antena() {
        super("Antena de telecomunicações");
    }

    @Override
    public String getTipo() {
        return "Antena";
    }

    @Override
    public void configurando() {
        System.out.println("Configurando identificação da faixa de operação da antena...");
        System.out.println("Conferindo polarização e especificacoes do modelo...");
        System.out.println("Configuracao da antena concluída.");
    }

    @Override
    public void inspecionando() {
        System.out.println("Inspecionando radome, estrutura e elementos radiantes...");
        System.out.println("Verificando conectores e fixacoes mecânicas...");
        System.out.println("Inspecao concluída para antena, equipamento número " + getId() + ".");
    }

    @Override
    public void testandoFuncionamento() {
        System.out.println("Verificando continuidade do caminho de RF...");
        System.out.println("Registrando resultado de teste de ROE/VSWR (simulação)...");
        System.out.println("Verificando integridade dos conectores e desempenho de RF...");
        System.out.println("Testes concluídos para antena, equipamento número " + getId() + ".");
    }
}
