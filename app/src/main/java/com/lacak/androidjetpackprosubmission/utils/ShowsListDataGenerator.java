package com.lacak.androidjetpackprosubmission.utils;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;

import java.util.ArrayList;
import java.util.List;

public class ShowsListDataGenerator {
    public static List<FilmEntity> generateShowsListData(){
        ArrayList<FilmEntity> showsList = new ArrayList<>();

        // 1
        showsList.add(new FilmEntity(
                "Dragon Ball Z",
                "1989",
                "Animation, Sci-Fi & Fantasy, Action & Adventure",
                "26m",
                "82%",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                "https://www.themoviedb.org/tv/12971",
                null
        ));

        // 2
        showsList.add(new FilmEntity(
                "Fairy Tail",
                "2009",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
                "25m",
                "78%",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "https://www.themoviedb.org/tv/46261-fairy-tail",
                null
        ));

        // 3
        showsList.add(new FilmEntity(
                "Family Guy",
                "1999",
                "Animation, Comedy",
                "22m",
                "70%",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://www.themoviedb.org/tv/1434-family-guy",
                null
        ));

        // 4
        showsList.add(new FilmEntity(
                "The Flash",
                "2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "77%",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/tv/60735-the-flash",
                null
        ));

        // 5
        showsList.add(new FilmEntity(
                "Game of Thrones",
                "2011",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "1h",
                "84%",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "https://www.themoviedb.org/tv/1399-game-of-thrones",
                null
        ));

        // 6
        showsList.add(new FilmEntity(
                "Hanna",
                "2019",
                "Action & Adventure, Drama",
                "50m",
                "75%",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "https://www.themoviedb.org/tv/54155-hanna",
                null
        ));

        // 7
        showsList.add(new FilmEntity(
                "Naruto Shipp??den",
                "2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "25m",
                "86%",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "https://www.themoviedb.org/tv/31910-naruto-shipp-den",
                null
        ));

        // 8
        showsList.add(new FilmEntity(
                "Supergirl",
                "2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "42m",
                "73%",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "https://www.themoviedb.org/tv/62688-supergirl",
                null
        ));

        // 9
        showsList.add(new FilmEntity(
                "The Simpsons",
                "1989",
                "Family, Animation, Comedy",
                "22m",
                "78%",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://www.themoviedb.org/tv/456-the-simpsons",
                null
        ));

        // 10
        showsList.add(new FilmEntity(
                "The Walking Dead",
                "2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "42m",
                "81%",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "https://www.themoviedb.org/tv/1402-the-walking-dead",
                null
        ));

        return showsList;
    }
}
