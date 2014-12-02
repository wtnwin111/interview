package com.interview.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created_By: stefanie
 * Date: 14-12-2
 * Time: 下午4:54
 */
public class D3_MusicalJukeBox {
    static class Song {
        String name;
    }

    static class CD {
        //a model of physical CD
        Map<Song, Integer> tracks = new HashMap<>();

        public CD() {
            //init the tracks
        }
    }

    static class PlayList {
        private Queue<Song> queue;

        PlayList(Queue<Song> queue) {
            this.queue = queue;
        }

        public Song getNextTrackToPlay() {
            return queue.peek();
        }

        public void addToPlayList(Song s) {
            queue.add(s);
        }
    }

    static class CDPlayer {
        private CD cd;
        private PlayList playlist;

        CDPlayer(CD cd, PlayList playlist) {
            this.cd = cd;
            this.playlist = playlist;
        }

        public CD getCd() {
            return cd;
        }

        public void setCd(CD cd) {
            this.cd = cd;
        }

        public PlayList getPlaylist() {
            return playlist;
        }

        public void setPlaylist(PlayList playlist) {
            this.playlist = playlist;
        }

        public void playTrack(Song s) {
        }
    }

    static class TrackSelector {
        private Song currentSong;

        public TrackSelector(Song s) {
            currentSong = s;
        }

        public void setTrack(Song s) {
            currentSong = s;
        }

        public Song getCurrentSong() {
            return currentSong;
        }
    }

    static class User {
        private String name;
        private String id;

        User(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    static class JukeBox {
        private CDPlayer cdPlayer;
        private User user;
        private Set<CD> cdCollection;
        private TrackSelector ts;

        public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, TrackSelector ts) {
            this.cdPlayer = cdPlayer;
            this.cdCollection = cdCollection;
            this.user = user;
            this.ts = ts;
        }

        public void play(){

        }

        public Song getCurrentTrack() {
            return ts.getCurrentSong();
        }

        public void processOneUser(User u) {
            this.user = u;
        }
    }

}
