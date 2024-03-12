import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Other profile-related methods
}

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class OnlineExam {
    private static User currentUser;
    private static List<Question> questions;
    private static int timeLimitInMinutes = 10; // Exam time limit

    public static void main(String[] args) {
        initializeQuestions();
        login();
        updateProfileAndPassword();

        // Start the exam
        startExam();

        // Display questions, allow user to select answers
        displayQuestions();

        // Timer and auto-submit
        startTimerAndSubmit();

        // Logout
        logout();
    }

    private static void initializeQuestions() {
        // Initialize questions with options and correct answers
        questions = new ArrayList<>();
        List<String> options1 = List.of("Rome", "Monaco", "Paris", "Madrid");
        questions.add(new Question("What is the capital of France?", options1, 2));

        List<String> options2 = List.of("Mars", "Saturn", "Uranus", "Jupiter");
        questions.add(new Question("What is the largest planet in our solar system?", options2, 3));

        // Add more questions as needed
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Exam!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Authenticate user (in a real system, you'd check against a database)
        currentUser = new User(username, password);
        System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
    }

    private static void updateProfileAndPassword() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Update Profile and Password:");
        // Implement profile and password update logic
    }

    private static void startExam() {
        System.out.println("Starting Exam. You have " + timeLimitInMinutes + " minutes.");
        // Implement logic to set up the exam environment
    }

    private static void displayQuestions() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestionText());
            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char) ('A' + j) + ". " + options.get(j));
            }

            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            // Validate and process the answer
            validateAndProcessAnswer(question, userAnswer);
        }
    }

    private static void validateAndProcessAnswer(Question question, char userAnswer) {
        int userOption = userAnswer - 'A';
        if (userOption >= 0 && userOption < question.getOptions().size()) {
            if (userOption == question.getCorrectOption()) {
                System.out.println("Correct!");
                // Implement logic to track user's correct answers
            } else {
                System.out.println("Incorrect. Correct answer: " + (char) ('A' + question.getCorrectOption()));
                // Implement logic to track user's incorrect answers
            }
        } else {
            System.out.println("Invalid answer. Please choose A, B, C, or D.");
            // Allow the user to re-enter the answer for the current question
            validateAndProcessAnswer(question, new Scanner(System.in).next().toUpperCase().charAt(0));
        }
    }

    private static void startTimerAndSubmit() {
        // Implement timer logic
        System.out.println("\nTime's up! Automatically submitting your answers.");
        // Implement logic to submit the answers
    }

    private static void logout() {
        System.out.println("Logout successful. Thank you for taking the exam, " + currentUser.getUsername() + "!");
        // Implement any necessary cleanup or logging
    }
}
