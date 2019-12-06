package main.java.onlinechat;

import java.util.Scanner;
import java.util.HashMap;


public class OnlineChat {

    private static HashMap<String, User> users = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Integer command = 1;

        Scanner in = new Scanner(System.in);

        try {
            while (command != 0) {
                displayOptionsMenu();
                command = in.nextInt();
                in.nextLine();
                processCommand(command, in);
            }

            System.out.println("Bye bye! See you next time!");
        } catch (Exception e) {

        } finally {
            in.close();
        }
    }

    public static void displayOptionsMenu() {
        System.out.println("Welcome to our Chat app");
        System.out.println("-----------------------");
        System.out.println("Choose one of the following options");
        System.out.println("1) Choose user");
        System.out.println("2) Create user");
        System.out.println("0) Exit");
    }

    public static void processCommand(int command, Scanner in) {
        if (command == 1) {
            chooseUser(in);
        }

        if (command == 2) {
            createUser(in);
        }

    }

    public static void createUser(Scanner in) {
        System.out.println("Type the user info");
        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("Email: ");
        String email = in.nextLine();

        System.out.print("Phone: ");
        String phone = in.nextLine();

        User user = new User(name, email, phone);

        if (users.containsKey(email)) {
            System.out.println("User with email address already registered!");
            return;
        }

        users.put(user.getEmail(), user);
        System.out.println("User created successfully");
    }

    public static void chooseUser(Scanner in) {
        listUsers();

        System.out.println("Type user email address");
        System.out.print("Email: ");
        String email = in.nextLine();

        if (!users.containsKey(email)) {
            System.out.println("Sorry, email is not registered");
            return;
        }

        User user = users.get(email);
        userLoop(user, in);
    }

    public static void listUsers() {
        users.forEach((String email, User user) ->
            System.out.println(String.format("User: %s", user.getEmail()))
        );
    }

    public static void userLoop(User user, Scanner in) {
        System.out.println("User selected");
        System.out.println(user.getEmail());
        return;
    }
}
