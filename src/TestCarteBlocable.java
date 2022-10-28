// Javadoc les tests ne marche pas, sauf si on met les import si dessous en commentaires
// import static libtest.Lanceur.lancer;
// import static libtest.OutilTest.assertEquals;
// import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 */
public class TestCarteBlocable {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarteBlocable(), args);
	}

	/**
	 * verification constructeur
	 */
	public void test_Methodes_MethodesOK(){
		CarteBlocable carte = new CarteBlocable("code");
		assertEquals("solde", 0.0 , carte.getSolde());
	}

	/**
	 * verification constructeur si paramètre solde positif
	 */
	public void test_Methodes_MethodesSoldePositif(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("solde", 100.0, carte.getSolde());
	}

	/**
	 * verification constructeur si paramètre solde négatif
	 */
	public void test_Methodes_MethodesSoldeNegatif(){
		CarteBlocable carte = new CarteBlocable(-1, 1000, "code");
		assertEquals("solde", 0.0, carte.getSolde());
	}
	
	/**
	 * verification constructeur si paramètre découvert positif
	 */
	public void test_Methodes_MethodesDecouvertPositif(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("decouvert", 1000.0, carte.getDecouvert());
	}

	/**
	 * verification constructeur si paramètre découvert négatif
	 */
	public void test_Methodes_MethodesDecouvertNegatif(){
		CarteBlocable carte = new CarteBlocable(100, -1000, "code");
		assertEquals("decouvert", 0.0, carte.getDecouvert());
	}

	/**
	 * verification méthode etreCodeCorrect si code bon
	 */
	public void test_etreCodeCorrect_etreCodeCorrectOK(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("boolean b",true, carte.etreCodeCorrect("code"));
	}

	/**
	 * verification méthode etreCodeCorrect si code mauvais
	 */
	public void test_etreCodeCorrect_etreCodeCorrectFaux(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("boolean b", false, carte.etreCodeCorrect("Code"));
	}

	/**
	 * verification méthode deposer avec montant positif
	 */
	public void test_deposer_deposerMontantPositif(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		carte.deposer(20);
		assertEquals("solde", 120., carte.getSolde());
	}

	/**
	 * verification méthode deposer avec montant négatif
	 */ 
	public void test_deposer_deposerMontantNegatif(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		carte.deposer(-1);
		assertEquals("solde", 100., carte.getSolde());
	}

	/**
	 * verification méthode depenser avec prix qui ne dépasse pas le découvert et code bon
	 */ 
	public void test_depenser_depenserPrixBonCodeBon(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("boolean b", true, carte.depenser(50, "code"));
	}

	/**
	 * verification méthode depenser avec prix qui ne dépasse pas le découvert et code mauvais
	 */ 
	public void test_depenser_depenserPrixBonCodeMauvais(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("boolean b", false, carte.depenser(50, "Code"));
	}

	/**
	 * verification méthode depenser avec prix qui dépasse le découvert et code bon
	 */ 
	public void test_depenser_depenserPrixDepasseCodeBon(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("boolean b", false, carte.depenser(5000, "code"));
	}

	/**
	 * verification méthode depenser avec prix qui dépasse le découvert et code mauvais
	 */ 
	public void test_depenser_depenserPrixDepasseCodeMauvais(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("boolean b", false, carte.depenser(5000, "Code"));
	}

	/**
	 * verification méthode depenser avec 1 erreur de code secret
	 */ 
	public void test_depenser_depenser1ErreurCode(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		carte.depenser(50, "Code");
		assertEquals("boolean b", true, carte.depenser(50, "code"));
	}

	/**
	 * verification méthode depenser avec 2 erreur de code secret
	 */ 
	public void test_depenser_depenser2ErreurCode(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		carte.depenser(50, "Code");
		carte.depenser(50, "Code");
		assertEquals("boolean b", true, carte.depenser(50, "code"));
	}

	/**
	 * verification méthode depenser avec 3 erreur de code secret
	 */ 
	public void test_depenser_depenser3ErreurCode(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		carte.depenser(50, "Code");
		carte.depenser(50, "Code");
		carte.depenser(50, "Code");
		assertEquals("boolean b", false, carte.depenser(50, "code"));
	}

	/**
	 * verification méthode depenser avec plus de 3 erreur de code secret
	 */ 
	public void test_depenser_depenserPlus3ErreurCode(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		carte.depenser(50, "Code");
		carte.depenser(50, "Code");
		carte.depenser(50, "Code");
		carte.depenser(50, "Code");
		assertEquals("boolean b", false, carte.depenser(50, "code"));
	}

	/**
	 * verification méthode toString
	 */ 
	public void test_toString_toStringOK(){
		CarteBlocable carte = new CarteBlocable(100, 1000, "code");
		assertEquals("String", "carteB: 100.0 / -1000.0", carte.toString());
	}

	
}
