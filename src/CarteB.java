/**
 * class CarteB
 */
public class CarteB {

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

    /***
     * constructeur construisant une carte bancaire par défaut
     * 
     * @param code code secret de la carte
    */
    public CarteB(String code){
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
    public CarteB(double montant, double decouv, String code){
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
     * L'opération ne peut s'effectuer que si le code passé en paramètre est le bon code secret et si le solde après 
     * retrait du prix est bien supérieur au découvert autorisé. 
     * Si l'opération s'est correctement passée, cette méthode retourne vrai sinon elle doit retourner faux.
     * 
     * @param prix prix retiré du solde de la carte
     * @param code code entré en paramètre pour utilisé la carte
     * @return retourne vrai si le code entré en paramètre et le même que le code secret de la carte et si le solde après 
     * retrait du prix est bien supérieur au découvert autorisé, retourne faux sinon
    */ 
    public boolean depenser(double prix, String code){
        boolean b = false;
        if (this.codeCarte.equals(code) && this.solde - prix > 0 - this.decouvert){
            b = true;
            this.solde -= prix;
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
