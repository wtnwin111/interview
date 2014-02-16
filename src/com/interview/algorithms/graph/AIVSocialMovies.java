package com.interview.algorithms.graph;

import java.util.*;

/**
 * Created_By: zouzhile
 * Date: 2/4/14
 * Time: 8:10 PM
 */


public class AIVSocialMovies implements SocialMovies {

    class Movie {
        int id;
        String title;
        Set<Movie> similarMovies;
        Movie(int id, String title) {
            this.id = id;
            this.title = title;
            this.similarMovies = new HashSet<Movie>();
        }
    }

    class Customer {
        int id = -1;
        String name;
        Set<Movie> likedMovies = null;
        Set<Movie> watchedMovies = null;
        Set<Customer> friends;
        Customer(int id, String name) {
            this.id = id;
            this.name = name;
            this.friends = new HashSet<Customer>();
            this.likedMovies = new HashSet<Movie>();
            this.watchedMovies = new HashSet<Movie>();
        }

        public void addFriend(Customer customer) {
            if(! this.friends.contains(customer))
                this.friends.add(customer);
        }

        @Override
        public boolean equals(Object o) {
            if ( o == null || ! (o instanceof Customer) )
                return false;
            return this.id == ((Customer)o).id;
        }

        @Override
        public int hashCode(){
            return this.id;
        }
    }

    private HashMap<Integer, Customer> customerNetwork = new HashMap<Integer, Customer>();
    private HashMap<Integer, Movie> movies = new HashMap<Integer, Movie>();


    @Override
    public void addMovie(int movieId, String title) {
        Movie movie = this.movies.get(movieId);
        if(movie == null) {
            movie = new Movie(movieId, title);
            this.movies.put(movieId, movie);
        }
    }

    @Override
    public String lookupMovie(int movieId) {
        Movie movie = this.movies.get(movieId);
        String title = movie == null ? null : movie.title;
        return title;
    }

    @Override
    public void addCustomer(int customerId, String name) {
        if(this.customerNetwork.get(customerId) != null)
            return;
        Customer customer = new Customer(customerId, name);
        this.customerNetwork.put(customerId, customer);
    }

    @Override
    public String lookupCustomer(int customerId) {
        Customer customer = this.customerNetwork.get(customerId);
        String name = customer == null ? null : customer.name;
        return name;
    }

    @Override
    public void addFriend(int customerId1, int customerId2) {
        if(this.customerNetwork.get(customerId1) == null ||
                this.customerNetwork.get(customerId2) == null ||
                customerId1 == customerId2)
            return;
        Customer customer1 = this.customerNetwork.get(customerId1);
        Customer customer2 = this.customerNetwork.get(customerId2);
        customer1.addFriend(customer2);
        customer2.addFriend(customer1);
    }

    @Override
    public Collection<Integer> getCommonFriends(int customerId1, int customerId2) {
        Customer customer1 = this.customerNetwork.get(customerId1);
        Customer customer2 = this.customerNetwork.get(customerId2);
        if(customer1 == null || customer2 == null)
            return new ArrayList<Integer>();
        List<Integer> common = new ArrayList<Integer>();
        for(Customer friend : customer1.friends){
            if(customer2.friends.contains(friend))
                common.add(friend.id);
        }
        return common;
    }

    @Override
    public int getNetworkSize(int customerId, int maxLinks) {
        Customer customer = this.customerNetwork.get(customerId);
        if(customer == null || maxLinks < 0)
            return 0;

        Set<Customer> candidates = new HashSet<Customer>();
        Set<Customer> visited = new HashSet<Customer>();
        candidates.add(customer);
        while(maxLinks >= 0 && ! candidates.isEmpty()) {
            Set<Customer> newCandidates = new HashSet<Customer>();
            for(Customer currentCandidate : candidates){
                if(! visited.contains(currentCandidate)) {
                    newCandidates.addAll(currentCandidate.friends);
                    visited.add(currentCandidate);
                }
            }
            candidates.clear();
            candidates.addAll(newCandidates);
            maxLinks --;
        }
        return visited.size();
    }
}
