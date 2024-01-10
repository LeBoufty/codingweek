package eu.telecomnancy.BDD_App;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CreateBDD {
    public static final String BDD_NAME = "/tmp/potehgist.db";
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("[DEBUG] Le nom du driver est " + meta.getDriverName());
                System.out.println("[DEBUG] Une nouvelle base de données a été créée.");

                // Création de la table "utilisateurs"
                String utilisateurs = "CREATE TABLE IF NOT EXISTS utilisateurs (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	nom text NOT NULL,\n"
                        + "	mot_de_passe text NOT NULL,\n"
                        + "	email text NOT NULL UNIQUE,\n"
                        + "	argent integer NOT NULL,\n"
                        + "     code_postal text NOT NULL,\n"
                        + "     image_profil blob NOT NULL,\n" // image de profil
                        + "	admin bool NOT NULL\n"
                        + ");";
                conn.createStatement().execute(utilisateurs); // Ajout dans la BDD
                System.out.println("[DEBUG] La table utilisateurs a été créée.");

                // Création de la table "offre"

                String offres = "CREATE TABLE IF NOT EXISTS offres (\n"
                        + "     nom text NOT NULL,\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_vendeur integer NOT NULL,\n"
                        + "	prix integer NOT NULL,\n"
                        + " categorie text NOT NULL,\n" // service ou matériel
                        + " description text,\n"
                        + " date_depot datetime NOT NULL,\n"
                        + "	FOREIGN KEY(id_vendeur) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(offres); // Ajout dans la BDD
                System.out.println("[DEBUG] La table offres a été créée.");

                // Création de la table "évaluation"

                String evaluations = "CREATE TABLE IF NOT EXISTS evaluations (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_offre integer NOT NULL,\n"
                        + "	id_evaluant integer NOT NULL,\n"
                        + "	valeur_evaluation integer NOT NULL,\n"
                        + "	FOREIGN KEY(id_offre) REFERENCES offres(id),\n"
                        + "	FOREIGN KEY(id_evaluant) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(evaluations); // Ajout dans la BDD
                System.out.println("[DEBUG] La table evaluations a été créée.");

                // Création de la table "liste d'attente"
                
                String liste_attente = "CREATE TABLE IF NOT EXISTS liste_attente (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_offre integer NOT NULL,\n"
                        + "	id_acheteur integer NOT NULL,\n"
                        + " position integer NOT NULL,\n" // position 0 = acheteur actuel
                        + "	FOREIGN KEY(id_offre) REFERENCES offres(id),\n"
                        + "	FOREIGN KEY(id_acheteur) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(liste_attente); // Ajout dans la BDD
                System.out.println("[DEBUG] La table liste_attente a été créée.");

                // Création de la table "photos"

                String photos = "CREATE TABLE IF NOT EXISTS photos (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_offre integer NOT NULL,\n"
                        + "	photos blob NOT NULL,\n"
                        + " position integer NOT NULL,\n" // position 0 = photo principale
                        + "	FOREIGN KEY(id_offre) REFERENCES offres(id)\n"
                        + ");";
                conn.createStatement().execute(photos); // Ajout dans la BDD
                System.out.println("[DEBUG] La table photos a été créée.");

                // Création de la table "messages"

                String messages = "CREATE TABLE IF NOT EXISTS messages (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_utilisateur_envoie integer NOT NULL,\n" // l'id de celui qui a envoyé le message
                        + "	id_utilisateur_recoit integer NOT NULL,\n" // l'id de celui qui a reçu le message
                        + " message text NOT NULL,\n"
                        + " date_envoi datetime NOT NULL,\n"
                        + "	FOREIGN KEY(id_utilisateur_envoie) REFERENCES utilisateurs(id),\n"
                        + "	FOREIGN KEY(id_utilisateur_recoit) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(messages); // Ajout dans la BDD
                System.out.println("[DEBUG] La table messages a été créée.");

                // Création de la table "sommeils"

                String sommeils = "CREATE TABLE IF NOT EXISTS sommeils (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_utilisateur integer NOT NULL,\n"
                        + "     date_debut datetime NOT NULL,\n"
                        + "     date_fin datetime NOT NULL,\n"
                        + "	FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(sommeils); // Ajout dans la BDD
                System.out.println("[DEBUG] La table sommeils a été créée.");

                // Création de la table "plannings réservations"

                String plannings_reservations = "CREATE TABLE IF NOT EXISTS plannings_reservations (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_utilisateur integer NOT NULL,\n"
                        + "     id_offre integer NOT NULL,\n"
                        + "     date_debut datetime NOT NULL,\n"
                        + "     date_fin datetime NOT NULL,\n"
                        + "	FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id),\n"
                        + "	FOREIGN KEY(id_offre) REFERENCES offres(id)\n"
                        + ");";
                conn.createStatement().execute(plannings_reservations); // Ajout dans la BDD
                System.out.println("[DEBUG] La table plannings_reservations a été créée.");

                // Création de la table "plannings offres"

                String plannings_offres = "CREATE TABLE IF NOT EXISTS plannings_offres (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "     id_offre integer NOT NULL,\n"
                        + "     date_debut datetime NOT NULL,\n"
                        + "     date_fin datetime NOT NULL,\n"
                        + "	FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id),\n"
                        + "	FOREIGN KEY(id_offre) REFERENCES offres(id)\n"
                        + ");";
                conn.createStatement().execute(plannings_offres); // Ajout dans la BDD
                System.out.println("[DEBUG] La table plannings_offres a été créée.");

                // Création de la table "plannings pré-réservations"

                String plannings_prereservations = "CREATE TABLE IF NOT EXISTS plannings_prereservations (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_utilisateur integer NOT NULL,\n"
                        + "     id_offre integer NOT NULL,\n"
                        + "     date_debut datetime NOT NULL,\n"
                        + "     date_fin datetime NOT NULL,\n"
                        + "	FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id),\n"
                        + "	FOREIGN KEY(id_offre) REFERENCES offres(id)\n"
                        + ");";
                conn.createStatement().execute(plannings_prereservations); // Ajout dans la BDD
                System.out.println("[DEBUG] La table plannings_prereservations a été créée.");

                // Création de la table "notifications"

                String notifications = "CREATE TABLE IF NOT EXISTS notifications (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_utilisateur integer NOT NULL,\n"
                        + " message text NOT NULL,\n"
                        + " date datetime NOT NULL,\n"
                        + " vue bool NOT NULL,\n"
                        + "	FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(notifications); // Ajout dans la BDD
                System.out.println("[DEBUG] La table notifications a été créée.");

                // Création de la table "reclamations"

                String reclamations = "CREATE TABLE IF NOT EXISTS reclamations (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	id_utilisateur integer NOT NULL,\n"
                        + " message text NOT NULL,\n"
                        + " date datetime NOT NULL,\n"
                        + " resolu bool NOT NULL DEFAULT false,\n"
                        + "	FOREIGN KEY(id_utilisateur) REFERENCES utilisateurs(id)\n"
                        + ");";
                conn.createStatement().execute(reclamations); // Ajout dans la BDD
                System.out.println("[DEBUG] La table reclamations a été créée.");

                // Création de la table "test_images"

                String test_images = "CREATE TABLE IF NOT EXISTS test_images (\n"
                        + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + "	image blob NOT NULL\n"
                        + ");";
                conn.createStatement().execute(test_images); // Ajout dans la BDD
                System.out.println("[DEBUG] La table test_images a été créée.");

                // fermeture de la connexion
                conn.close();
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static void remplitsql() {

    }

    public static void main(String[] args) {
        createNewDatabase(BDD_NAME);
    }

}
