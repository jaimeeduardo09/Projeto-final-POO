package Producao;

import Equipamentos.Generico.Equipamento;
import Equipamentos.Interfaces.*;


public class EsteiraProducao {

    private final Equipamento equipamento;

    public EsteiraProducao(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void produzir() throws ExcecaoProducao {
        try {
            System.out.println("\n=================================");
            System.out.println("Produzindo " + equipamento.getNome()
                    + " (ID " + equipamento.getId() + ")");
            System.out.println("=================================");

            if (equipamento instanceof Configuracao) {
                ((Configuracao) equipamento).configurando();
            }

            if (equipamento instanceof Inspecao) {
                ((Inspecao) equipamento).inspecionando();
            }

            if (equipamento instanceof Teste) {
                ((Teste) equipamento).testandoFuncionamento();
            }

            System.out.println(equipamento.getNome() + " finalizado com sucesso.");
        } catch (Exception e) {
            throw new ExcecaoProducao("Falha ao produzir "
                    + equipamento.getNome() + " (ID " + equipamento.getId()
                    + "): " + e.getMessage());
        }
    }
}
