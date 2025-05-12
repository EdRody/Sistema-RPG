import java.util.ArrayList;

public class Personagem {
    String nome;
    String campanha;
    float dinheiro;
    int nivel;
    Jogador jogador;
    Raca raca;
    Classe classe;
    ArrayList<Pericia> pericias;
    ArrayList<Feitico> feiticos;
    ArrayList<Atributo> atributos;
    ArrayList<Item> itens;

    public Personagem(String nome, String campanha, Jogador jogador, Raca raca, Classe classe) {
        this.nome = nome;
        this.campanha = campanha;
        this.jogador = jogador;
        this.raca = raca;
        this.classe = classe;
        this.nivel = 0;
        this.dinheiro = 0;
        this.atributos = new ArrayList<>();
        this.feiticos = new ArrayList<>();
        this.pericias = new ArrayList<>();
        this.itens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCampanha() {
        return campanha;
    }

    public void setCampanha(String campanha) {
        this.campanha = campanha;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public ArrayList<Pericia> getPericias() {
        return pericias;
    }

    public void setPericias(ArrayList<Pericia> pericias) {
        this.pericias = pericias;
    }

    public ArrayList<Feitico> getFeiticos() {
        return feiticos;
    }

    public void setFeiticos(ArrayList<Feitico> feiticos) {
        this.feiticos = feiticos;
    }

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Atributo> atributos) {
        this.atributos = atributos;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void mostrarDetalhes() {
        System.out.println("==== Detalhes da Ficha ====");
        System.out.println("Nome: " + getNome());
        System.out.println("Campanha: " + getCampanha());
        System.out.println("Nível: " + getNivel());
        System.out.println("Dinheiro: " + getDinheiro());

        if (getRaca() != null) {
            System.out.println("Raça: " + getRaca().getNome()); // Supondo que Raca tem getNome()
        } else {
            System.out.println("Raça: (não definida)");
        }

        if (getClasse() != null) {
            System.out.println("Classe: " + getClasse().getNome()); // Supondo que Classe tem getNome()
        } else {
            System.out.println("Classe: (não definida)");
        }

        System.out.println("Atributos:");
        if (!getAtributos().isEmpty()) {
            for (Atributo atributo : getAtributos()) {
                System.out.println(STR."  \{atributo.getSigla()}: \{atributo.getValor()}");
            }
        } else {
            System.out.println("  Nenhum atributo cadastrado.");
        }

        System.out.println("Feitiços:");
        if (getFeiticos().isEmpty()) {
            System.out.println("  Nenhum feitiço cadastrado.");
        } else {
            for (Feitico f : getFeiticos()) {
                System.out.println("  " + f.getNome());
            }
        }

        System.out.println("Itens:");
        if (getItens().isEmpty()) {
            System.out.println("  Nenhum item cadastrado.");
        } else {
            for (Item item : getItens()) {
                System.out.println("  " + item.getNome());
            }
        }

        System.out.println("Perícias:");
        if (getPericias().isEmpty()) {
            System.out.println("  Nenhuma perícia cadastrada.");
        } else {
            for (Pericia p : getPericias()) {
                System.out.println("  " + p.getNome());
            }
        }

    }

}

