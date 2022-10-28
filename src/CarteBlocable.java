/**
 * class CarteBlocable, pour bloquer la carte un ajoute un attribut entier "tantative"
 * ensuite dans la méthode "depenser" on ajoute dans la condition "et this.tantative strictement inferieur à 3"
 * PS: je ne peux pas mettre les signes sinon le javadoc ne marche pas
 * ensuite on ajoute un "else if (this.codeCarte.equals(code) == false)" après le première condition
 * et si cette nouvelle condition s'applique alors on ajoute 1 à l'attribut "tentative"
 * ce qui fait qu'à partir de la 3e tentative raté, la condition pour depenser ne pourra plus etre bonne
 * car "tentative" sera égal à 3
 */
public class CarteBlocable {

    /***
     * attribut réel représentant le montant sur la carte 
    */
    private double solde;

    /***
     * attribut réel positif désignant le découvert autorisé de la carte
    */ 
    private double decouvert;

    /***
     * attribut String correspondant au code secret de la carte
    */
    private String codeCarte;

    /**
     * attribut entier correspondant au nombre de tentative raté pour le code de la carte
     */
    private int tentative;

    /***
     * constructeur construisant une carte bancaire par défaut
     * 
     * @param code code secret de la carte
    */
    public CarteBlocable(String code){
        this.solde = 0;
        this.decouvert = 100;
        this.codeCarte = code;
    }

    /***
     * constructeur avec 3 paramètres construisant une carte bancaire par défaut
     * 
     * @param montant solde initial du compte
     * @param decouv découvert autorisé
     * @param code code secret de la carte
    */
    public CarteBlocable(double montant, double decouv, String code){
        if (montant < 0){
            this.solde = 0;
        } else {
            this.solde = montant;
        }
        if (decouv < 0){
            this.decouvert = 0;
        } else {
            this.decouvert = decouv;
        }
        this.codeCarte = code;
    }

    /**
     * méthode qui retourne le solde de la carte
     * 
     * @return solde de la carte 
     */
    public double getSolde(){
        return this.solde;
    }

    /***
     * méthode qui retourne le découvert autorisé de la carte
     * 
     * @return decouvert de la carte
    */ 
    public double getDecouvert(){
        return this.decouvert;
    }


    /***
     * méthode qui retourne vrai si le code entré en paramètre et le même que le code secret de la carte, retourne faux sinon
     * 
     * @param code code entré en paramètre pour utilisé la carte
     * @return retourne vrai si le code entré en paramètre et le même que le code secret de la carte, retourne faux sinon
    */ 
    public boolean etreCodeCorrect(String code){
        boolean b = this.codeCarte.equals(code);
        return b;
    }

    /***
     * méthode qui ajoute un montant au solde de la carte, si le montant est négatif rien ne se passe
     * 
     * @param montant montant ajouté au solde de la carte
    */ 
    public void deposer(double montant){
        if (montant >= 0){
            this.solde += montant;
        }
    }

    /***
     * méthode qui doit retirer le prix au solde du compte. 
     * L'opération ne peut s'effectuer que si le code passé en paramètre est le bon code secret, si le solde après 
     * retrait du prix est bien supérieur au découvert autorisé et si le nombre de tentative raté est inférieur à 3
     * Si l'opération s'est correctement passée, cette méthode retourne vrai sinon elle doit retourner faux.
     * 
     * @param prix prix retiré du solde de la carte
     * @param code code entré en paramètre pour utilisé la carte
     * @return retourne vrai si le code entré en paramètre et le même que le code secret de la carte, si le solde après 
     * retrait du prix est bien supérieur au découvert autorisé et si le nombre de tentative raté est inférieur à 3, 
     * retourne faux sinon
    */ 
    public boolean depenser(double prix, String code){
        boolean b = false;
        if (this.codeCarte.equals(code) && this.solde - prix > 0 - this.decouvert && this.tentative < 3){
            b = true;
            this.solde -= prix;
        } else if (this.codeCarte.equals(code) == false && this.tentative != 3) {
            this.tentative++;
        }
        return b;
    }

    /***
     * méthode qui retourne la chaine "carteB: " suivie du solde du compte et du découvert autorisé decouvert 
     * sous la forme suivante (espaces compris) : "carteB: solde / -decouvert "
     * 
     * @return "carteB: solde / -decouvert "
    */
    public String toString(){
        String s = "carteB: " + this.solde + " / -" + this.decouvert;
        return s;
    }
}
