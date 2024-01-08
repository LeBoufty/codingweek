package eu.telecomnancy.BDD_App;

public class TestModify {
    
    public static void main(String[] args) {
        
        // Test de la modification d'un utilisateur avec l'API
        API api = API.getInstance();
        try {
            // Crée l'utilisateur 1
            api.addUser("Lol", "Lol", "Lol", "54600");
            System.out.println("L'utilisateur 1 s'appelle " + api.getUsername(1));
            api.modifyUsername(1, "Jean");
            System.out.println("L'utilisateur 1 s'appelle maintenant " + api.getUsername(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
    }
}
