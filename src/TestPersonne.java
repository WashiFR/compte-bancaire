// Javadoc les tests ne marche pas, sauf si on met les import si dessous en commentaires
// import static libtest.Lanceur.lancer;
// import static libtest.OutilTest.assertEquals;

/**
 * classe de test qui permet de verifier que la classe Personne
 * fonctionne correctement
 */
public class TestPersonne {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPersonne(), args);
	}

	/**
	 * verifie methodes correctes
	 */
	public void test_00_testMethodes(){
		Personne p = new Personne("Albert");
		String nom = p.getNom();
		CarteB carte = p.getCarte();

		CarteB cb=new CarteB("Moncode");
		p.prendreCarte(cb);

		Personne p2 = new Personne("B");
		boolean res = p.donnerCarte(p2);

		String resString = p.payer(200.,"Moncode");
	}

	/**
	 * verifie constructeur correctes
	 */
	public void test_Methodes_MethodeOK(){
		Personne p = new Personne("Albert");
		assertEquals("nom", "Albert", p.getNom());
	}

	/**
	 * verifie méthode prendre si la personne prend bien la carte par défaut
	 */
	public void test_prendreCarte_prendreCarteV1OK(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB("Moncode");
		p.prendreCarte(cb);
		assertEquals("carte", "carteB: 0.0 / -100.0", p.getCarte().toString());
	}

	/**
	 * verifie méthode prendre si la personne prend bien la carte avec ajout d'information de la carte
	 */
	public void test_prendreCarte_prendreCarteV2OK(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);
		assertEquals("carte", "carteB: 100.0 / -1000.0", p.getCarte().toString());
	}

	/**
	 * verifie méthode donner si la personne2 sans carte (p2) prend la carte de la personne1 avec carte (p)
	 */
	public void test_donnerCarte_donnerCarteP2SansCarte(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);

		Personne p2 = new Personne("B");
		assertEquals("boolean echange", true, p.donnerCarte(p2));
	}

	/**
	 * verifie méthode donner si la personne2 avec carte (p2) ne prend pas la carte de la personne1 avec carte (p)
	 */
	public void test_donnerCarte_donnerCarteP2AvecCarte(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);

		Personne p2 = new Personne("B");
		CarteB cb2 = new CarteB(200, 2000, "Moncode");
		p2.prendreCarte(cb2);
		assertEquals("boolean echange", false, p.donnerCarte(p2));
	}

	/**
	 * verifie méthode payer avec prix qui ne dépasse pas le découvert et code bon
	 */ 
	public void test_payer_payerPrixInferieurCodeBon(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);
		assertEquals("String", "* montant accepte", p.payer(100., "Moncode"));
	}

	/**
	 * verifie méthode payer avec prix qui ne dépasse pas le découvert et code mauvais
	 */ 
	public void test_payer_payerPrixInferieurCodeMauvais(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);
		assertEquals("String", "* code incorrect", p.payer(100., "moncode"));
	}

	/**
	 * verifie méthode payer avec prix qui dépasse le découvert et code bon
	 */ 
	public void test_payer_payerPrixSuperieurCodeBon(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);
		assertEquals("String", "* montant refuse", p.payer(10000., "Moncode"));
	}

	/**
	 * verifie méthode payer avec prix qui dépasse le découvert et code mauvais
	 */ 
	public void test_payer_payerPrixSuperieurCodeMauvais(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);
		assertEquals("String", "* code incorrect", p.payer(10000., "moncode"));
	}

	/**
	 * verifie méthode payer avec une personne sans carte
	 */ 
	public void test_payer_payerSansCarte(){
		Personne p = new Personne("Albert");
		assertEquals("String", "* pas de carte", p.payer(100., "Moncode"));
	}

	/**
	 * verifie méthode toString si lorsque la personne a une carte, renvoie nom(carteB: solde / -decouvert)
	 */
	public void test_toString_toStringAvecCarte(){
		Personne p = new Personne("Albert");
		CarteB cb = new CarteB(100, 1000, "Moncode");
		p.prendreCarte(cb);
		assertEquals("String", "Albert(carteB: 100.0 / -1000.0)", p.toString());
	}

	/**
	 * verifie méthode toString si lorsque la personne n'a pas de carte, renvoie nom(pas de carte)
	 */
	public void test_toString_toStringSansCarte(){
		Personne p = new Personne("Albert");
		assertEquals("String", "Albert(pas de carte)", p.toString());
	}

}