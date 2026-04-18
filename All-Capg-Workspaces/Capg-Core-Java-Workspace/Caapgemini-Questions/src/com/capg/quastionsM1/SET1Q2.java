package com.capg.quastionsM1;
import java.util.*;

public class SET1Q2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlaylistTracker tracker = new PlaylistTracker();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            if (input.startsWith("ADD ")) {
                String songName = input.substring(4);
                tracker.addSong(songName);
            } else if (input.startsWith("REMOVE ")) {
                String songName = input.substring(7);
                tracker.removeSong(songName);
            } else if (input.startsWith("MOVE ")) {
                String songName = input.substring(5);
                tracker.moveToTop(songName);
            } else if (input.equals("PRINT")) {
                tracker.getAllSongs();
            }
        }
    }
}
class PlaylistTracker {
    private LinkedList<String> playlist;

    public PlaylistTracker() {
        playlist = new LinkedList<>();
    }

    // Add song to end
    public void addSong(String songName) {
        playlist.addLast(songName);
    }

    // Remove song if exists
    public void removeSong(String songName) {
        playlist.remove(songName);
    }

    // Move song to top if exists
    public void moveToTop(String songName) {
        if (playlist.contains(songName)) {
            playlist.remove(songName);
            playlist.addFirst(songName);
        }
    }

    // Print all songs
    public void getAllSongs() {
        if (playlist.isEmpty()) {
            System.out.println("EMPTY PLAYLIST");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.print(playlist.get(i));
                if (i != playlist.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
