# Music Recommender System

## Introduction
The application will manage a detailed data model with users, songs, artists, genres, and listening sessions. 
Additionally, data science techniques will be applied to analyze patterns in user preferences and audio data, offering a robust recommendation engine.

### Features

### 1. Authentication
![Auth](img/auth.jpg)

#### Auth

| Feature           | Description                      | Status |
|-------------------|----------------------------------|--------|
| Register          | Method void register (User user) | Done   |
| Login             | Method User login                | Done   |
| Generate Nickname | Generate random nickname         | Done   |

#### User

| Feature       | Description                                              | Status |
|---------------|----------------------------------------------------------|--------|
| Guest_User    | Guest user access to Manager System                      | Done   |
| Admin_User    | Admin user access to Administrator Manager System        | Done   |
| Member_User   | Access to Manager System, but will have not manipulating | Done   |


### 2. Manager
![Manager](img/manager.jpg)

#### AdminManager

| Feature       | Description    | Status |
|---------------|----------------|--------|
| Add Song      | Add new Songs  | Done   |
| Update Song   | Add new Artist | Done   |
| Remove Song   | Add new Genre  | Done   |
| Show All Song | Add new Genre  | Done   |


#### MusicManager

| Feature                | Description                                | Status   |
|------------------------|--------------------------------------------|----------|
| Access Admin Interface | Access member user to yourself profile     | to be Do |
| Validate Song          | Validate song                              | Done     |
| Play Song              | Play song                                  | Done     |
| Pause Song             | Pause song                                 | Done     |
| Resume Song            | Resume song                                | Done     |
| Next Song              | Next song                                  | Done     |
| Previous Song          | Previous song                              | Done     |
| Search Song by Title   | Search by Title and return a Song          | Done     |
| Shows Songs By Genre   | Search by Genre and return a list of songs | Done     |
| Search By Artist       | Search by Artist and return a Songs        | Done     |
| Search By Release      | Search by range date and return an Album   | Done     |
| Real Time Search       | Search by different parameters             | to be Do |

#### MemberProfileManager

| Feature              | Description                      | Status   |
|----------------------|----------------------------------|----------|
| Show Profile         | Show your Profile                | Done     |
| Show Top Ten Song    | The top Ten Songs                | Done     |
| Show Top three Genre | The Genres most heading for User | to be Do |
| Show Top Artist      | The Artist Most heading for User | to be Do |
| update nickname      | Updated nickname                 | Done     |
| update password      | Updated password                 | Done     |
| update email         | Updated email                    | Done     |

### 3. Songs
![Songs](img/songs.jpg)

#### Song

| Feature           | Description                         | Status |
|-------------------|-------------------------------------|--------|
| Song Class        | To Make Class Song with composition | Done   |

### 4. DATA
![Data](img/data.jpg)

#### Song

| Feature    | Description                 | Status |
|------------|-----------------------------|--------|
| Data Class | generate instance DataSongs | Done   |
