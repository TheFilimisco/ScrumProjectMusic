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

public class MemberProfileManager {
    HashMap<String, Song> songs;
    MemberUser user;

    public MemberProfileManager() {}

    public User showProfile(){return user;}

    public ArrayList<Song> showTopTenSongs() {
        ArrayList<Song> sortedSongs = new ArrayList<>(songs.values());
//        sortedSongs.sort(Comparator.comparing().reversed());
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

//    public ArrayList<Genre> showTopThreeGenres(){}
//
//    public ArrayList<Artist> showTopArtist(){}

    public void updatePassword (String password) {
        if (password.contains(user.getName())){
            System.out.println("The new password cannot contain your name");
        }
        else if (password.contains(user.getNickName())){
            System.out.println("The new password cannot contain your nickname");
        }
        else if (password.contains(user.getEmail())){
            System.out.println("The new password cannot contain your email");
        }
        else if (password.contains(user.getDateOfBirth().toString())){
            System.out.println("The new password cannot contain your date of birth");
        }
        else if (password.contains(user.getPassword())){
            System.out.println("The new password cannot be identical to your current one");
        }
        user.setPassword(password);
        System.out.println("Password updated succesfully.");
    }


    public void updateEmail(String email) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            user.setEmail(email);
            System.out.println("Email updated succesfully.");
        }
        else System.out.println("The new email has and invalid format, please try again.");
    }

    public void updateNickname(String nickname) {
        if (nickname.contains(user.getName())){
            System.out.println("The new nickname cannot contain your name");
        }
        else if (nickname.contains(user.getPassword())){
            System.out.println("The new nickname cannot contain your password");
        }
        else if (nickname.contains(user.getEmail())){
            System.out.println("The new nickname cannot contain your email");
        }
        else if (nickname.contains(user.getDateOfBirth().toString())){
            System.out.println("The new nickname cannot contain your date of birth");
        }
        else if (nickname.contains(user.getNickName())){
            System.out.println("The new nickname cannot be identical to your current one");
        }
        user.setNickName(nickname);
        System.out.println("Nickname updated succesfully.");
    }
}
