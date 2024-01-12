package eu.telecomnancy.BDD_App;

public class DestroyBDD {

    public static void main(String[] args) {

        String url =  CreateBDD.BDD_NAME;

        // Supprime le fichier de la BDD
        java.io.File file = new java.io.File(url);
        if (file.delete()) {
            //System.Out.println("[DEBUG] La base de données a été supprimée.");
        } else {
            //System.Out.println("[DEBUG] La base de données n'a pas été supprimée.");
        }
    }
    
}
