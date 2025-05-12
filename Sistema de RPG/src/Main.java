import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Leitor leitor = new Leitor();
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

        while(true){
            Imprimir("Bem vindo ao Void RPG, seu melhor sistema de gerenciamento de fichas!!");
            Imprimir("");
            Imprimir("Selecione uma opção:");
            Imprimir("1 - Criar uma conta");
            Imprimir("2 - Acessar uma conta");
            Imprimir("0 - Sair do sistema");

            int opcao = leitor.lerInt("Digite um número");

            if(opcao == 1){
                boolean continuar = true;
                while(continuar) {
                    String nome = leitor.lerString("Digite seu nome");
                    boolean checar = true;

                    for (Jogador jogador : jogadores) {
                        if (nome.equals(jogador.getUsername())){
                            Imprimir("Nome de usuário já utilizado.");
                            checar = false;
                        }
                    }
                    if (checar){
                    Jogador jogador = new Jogador(nome);
                    jogadores.add(jogador);
                    Imprimir("Usuario criado com sucesso!");
                    continuar = false;
                    }
                }
            } else if(opcao == 2) {

                if (jogadores.size() == 0){
                    Imprimir("Nenhum usuário encontrado");
            } else {

                Imprimir("Jogadores cadastrados:");
                for(int indiceJogador = 0; indiceJogador < jogadores.size(); indiceJogador++){
                    Imprimir("(" + indiceJogador + ") " + jogadores.get(indiceJogador).getUsername());
                }
                boolean numeroValido = false;
                Jogador jogadorLogado = jogadores.get(0);

                while(!numeroValido) {
                    int jogadorSelecionado = leitor.lerInt("Digite o usuário");

                    if (jogadorSelecionado <= jogadores.size() - 1) {
                        jogadorLogado = jogadores.get(jogadorSelecionado);
                        numeroValido = true;
                    } else {
                        Imprimir("Numero de usuario inválido, tente novamente.");
                    }
                }

                Imprimir("");
                Imprimir("Jogador " + jogadorLogado.getUsername() + " selecionado com sucesso!");

                boolean logado = true;

                while(logado) {
                    Imprimir("Conta de " + jogadorLogado.getUsername());
                    Imprimir("");
                    Imprimir("Selecione uma opção: ");

                    Imprimir("1 - Criar personagem");
                    Imprimir("2 - Selecionar personagem");
                    Imprimir("0 - Voltar");
                    int opcao_Jogador = leitor.lerInt("Digite um número");

                    if (opcao_Jogador == 1){
                        String nome = leitor.lerString("Digite o nome do personagem");
                        String Campanha = leitor.lerString("Digite o nome da campanha");
                        String racaNome = leitor.lerString("Digite o nome da raça");
                        String racaDescricao = leitor.lerString("Digite uma descricao da raça " + racaNome);
                        Raca raca = new Raca(nome, racaDescricao);
                        String classeNome = leitor.lerString("Digite o nome da classe");
                        String classeDescricao = leitor.lerString("Digite uma descrição da classe " + classeNome);
                        Classe classe = new Classe(classeNome, classeDescricao);


                        Personagem novoPersonagem = new Personagem(nome, Campanha, jogadorLogado, raca, classe);
                        jogadorLogado.getPersonagens().add(novoPersonagem);


                    }

                    if (opcao_Jogador == 2){
                        if (jogadorLogado.getPersonagens().size() > 0) {
                            Imprimir("Lista de personagens: ");

                            ArrayList<Personagem> personagens = jogadorLogado.getPersonagens();
                            for (int i = 0; i < personagens.size(); i++) {
                                Imprimir("(" + i + ") " + personagens.get(i).getNome());
                            }


                            boolean personagemValido = false;
                            Personagem personagemEscolhido = personagens.get(0);

                            while (!personagemValido) {
                                int personagemSelecionado = leitor.lerInt("Selecione um personagem");

                                if (personagemSelecionado <= personagens.size() - 1) {
                                    personagemEscolhido = personagens.get(personagemSelecionado);
                                    personagemValido = true;
                                } else {
                                    Imprimir("Numero de personagem inválido, tente novamente.");
                                }
                            }

                            boolean ficha = true;

                            while (ficha) {
                                Imprimir("Ficha de " + personagemEscolhido.getNome());
                                Imprimir("Opções:");
                                Imprimir("1: Verificar detalhes da ficha");
                                Imprimir("2: Adicionar atributo");
                                Imprimir("3: Adicionar feitiço");
                                Imprimir("4: Verificar feitiços");
                                Imprimir("5: Adicionar item");
                                Imprimir("6: Verificar items");
                                Imprimir("7: Adicionar pericia");
                                Imprimir("8: Verificar pericias");
                                Imprimir("0: Voltar");

                                int opcao_personagem = leitor.lerInt("Selecione uma opção");

                                switch (opcao_personagem) {
                                    case 1:
                                        personagemEscolhido.mostrarDetalhes();
                                        break;
                                    case 2:
                                        String nome = leitor.lerString("Digite o nome do atributo: ");
                                        String descricao = leitor.lerString("Digite a descrição do atributo: ");
                                        int valor = leitor.lerInt("Digite o valor do atributo: ");
                                        int bonusMod = leitor.lerInt("Digite o bônus de modificação: ");
                                        String sigla = leitor.lerString("Digite a sigla do atributo: ");

                                        Atributo novoAtributo = new Atributo(nome, descricao, valor, bonusMod, sigla, personagemEscolhido);
                                        personagemEscolhido.getAtributos().add(novoAtributo);

                                        System.out.println("Atributo '" + nome + "' adicionado com sucesso!");
                                        break;

                                    case 3:
                                        String nomeFeitico = leitor.lerString("Nome do feitiço:");
                                        String descricaoFeitico = leitor.lerString("Descrição do feitiço:");
                                        int nivelFeitico = leitor.lerInt("Nivel do feitiço:");

                                        Feitico novoFeitico = new Feitico(nomeFeitico, nivelFeitico, descricaoFeitico);

                                        personagemEscolhido.getFeiticos().add(novoFeitico);
                                        Imprimir("Feitiço " + novoFeitico.getNome() + " adicionado à lista de feitiços!");

                                        break;
                                    case 4:
                                        Imprimir("Lista de feitiços");
                                        for (Feitico feitico : personagemEscolhido.getFeiticos()) {
                                            Imprimir("Nome: " + feitico.getNome());
                                            Imprimir("Nível: " + feitico.getNivel());
                                            Imprimir("Descricao: " + feitico.getDescricao());
                                            Imprimir("");
                                        }
                                        break;
                                    case 5:
                                        String nomeItem = leitor.lerString("Nome do item");
                                        float quantItem = leitor.lerFloat("Quantidade do item");
                                        String descricaoItem = leitor.lerString("Descriçao do item");

                                        Item novoItem = new Item(nomeItem, quantItem, descricaoItem);
                                        personagemEscolhido.getItens().add(novoItem);
                                        Imprimir("Item " + novoItem.getNome() + " adicionado ao inventário!");

                                        break;
                                    case 6:
                                        Imprimir("Inventário: ");
                                        for (Item item : personagemEscolhido.getItens()) {
                                            Imprimir("Nome: " + item.getNome());
                                            Imprimir("Quantidade: " + item.getQuantidade());
                                            Imprimir("Descricao: " + item.getDescricao());
                                            Imprimir("");
                                        }
                                        break;
                                    case 7:
                                        String nomePericia = leitor.lerString("Nome da perícia");
                                        String descricaoPericia = leitor.lerString("Descrição da perícia");
                                        int bonusPericia = leitor.lerInt("Bônus da perícia");

                                        Pericia novaPericia = new Pericia(nomePericia, descricaoPericia, bonusPericia);
                                        personagemEscolhido.getPericias().add(novaPericia);
                                        Imprimir("Pericia " + novaPericia.getNome() + " adicionada!");

                                        break;
                                    case 8:
                                        Imprimir("Lista perícias: ");
                                        for (Pericia pericia : personagemEscolhido.getPericias()) {
                                            Imprimir("Nome: " + pericia.getNome());
                                            Imprimir("Quantidade: " + pericia.getBonusMod());
                                            Imprimir("Descricao: " + pericia.getDescricao());
                                            Imprimir("");
                                        }
                                        break;
                                    case 0:
                                        ficha = false; // sai do menu
                                        break;
                                    default:
                                        Imprimir("Opção inválida. Tente novamente.");
                                }


                            }


                        } else {
                            Imprimir("Nenhum personagem disponivel");
                        }
                    }

                    if (opcao_Jogador == 0){
                        logado = false;
                    }


                }



            }} else{
                Imprimir("Sistema desligando...");
                return;
            }


        }
    }

    public static void Imprimir(String texto) {
        System.out.println(texto);
    }






}
