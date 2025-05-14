public class Pericia {
    String nome;
    String descricao;
    int bonusMod;

    public Pericia(String nome, String descricao, int bonusMod) {
        this.nome = nome;
        this.descricao = descricao;
        this.bonusMod = bonusMod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getBonusMod() {
        return bonusMod;
    }

    public void setBonusMod(int bonusMod) {
        this.bonusMod = bonusMod;
    }
}
