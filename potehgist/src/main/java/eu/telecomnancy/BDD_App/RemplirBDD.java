package eu.telecomnancy.BDD_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Instant;

import eu.telecomnancy.Model.ImageBlob;
import eu.telecomnancy.Model.Utilisateur;

import javafx.scene.image.Image;

public class RemplirBDD {
    
    

    public void remplir() throws Exception
    {
        try {
            String url =  CreateBDD.BDD_NAME;
            // Supprime le fichier de la BDD
            java.io.File file = new java.io.File(url);
            if (file.delete()) {
                //System.out.println("[DEBUG] La base de données a été supprimée.");
            } else {
                //System.out.println("[DEBUG] La base de données n'a pas été supprimée.");
            }
            CreateBDD.createNewDatabase("/tmp/potehgist.db");
            url = "jdbc:sqlite:/tmp/potehgist.db";
            Connection conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //String pathooo = API.getInstance().ResourceJar("/eu/telecomnancy/assets/logo.png");
        //System.out.println(pathooo);

        // Ajout des utilisateurs
        try {

            Utilisateur u = new Utilisateur("a", "a","a", "54000");
            u.saveAsNew();
            
            u =new Utilisateur("Claude La Bagarre","Avalanche","Claude@Shinra.ff","77000");
            u.saveAsNew();

            u = new Utilisateur("JCVD", "J","JeanClaudeVanDame@gmail.fr", "30000");
            u.saveAsNew();

            u = new Utilisateur("Joe Biden", "1234","Biden@wanadoo.com","75000");
            u.setAdmin(true);
            u.saveAsNew();

            u = new Utilisateur("Doigby", "Squeezie","Doigby@twitch.tv", "54000");
            u.saveAsNew();

            u = new Utilisateur("z", "z","z", "z");
            u.saveAsNew();

            u = new Utilisateur("e", "e","e", "e");
            u.saveAsNew();

            u = new Utilisateur("admin", "admin","admin@hotmail.fr", "10",1);
            u.saveAsNew();

            u = new Utilisateur("Massi", "xora","Massimiliano.Mortaigne@telecomnancy.eu", "54000");
            u.saveAsNew();

            u = new Utilisateur("Sephiroth", "jenova","Sephiroth.Hojo@Shinra.ff", "77000");
            u.saveAsNew();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Ajout des offres
        try {
            
            // String path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/Cloud_Strife.png");
            String path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "Cloud_Strife.png";
            Image image = new Image(path);
            byte[] imageByte = ImageBlob.imageToByte(image);
            // path = path.substring(5);
            API.getInstance().addOffre("Mercenaire à louer","Talents de mercenaire efficace à louer.\nPas cher.\nNe travaille pas pour les enfants", 7, 2, "Service", imageByte);
            int datedebut = (int)Instant.now().getEpochSecond();
            int datefin = (int)Instant.now().getEpochSecond()+90000*4;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "logo.png";
            // path = path.substring(5);
            Image image2 = new Image(path);
            byte[] imageByte2 = ImageBlob.imageToByte(image2);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/logo.png");
            API.getInstance().addOffre("Cherche eau","Je cherche de l'eau.\nJ'adore l'eau et il n'y en a plus.", 1, 2, "Service", imageByte2);
            datedebut = (int)Instant.now().getEpochSecond()+90000;
            datefin = (int)Instant.now().getEpochSecond()+90000*10;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "Joe-Biden.png";
            Image image3 = new Image(path);
            byte[] imageByte3 = ImageBlob.imageToByte(image3);
            
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/Joe-Biden.png");
            API.getInstance().addOffre("Service de lutins","Les lutins fabriquent vos cadeaux.", 10, 3, "Service", imageByte3);
            datedebut = (int)Instant.now().getEpochSecond()-90000*3;
            datefin = (int)Instant.now().getEpochSecond()+90000*3;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "logo.png";
            Image image4 = new Image(path);
            byte[] imageByte4 = ImageBlob.imageToByte(image4);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/logo.png");
            API.getInstance().addOffre("Service de lutins","puceau moi ? serieusement ^^ haha on me l avait pas sortie celle la depuis loooongtemps :) demande a mes potes si je suis puceau tu vas voir les reponses que tu vas te prendre XD rien que la semaine passee j ai niquer donc chuuuuut ferme la puceau de merde car oui toi tu m as tout l air d un bon puceau de merde car souvent vous etes frustrer de ne pas BAISER :) ses agreable de se faire un missionnaire ou un amazone avec une meuf hein? tu peux pas repondre car tu ne sais pas ce que c ou alors tu le sais mais tu as du taper dans ta barre de recherche \"missionnaire sexe\" ou \"amazone sexe\" pour comprendre ce que c etait mdddrrr !! c est grave quoiquil en soit.... pour revenir a moi, je pense que je suis le mec le moins puceau de ma bande de 11 meilleurs amis pas psk j ai eu le plus de rapport intime mais psk j ai eu les plus jolie femme que mes amis :D ses pas moi qui le dit, ses eux qui commente sous mes photos insta \"trop belle la fille que tu as coucher avec hier en boite notamment!\" donc apres si tu veux que sa parte plus loi sa peut partir vraiment loi j habite dans la banlieue de niort sa te parle steven sanchez ? ses juste un cousin donc OKLM hahaha on verra si tu parles encore le puceau de merde mdddrrr pk insulter qd on est soi meme puceau tu me feras toujour marrer!!", 20, 6, "Service", imageByte4);
            datedebut = (int)Instant.now().getEpochSecond()+90000;
            datefin = (int)Instant.now().getEpochSecond()+90000*2;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "logo.png";
            Image image5 = new Image(path);
            byte[] imageByte5 = ImageBlob.imageToByte(image5);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/logo.png");
            API.getInstance().addOffre("Truc long","\"Unfortunate\" doesn't begin to describe my series, this game rewards blind luck and nothing else, I am beyond convinced at this point. After getting completely tooled by scheduling with my opponent changing times on me last minute and refusing to provide confirmation prior to the day of the match as to play times, losing this way somehow felt even worse than I had thought possible. My preparation was superior, my play was superior, and I lost, so I don't see a reason to continue engaging in an activity where what is within my control is overwhelmingly outweighed by what is not. I am done with competitive Pokemon, and you won't get a fond farewell. This community is infected to its roots with a degenerative disease that grows stronger over time but stops short of killing its host. Tournaments used to have a competitive spirit at their heart, this has been transplanted and replaced with an artificial organ that feeds on vitriol and mockery from insecure little boys that heckle by the sidelines and tear each other to shreds over scraps of attention. The environment we fostered has trapped us all like this in a vicious cycle, and escaping it requires acceptance of the harshest reality we all scramble to explain away, that none of the countless straining efforts we put ourselves through here will ever amount to one single shining glimmer of significance. I would make this the end, but World Cup is still ongoing, and I would never leave so many great friends out to dry, so I'll suffer through a few more games for them. One last thing before I leave you all to react with disdain, ridicule, and self-righteous fervor, before you do everything in your power to minimize my words and thoughts, box them up and shove them to some cobwebbed corner of your memory, and hope they disappear forever as a stain on your finite time ground to dust. From this moment on, nothing you say matters to me. The foulest insults you hurl with intent to wound will calmly settle at the earth before my feet, and the venom you spit will bring all the pain of a warm summer breeze. You are less than anything you can conceive, while I carry on, brimming with joy distilled from detachment.", 100000, 5, "Service", imageByte5);
            datedebut = (int)Instant.now().getEpochSecond()+90000*4;
            datefin = (int)Instant.now().getEpochSecond()+90000*9;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "logo.png";
            Image image6 = new Image(path);
            byte[] imageByte6 = ImageBlob.imageToByte(image6);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/logo.png");
            API.getInstance().addOffre("Caractère speciaux","Shut up bozo, CURSE OF RA 𓀀 𓀁 𓀂 𓀃 𓀄 𓀅 𓀆 𓀇 𓀈 𓀉 𓀊 𓀋 𓀌 𓀍 𓀎 𓀏 𓀐 𓀑 𓀒 𓀓 𓀔 𓀕 𓀖 𓀗 𓀘 𓀙 𓀚 𓀛 𓀜 𓀝 𓀞 𓀟 𓀠 𓀡 𓀢 𓀣 𓀤 𓀥 𓀦 𓀧 𓀨 𓀩 𓀪 𓀫 𓀬 𓀭 𓀲 𓀳 𓀴 𓀵 𓀶 𓀷 𓀸 𓀹 𓀺 𓀻 𓀼 𓀽 𓀾 𓀿 𓁀 𓁁 𓁂 𓁃 𓁄 𓁅 𓁆 𓁇 𓁈 𓁉 𓁊 𓁋 𓁍 𓁎 𓁏 𓁐 𓁑", 1, 6, "Service", imageByte6);
            datedebut = (int)Instant.now().getEpochSecond()+90000*1;
            datefin = (int)Instant.now().getEpochSecond()+90000*3;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "farine.jpeg";
            Image image7 = new Image(path);
            byte[] imageByte7 = ImageBlob.imageToByte(image7);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/farine.jpeg");
            API.getInstance().addOffre("10g de pure....","...farine. C'est de la farine.", 1, 3, "Materiel", imageByte7);
            datedebut = (int)Instant.now().getEpochSecond()+90000*1;
            datefin = (int)Instant.now().getEpochSecond()+90000*3;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "staff.png";
            Image image8 = new Image(path);
            byte[] imageByte8 = ImageBlob.imageToByte(image8);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/staff.png");
            API.getInstance().addOffre("Bâton","Appartenait à une collègue.\nElle ne l'utilise plus.\nEn bon état.", 10, 2, "Materiel", imageByte8);
            datedebut = (int)Instant.now().getEpochSecond()-90000*10;
            datefin = (int)Instant.now().getEpochSecond()+90000*20;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "boeing737.jpg";
            Image image9 = new Image(path);
            byte[] imageByte9 = ImageBlob.imageToByte(image9);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/boeing737.jpg");
            API.getInstance().addOffre("Boeing 737","Avion en location.\nSans danger.\nPorte amovible.", 100,4, "Materiel", imageByte9);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "Massi.jpg";
            Image image10 = new Image(path);
            byte[] imageByte10 = ImageBlob.imageToByte(image10);
            // path = path.substring(5);
            path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/Massi.jpg");
            API.getInstance().addOffre("Moi","Bonjour\nC'est moi, Massimiliano Mortaigne.\nJe suis en vente\nVery cheap.", 1,4, "Materiel", imageByte10);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "titouan.png";
            Image image11 = new Image(path);
            byte[] imageByte11 = ImageBlob.imageToByte(image11);
            // path = path.substring(5);
            path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/titouan.png");
            API.getInstance().addOffre("Président","Je loue mes services de président.\nJe peux présider toutes les conventions et évennements\nPrenez moi svp.", 1,4, "Materiel", imageByte11);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "PYJ.png";
            Image image12 = new Image(path);
            byte[] imageByte12 = ImageBlob.imageToByte(image12);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/PYJ.png");
            API.getInstance().addOffre("Garde du corps","Loue talents de garde du corps.\nAttention je suis pas commode.", 1,4, "Service", imageByte12);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "pierre.jpg";
            Image image13 = new Image(path);
            byte[] imageByte13 = ImageBlob.imageToByte(image13);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/pierre.jpg");
            API.getInstance().addOffre("Trône de Ramen","Je propose la location de mon trône.\nDe bonne facture.\nPresque neuf.", 1,4, "Materiel", imageByte13);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "Arnaud.jpg";
            Image image14 = new Image(path);
            byte[] imageByte14 = ImageBlob.imageToByte(image14);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/Arnaud.jpg");
            API.getInstance().addOffre("Cours de cocktails","Je vous apprend comment faire des cocktails.\nJe sais faire, promis.\nC'est pas ma faute le shaker était pas verrouillé, OK ?!", 1,4, "Service", imageByte14);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            path = getClass().getResource("/eu/telecomnancy/assets/").toExternalForm() + "abomination.jpg";
            Image image15 = new Image(path);
            byte[] imageByte15 = ImageBlob.imageToByte(image15);
            // path = path.substring(5);
            // path =API.getInstance().ResourceJar("/eu/telecomnancy/assets/abomination.jpg");
            API.getInstance().addOffre("okdjodgkfodg","J seifjs eigjris.\nBokhtlh thjfogkdr.\nfefndfn", 1,4, "Materiel", imageByte15);
            datedebut = (int)Instant.now().getEpochSecond();
            datefin = (int)Instant.now().getEpochSecond()+90000*70;
            API.getInstance().addPlaningLastOffre(datedebut, datefin);

            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Ajout des évaluations
        API.getInstance().addEvaluation(3, 5);
        API.getInstance().addEvaluation(3, 5);
        API.getInstance().addEvaluation(3, 1);
        API.getInstance().addEvaluation(3, 5);
        API.getInstance().addEvaluation(3, 1);
        API.getInstance().addEvaluation(1,5);
        API.getInstance().addEvaluation(1, 5);
        API.getInstance().addEvaluation(1, 4);
        API.getInstance().addEvaluation(3, 5);
        API.getInstance().addEvaluation(1, 5);
        API.getInstance().addEvaluation(5, 1);
        API.getInstance().addEvaluation(2, 2);
        API.getInstance().addEvaluation(2, 4);

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
        API.getInstance().addmessage(10, 2, "Claude.");
        API.getInstance().addmessage(10, 2, "I know you can read this Claude.");
        API.getInstance().addmessage(10, 2, "Come to me.");
        API.getInstance().addmessage(10, 2, "I am waitting.");
        API.getInstance().addmessage(10, 2, "The time for the reunion has come.");
        API.getInstance().addmessage(10, 2, "Claude.");
        API.getInstance().addmessage(10, 2, "You cannot postpone our meeting forever.");
        API.getInstance().addmessage(10, 2, "6 weeks until Rebirth. PS5 is ready.");
        API.getInstance().addmessage(10, 2, "Come Claude.");
        

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
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(1, "Vous avez un nouveau chat",1,2);
        API.getInstance().addnotif(2, "Sephiroth",1,10);
        API.getInstance().addnotif(2, "Sephiroth",1,10);
        API.getInstance().addnotif(2, "Sephiroth",1,10);
        API.getInstance().addnotif(2, "Sephiroth",1,10);
        API.getInstance().addnotif(2, "Sephiroth",1,10);
        API.getInstance().addnotif(2, "Sephiroth",1,10);
        API.getInstance().addnotif(2, "Sephiroth",1,10);


        //ajout des reclamations

        API.getInstance().addReclamation(1, "Je n'ai pas reçu mon colis");
        API.getInstance().addReclamation(1, "Je n'ai pas reçu mon colis");
        API.getInstance().addReclamation(1, "Je n'ai pas reçu mon colis");
        API.getInstance().addReclamation(1, "Je n'ai pas reçu mon colis");
        API.getInstance().addReclamation(2, "b");
        API.getInstance().addReclamation(1, "Je n'ai pas reçu mon colis");
        API.getInstance().addReclamation(4, "Je n'ai pas reçu mes missiles alors que je suis au pole Nord");


    }

    public static void main(String [] args) throws Exception {
        RemplirBDD remplirbdd = new RemplirBDD();
        remplirbdd.remplir();
    }

}
