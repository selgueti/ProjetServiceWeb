package fr.uge.projet.user;

public class Login {

    private final String pseudo;
    private final String password;


    public Login(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }


    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

}
