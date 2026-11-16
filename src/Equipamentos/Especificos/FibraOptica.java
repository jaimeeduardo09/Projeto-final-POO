package Equipamentos.Especificos;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.Inspecao;
import Equipamentos.Interfaces.Teste;

public class FibraOptica extends Equipamento implements Inspecao, Teste {

    public FibraOptica() {
        super("Cabo de fibra óptica");
    }

    @Override
    public String getTipo() {
        return "Cabo de fibra óptica";
    }

    @Override
    public void inspecionando() {
        System.out.println("Inspecionando capa e integridade do cabo óptico...");
        System.out.println("Verificando acabamento e limpeza dos conectores...");
        System.out.println("Inspecao concluída para cabo de fibra óptica, equipamento número " + getId() + ".");
    }

    @Override
    public void testandoFuncionamento() {
        System.out.println("Verificando continuidade da fibra óptica...");
        System.out.println("Realizando teste de atenuação óptica (simulação)...");
        System.out.println("Verificando identificação e tipo dos conectores...");
        System.out.println("Testes concluídos para cabo de fibra óptica, equipamento número " + getId() + ".");
    }
}
