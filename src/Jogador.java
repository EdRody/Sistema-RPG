import java.util.ArrayList;

public class Jogador {
    String username;
    ArrayList<Personagem> personagens;

    public Jogador(String username) {
        this.username = username;
        this.personagens = new ArrayList<Personagem>();
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void menuJogador() {
        Leitor leitor = new Leitor();
        boolean logado = true;

        while (logado) {
            System.out.println("Conta de " + getUsername());
            System.out.println("");
            System.out.println("Selecione uma opção: ");

            System.out.println("1 - Criar personagem");
            System.out.println("2 - Selecionar personagem");
            System.out.println("0 - Voltar");
            int opcao = leitor.lerInt("Digite um número");

            switch (opcao) {
                case 1: {
                    Cadastro cadastro = new Cadastro();
                    Personagem novoPersonagem = cadastro.criarPersonagem(this);
                    getPersonagens().add(novoPersonagem);
                    break;
                }
                case 2: {
                    if (getPersonagens().size() > 0) {
                        System.out.println("Lista de personagens: ");

                        ArrayList<Personagem> personagens = getPersonagens();
                        for (int i = 0; i < personagens.size(); i++) {
                            System.out.println("(" + i + ") " + personagens.get(i).getNome());
                        }

                        boolean personagemValido = false;
                        Personagem personagemEscolhido = personagens.get(0);

                        while (!personagemValido) {
                            int personagemSelecionado = leitor.lerInt("Selecione um personagem");

                            if (personagemSelecionado <= personagens.size() - 1) {
                                personagemEscolhido = personagens.get(personagemSelecionado);
                                personagemValido = true;
                            } else {
                                System.out.println("Numero de personagem inválido, tente novamente.");
                            }
                        }
                        personagemEscolhido.menuPersonagem();
                        break;

                    } else {
                        System.out.println("Nenhum personagem disponivel");
                        break;
                    }
                }
                case 0: {
                    System.out.println("Saindo da conta...");
                    return;
                }
                default: {
                    break;
                }
            }
        }
    }
}
