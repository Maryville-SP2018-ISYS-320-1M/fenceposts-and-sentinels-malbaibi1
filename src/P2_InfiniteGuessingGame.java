/*
 ISYS 320
 Name: Mansour Albaibi
 Date: 21-4-2018
*/


import java.util.Random;
import java.util.Scanner;

public class P2_InfiniteGuessingGame {

 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  int secretNumber = getSecretNumber();
  int numberOfGuessesAllowed = 7;
  String str;
  String str1 = "quit";
  int totalGuess = 0, gamePlayed=0, totalWins = 0;
  while(true){
  outputWelcomeMessage();
  int guessesTaken = playGame(secretNumber, numberOfGuessesAllowed);
  totalGuess = totalGuess + guessesTaken;                                               //count total number of guesses
  gamePlayed = gamePlayed + 1;                                                          //count total games played
  int no = outputEndingMessage(guessesTaken, numberOfGuessesAllowed, secretNumber);
  totalWins = totalWins + no;                                                                       //count total wins
  System.out.println("Would you like to continue or quit game?");                       //enable user to continue playing
  str = in.next();
  if (str.equals("quit")) {
        break;
  }
  }
 
  System.out.println("Total games played : " + gamePlayed);
   System.out.println("Total guesses : " + totalGuess);
    System.out.println("Total games win : " + totalWins);
 }

 public static void outputWelcomeMessage() {
  System.out.println("This is a guessing game.");
  System.out.println("I picked a random number from 1 to 100");
 }

 public static int outputEndingMessage(int guessesTaken, int numberOfGuessesAllowed, int secretNumber) {      //return win game
   int win = 0;
  if (guessesTaken < numberOfGuessesAllowed) {
   System.out.println("Congratuations, you guessed it!");
   win++;
  } else {
   System.out.println("The secret number was " + secretNumber + ". Try again.");
  }
  return win;
 }

 public static int getSecretNumber() {
  Random generator = new Random();
  return generator.nextInt(100) + 1;
 }

 public static int getNextGuess() {
  Scanner console = new Scanner(System.in);
  int nextGuess;
  do {
   System.out.println("What is your guess? ");
   nextGuess = console.nextInt();

   if (nextGuess < 0 || nextGuess > 100) {
     if(nextGuess < 0){
     System.out.println("Guess is too small.");                            //feedback on user guess is too small
     System.out.println("ERROR: Guess should be between 0 and 100");
     }else if (nextGuess > 100){
     System.out.println("Guess is too large.");                            //feedback on user guess is too large
     System.out.println("ERROR: Guess should be between 0 and 100");
     }
   }
  } while (nextGuess < 0 || nextGuess > 100);

  return nextGuess;
 }

 public static int playGame(int secretNumber, int allowedGuesses) {
  int numOfGuessesTaken;
  numOfGuessesTaken = 0;
  while (numOfGuessesTaken < allowedGuesses) {
   int nextGuess = getNextGuess();

   if (nextGuess == secretNumber) {
    return numOfGuessesTaken;
   } else {
    System.out.println("Nope, guess again. ");
    numOfGuessesTaken++;
   }
  }

  return numOfGuessesTaken;
 }

}