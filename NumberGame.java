import java.util.*;
public class NumberGame {

    public static int result(int guess, int randomNum ){

        int deviation =0;
        if(guess==randomNum){
            System.out.println("Bingo!");
        }

        else if(guess>randomNum){

            if((guess-randomNum)>15){
                System.out.println("Guess is too high!!");
            }

            else{
                System.out.println("Guess is a bit high!!");
            }

            deviation += Math.abs(guess-randomNum);
        }

        else if(guess<randomNum){

            if((randomNum-guess)>15){
                System.out.println("Guess is too low!!");
            }

            else{
                System.out.println("Guess is a bit low!!");
            }

            deviation += Math.abs(guess-randomNum);

        }

        return deviation;

    }




    public static int[] round(int maxAttempts) {
        Scanner scnr = new Scanner(System.in);
        int[] data = new int[2];
        int randomNum;
        int guess = 0;
        int attempts = 1;
        int deviation = 0;
        int devPerRound =0;
        Random rand = new Random();
        randomNum = rand.nextInt(100) + 1;

        while (attempts <= maxAttempts) {

            while (true) {
                System.out.println("\nEnter your guess");

                if (scnr.hasNextInt()) {
                    guess = scnr.nextInt();
                    break;
                } else {

                    if (scnr.hasNextDouble()) {
                        System.out.println("Pls input an integer value");
                    } else {
                        System.out.println("Pls input a valid value");
                    }

                    scnr.next();
                }
            }

            devPerRound = result(guess, randomNum);
            deviation += devPerRound;

            if(devPerRound ==0){
                break;
            }
            attempts++;
        }

        if(attempts==maxAttempts+1){
            System.out.println("You lose! You have extinguished all attempts!");
            System.out.println("The random number is " + randomNum);
        }

        else {
            System.out.println("You took " + (attempts) + " attempts to get it right");
        }

        data[0] = attempts;
        data[1] = deviation;

        return data;

    }







    public static double overallScore(ArrayList<int[]> data,int maxAttempts){

        double overallScore;
        double avgDeviation=0.0;
        int noOfWins = 0;

        for(int i=0;i<data.size();i++){
            if (data.get(i)[0]<=maxAttempts){
                noOfWins++;
            }
            avgDeviation+=data.get(i)[1];
        }

        avgDeviation = avgDeviation/data.size();

        if(data.size()<=4){
            if(maxAttempts<=4) {
                overallScore = (1 - (avgDeviation / 100)) * 70 + ((double) noOfWins / data.size()) * 30;
            }

            else{
                overallScore = (1 - (avgDeviation / 100)) * 60 + ((double) noOfWins / data.size()) * 40;
            }

        }

        else {
            if(maxAttempts<=4) {
                overallScore = (1 - (avgDeviation / 100)) * 30 + ((double) noOfWins / data.size()) * 70;
        }

            else{
                overallScore = (1 - (avgDeviation / 100)) * 40 + ((double) noOfWins / data.size()) * 60;
            }
        }

        return overallScore;

    }






    public static void main(String[] args){

        ArrayList<int[]> dataOfRounds = new ArrayList<>();
        int rounds;
        int maxAttempts;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to the number game");



        while(true) {
            System.out.println("\nPls enter the no of rounds you want to play ");

            if (scnr.hasNextInt()) {
                rounds = scnr.nextInt();
                break;
            }

            else {

                if (scnr.hasNextDouble()) {
                    System.out.println("Pls input an integer value");
                }

                else {
                    System.out.println("Pls input a valid value");
                }

                scnr.next();
            }
        }




        while(true) {
            System.out.println("\nHow many maximum attempts do you want to have in a round?");
            System.out.println("Easy: 8 and above ");
            System.out.println("Medium: 3-7");
            System.out.println("Hard: 1-3");


            if (scnr.hasNextInt()) {
                maxAttempts = scnr.nextInt();
                break;
            }

            else {

                if (scnr.hasNextDouble()) {
                    System.out.println("Pls input an integer value");
                }

                else {
                    System.out.println("Pls input a valid value");
                }

                scnr.next();
            }
        }



        for(int i =0;i<rounds;i++){
            System.out.println("\nRound " + (i + 1));
            dataOfRounds.add(round(maxAttempts));
        }


        double score = overallScore(dataOfRounds,maxAttempts);
        System.out.printf("Your overall score(out of 100) is: %.2f" ,score);

    }



}
