package studio8;

import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class Quiz {
	
	Question[] questions;
	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("For Select All the Apply or MCQ, please the number(s) (ex: 1234) \nPlease enter your answer: ");
		String out = in.next();
		return out;
	}
	
	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */	
	public int getTotalPoints() {
		int totalPoints = 0;
		for (Question question : this.questions) {
			int points = question.getPoints();
			totalPoints += points;
		}
		return totalPoints;
	}
	
	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		int totalPoints = this.getTotalPoints();
		int pointsEarned = 0;
		for (int i = 0; i < this.questions.length; i++) {
			System.out.println();
			this.questions[i].displayPrompt();
			System.out.println();
			String givenAnswer = getUserAnswer(in);
			int points = this.questions[i].checkAnswer(givenAnswer);
			System.out.println("Points earned: " + points);
			System.out.println();
			pointsEarned += points;
		}
		System.out.println("You scored " + pointsEarned + "/" + totalPoints);

	}
	
	
	public static void main(String[] args) {
		// TODO: Make your own Quiz!
		Scanner in = new Scanner(System.in);
		Question q1 = new Question("How many fingers does a human have?", "10", 5);
		String[] choices = {"Pretty", "Fat", "Smart", "Funny"};
		String[] choices2 = {"Claire Park", "Junoh Kim", "Yiming Zhao"};
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("Who is my girlfriend?", "1", 5, choices2);
		SelectAllQuestion s1 = new SelectAllQuestion("What do I like about my girlfriend?", "134", choices);
		Question[] questions = {q1, q2, s1};
		Quiz quiz = new Quiz(questions);
		// for (Question question : quiz.questions) {
		// 	question.displayPrompt();
		// }
		quiz.takeQuiz(in);
		
	}
}
