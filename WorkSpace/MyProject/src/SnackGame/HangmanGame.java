package SnackGame;

import java.util.Scanner;

public class HangmanGame {
    private String[] words = {"apple", "banana", "orange", "grape", "pineapple"};
    private String word;
    private char[] guessedLetters;
    private int triesLeft;

    public void play() {
        initializeGame();
        while (triesLeft > 0 && !isWordGuessed()) {
            displayGameState();
            char letter = readLetterFromUser();
            checkLetter(letter);
        }
        displayGameResult();
    }

    private void initializeGame() {
        // Select a random word from the array
        word = words[(int) (Math.random() * words.length)];

        // Initialize guessedLetters with underscores
        guessedLetters = new char[word.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        triesLeft = 6;
    }

    private void displayGameState() {
        System.out.println("\nWord: " + String.valueOf(guessedLetters));
        System.out.println("Tries left: " + triesLeft);
    }

    private char readLetterFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String input = scanner.nextLine().toLowerCase();
        return input.charAt(0);
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                guessedLetters[i] = letter;
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            triesLeft--;
            System.out.println("Wrong letter!");
        }
    }

    private boolean isWordGuessed() {
        return word.equals(String.valueOf(guessedLetters));
    }

    private void displayGameResult() {
        if (isWordGuessed()) {
            System.out.println("\nCongratulations! You guessed the word: " + word);
        } else {
            System.out.println("\nGame over! You ran out of tries. The word was: " + word);
        }
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}
