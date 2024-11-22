/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rosatace.pauladrian_finalexam;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class Rosatace_Class {
    private final Map<Integer, String> idToUsername;
    private final Map<Integer, Set<Integer>> friendshipGraph;

    public Rosatace_Class() {
        idToUsername = new HashMap<>();
        friendshipGraph = new HashMap<>();
    }

    public void addUser(int userId, String username) {
        idToUsername.put(userId, username);
        friendshipGraph.put(userId, new HashSet<>());
    }

    public void addFriendship(int user1, int user2) {
        friendshipGraph.get(user1).add(user2);
        friendshipGraph.get(user2).add(user1);
    }

    public Set<Integer> getFriends(int userId) {
        return friendshipGraph.getOrDefault(userId, Collections.emptySet());
    }

    public Set<Integer> friendRecommendations(int userId) {
        Set<Integer> recommendedFriends = new HashSet<>();
        Set<Integer> userFriends = friendshipGraph.getOrDefault(userId, Collections.emptySet());

        for (int friendId : userFriends) {
            for (int friendOfFriend : friendshipGraph.getOrDefault(friendId, Collections.emptySet())) {
                if (!userFriends.contains(friendOfFriend) && friendOfFriend != userId) {
                    recommendedFriends.add(friendOfFriend);
                }
            }
        }
        return recommendedFriends;
    }

    public void displayFriendships() {
        for (Map.Entry<Integer, Set<Integer>> entry : friendshipGraph.entrySet()) {
            int userId = entry.getKey();
            String username = idToUsername.get(userId);
            System.out.print(username +"[Id:" + userId + "] is friends with ");
            for (int friendId : entry.getValue()) {
                System.out.print(idToUsername.get(friendId) +"[Id:" + friendId + "]\n");
            }               
        }
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Users: ");
        for (int userId : getAllUsers()) {
        System.out.print(userId + ", ");
        }
        System.out.print("\nFriendships: [");
        for (int userId : getAllUsers()) {
            Set<Integer> friends = getFriends(userId);
            if (!friends.isEmpty()) {
                for (int friendId : friends) {
                    System.out.print("(" + userId + "," + friendId + ")");
                }
            }
        }
        System.out.print("]\n\n");
    }

    public Set<Integer> getAllUsers() {
        return new HashSet<>(friendshipGraph.keySet());
    }
}      

