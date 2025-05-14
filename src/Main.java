import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Leitor leitor = new Leitor();
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();


        while(true){
            System.out.println("Bem vindo ao Void RPG, seu melhor sistema de gerenciamento de fichas!!");
            System.out.println("");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar uma conta");
            System.out.println("2 - Acessar uma conta");
            System.out.println("0 - Sair do sistema");

            int opcao = leitor.lerInt("Digite um número");

            switch(opcao){
                case 1:
                    Cadastro cadastroJogador = new Cadastro();

                    String nome = cadastroJogador.criarUsuario(jogadores);

                    Jogador jogador = new Jogador(nome);
                    jogadores.add(jogador);
                break;

                case 2:
                    if (jogadores.size() == 0){
                        System.out.println("Nenhum usuário encontrado");
                        break;
                    }
                    else {
                    System.out.println("Jogadores cadastrados:");
                    for(int indiceJogador = 0; indiceJogador < jogadores.size(); indiceJogador++){
                        System.out.println("(" + indiceJogador + ") " + jogadores.get(indiceJogador).getUsername());
                    }
                    boolean numeroValido = false;
                    Jogador jogadorLogado = jogadores.get(0);

                    while(!numeroValido) {
                        int jogadorSelecionado = leitor.lerInt("Digite o usuário");

                        if (jogadorSelecionado <= jogadores.size() - 1) {
                            jogadorLogado = jogadores.get(jogadorSelecionado);
                            numeroValido = true;
                    } else {
                        System.out.println("Numero de usuario inválido, tente novamente.");
                    }
                    }
                    System.out.println("");
                    System.out.println("Jogador " + jogadorLogado.getUsername() + " selecionado com sucesso!");

                    jogadorLogado.menuJogador();
                    break;
                    }
                case 0:
                    System.out.println("Sistema desligando...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
