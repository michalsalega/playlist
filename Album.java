package com.michalek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songList;
   // private ArrayList<Song> songs;

    private class SongList{
        private List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public List<Song> getSongs() {
            return songs;
        }

        public boolean addSong(String title, double duration){
            if(findSong(title) == null){
                this.songs.add(new Song(title, duration));
                return true;
            }
            return false;
        }

        public Song findSong(String title){
            for(Song checkedSong: this.songs){
                if(checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            }
            return null;
        }
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songList.addSong(title,duration);
    }
//
//    private Song findSong(String title) {
//        for(Song checkedSong: this.songs) {
//            if(checkedSong.getTitle().equals(title)) {
//                return checkedSong;
//            }
//        }
//        return null;
//    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >=0) && (index <= this.songList.getSongs().size())) {
            playList.add(this.songList.getSongs().get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songList.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }



















}
