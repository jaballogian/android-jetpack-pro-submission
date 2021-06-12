package com.lacak.androidjetpackprosubmission.utils;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.data.source.remote.response.FilmResponse;

import java.util.ArrayList;
import java.util.List;

public class MoviesListDataGenerator {
    public static List<FilmEntity> generateMoviesListData() {
        ArrayList<FilmEntity> moviesList = new ArrayList<>();

        // 1
        moviesList.add(new FilmEntity(
                "Ralph Breaks the Internet",
                "2018",
                "Family, Animation, Comedy, Adventure",
                "1h 52m",
                "72%",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "https://www.themoviedb.org/movie/404368-ralph-breaks-the-internet",
                "@drawable/moives_poster_ralph"
        ));

        // 2
        moviesList.add(new FilmEntity(
                "Alita: Battle Angel",
                "2019",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "72%",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/movie/399579-alita-battle-angel",
                "@drawable/movies_poster_alita"
        ));

        // 3
        moviesList.add(new FilmEntity(
                "Aquaman",
                "2018",
                "Action, Adventure, Fantasy",
                "2h 23m",
                "69%",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/movie/297802-aquaman",
                "@drawable/movies_poster_aquaman"
        ));

        // 4
        moviesList.add(new FilmEntity(
                "Bohemian Rhapsody",
                "2018",
                "Music, Drama, History",
                "2h 15m",
                "80%",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody",
                "@drawable/movies_poster_bohemian"
        ));

        // 5
        moviesList.add(new FilmEntity(
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "69%",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "https://www.themoviedb.org/movie/338952-fantastic-beasts-the-crimes-of-grindelwald",
                "@drawable/movies_poster_crimes"
        ));

        // 6
        moviesList.add(new FilmEntity(
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "Animation, Family, Adventure",
                "1h 44m",
                "78%",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://www.themoviedb.org/movie/166428-how-to-train-your-dragon-3",
                "@drawable/movies_poster_how_to_train"
        ));

        // 7
        moviesList.add(new FilmEntity(
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "83%",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://www.themoviedb.org/movie/299536-avengers-infinity-war",
                "@drawable/movies_poster_infinity_war"
        ));

        // 8
        moviesList.add(new FilmEntity(
                "Robin Hood",
                "2018",
                "Adventure, Action, Thriller",
                "1h 56m",
                "59%",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "https://www.themoviedb.org/movie/375588-robin-hood-origins",
                "@drawable/movies_poster_robin_hood"
        ));

        // 9
        moviesList.add(new FilmEntity(
                "Spider-Man: Into the Spider-Verse",
                "2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "84%",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "https://www.themoviedb.org/movie/324857-spider-man-into-the-spider-verse",
                "@drawable/movies_poster_spiderman"
        ));

        // 10
        moviesList.add(new FilmEntity(
                "T-34",
                "2018",
                "War, Action, Drama, History",
                "2h 19m",
                "69%",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "https://www.themoviedb.org/movie/505954-34",
                "@drawable/movies_poster_t34"
        ));

        return moviesList;
    }

    public static List<FilmResponse> generateRemoteDummyMoviesListData(){
        ArrayList<FilmResponse> moviesList = new ArrayList<>();

        // 1
        moviesList.add(new FilmResponse(
                "Ralph Breaks the Internet",
                "2018",
                "Family, Animation, Comedy, Adventure",
                "1h 52m",
                "72%",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "https://www.themoviedb.org/movie/404368-ralph-breaks-the-internet",
                "@drawable/moives_poster_ralph"
        ));

        // 2
        moviesList.add(new FilmResponse(
                "Alita: Battle Angel",
                "2019",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "72%",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "https://www.themoviedb.org/movie/399579-alita-battle-angel",
                "@drawable/movies_poster_alita"
        ));

        // 3
        moviesList.add(new FilmResponse(
                "Aquaman",
                "2018",
                "Action, Adventure, Fantasy",
                "2h 23m",
                "69%",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/movie/297802-aquaman",
                "@drawable/movies_poster_aquaman"
        ));

        // 4
        moviesList.add(new FilmResponse(
                "Bohemian Rhapsody",
                "2018",
                "Music, Drama, History",
                "2h 15m",
                "80%",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/movie/424694-bohemian-rhapsody",
                "@drawable/movies_poster_bohemian"
        ));

        // 5
        moviesList.add(new FilmResponse(
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "69%",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "https://www.themoviedb.org/movie/338952-fantastic-beasts-the-crimes-of-grindelwald",
                "@drawable/movies_poster_crimes"
        ));

        // 6
        moviesList.add(new FilmResponse(
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "Animation, Family, Adventure",
                "1h 44m",
                "78%",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "https://www.themoviedb.org/movie/166428-how-to-train-your-dragon-3",
                "@drawable/movies_poster_how_to_train"
        ));

        // 7
        moviesList.add(new FilmResponse(
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "83%",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "https://www.themoviedb.org/movie/299536-avengers-infinity-war",
                "@drawable/movies_poster_infinity_war"
        ));

        // 8
        moviesList.add(new FilmResponse(
                "Robin Hood",
                "2018",
                "Adventure, Action, Thriller",
                "1h 56m",
                "59%",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "https://www.themoviedb.org/movie/375588-robin-hood-origins",
                "@drawable/movies_poster_robin_hood"
        ));

        // 9
        moviesList.add(new FilmResponse(
                "Spider-Man: Into the Spider-Verse",
                "2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "84%",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "https://www.themoviedb.org/movie/324857-spider-man-into-the-spider-verse",
                "@drawable/movies_poster_spiderman"
        ));

        // 10
        moviesList.add(new FilmResponse(
                "T-34",
                "2018",
                "War, Action, Drama, History",
                "2h 19m",
                "69%",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "https://www.themoviedb.org/movie/505954-34",
                "@drawable/movies_poster_t34"
        ));

        return moviesList;
    }
}
