/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rosatace.pauladrian_finalexam;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class RosatacePaulAdrian_FinalExam {

    public static void main(String[] args) {
        
        RosatacePaulAdrian_FinalExam ros = new RosatacePaulAdrian_FinalExam();
        ros.runCode();
    }
    
        Rosatace_Class network = new Rosatace_Class();
        Scanner scan = new Scanner(System.in);
    
    public void runCode() {
        while (true) {
            displaySelection();
            int select = getUserChoice();

            if (select == 1){
                addUser();
            }else if (select == 2){
                addFriendship();
            }else if (select == 3){
                showFriendships();
            }else if (select == 4){
                getRecommendedFriends();
            }else if (select == 5){
                System.out.println("Ended!");
                    scan.close();
                    return;
            }else {
                System.out.println("Invalid selection. Please retry.");
            }
        }   
    }   
    
    private void displaySelection() {
        System.out.println("=======================================");
        System.out.println("   Social Media Friend Recommendation ");
        System.out.println("[1] Add User");
        System.out.println("[2] Add Friendship");
        System.out.println("[3] Show The List of Friends");
        System.out.println("[4] Friend Recommendations");
        System.out.println("[5] Exit");
        System.out.println("=======================================");
    }

    private int getUserChoice() {
        System.out.print("\nEnter your choice: ");
        return scan.nextInt();
    }

    private void addUser() {
        System.out.print("Enter the username: ");
        String username = scan.next();
        System.out.print("Enter the user Id: ");
        int userId = scan.nextInt();
        network.addUser(userId, username);
        System.out.println("User " + username + " (Id: " + userId + ") added.\n");          
    }

    private void addFriendship() {
        System.out.print("Enter the first user Id: ");
        int user1 = scan.nextInt();
        System.out.print("Enter the second user Id: ");
        int user2 = scan.nextInt();
        network.addFriendship(user1, user2);
        System.out.println("Friendship added between [Id:" + user1 + "] and [Id:" + user2 + "].\n");
    }

    private void showFriendships() {
        network.displayFriendships();
    }    
     
    private void getRecommendedFriends() {
        System.out.print("Enter the user Id to get recommendations for: ");
        int userId = scan.nextInt();
        Set<Integer> recommendedFriends = network.friendRecommendations(userId);
        if (recommendedFriends.isEmpty()) {
            System.out.println("No recommended friends for user " + (userId) +".");
        }else {
            System.out.print("Friend recommendations for " + (userId) + ": ");
            for (int friendId : recommendedFriends) {
                System.out.print("[Id:" + friendId + "]");
            }
            System.out.println();
        }
    }
}   

