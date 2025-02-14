package management;

import model.song.Artist;
import model.song.Genre;
import model.song.Song;
import model.user.MemberUser;
import model.user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

//public class MusicMemberManagerProfile implements MemberManagerProfile {
//    private HashMap<Integer, Song> songs;
//    private MemberUser memberUser;
//
//    public MusicMemberManagerProfile() {
//        this.songs = new HashMap<>();
//    }

    //To be added alongside the other methods
//    @Override
//    public User showProfile() {
//        return memberUser;
//    }
//
//
    public ArrayList<Song> showTopTenSongs() {
        ArrayList<Song> sortedSongs = new ArrayList<>(songs.values());
        sortedSongs.sort(Comparator.comparing(Song::getPlayCount).reversed());
        ArrayList<Song> topTenSongs = new ArrayList<>();
        Iterator<Song> songIterator = sortedSongs.iterator();
        int counter = 0;

        while(counter < 10){
            Song song = songIterator.next();
            topTenSongs.add(song);
            counter++;
        }
        return topTenSongs;
    }
//
//    @Override
//    public ArrayList<Genre> showTopThreeGenres() {
//        HashMap<Genre,Integer> topGenres = new HashMap<>();
//        for(Song song : songs.values()){
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<Artist> showTopArtist() {
//        return null;
//    }
//
//    @Override
//    public void updatePassword (String password) {
//        if (password.contains(memberUser.getName())){
//            System.out.println("The new password cannot contain your name");
//        }
//        else if (password.contains(memberUser.getNickName())){
//            System.out.println("The new password cannot contain your nickname");
//        }
//        else if (password.contains(memberUser.getEmail())){
//            System.out.println("The new password cannot contain your email");
//        }
//        else if (password.contains(memberUser.getDateOfBirth().toString())){
//            System.out.println("The new password cannot contain your date of birth");
//        }
//        else if (password.contains(memberUser.getPassword())){
//            System.out.println("The new password cannot be identical to your current one");
//        }
//        memberUser.setPassword(password);
//        System.out.println("Password updated succesfully.");
//    }
//
//    @Override
//    public void updateEmail(String email) {
//        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
//            memberUser.setEmail(email);
//            System.out.println("Email updated succesfully.");
//        }
//        else System.out.println("The new email has and invalid format, please try again.");
//    }
//
//    @Override
//    public void updateNickname(String nickname) {
//        if (nickname.contains(memberUser.getName())){
//            System.out.println("The new nickname cannot contain your name");
//        }
//        else if (nickname.contains(memberUser.getPassword())){
//            System.out.println("The new nickname cannot contain your password");
//        }
//        else if (nickname.contains(memberUser.getEmail())){
//            System.out.println("The new nickname cannot contain your email");
//        }
//        else if (nickname.contains(memberUser.getDateOfBirth().toString())){
//            System.out.println("The new nickname cannot contain your date of birth");
//        }
//        else if (nickname.contains(memberUser.getNickName())){
//            System.out.println("The new nickname cannot be identical to your current one");
//        }
//        memberUser.setNickName(nickname);
//        System.out.println("Nickname updated succesfully.");
//    }
//}
