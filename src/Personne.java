/**
 * class Personne qui utilise la class CarteB
 */
public class Personne {
    
    /**
     * attribut String correspondant au nom de la personne 
    */
    private String nom;

    /**
     * attribut CarteB correspondant à la carte bancaire possédée de la personne
    */
    private CarteB carte;

    /**
     * constructeur qui construit une personne sans carte
     * 
     * @param pNom nom de la personne
    */ 
    public Personne(String pNom){
        this.nom = pNom;
        this.carte = null;
    }

    /**
     * méthode qui retourne les informations de la carte de la personne
     * 
     * @return retourne information de la carte de la personne
    */
    public CarteB getCarte(){
        return this.carte;
    }

    /**
     * méthode qui retourne le nom de la personne
     * 
     * @return retourne le nom de la personne
    */
    public String getNom(){
        return this.nom;
    }

    /**
     * méthode qui met à jour la carte de la personne
     * 
     * @param carteB informations de la carte bancaire
    */
    public void prendreCarte(CarteB carteB){
        this.carte = carteB;
    }

    /**
     * méthode qui permet de donner la carte de la personne (p1) à une autre personne entrée en paramètre (p2),
     * à l'issue de cette méthode la personne qui a donné sa carte (p1) perd sa carte
     * 
     * @param p personne entrée en paramètre
     * @return retourne true si la carte a été donné, false sinon
    */
    public boolean donnerCarte(Personne p){
        boolean echange = false;
        if (p.carte == null && p != null){
            echange = true;
            p.carte = this.carte;
            this.carte = null;
        }
        return echange;
    }

    /**
     * méthode qui permet d'utiliser la carte par la personne pour payer le prix passé en paramètre.
     * L'opération ne peut se faire que si (1) le code passé en paramètre correspond bien au code secret, 
     * (2) le retrait du prix passé en paramètre ne fait pas dépasser le découvert autorisé.
     * 
     * @param prix prix dépenser voulus entré en paramètre
     * @param code code secret entré en paramètre
     * @return retourne une chaine de caractère
    */
    public String payer(double prix, String code){
        String s = "";
        if (this.carte != null){
            if (this.carte.etreCodeCorrect(code)){
                if (this.carte.depenser(prix, code)){
                   s += "* montant accepte";
                } else {
                    s += "* montant refuse";
                }
            } else {
                s += "* code incorrect";
            }
        } else {
            s += "* pas de carte";
        }
        return s;
    }

    /**
     * méthode qui permet d'afficher le statut d'une personne.
     * Cette méthode retourne une chaine de la forme : "nom(carteB: solde / -decouvert )" où
     * nom désigne le nom de la personne ;
     * solde désigne le solde de la carte ;
     * decouvert désigne le découvert autorisé.
     * Si la personne ne possède pas de carte bancaire, l'affichage se limite à "nom (pas de carte)".
     * 
     * @return "nom(carteB: solde / -decouvert)" si la personne à une carte, "nom(pas de carte)" sinon
    */
    public String toString(){
        String s = "";
        if (this.carte == null){
            s += this.nom + "(pas de carte)";
        } else {
            s += this.nom + "(" + this.carte.toString() + ")";
        }
        return s;
    }
}
