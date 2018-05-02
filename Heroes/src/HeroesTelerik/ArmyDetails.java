package HeroesTelerik;

import HeroesTelerik.MainHero.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArmyDetails {

    public static void showForces(Hero hero) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            System.out.println("\n\n");
            System.out.println("********************************************");
            System.out.println("********************************************");
            System.out.println("                 YOUR FORCES\n");
            System.out.printf(" 1.  %d %s        (press 1 to disband) \n", hero.army.getSlot1numbers(), hero.army.getSlotOneType());
            System.out.printf(" 2.  %d %s        (press 2 to disband) \n", hero.army.getSlot2numbers(), hero.army.getSlotTwoType());
            System.out.printf(" 3.  %d %s        (press 3 to disband)\n\n", hero.army.getSlot3numbers(), hero.army.getSlotThreeType());

            System.out.println("(Press 4 to exit)");
            System.out.print("Please enter your choice: ");
            char choice = br.readLine().charAt(0);
            switch (choice) {

                case '1':
                    hero.army.setSlotOne(2000000000);
                    continue;
                case '2':
                     hero.army.setSlotTwo(2000000000);
                     continue;
                case '3':
                     hero.army.setSlotThree(2000000000);
                     continue;
                case '4':
                     return;

            }


        }


    }
}