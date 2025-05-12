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

}
