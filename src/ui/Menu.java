package ui;

public class Menu {

    public void auth() {
        System.out.println("""
                ========================Welcome Music Recommender System=====================
                                1. Login
                                2. Register
                                3. Exit
                ==============================================================================
                """);
    }

    public void app() {
        System.out.println("""
                =========================== App ===============================
                                1. Access to Profile
                                2. Search Songs by Title
                                3. Search Songs by Genre
                                4. Search Songs by Artist
                                5. Search Songs by Date(YYY-mm-dd)
                                6. Real-Time Song Search
                                7. Back
                ================================================================
                """);
    }


    public void admin() {
        System.out.println("""
                =============================Admin Manager Menu============================
                                1.Add song
                                2.Update song
                                3.Remove song
                                4.Show All song
                                5. Back
                ===========================================================================
                """);
    }

    public void profile() {
        System.out.println("""
                =========================Profile Menu===============================
                                1. Show Top Songs
                                2. Show Top Albums
                                3. Show Top Artists
                                4. Show Top Genres
                                5. Back
                ====================================================================
                """);

    }

    public void MediaPlayer() {
        System.out.println("""
                =========================Song Menu===============================
                                1. Play song
                                2. Pause song
                                3. Resume song
                                4. Next song
                                5. Previous song
                                6. Back
                ==================================================================
                """);

    }

}
