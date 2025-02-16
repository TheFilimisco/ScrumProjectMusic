package management;

import model.song.Album;
import model.song.Artist;
import model.song.Genre;
import model.song.Song;
import model.user.memberuser.MemberUser;
import model.user.User;
import model.user.memberuser.UserHistory;

import java.util.*;

public class MemberProfileManager { ;
    MemberUser user;
    UserHistory history;

    public MemberProfileManager() {}

    public User showProfile(){return user;}

    public ArrayList<Integer> showTopTenSongs() {
       List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(history.getSongCounter().entrySet());
       sortedList.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
       ArrayList<Integer> top10 = new ArrayList<>();
        for (int i = 0; i < Math.min(10, sortedList.size()); i++) {
            top10.add(sortedList.get(i).getKey());
        }
        return top10;
    }

    public ArrayList<Album> showTopFiveAlbums() {
        List<Map.Entry<Album, Integer>> sortedList = new ArrayList<>(history.getAlbumCounter().entrySet());
        sortedList.sort(Map.Entry.<Album, Integer>comparingByValue().reversed());
        ArrayList<Album> top5 = new ArrayList<>();
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            top5.add(sortedList.get(i).getKey());
        }
        return top5;
    }

    public ArrayList<Artist> showTopFiveArtists() {
        List<Map.Entry<Artist, Integer>> sortedList = new ArrayList<>(history.getArtistCounter().entrySet());
        sortedList.sort(Map.Entry.<Artist, Integer>comparingByValue().reversed());
        ArrayList<Artist> top5 = new ArrayList<>();
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            top5.add(sortedList.get(i).getKey());
        }
        return top5;
    }

    public ArrayList<Genre> showTopThreeGenres(){
        List<Map.Entry<Genre, Integer>> sortedList = new ArrayList<>(history.getGenreCounter().entrySet());
       sortedList.sort(Map.Entry.<Genre,Integer>comparingByValue().reversed());
        ArrayList<Genre> top3 = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
        top3.add(sortedList.get(i).getKey());
    }
        return top3;
}

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
        else user.setPassword(password);
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
        else user.setNickName(nickname);
        System.out.println("Nickname updated succesfully.");
    }
}
