package com.interview.algorithms.graph;

import java.util.Collection;

// Maintains a network of movies and customers
// All methods should return an empty collection, -1, or null on failure, as appropriate
public interface SocialMovies {

    // Defines a movie ID to title mapping in the system
    void addMovie(int movieId, String title);

    // Returns the title of the given movie
    String lookupMovie(int movieId);

    // Defines a customer ID to name mapping in the system
    void addCustomer(int customerId, String name);

    // Returns the name of the given customer
    String lookupCustomer(int customerId);

    // Associate two customers as being friends
    void addFriend(int customerId1, int customerId2);

    // Returns the IDs of all customers that are friends of both given customers
    Collection<Integer> getCommonFriends(int customerId1, int customerId2);

    // Returns the total number of unique customers that can be reached from the given customer
    // through at most <maxLinks> friend links
    // Example:
    // - A is friends with B, C, D
    // - B is friends with A, F
    // getNetworkSize(A,1) := 3
    // getNetworkSize(A,2) := 4
    int getNetworkSize(int customerId, int maxLinks);
}
