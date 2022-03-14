/*L'utilisateur recevra 1000 $ pour commencer et pourra jouer a une variete de jeux.
Ils doivent parier un montant d'argent pour jouer et peuvent soit perdre leur pari, soit gagner et gagner de l'argent.
Ils peuvent quitter le casino après chaque partie, mais seront expulses s'ils n'ont plus d'argent.*/

import java.util.Scanner;
import java.util.Random;
public class Jeux {
    public static void main(String[] args){

//Instanciation de scanner
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);

//Declarer le chemin et le montant total d'argent avec lequel l'utilisateur commence
        int path;
        int total = 1000;

//L'utilisateur saisit son nom et une declaration contenant les instructions de base du casino sera emise
        System.out.print("Entrez votre nom: ");
        String name = reader2.nextLine();
        System.out.println("\nSalut " + name +" !");
        System.out.println("Vous avez 1000 $. \nVous pouvez quitter le casino a tout moment, mais vous serez expulse une fois que vous n'aurez plus d'argent."
                + "\nVeuillez faire vos paris en montants entiers positifs. \nMerci et passez un bon moment!");

/*L'utilisateur choisit un jeu dans un menu et une instruction switch est utilisee pour appeler differentes methodes pour chaque jeu. Le montant total d'argent est mis a jour
après chaque match*/
        do {
            System.out.print("\nEntrez 1 pour jouer a la Machine a Sous"
                    + "\nEntrez 2 pour jouer au Blackjack"
                    + "\nEntrez 3 pour jouer au Keno"
                    + "\nEntrez 4 pour jouer a la Roulette"
                    + "\nEntrez 5 pour quitter le Casino"
                    + "\nEntrez ici: ");
            path = reader.nextInt();

            if (path == 1){
                total += Slots(total);
                System.out.println("\nVous avez maintenant: $" + total);
            }

            if (path == 2){
                total += Blackjack(total);
                System.out.println("\nVous avez maintenant: $" + total);
            }

            if (path == 3){
                total -= Keno(total);
                System.out.println("\nVous avez maintenant: $" + total);
            }
            if (path == 4){
                total += Roulette(total);
                System.out.println("\nVous avez maintenant: $" + total);
            }
        }
        while (path != 5 && total > 0);
        System.out.println("\nA plus " + name + "! On espère vous revoir bientôt!");
    }

    //Methode de jeu des machines a sous
    public static int Slots(int total){

//Instanciation du scanner et de random class
        Scanner reader = new Scanner(System.in);
        Random gen = new Random();

//Declaration et initialisation des variables        
        int path3 = 1;
        int bet2 = 0;
        int bet3 = 0;
        int bet4 = 0;

//L'utilisateur choisit dans un menu        
        while (path3 == 1) {
            int winLevel = 0;
            System.out.print("\nEntrez 1 pour placer un pari et jouer"
                    + "\nEntrez 2 pour voir les instructions"
                    + "\nEntrez 3 pour quitter le jeu"
                    + "\nEntrez ici: ");
            int path = reader.nextInt();

//La boucle tant que est utilisee pour s'assurer que l'entree est l'un des choix proposes  
            while ((path < 1)||(path > 3)){
                System.out.print("\nEntrez 1 pour placer un pari et jouer"
                        + "\nEntrez 2 pour voir les instructions"
                        + "\nEntrez 3 pour quitter le jeu"
                        + "\nEntrez ici: ");
                path = reader.nextInt();
            }

//Si l'utilisateur choisit de parier et de jouer, il entre le montant qu'il souhaite parier            
            if (path == 1){
                System.out.print("\nEntrez le montant d'argent que vous souhaitez parier: ");
                int bet = reader.nextInt();
                System.out.print("\n");

//Le montant doit être superieur a 1 $ et inferieur ou egal au montant total d'argent               
                while (bet > total || bet < 1){
                    System.out.print("\nEntrez le montant d'argent que vous souhaitez parier: ");
                    bet = reader.nextInt();
                    System.out.print("\n");
                }

//Un tableau est cree pour le premier emplacement avec des nombres de 1 a 10                
                int [] slot1 = new int [10];
                for (int i = 0; i < 10; i++){
                    slot1 [i] = i;
                }

//Un tableau est cree pour le deuxième emplacement avec des nombres de 1 a 10             
                int [] slot2 = new int [10];
                for (int i = 0; i < 10; i++){
                    slot2 [i] = i;
                }

//Un tableau est cree pour le troisième emplacement avec des nombres de 1 a 10            
                int [] slot3 = new int [10];
                for (int i = 0; i < 10; i++){
                    slot3 [i] = i;
                }

//Les machines a sous seront jouees trois fois a l'aide d'une boucle pour               
                for (int i = 1; i <=3; i++){

//3 nombres sont generes aleatoirement pour être utilises comme index dans les tableaux                    
                    int one = gen.nextInt(10);
                    int two = gen.nextInt(10);
                    int three = gen.nextInt(10);

//L'utilisateur doit entrer 1 pour voir les resultats de la machine                   
                    System.out.print("Les machines a sous tournent. Appuyez sur 1 pour arrêter: ");
                    int spinStop = reader.nextInt();

//Verification de l'entree a l'aide de la boucle while                    
                    while (spinStop != 1){
                        System.out.print("Les machines a sous tournent. Appuyez sur 1 pour arrêter: ");
                        spinStop = reader.nextInt();
                    }

//Une fois que l'utilisateur entre le nombre 1, les resultats sont transmis a l'utilisateur                  
                    if (spinStop == 1){

                        System.out.println("\n ________     ________     ________"
                                + "\n|        |   |        |   |        |"
                                + "\n|        |   |        |   |        |"
                                + "\n|   " + slot1[one]+"    |   |   " + slot2[two]+"    |   |   " + slot3[three]+"    |"
                                + "\n|        |   |        |   |        |"
                                + "\n|________|   |________|   |________|\n");
                    }

//En fonction du resultat, le pari de l'utilisateur est multiplie ou perdu par un montant specifique                    
                    if (slot1[one] == 7 && slot2[two] == 7 && slot3[three] == 7){
                        System.out.println("Vous avez trois 7!!!");
                        winLevel += 6;
                    }

                    else if (slot1[one] == 7 && slot2[two] == 7 || slot1[one] == 7 && slot3[three] == 7 || slot2[two] == 7 && slot3[three] == 7 ){
                        System.out.println("Vous avez deux 7!");
                        winLevel += 2;
                    }

                    else if (slot1[one] == slot2[two] && slot1[one] == slot3[three]){
                        System.out.println("Vous avez trois de la même chose!");
                        winLevel += 4;
                    }

                    else {
                        System.out.println("VOUS N'AVEZ RIEN EU !!! :(");
                        winLevel += 0;
                    }

                }

//La difference entre leur montant et leur nouvelle somme d'argent est calculee                
                bet2 = (bet * winLevel);
                bet4 = bet2 - bet;

//La boucle while se terminera et l'utilisateur sera dirige vers le menu principal                
                path3 = 2;
            }

//Si l'utilisateur choisit de voir les instructions, elles seront affiches. Ensuite, l'utilisateur sera redirige vers le menu du jeu de la machine a sous            
            else if (path == 2){
                System.out.print("\nRègles"
                        + "\n¯¯¯¯¯"
                        + "\n1. C'est simple. Faites simplement un pari et vous pourrez jouer trois fois aux machines a sous."
                        + "\n2. Obtenez deux 7 et votre mise sera multipliee par 2"
                        + "\n3. Obtenez trois fois la même chose et votre mise sera multipliee par 4"
                        + "\n4. Obtenez trois 7 et votre mise sera multipliee par 6"
                        + "\n5. Les recompenses peuvent être cumulees (Exemple: Si vous obtenez deux 7 a un tour et trois 7 a un autre, votre mise sera multipliee par 8.)"
                        + "\n6. Si vous n'obtenez aucune recompense, vous perdez le montant d'argent mise.\n");
            }

//S'ils choisissent de quitter le jeu, la boucle while se terminera et ils reviendront au menu principal            
            else if (path == 3){
                path3 = 2;
            }
        }

//Le montant d'argent qu'ils ont obtenu ou perdu sera retourne au menu principal
        return bet4;
    }


    //Methode de jeu au blackjack
    public static int Blackjack(int total3){

//Instanciation du scanner et de class random
        Random gen = new Random();
        Scanner reader = new Scanner(System.in);

//Declaration et initialisation des variables        
        int path2 = 1;
        int path = 1;
        int bet = 0;
        int path3 = 1;

//Le jeu est a l'interieur de la boucle while pour permettre a l'utilisateur de revenir au menu Blackjack après avoir lu les instructions        
//Un menu est affiche a l'utilisateur et il peut faire un choix        
        while (path3 == 1){
            System.out.print("\nEntrez 1 pour placer un pari et jouer"
                    + "\nEntrez 2 pour voir les instructions"
                    + "\nEntrez 3 pour quitter le jeu"
                    + "\nEntrez ici: ");
            path = reader.nextInt();

//L'entree est verifiee
            while ((path < 1)||(path > 3)){
                System.out.print("\nEntrez 1 pour placer un pari et jouer"
                        + "\nEntrez 2 pour voir les instructions"
                        + "\nEntrez 3 pour quitter le jeu"
                        + "\nEntrez ici: ");
                path = reader.nextInt();
            }

//S'ils decident de parier et de jouer, ils peuvent parier un montant en dollars            
            if (path == 1){
                int total = 0;
                int total2 = 0;
                System.out.print("\nEntrez le montant d'argent que vous souhaitez parier: ");
                bet = reader.nextInt();

//La boucle while est utilisee pour s'assurer que le pari est superieur a 1 $ et inferieur ou egal au montant total d'argent qu'ils ont actuellement                
                while (bet > total3 || bet < 1){
                    System.out.print("\nEntrez le montant d'argent que vous souhaitez parier: ");
                    bet = reader.nextInt();
                }

//Un tableau pour un jeu de cartes est cree
                int [] cardNum = new int [52];

//Un nombre aleatoire de 1 a 13 est attribue a chaque element du jeu de cartes.                
                for (int i = 0; i < 52 ; i++){
                    cardNum [i] = gen.nextInt(13) + 1;
                }

//2 nombres aleatoires de 0 a 52 sont generes a utiliser notamment pour les indices dans les tableaux                
                int q = gen.nextInt(52);
                int r = gen.nextInt(52);

//Si les valeurs des 2 numeros de carte totalisent plus de 21, de nouveaux indices sont generes                
                while (cardNum[q] + cardNum[r] > 21){
                    q = gen.nextInt(52);
                    r = gen.nextInt(52);
                }

//Les deux cartes que l'utilisateur sont generes                    
                System.out.print("\nVos deux cartes sont " + cardNum[q] + " et " + cardNum[r]);

//Le total de leurs cartes est calcule et affiche                
                total += cardNum[q];
                total += cardNum[r];

                System.out.println("\nTotal: " + total);

//Tant que le total de la carte de l'utilisateur est inferieur a 21, plusieurs options lui sont proposees              
                while (total < 21){

                    System.out.print("\nTirer (Appuyez sur 1)"
                            + "\nRester (Appuyez sur 2)"
                            + "\nEntrez ici: ");
                    int choice = reader.nextInt();

//L'entree de l'utilisateur est verifiee                    
                    while (choice < 1 || choice > 2){
                        System.out.print("\nTirer (Appuyez sur 1)"
                                + "\nRester (Appuyez sur 2)"
                                + "\nEntrez ici: ");
                        choice = reader.nextInt();
                    }

//Si les utilisateurs choisissent de "Tirer", ils reçoivent une autre carte et leur total est mis a jour                    
                    if (choice == 1){
                        q = gen.nextInt(52)+ 1;
                        System.out.print("\nVotre carte est " + cardNum[q] + "\n");
                        total += cardNum[q];
                    }



//Si les utilisateurs choisissent de "Rester", le tour de l'ordinateur commence                    
                    if (choice == 2){
                        break;
                    }
                }

//Si leur total est de 21, le tour de l'ordinateur n'aura pas lieu                    
                if (total == 21){
                    System.out.println("Vous avez gagne !");
                    path3 = 2;
                    break;
                }
                if (total > 21){
                    System.out.println("Vous avez perdu !");
                    bet *=-1;
                    path3 = 2;
                    break;
                }

//Le tour de l'ordinateur commence                
                if (path2 == 1){

//Des nombres aleatoires sont generes pour être utilises comme indices dans le tableau du jeu de cartes                    
                    q = gen.nextInt(52)+ 1;
                    r = gen.nextInt(52) + 1;

                    if (cardNum[q] + cardNum[r] > 21){
                        q = gen.nextInt(52)+ 1;
                        r = gen.nextInt(52) + 1;
                    }

//Les cartes de l'ordinateur sont transmises a l'utilisateur                    
                    System.out.print("\nLes cartes de l'ordinateur sont " + cardNum[q] + " et " + cardNum[r] + "\n");

                    total2 += cardNum[q];
                    total2 += cardNum[r];

//L'ordinateur continue d'obtenir des cartes jusqu'a ce qu'il n'en puisse plus sans depasser 21
//Selon l'utilisateur qui est le plus proche de 21, differents resultats sont possibles et differents montants en dollars sont donnes en recompense

//Si le total de l'ordinateur est toujours inferieur a 21, ils continueront a ramasser des cartes jusqu'a ce qu'ils ne puissent plus sans depasser 21
                    if (total2 <= 21){
                        while (total2 + cardNum[q] <= 21){
                            q = gen.nextInt(52)+1;
                            System.out.println("L'ordinateur a choisi \"Tirer\"");
                            System.out.println("L'ordinateur a obtenu " + cardNum[q]);
                            total2 += cardNum[q];
                        }

//Si l'utilisateur est encore plus proche de 21 que l'ordinateur, l'ordinateur prendra une autre carte                        
                        if (21 - total2 > 21 - total){
                            q = gen.nextInt(52)+1;
                            System.out.println("L'ordinateur a choisi \"Tirer\"");
                            System.out.println("L'ordinateur a obtenu " + cardNum[q]);
                            total2 += cardNum[q];
                        }
                    }

//Differents resultats                    
                    if (total == 21){
                        String outcome = "Vous avez gagne !";
                        System.out.println(outcome);
                        break;
                    }

                    else if (total2 == 21){
                        String outcome = "Vous avez perdu !";
                        System.out.println(outcome);
                        bet *= -1;
                        break;
                    }

                    else if ((21 - total) > 0 && 21 - total2 < 0){
                        String outcome = "Vous avez gagne !";
                        System.out.println(outcome);
                        break;
                    }

                    else if ((21 - total2) > 0 && 21 - total < 0){
                        String outcome = "Vous avez perdu !";
                        System.out.println(outcome);
                        bet *= -1;
                        break;
                    }

                    else if ((21 - total) < (21 - total2)){
                        String outcome = "Vous avez gagne !";
                        System.out.println(outcome);
                        break;
                    }

                    else if ((21 - total2) < (21 - total)){
                        String outcome = "Vous avez perdu !";
                        System.out.println(outcome);
                        bet *= -1;
                        break;
                    }

                    else if ((21 - total2) == (21 - total)){
                        String outcome = "Vous avez gagne !";
                        System.out.println(outcome);
                        break;
                    }
                    break;
                }
//Quand la boucle se terminera, l'utilisateur reviendra au menu principal
                path3 = 2;
            }

//Si l'utilisateur decide de consulter les instructions, L'utilisateur sera renvoye juste après au menu du Blackjack            
            if (path == 2){
                System.out.print("\nRègles"
                        + "\n¯¯¯¯¯"
                        + "\n1. Pour commencer, vous recevez 2 cartes numerotees."
                        + "\n2. Ensuite, vous choisissez de tirer ou de rester."
                        + "\n   Tirer = Obtenir une autre carte"
                        + "\n   Rester = Arrêtez de prendre des cartes"
                        + "\n3. Le but du jeu est d'obtenir un total avec vos cartes aussi proche de 21 sans depasser"
                        + "\n4. Si vous depassez 21, Vous avez perdu automatiquement. Si vous restez, l'ordinateur commencera son tour"
                        + "\n5. Si l'ordinateur se rapproche de 21 plus que vous, vous avez perdu ."
                        + "\n6. Si vous avez gagne , votre pari est double, mais si vous avez perdu , vous perdez tout votre pari"
                        + "\n7. C'est aussi le meilleur jeu je veux pas debattre >:( .\n");
            }

//Si l'utilisateur decide de quitter le jeu, la boucle while prendra fin et l'utilisateur sera renvoye au menu principal            
            if (path == 3){
                path3 = 2;
            }
        }

//Le montant d'argent gagne ou perdu est retourne a la methode principale        
        return bet;
    }

    //Methode de jeu du Keno
    public static int Keno(int total){

//Instantiation du scanner de la classe random
        Scanner reader = new Scanner(System.in);
        Random gen = new Random();

//Declaration et initialisation des variables        
        int bet;
        bet = 0;
        int count = 0;
        int path3 = 1;

//Le jeu est en boucle while pour permettre a l'utilisateur de revenir au menu du jeu après avoir vu les instructions
//Le menu est affiche a l'utilisateur et il fait un choix
        while (path3 == 1){
            System.out.print("\nEntrez 1 pour placer un pari et jouer"
                    + "\nEnter 2 pour les consignes"
                    + "\nEntrez 3 pour quitter le jeu"
                    + "\nEntrez ici: ");
            int path = reader.nextInt();

//Verification de l'entree            
            while (path < 1 || path > 3){
                System.out.print("\nEntrez 1 pour placer un pari et jouer"
                        + "\nEnter 2 pour les consignes"
                        + "\nEntrez 3 pour quitter le jeu"
                        + "\nEntrez ici: ");
                path = reader.nextInt();
            }

//S'ils choisissent de parier et de jouer, ils peuvent parier un montant en dollars            
            if (path == 1){
                System.out.print("\nEntrez le montant en dollars que vous souhaitez parier: ");
                bet = reader.nextInt();
                System.out.print("\n");

//Si le pari est inferieur a 1$ ou superieur a l'argent total que l'utilisateur possède actuellement, il doit reparier a nouveau        
                while (bet > total || bet < 1){
                    System.out.print("\nEntrez le montant en dollars que vous souhaitez parier: ");
                    bet = reader.nextInt();
                    System.out.print("\n");
                }

//Un tableau est cree pour contenir les 10 variables saisies par l'utilisateur                
                int [] choices = new int [10];

//L'utilisateur saisit 10 numeros de 1 a 40 pour remplir le tableau                
                for (int i = 0; i < 10; i++){
                    System.out.print("Entrez un nombre de 1 a 40: ");
                    choices[i] = reader.nextInt();

                    while (choices[i] < 1 || choices[i] > 40){
                        System.out.print("Veuillez entrer un nombre de 1 a 40: ");
                        choices[i] = reader.nextInt();
                    }
                }

//10 nombres aleatoires de 1 a 40 sont generes et transmis a l'utilisateur                
                int [] comp = new int [10];
                System.out.println("\nLes nombres aleatoires choisis sont: ");

                for (int i = 0; i < 10; i++){
                    comp[i] = gen.nextInt(40) + 1;
                    if (i >=0 && i <= 8){
                        System.out.print(comp[i] + ", ");
                    }

                    if (i == 9){
                        System.out.print(comp[i]);
                    }
                }

                for (int i = 0; i < 10; i++){
                    for (int p = 0; p < 10; p ++){
                        if (choices[i] == comp[p]){
                            count ++;
                        }
                    }
                }

//Le nombre de numeros est envoye a l'utilisateur                
                System.out.println("\n\nVous correspondez a un total de " + count + " nombre(s)");

//Selon le nombre de numeros correspondants, L'utilisateur gagne des differentes sommes d'argent.                
                if (count >=2 && count < 4){
                    bet *= -1;
                }
                if (count >=4 && count < 6){
                    bet *= -2;
                }
                if (count >=6 && count < 8){
                    bet *= -3;
                }
                if (count >= 8 && count < 10){
                    bet *= -4;
                }
                if (count == 10){
                    bet *= -5;
                }
                else {
                    bet *= 1;
                }

//La boucle while se termine et l'utilisateur revient au menu principal                
                path3 = 2;
            }

//Si l'utilisateur decide de voir les instructions, elles seront affiches et l'utilisateur retourne au menu du jeu            
            if (path == 2){
                System.out.print("\nRègles"
                        + "\n¯¯¯¯¯"
                        + "\n1. Pour commencer, vous choisissez 10 nombres allant de 1 a 40."
                        + "\n2. Ensuite, 10 autres nombres de 1 a 40 sont generes aleatoirement"
                        + "\n3. En fonction du nombre de nombres que vous pouvez faire correspondre, votre pari est multiplie en consequence"
                        + "\n4. 2 a 3 nombres correspondants = Vous obtenez un montant en dollars egal a votre mise"
                        + "\n5. 4 a 5 nombres correspondants = Vous obtenez un montant en dollars egal a 2 fois votre mise"
                        + "\n6. 6 a 7 nombres correspondants = Vous obtenez un montant en dollars egal a 3 fois votre mise"
                        + "\n7. 8 a 9 nombres correspondants = Vous obtenez un montant en dollars egal a 4 fois votre mise"
                        + "\n8. 10 nombres correspondants = Vous obtenez un montant en dollars egal a 5 fois votre mise\n");
            }

//Si l'utilisateur choisit de quitter le jeu, la boucle while se termine et il retournera au menu principal            
            if (path == 3){
                path3 = 2;
            }

        }

//Le montant d'argent gagne ou perdu est retourne a la methode principale
        return bet;
    }

    //Methode de jeu de la Roulette
    public static int Roulette(int total){
        Scanner reader = new Scanner(System.in);
        Random gen = new Random();
        int path3 = 1;
        int beteven = 0;
        int betodd = 0;
        int betnum = 0;
        int choice2 = 1;
        int bet1 = 0;
        int choice = 0;
        int num = 37;
        int money = 0;
        int count = 0;
        int betColour = 0;

//L'utilisateur choisit dans le menu de la Roulette et l'entree est verifiee      
        while (path3 == 1) {
            System.out.print("\nEntrez 1 pour faire un pari: "
                    + "\nEntrez 2 pour voir les instructions: "
                    + "\nEntrez 3 pour quitter le jeu: "
                    + "\nEntrez ici: ");
            int path = reader.nextInt();

            while (path < 1 || path > 3){
                System.out.print("\nEntrez 1 pour faire un pari: "
                        + "\nEntrez 2 pour voir les instructions: "
                        + "\nEntrez 3 pour quitter le jeu: "
                        + "\nEntrez ici: ");
                path = reader.nextInt();
            }

//Si il choisit de parier, il sera envoye vers un menu où il choisira sur quoi parier            
            if (path == 1){

//La boucle Do while permet a l'utilisateur de parier sur plusieurs choses  
//L'utilisateur ne peut pas parier deux fois sur le même choix
                do {
                    System.out.print("\nEntrez 1 pour parier sur pair/impair (pari 2x)"
                            + "\nEntrez 2 pour faire un pari sur le numero (pari 4x)"
                            + "\nEntrez 3 pour faire un pari sur la couleur"
                            + "\nEntrez ici: ");
                    int betChoice = reader.nextInt();

                    while (betChoice < 1 || betChoice > 3){
                        System.out.print("\nEntrez 1 pour parier sur pair/impair (pari 2x)"
                                + "\nEntrez 2 pour faire un pari sur le numero (pari 4x)"
                                + "\nEntrez 3 pour faire un pari sur la couleur"
                                + "\nEntrez ici: ");
                        betChoice = reader.nextInt();
                    }

                    while ((betChoice == 1) && (beteven > 0 || betodd > 0)){
                        System.out.print("\nEntrez 1 pour parier sur pair/impair (pari 2x)"
                                + "\nEntrez 2 pour faire un pari sur le numero (pari 4x)"
                                + "\nEntrez 3 pour faire un pari sur la couleur"
                                + "\nEntrez ici: ");
                        betChoice = reader.nextInt();

                        while (betChoice < 1 || betChoice > 3){
                            System.out.print("\nEntrez 1 pour parier sur pair/impair (pari 2x)"
                                    + "\nEntrez 2 pour faire un pari sur le numero (pari 4x)"
                                    + "\nEntrez 3 pour faire un pari sur la couleur"
                                    + "\nEntrez ici: ");
                            betChoice = reader.nextInt();
                        }
                    }

                    while ((betChoice == 2) && (betnum > 0)){
                        System.out.print("\nEntrez 1 pour parier sur pair/impair"
                                + "\nEntrez 2 pour faire un pari sur le numero"
                                + "\nEntrez 3 pour faire un pari sur la couleur"
                                + "\nEntrez ici: ");
                        betChoice = reader.nextInt();

                        while (betChoice < 1 || betChoice > 3){
                            System.out.print("\nEntrez 1 pour parier sur pair/impair (pari 2x)"
                                    + "\nEntrez 2 pour faire un pari sur le numero (pari 4x)"
                                    + "\nEntrez 3 pour faire un pari sur la couleur"
                                    + "\nEntrez ici: ");
                            betChoice = reader.nextInt();
                        }
                    }

                    while ((betChoice == 3) && (betColour > 0)){
                        System.out.print("\nEntrez 1 pour parier sur pair/impair "
                                + "\nEntrez 2 pour faire un pari sur le numero"
                                + "\nEntrez 3 pour faire un pari sur la couleur"
                                + "\nEntrez ici: ");
                        betChoice = reader.nextInt();

                        while (betChoice < 1 || betChoice > 3){
                            System.out.print("\nEntrez 1 pour parier sur pair/impair (pari 2x)"
                                    + "\nEntrez 2 pour faire un pari sur le numero (pari 4x)"
                                    + "\nEntrez 3 pour faire un pari sur la couleur"
                                    + "\nEntrez ici: ");
                            betChoice = reader.nextInt();
                        }
                    }

//Paris sur pair ou impair                  
                    if (betChoice == 1){
                        System.out.print("\nEntrez 1 pour parier sur pair"
                                + "\nEntrez 2 pour parier sur impair"
                                + "\nEntrez ici: ");
                        bet1 = reader.nextInt();

                        while (bet1 < 1 || bet1 > 2){
                            System.out.print("\nEntrez 1 pour parier sur pair"
                                    + "\nEntrez 2 pour parier sur impair"
                                    + "\nEntrez ici: ");
                            bet1 = reader.nextInt();
                        }

                        if (bet1 == 1){
                            System.out.print("\nEntrez combien vous souhaitez parier: ");
                            beteven = reader.nextInt();

                            while (beteven + betnum + betColour > total  || beteven < 1){
                                System.out.print("\nEntrez combien vous souhaitez parier: ");
                                beteven = reader.nextInt();
                            }
                        }

                        if (bet1 == 2){
                            System.out.print("\nEntrez combien vous souhaitez parier: ");
                            betodd = reader.nextInt();

                            while (betodd + betnum + betColour > total || betodd < 1){
                                System.out.print("\nEntrez combien vous souhaitez parier: ");
                                betodd = reader.nextInt();
                            }
                        }
                    }

//Paris sur un numero specifique                  
                    if (betChoice == 2){
                        System.out.print("\nEntrez le nombre de 0 a 36: ");
                        num = reader.nextInt();

                        while (num < 0 || num > 36){
                            System.out.print("\nEntrez le nombre de 0 a 36: ");
                            num = reader.nextInt();
                        }

                        System.out.print("\nEntrez combien vous souhaitez parier: ");
                        betnum = reader.nextInt();

                        while (beteven + betodd + betnum + betColour > total || betnum < 1){
                            System.out.print("\nEntrez combien vous souhaitez parier: ");
                            betnum = reader.nextInt();
                        }
                    }

//Paris de couleur                  
                    if (betChoice == 3){
                        System.out.print("\nEntrez 1 pour parier sur le vert (pari 3x)"
                                + "\nEntrez 2 pour parier sur le rouge (2x pari)"
                                + "\nEntrez 3 pour parier sur le noir (2x pari)"
                                + "\nEntrez ici: ");
                        choice = reader.nextInt();

                        while (choice < 1 || choice > 3){
                            System.out.print("\nEntrez 1 pour parier sur le vert (pari 3x)"
                                    + "\nEntrez 2 pour parier sur le rouge (2x pari)"
                                    + "\nEntrez 3 pour parier sur le noir (2x pari)"
                                    + "\nEntrez ici: ");
                            choice = reader.nextInt();
                        }

                        if (choice == 1){
                            System.out.print("\nEntrez combien vous souhaitez parier: ");
                            betColour = reader.nextInt();

                            while (beteven + betodd + betnum + betColour > total || betColour < 1){
                                System.out.print("\nEntrez combien vous souhaitez parier: ");
                                betColour = reader.nextInt();
                            }
                        }

                        if (choice == 2){
                            System.out.print("\nEntrez combien vous souhaitez parier: ");
                            betColour = reader.nextInt();

                            while (beteven + betodd + betnum + betColour > total || betColour < 1){
                                System.out.print("\nEntrez combien vous souhaitez parier: ");
                                betColour = reader.nextInt();
                            }
                        }

                        if (choice == 3){
                            System.out.print("\nEntrez combien vous souhaitez parier: ");
                            betColour = reader.nextInt();

                            while (beteven + betodd + betnum + betColour > total || betColour < 1){
                                System.out.print("\nEntrez combien vous souhaitez parier: ");
                                betColour = reader.nextInt();
                            }
                        }
                    }

//Si l'utilisateur parie sur 3 sections ou atteint une mise totale egale a la somme d'argent dont il dispose, la boucle s'arrête                  
                    count ++;
                    if (count == 3){
                        break;
                    }
                    if (betColour + betnum + beteven + betodd == total){
                        break;
                    }

//L'utilisateur peut continuer le jeu ou faire un autre pari                  
                    System.out.print("\nEntrez 1 pour faire un autre pari et un autre entier pour voir votre sort: ");
                    choice2 = reader.nextInt();
                }
                while (choice2 == 1);

//Une couleur et un nombre aleatoires sont generes              
                int randNum = gen.nextInt(37);
                String [] colours = new String [100];

/*Pour rendre differentes couleurs plus probables, tous les nombres pairs qui ne sont pas des multiples de 10 sont noir.
Tous les nombres impairs sont rouge. Tous les multiples de 10 sont vert*/
                for (int i = 0; i < 100; i ++){
                    if ((i % 2 == 0) && ((i/10) % 2 != 0)){
                        colours[i] = "noir";
                    }
                    if ((i % 2 != 0) && ((i/10) % 2 != 0)){
                        colours[i] = "rouge";
                    }
                    if (((i/10) % 2 == 0)){
                        colours[i] = "vert";
                    }
                }

                int colourNum = gen.nextInt(100);

//La couleur et le nombre aleatoires sont generes              
                System.out.println("\nVous avez obtenu un " + colours[colourNum] + " " + randNum);

//En fonction des paris effectues et de la couleur et du nombre affiches, le pari est multiplie en consequence              
                if (bet1 == 1 && randNum % 2 == 0){
                    System.out.println("Vous avez matche un pair!");
                    beteven*=1;
                    money += beteven;
                }
                if (bet1 == 2 && randNum % 2 != 0){
                    System.out.println("Vous avez matche un impair!");
                    betodd *=1;
                    money += betodd;
                }
                if (num == randNum){
                    System.out.println("Vous avez matche avec votre nombre !");
                    betnum *=4;
                    money += betnum;
                }
                if (choice == 1 && colours[colourNum].equals("vert")){
                    System.out.println("Vous avez matche le vert!");
                    betColour*=3;
                    money += betColour;
                }
                if (choice == 2 && colours[colourNum].equals("rouge")){
                    System.out.println("Vous avez matche le rouge!");
                    betColour*=1;
                    money += betColour;
                }
                if (choice == 3 && colours[colourNum].equals("noir")){
                    System.out.println("Vous avez matche le noir!");
                    betColour*=1;
                    money += betColour;
                }
                if (bet1 == 1 && randNum % 2 != 0){
                    System.out.println("Vous n'avez pas matche un pair");
                    beteven*=-1;
                    money += beteven;
                }
                if (bet1 == 2 && randNum % 2 == 0){
                    System.out.println("Vous n'avez pas matche un impair");
                    betodd *=-1;
                    money += betodd;
                }
                if ((betnum > 0) && (num != randNum)){
                    System.out.println("Vous n'avez pas matche avec votre couleur");
                    betnum *=-1;
                    money += betnum;
                }
                if (choice == 1 && !colours[colourNum].equals("vert")){
                    System.out.println("Vous n'avez pas matche la couleur");
                    betColour*=-1;
                    money += betColour;
                }
                if (choice == 2 && !colours[colourNum].equals("rouge")){
                    System.out.println("Vous n'avez pas matche la couleur");
                    betColour*=-1;
                    money += betColour;
                }
                if (choice == 3 && !colours[colourNum].equals("noir")){
                    System.out.println("Vous n'avez pas matche la couleur");
                    betColour*=-1;
                    money += betColour;
                }

//L'utilisateur revient au menu principal          
                path3 = 2;
            }

//Si l'utilisateur choisit de voir les instructions, elles seront affichees          
            if (path == 2){
                System.out.print("\nRègles"
                        + "\n¯¯¯¯¯"
                        + "\n1. Placez un pari ou plus sur l'un ou l'autre"
                        +  "\n   I) Une couleur (noir, rouge ou vert),"
                        + "\n   II) Un nombre specifique (0-36)"
                        + "\n   III) Si le nombre sera pair/impair"
                        + "\n2. Lancez ensuite votre nombre pour voir si vous avez gagne ou perdu de l'argent.\n");
//L'utilisateur revient au menu du jeu             
            }

//Si l'utilisateur decide de quitter le jeu, l'utilisateur revient au menu principal          
            if (path == 3){
                path3 = 2;
            }

        }

//Le montant de l'argent gagne ou perdu est retourne a la methode principale      
        return money;
    }
}