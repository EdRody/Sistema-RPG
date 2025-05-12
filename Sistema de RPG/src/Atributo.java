public class Atributo {
    Personagem personagem;
    String nome;
    String descricao;
    int valor;
    int bonusMod;
    String sigla;

    public Atributo(String nome, String descricao, int valor, int bonusMod, String sigla, Personagem personagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.bonusMod = bonusMod;
        this.sigla = sigla;
        this.personagem = personagem;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public int getBonusMod() {
        return bonusMod;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setBonusMod(int bonusMod) {
        this.bonusMod = bonusMod;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
