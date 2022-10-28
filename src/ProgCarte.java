/**
 * class ProgCarte : main qui vérifie que les opérations se sont bien déroulées
 */
public class ProgCarte{

    /**
     * méthode de lancement du main
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        // créer une carte bancaire avec un solde de 100, un découvert de 1000 et comme code "Moncode"
        CarteB carte = new CarteB(100, 1000, "Moncode");
        // créer une personne nommée Albert
        Personne albert = new Personne("Albert");

        // associer la carte bancaire "carte" à Albert
        albert.prendreCarte(carte);
        System.out.println("");

        // Albert paye 50 euros avec code correct
        System.out.println(albert.payer(50., "Moncode"));
        // afficher résultat de l'opération
        System.out.println(albert.toString());

        // créer une personne nommée Bertrand
        Personne bertrand = new Personne("Bertrand");
        // donner la carte de Albert à Bertrand
        albert.donnerCarte(bertrand);

        System.out.println("");
        // Bertrand paye 500 euros avec code correct
        System.out.println(bertrand.payer(500., "Moncode"));
        // afficher le resultat
        System.out.println(bertrand.toString());

        System.out.println("");
        // Albert paye 100 euros avec code correct (n'a plus de carte)
        System.out.println(albert.payer(100., "Moncode"));
        // afficher le résultat
        System.out.println(albert.toString());

        System.out.println("");
        // Bertrand paye 100 euros avec code incorrect
        System.out.println(bertrand.payer(100., "moncode"));
        // afficher le résultat
        System.out.println(bertrand.toString());

        System.out.println("");
    }
}