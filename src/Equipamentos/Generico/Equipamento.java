package Equipamentos.Generico;

public abstract class Equipamento {

    private final String nome;
    private final int id;
    private static int contador;

   
    public Equipamento(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do equipamento não pode ser vazio.");
        }

        this.nome = nome;
        contador++;
        this.id = contador;
    }

    public static void resetContagem() {
        contador = 0;
    }


    public abstract String getTipo();

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
