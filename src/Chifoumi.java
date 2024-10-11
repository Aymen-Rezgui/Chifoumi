import java.util.Scanner;

public class Chifoumi {

	public static void main(String[] args) {

		int nbGagneJoueur1 = 0, nbGagneJoueur2 = 0;
		String[] listeChoix = new String[3];

		System.out.println("Bienvenue au jeu Chifoumi !");

		// Sélectionner les règles
		System.out.println("Veuillez sélectionner les règles françaises(1) ou anglaises(2) :");
		Scanner scan = new Scanner(System.in);
		int choixRegles = scan.nextInt();
		if (choixRegles == 2) {
			listeChoix[0] = "Feuille";
			listeChoix[1] = "Pierre";
			listeChoix[2] = "Ciseaux";
		} else {
			listeChoix[0] = "Pierre";
			listeChoix[1] = "Feuille";
			listeChoix[2] = "Ciseaux";
		}

		// Sélectionner le nombre de joueurs
		System.out.println("Veuillez sélectionner le nombre de joueurs (1 ou 2) :");
		int nbJoueurs = scan.nextInt();

		// Sélectionner le nombre de parties
		System.out.println("Veuillez sélectionner le nombre de parties (1 à 10) :");
		int nbParties = scan.nextInt();
		scan.close();

		// Jouer les parties

		// Afficher les résultats
		System.out.println("Scores : (joueur 1) " + nbGagneJoueur1 + " - " + nbGagneJoueur2 + " (joueur 2)");
		if (nbGagneJoueur1 > nbGagneJoueur2)
			System.out.println("Le joueur 1 a gagné !");
		else {
			if (nbGagneJoueur1 < nbGagneJoueur2)
				System.out.println("Le joueur 2 a gagné !");
			else
				System.out.println("Egalité entre les 2 joueurs !");
		}
	}
}