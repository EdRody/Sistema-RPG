import java.util.ArrayList;
import java.util.Arrays;

public class Cadastro {
    Leitor leitor = new Leitor();

    public Cadastro() {    }

    public String criarUsuario(ArrayList<Jogador> jogadores){
        boolean continuar = true;
        String nome = "";
        while(continuar) {
            boolean checar = true;
            nome = leitor.lerString("Digite seu nome");

            for (Jogador jogador : jogadores) {
                if (nome.equals(jogador.getUsername())){
                    System.out.println("Nome de usuário já utilizado.");
                    checar = false;
                }

            }
            if (checar){
                System.out.println("Usuario criado com sucesso!");
                continuar = false;
            }


        }
        return nome;
    }

    public Atributo escolherAtributos(String atributo, String siglaAtributo) {

        String nome = atributo;
        String sigla = siglaAtributo;
        int valor = leitor.lerInt("Digite o valor do atributo " + atributo);

        Atributo novoAtributo = new Atributo(nome, valor, sigla);
        return novoAtributo;
    }

    public Personagem criarPersonagem(Jogador jogador) {

        String nome = leitor.lerString("Digite o nome do personagem");
        String Campanha = leitor.lerString("Digite o nome da campanha");
        String racaNome = leitor.lerString("Digite o nome da raça");
        String racaDescricao = leitor.lerString("Digite uma descricao da raça " + racaNome);
        Raca raca = new Raca(nome, racaDescricao);
        String classeNome = leitor.lerString("Digite o nome da classe");
        String classeDescricao = leitor.lerString("Digite uma descrição da classe " + classeNome);
        Classe classe = new Classe(classeNome, classeDescricao);

        Personagem novoPersonagem = new Personagem(nome, Campanha, jogador, raca, classe);

        ArrayList<String> atributos = new ArrayList<>(Arrays.asList(
                "Força", "Destreza", "Inteligência", "Sabedoria", "Constituição", "Carisma"
        ));

        ArrayList<String> siglaAtributos = new ArrayList<>(Arrays.asList(
                "STR", "DEX", "INT", "WIS", "CON", "CHA"
        ));

        for (int i = 0; i < atributos.size(); i++) {
            Atributo novoAtributo = escolherAtributos(atributos.get(i), siglaAtributos.get(i));
            novoPersonagem.getAtributos().add(novoAtributo);
        }
        return novoPersonagem;
    }

    public Feitico criarFeitico() {
        char perguntar = leitor.lerChar("Criar novo feitiço? s/n");

        if (perguntar == 's') {
            String nomeFeitico = leitor.lerString("Nome do feitiço");
            String descricaoFeitico = leitor.lerString("Descrição do feitiço");
            int nivelFeitico = leitor.lerInt("Nivel do feitiço");

            Feitico novoFeitico = new Feitico(nomeFeitico, nivelFeitico, descricaoFeitico);
            return novoFeitico;
        }
        else {
            return null;
        }
    }

    public Item criarItem() {
        char perguntar = leitor.lerChar("Criar novo item? s/n");

        if (perguntar == 's') {
        String nomeItem = leitor.lerString("Nome do item");
        float quantItem = leitor.lerFloat("Quantidade do item");
        String descricaoItem = leitor.lerString("Descriçao do item");

        Item novoItem = new Item(nomeItem, quantItem, descricaoItem);
        return novoItem;
        }
        else {
            return null;
        }
    }



}
