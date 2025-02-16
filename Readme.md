# Music Recommender System

## Introduction
The application will manage a detailed data model with users, songs, artists, genres, and listening sessions. 
Additionally, data science techniques will be applied to analyze patterns in user preferences and audio data, offering a robust recommendation engine.

### Features

### 1. Authentication
![Auth](img/auth.jpg)

#### Auth

| Feature           | Description                      | Status | Developer |
|-------------------|----------------------------------|--------|-----------|
| Register          | Method void register (User user) | Done   | Steven    |
| Login             | Method User login                | Done   | Steven    |
| Generate Nickname | Generate random nickname         | Done   | Steven    |

#### User

| Feature       | Description                                              | Status | Developer |
|---------------|----------------------------------------------------------|--------|-----------|
| Guest_User    | Guest user access to Manager System                      | Done   | Steven    |  
| Admin_User    | Admin user access to Administrator Manager System        | Done   | Steven    |
| Member_User   | Access to Manager System, but will have not manipulating | Done   | Steven    |


### 2. Manager
![Manager](img/manager.jpg)

#### AdminManager

| Feature       | Description    | Status | Developer |
|---------------|----------------|--------|-----------|
| Add Song      | Add new Songs  | Done   | Julia     |
| Update Song   | Add new Artist | Done   | Julia     |
| Remove Song   | Add new Genre  | Done   | Julia     |
| Show All Song | Add new Genre  | Done   | Julia     |


#### MusicManager

| Feature                | Description                                | Status   | Developer |
|------------------------|--------------------------------------------|----------|-----------|
| Access Admin Interface | Access member user to yourself profile     | Done     | Steven    |
| Validate Song          | Validate song                              | Done     | Melina    |
| Play Song              | Play song                                  | Done     | Melina    |
| Pause Song             | Pause song                                 | Done     | Melina    |
| Resume Song            | Resume song                                | Done     | Melina    |
| Next Song              | Next song                                  | Done     | Melina    |
| Previous Song          | Previous song                              | Done     | Melina    |
| Search Song by Title   | Search by Title and return a Song          | Done     | Melina    |
| Shows Songs By Genre   | Search by Genre and return a list of songs | Done     | Melina    |
| Search By Artist       | Search by Artist and return a Songs        | Done     | Melina    |
| Search By Release      | Search by range date and return Albums     | Done     | Melina    |
| Real Time Search       | Search by different parameters             | to be Do | Steven    |

#### MemberProfileManager

| Feature              | Description                      | Status   | Developer |
|----------------------|----------------------------------|----------|-----------|
| Show Profile         | Show your Profile                | Done     |           |
| Show Top Ten Song    | The top Ten Songs                | Done     |           |
| Show Top three Genre | The Genres most heading for User | to be Do |           |
| Show Top Artist      | The Artist Most heading for User | to be Do |           |
| update nickname      | Updated nickname                 | Done     |           |
| update password      | Updated password                 | Done     |           |
| update email         | Updated email                    | Done     |           | 

### 3. Songs
![Songs](img/songs.jpg)

#### Song

| Feature           | Description                         | Status | Developer |
|-------------------|-------------------------------------|--------|-----------|
| Song Class        | To Make Class Song with composition | Done   |           |

### 4. DATA
![Data](img/data.jpg)

#### Song

| Feature    | Description                 | Status | Developer      |
|------------|-----------------------------|--------|----------------| 
| Data Class | generate instance DataSongs | Done   | Steven & Julia | 


### Documentation
+ [Class Diagram Project Music Recommender System](https://drive.google.com/file/d/1EfPopsuNGfS590GFdUUheVOVDKjg46cd/view?usp=drive_link)
+ [Scrum Planner](https://docs.google.com/spreadsheets/d/1rEBiQTtqf0slariM-Mr7hmkwMj8jV7SxucW3dnAYtes/edit?usp=sharing)
+ [Scrum Report](https://docs.google.com/document/d/1i74uvANGPbzYQX3pflOqah5UxF3w0kFpW3wvfyKNrE0/edit?usp=sharing)
