// Javadoc les tests ne marche pas, sauf si on met les import si dessous en commentaires
// import static libtest.Lanceur.lancer;
// import static libtest.OutilTest.assertEquals;
// import libtest.*;

/**
 * classe de test qui permet de verifier que la classe CarteB
 * fonctionne correctement
 */
public class TestCarteB {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarteB(), args);
	}

	/**
	 * verification des méthodes
	 */
	public void test_00_Methodes(){
		CarteB carte = new CarteB("code");
		CarteB carte2 = new CarteB(100.,1000.,"code");
		assertEquals("solde",100.0,carte2.getSolde());

		boolean res = carte2.etreCodeCorrect("test");
		carte2.deposer(300.);

		res = carte2.depenser(100.,"code");
	}

	/**
	 * verification constructeur
	 */
	public void test_Methodes_MethodesOK(){
		CarteB carte = new CarteB("code");
		assertEquals("solde", 0.0 , carte.getSolde());
	}

	/**
	 * verification constructeur si paramètre solde positif
	 */
	public void test_Methodes_MethodesSoldePositif(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("solde", 100.0, carte.getSolde());
	}

	/**
	 * verification constructeur si paramètre solde négatif
	 */
	public void test_Methodes_MethodesSoldeNegatif(){
		CarteB carte = new CarteB(-1, 1000, "code");
		assertEquals("solde", 0.0, carte.getSolde());
	}
	
	/**
	 * verification constructeur si paramètre découvert positif
	 */
	public void test_Methodes_MethodesDecouvertPositif(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("decouvert", 1000.0, carte.getDecouvert());
	}

	/**
	 * verification constructeur si paramètre découvert négatif
	 */
	public void test_Methodes_MethodesDecouvertNegatif(){
		CarteB carte = new CarteB(100, -1000, "code");
		assertEquals("decouvert", 0.0, carte.getDecouvert());
	}

	/**
	 * verification méthode etreCodeCorrect si code bon
	 */
	public void test_etreCodeCorrect_etreCodeCorrectOK(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("boolean b",true, carte.etreCodeCorrect("code"));
	}

	/**
	 * verification méthode etreCodeCorrect si code mauvais
	 */
	public void test_etreCodeCorrect_etreCodeCorrectFaux(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("boolean b", false, carte.etreCodeCorrect("Code"));
	}

	/**
	 * verification méthode deposer avec montant positif
	 */
	public void test_deposer_deposerMontantPositif(){
		CarteB carte = new CarteB(100, 1000, "code");
		carte.deposer(20);
		assertEquals("solde", 120., carte.getSolde());
	}

	/**
	 * verification méthode deposer avec montant négatif
	 */ 
	public void test_deposer_deposerMontantNegatif(){
		CarteB carte = new CarteB(100, 1000, "code");
		carte.deposer(-1);
		assertEquals("solde", 100., carte.getSolde());
	}

	/**
	 * verification méthode depenser avec prix qui ne dépasse pas le découvert et code bon
	 */ 
	public void test_depenser_depenserPrixBonCodeBon(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("boolean b", true, carte.depenser(50, "code"));
	}

	/**
	 * verification méthode depenser avec prix qui ne dépasse pas le découvert et code mauvais
	 */ 
	public void test_depenser_depenserPrixBonCodeMauvais(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("boolean b", false, carte.depenser(50, "Code"));
	}

	/**
	 * verification méthode depenser avec prix qui dépasse le découvert et code bon
	 */ 
	public void test_depenser_depenserPrixDepasseCodeBon(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("boolean b", false, carte.depenser(5000, "code"));
	}

	/**
	 * verification méthode depenser avec prix qui dépasse le découvert et code mauvais
	 */ 
	public void test_depenser_depenserPrixDepasseCodeMauvais(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("boolean b", false, carte.depenser(5000, "Code"));
	}

	/**
	 * verification méthode toString
	 */ 
	public void test_toString_toStringOK(){
		CarteB carte = new CarteB(100, 1000, "code");
		assertEquals("String", "carteB: 100.0 / -1000.0", carte.toString());
	}
}