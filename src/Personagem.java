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

    Cadastro cadastro = new Cadastro();

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
        this.nivel = 1;
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
        System.out.println("Raça: " + getRaca().getNome());
        System.out.println("Classe: " + getClasse().getNome());

        System.out.println("Atributos:");
        if (!getAtributos().isEmpty()) {
            for (Atributo atributo : getAtributos()) {
                String sinal = "+";
                if (atributo.getBonusMod() < 0){
                    sinal = "";
                } else {
                    sinal = "+";
                }
                System.out.println(atributo.getSigla() + ": " + atributo.getValor() + " mod = " + sinal + atributo.getBonusMod());
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
            for (Pericia pericia : getPericias()) {
                System.out.println("  " + pericia.getNome() + "+" + pericia.getBonusMod());
            }
        }

    }

    public void menuPersonagem(){
        Leitor leitor = new Leitor();
        boolean ficha = true;

        while (ficha) {
            System.out.println("Ficha de " + getNome());
            System.out.println("Opções:");
            System.out.println("1: Verificar detalhes da ficha     2: Gerenciar Nível");
            System.out.println("3: Gerenciar feitiços              4: Gerenciar Itens");
            System.out.println("5: Gerenciar perícias              6: Gerenciar dinheiro");
            System.out.println("0: Sair");

            int opcao = leitor.lerInt("Selecione uma opção");

            switch (opcao) {
                case 1:
                    mostrarDetalhes();
                    break;
                case 2:
                    int alterarNivel = leitor.lerInt("Digite '1' para aumentar um nível, '2' para diminuir um nível ou qualquer outro dígito para sair");

                    switch(alterarNivel) {
                        case 1:{
                            setNivel(nivel + 1);
                            break;
                    }
                        case 2:{
                            setNivel(nivel - 1);
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Lista de feitiços");
                    for (Feitico feitico : getFeiticos()) {
                        System.out.println("Nome: " + feitico.getNome());
                        System.out.println("Nível: " + feitico.getNivel());
                        System.out.println("Descricao: " + feitico.getDescricao());
                        System.out.println("");
                    }
                    Feitico novoFeitico = cadastro.criarFeitico();

                    if (novoFeitico != null) {
                        getFeiticos().add(novoFeitico);
                        System.out.println("Feitiço " + novoFeitico.getNome() + " adicionado à lista de feitiços!");
                    }
                    break;
                case 4:
                    System.out.println("Inventário: ");
                    for (Item item : getItens()) {
                        System.out.println("Nome: " + item.getNome());
                        System.out.println("Quantidade: " + item.getQuantidade());
                        System.out.println("Descricao: " + item.getDescricao());
                        System.out.println("");
                    }
                    Item novoItem = cadastro.criarItem();

                    if (novoItem != null) {
                        getItens().add(novoItem);
                        System.out.println("Item " + novoItem.getNome() + " adicionado ao inventário!");
                    }
                    break;
                case 5:
                    String nomePericia = leitor.lerString("Nome da perícia");
                    String descricaoPericia = leitor.lerString("Descrição da perícia");
                    int bonusPericia = leitor.lerInt("Bônus da perícia");

                    Pericia novaPericia = new Pericia(nomePericia, descricaoPericia, bonusPericia);
                    getPericias().add(novaPericia);
                    System.out.println("Pericia " + novaPericia.getNome() + " adicionada!");

                    break;
                case 8:
                    System.out.println("Lista perícias: ");
                    for (Pericia pericia : getPericias()) {
                        System.out.println("Nome: " + pericia.getNome());
                        System.out.println("Quantidade: " + pericia.getBonusMod());
                        System.out.println("Descricao: " + pericia.getDescricao());
                        System.out.println("");
                    }
                    break;
                case 0:
                    ficha = false; // sai do menu
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }


        }
    }

}

