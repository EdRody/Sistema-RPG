public class Atributo {
    String nome;
    int valor;
    String sigla;

    public Atributo(String nome, int valor, String sigla) {
        this.nome = nome;
        this.valor = valor;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public int getBonusMod() {
        return (valor - 10) / 2;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
