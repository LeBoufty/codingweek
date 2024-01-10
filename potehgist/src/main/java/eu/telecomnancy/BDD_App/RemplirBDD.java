package eu.telecomnancy.BDD_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;

import eu.telecomnancy.Model.Utilisateur;

public class RemplirBDD {
    
    private Connection conn;
    private String url;

    public void remplir()
    {
        try {
            String url =  CreateBDD.BDD_NAME;
            // Supprime le fichier de la BDD
            java.io.File file = new java.io.File(url);
            if (file.delete()) {
                System.out.println("[DEBUG] La base de données a été supprimée.");
            } else {
                System.out.println("[DEBUG] La base de données n'a pas été supprimée.");
            }
            CreateBDD.createNewDatabase("/tmp/potehgist.db");
            url = "jdbc:sqlite:/tmp/potehgist.db";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println("e.getMessage()");
        }


        // Ajout des utilisateurs
        try {

            Utilisateur u = new Utilisateur("a", "a","a", "a");
            u.saveAsNew();
            
            u =new Utilisateur("Claude La Bagarre","Avalanche","Claude@Midgar.ff","54000");
            u.saveAsNew();

            
            u = new Utilisateur("ClaudeLaBagarre", "Avalanche","Claude@Migdar.ff", "10000");
            u.saveAsNew();

            u = new Utilisateur("JCVD", "J","JeanClaudeVanDame@gmail.fr", "30000");
            u.saveAsNew();

            u = new Utilisateur("Joe Biden", "1234","Biden@wanadoo.com","75000");
            u.saveAsNew();

            u = new Utilisateur("Doigby", "Squeezie","Doigby@twitch.tv", "54000");
            u.saveAsNew();

            u = new Utilisateur("z", "z","z", "z");
            u.saveAsNew();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Ajout des offres
        try {
            API.getInstance().addOffre("Mercenaire à louer","Talents de mercenaire efficace à louer.\n Pas cher.\nNe travaille pas pour les enfants", 7, 1, "Service");

            API.getInstance().addOffre("Cherche eau","Je cherche de l'eau.\nJ'adore l'eau et il n'y en a plus.", 1, 2, "Service");

            API.getInstance().addOffre("Service de lutins","Les lutins fabriquent vos cadeaux.", 10, 3, "Service");

            API.getInstance().addOffre("Service de lutins","puceau moi ? serieusement ^^ haha on me l avait pas sortie celle la depuis loooongtemps :) demande a mes potes si je suis puceau tu vas voir les reponses que tu vas te prendre XD rien que la semaine passee j ai niquer donc chuuuuut ferme la puceau de merde car oui toi tu m as tout l air d un bon puceau de merde car souvent vous etes frustrer de ne pas BAISER :) ses agreable de se faire un missionnaire ou un amazone avec une meuf hein? tu peux pas repondre car tu ne sais pas ce que c ou alors tu le sais mais tu as du taper dans ta barre de recherche \"missionnaire sexe\" ou \"amazone sexe\" pour comprendre ce que c etait mdddrrr !! c est grave quoiquil en soit.... pour revenir a moi, je pense que je suis le mec le moins puceau de ma bande de 11 meilleurs amis pas psk j ai eu le plus de rapport intime mais psk j ai eu les plus jolie femme que mes amis :D ses pas moi qui le dit, ses eux qui commente sous mes photos insta \"trop belle la fille que tu as coucher avec hier en boite notamment!\" donc apres si tu veux que sa parte plus loi sa peut partir vraiment loi j habite dans la banlieue de niort sa te parle steven sanchez ? ses juste un cousin donc OKLM hahaha on verra si tu parles encore le puceau de merde mdddrrr pk insulter qd on est soi meme puceau tu me feras toujour marrer!!", 20, 6, "Service");


            API.getInstance().addOffre("Truc long","\"Unfortunate\" doesn't begin to describe my series, this game rewards blind luck and nothing else, I am beyond convinced at this point. After getting completely tooled by scheduling with my opponent changing times on me last minute and refusing to provide confirmation prior to the day of the match as to play times, losing this way somehow felt even worse than I had thought possible. My preparation was superior, my play was superior, and I lost, so I don't see a reason to continue engaging in an activity where what is within my control is overwhelmingly outweighed by what is not. I am done with competitive Pokemon, and you won't get a fond farewell. This community is infected to its roots with a degenerative disease that grows stronger over time but stops short of killing its host. Tournaments used to have a competitive spirit at their heart, this has been transplanted and replaced with an artificial organ that feeds on vitriol and mockery from insecure little boys that heckle by the sidelines and tear each other to shreds over scraps of attention. The environment we fostered has trapped us all like this in a vicious cycle, and escaping it requires acceptance of the harshest reality we all scramble to explain away, that none of the countless straining efforts we put ourselves through here will ever amount to one single shining glimmer of significance. I would make this the end, but World Cup is still ongoing, and I would never leave so many great friends out to dry, so I'll suffer through a few more games for them. One last thing before I leave you all to react with disdain, ridicule, and self-righteous fervor, before you do everything in your power to minimize my words and thoughts, box them up and shove them to some cobwebbed corner of your memory, and hope they disappear forever as a stain on your finite time ground to dust. From this moment on, nothing you say matters to me. The foulest insults you hurl with intent to wound will calmly settle at the earth before my feet, and the venom you spit will bring all the pain of a warm summer breeze. You are less than anything you can conceive, while I carry on, brimming with joy distilled from detachment.", 100000, 5, "Service");

            API.getInstance().addOffre("Caractère speciaux","Shut up bozo, CURSE OF RA 𓀀 𓀁 𓀂 𓀃 𓀄 𓀅 𓀆 𓀇 𓀈 𓀉 𓀊 𓀋 𓀌 𓀍 𓀎 𓀏 𓀐 𓀑 𓀒 𓀓 𓀔 𓀕 𓀖 𓀗 𓀘 𓀙 𓀚 𓀛 𓀜 𓀝 𓀞 𓀟 𓀠 𓀡 𓀢 𓀣 𓀤 𓀥 𓀦 𓀧 𓀨 𓀩 𓀪 𓀫 𓀬 𓀭 𓀲 𓀳 𓀴 𓀵 𓀶 𓀷 𓀸 𓀹 𓀺 𓀻 𓀼 𓀽 𓀾 𓀿 𓁀 𓁁 𓁂 𓁃 𓁄 𓁅 𓁆 𓁇 𓁈 𓁉 𓁊 𓁋 𓁍 𓁎 𓁏 𓁐 𓁑", 1, 6, "Service");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Ajout des évaluations
        API.getInstance().addEvaluation(3, 1, 5);
        API.getInstance().addEvaluation(3, 2, 5);
        API.getInstance().addEvaluation(3, 3, 5);
        API.getInstance().addEvaluation(3, 4, 5);
        API.getInstance().addEvaluation(3, 5, 5);
        API.getInstance().addEvaluation(1, 1, 3);
        API.getInstance().addEvaluation(1, 2, 3);
        API.getInstance().addEvaluation(1, 3, 3);

        // Ajout des messages
        API.getInstance().addmessage(1, 2, "Salut");
        API.getInstance().addmessage(2, 1, "Salut");
        API.getInstance().addmessage(1, 2, "Ca va ?");
        API.getInstance().addmessage(2, 1, "Oui et toi ?");
        API.getInstance().addmessage(1, 2, "Ca va");
        API.getInstance().addmessage(2, 1, "Ok");
        API.getInstance().addmessage(1, 2, "A+");
        API.getInstance().addmessage(2, 1, "A+");
        API.getInstance().addmessage(1, 3, "Salut");
        API.getInstance().addmessage(3, 1, "Salut");
        API.getInstance().addmessage(1, 3, "Ca va ?");
        API.getInstance().addmessage(3, 1, "Oui et toi ?");
        API.getInstance().addmessage(1, 3, "Ca va");
        API.getInstance().addmessage(3, 1, "Ok");
        API.getInstance().addmessage(1, 3, "A+");
        API.getInstance().addmessage(3, 1, "A+");
        API.getInstance().addmessage(1, 4, "Salut");
        API.getInstance().addmessage(4, 1, "Salut");
        API.getInstance().addmessage(1, 4, "Ca va ?");
        API.getInstance().addmessage(4, 1, "Oui et toi ?");
        API.getInstance().addmessage(1, 4, "Ca va");
        API.getInstance().addmessage(4, 1, "Ok");
        API.getInstance().addmessage(1, 4, "A+");
        API.getInstance().addmessage(4, 1, "A+");
        

        // Ajout des réservations

        Instant now = Instant.now();
        int date_debut = (int)now.getEpochSecond();
        int date_fin = (int)now.getEpochSecond()+90000*4;
        API.getInstance().addreservation(1, 1, date_debut, date_fin);

        API.getInstance().addreservation(1, 3, date_debut, date_fin);

        date_debut = (int)now.getEpochSecond()+90000*6;
        date_fin = (int)now.getEpochSecond()+90000*10;
        API.getInstance().addreservation(1, 5, date_debut, date_fin);

        date_debut = (int)now.getEpochSecond()+90000*2;
        date_fin = (int)now.getEpochSecond()+90000*6;
        API.getInstance().addreservation(1, 4, date_debut, date_fin);
        

        // Ajout des notifications
        API.getInstance().addnotif(1, "Vous avez un nouveau chat");
        API.getInstance().addnotif(1, "Vous avez un nouveau chat");
        API.getInstance().addnotif(1, "Vous avez un nouveau chat");
        API.getInstance().addnotif(1, "Vous avez un nouveau chat");
        API.getInstance().addnotif(1, "Vous avez un nouveau chat");
        API.getInstance().addnotif(2, "Sephiroth");
        API.getInstance().addnotif(2, "Sephiroth");
        API.getInstance().addnotif(2, "Sephiroth");
        API.getInstance().addnotif(2, "Sephiroth");
        API.getInstance().addnotif(2, "Sephiroth");
        API.getInstance().addnotif(2, "Sephiroth");
        API.getInstance().addnotif(2, "Sephiroth");


    }


    public void ajoutnotifications(int id_utilisateur, String message, int jour, int mois, int annee, int heure, int minute, boolean vu)
    {
        String date_envoi = ""+annee+"-"+mois+"-"+jour+" "+heure+":"+minute;
        String query = "INSERT INTO notifications (id_utilisateur, message, date, vue) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_utilisateur);
            pstmt.setString(2, message);
            pstmt.setString(3, date_envoi);
            pstmt.setBoolean(4, vu);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de la notification");
        }
    }

    public void ajoutreclamations(int id_utilisateur, String message, int jour, int mois, int annee, int heure, int minute, boolean resolu)
    {
        String date_envoi = ""+annee+"-"+mois+"-"+jour+" "+heure+":"+minute;
        String query = "INSERT INTO reclamations (id_utilisateur, message, date, resolu) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_utilisateur);
            pstmt.setString(2, message);
            pstmt.setString(3, date_envoi);
            pstmt.setBoolean(4, resolu);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur lors de l'ajout de la réclamation");
        }
    }

    public static void main(String [] args) {
        RemplirBDD remplirbdd = new RemplirBDD();
        remplirbdd.remplir();
    }

}
