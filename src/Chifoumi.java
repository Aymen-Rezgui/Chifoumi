import java.util.Random;
import java.util.Scanner;

public class Chifoumi {

	public static void main(String[] args) {

		int nbGagneJoueur1 = 0, nbGagneJoueur2 = 0;
		String[] listeChoix = new String[3];
		Random rand = new Random();

		System.out.println("Bienvenue au jeu Chifoumi !");

		// Sélectionner les règles
		System.out.println("Veuillez sélectionner les règles françaises(1) ou anglaises(2) :");
		Scanner scan = new Scanner(System.in);
		int choixRegles = scan.nextInt();
		// L'ordre du tableau détermine l'ordre d'affichage des éléments
		// Le 1er élément gagne contre le 3ème
		// Le 2ème élément gagne contre le 1er
		// Le 3ème élément gagne contre le 2ème
		if (choixRegles == 2) {
			listeChoix[0] = "Feuille";
			listeChoix[1] = "Pierre";
			listeChoix[2] = "Ciseaux";
		} else {
			listeChoix[0] = "Pierre";
			listeChoix[1] = "Feuille";
			listeChoix[2] = "Ciseaux";
		}

		// Sélectionner le nombre de joueurs, tant que le chiffre donnée est <
		// 1 ou > 2
		int nbJoueurs;
		do {
			System.out.println("Veuillez sélectionner le nombre de joueurs (1 ou 2) :");
			nbJoueurs = scan.nextInt();
			if (nbJoueurs < 1 || nbJoueurs > 2)
				System.out.println("Veuillez saisir un chiffre entre 1 et 2 :");
		} while (nbJoueurs < 1 || nbJoueurs > 2);
		String nomJoueur2;
		if (nbJoueurs < 2)
			nomJoueur2 = "L'ordinateur";
		else
			nomJoueur2 = "Le joueur 2";

		// Sélectionner le nombre de parties
		System.out.println("Veuillez sélectionner le nombre de parties (1 à 10) :");
		int nbPartiesTotal = scan.nextInt();
		int nbPartieCourante = 1;

		// Jouer les parties

		while (nbPartieCourante <= nbPartiesTotal) {

			int choixJoueur1, choixJoueur2;

			System.out.println("--------------------------------------------------");
			System.out.println("Manche n°" + nbPartieCourante);

			do {
				// On affiche la liste des choix possible
				System.out.println("Joueur 1 sélectionne son objet :");
				for (int i = 0; i < listeChoix.length; i++) {
					System.out.println((i + 1) + " - " + listeChoix[i]);
				}

				// On fait saisir un chiffre pour le joueur 1, tant que le chiffre donné est <
				// 1 ou > 3
				do {
					choixJoueur1 = scan.nextInt();
					if (choixJoueur1 < 1 || choixJoueur1 > 3)
						System.out.println("Veuillez saisir un chiffre entre 1 et 3 :");
				} while (choixJoueur1 < 1 || choixJoueur1 > 3);

				if (nbJoueurs > 1) {
					// On affiche la liste des choix possible
					System.out.println("Joueur 2 sélectionne son objet :");
					for (int i = 0; i < listeChoix.length; i++) {
						System.out.println((i + 1) + " - " + listeChoix[i]);
					}

					// On fait saisir un chiffre pour le joueur 2, tant que le chiffre donné est <
					// 1 ou > 3
					do {
						choixJoueur2 = scan.nextInt();
						if (choixJoueur2 < 1 || choixJoueur2 > 3)
							System.out.println("Veuillez saisir un chiffre entre 1 et 3 :");
					} while (choixJoueur2 < 1 || choixJoueur2 > 3);
				} else {
					choixJoueur2 = rand.nextInt(1, 4);
					System.out.println("L'ordinateur a choisi : " + listeChoix[choixJoueur2 - 1]);
				}

				if (choixJoueur1 == choixJoueur2)
					System.out.println("Egalité, on rejoue !");
			} while (choixJoueur1 == choixJoueur2); // Tant qu'il y a égalité, les 2 joueurs rejouent

			if ((choixJoueur1 == 1 && choixJoueur2 == 3) || (choixJoueur1 == 2 && choixJoueur2 == 1)
					|| (choixJoueur1 == 3 && choixJoueur2 == 2)) {
				System.out.println("Le joueur 1 gagne la manche n°" + nbPartieCourante + " !");
				nbGagneJoueur1++;
			} else {
				System.out.println(nomJoueur2 + " gagne la manche n°" + nbPartieCourante + " !");
				nbGagneJoueur2++;
			}
			nbPartieCourante++;
		}

		scan.close();

		// Afficher les résultats
		System.out.println("----------------SCORES-----------------");
		System.out.println("Le joueur 1 a un score de " + nbGagneJoueur1);
		System.out.println(nomJoueur2 + " a un score de " + nbGagneJoueur2);
		System.out.println("---------------------------------------");
		if (nbGagneJoueur1 > nbGagneJoueur2)
			System.out.println("Le joueur 1 a gagné !");
		else {
			if (nbGagneJoueur1 < nbGagneJoueur2)
				System.out.println(nomJoueur2 + " a gagné !");
			else
				System.out.println("Egalité entre les 2 joueurs !");
		}
	}
}