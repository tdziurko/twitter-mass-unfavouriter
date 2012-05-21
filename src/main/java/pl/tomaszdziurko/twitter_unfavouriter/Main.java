package pl.tomaszdziurko.twitter_unfavouriter;

import twitter4j.*;

public class Main {

    public static void main(String[] args) throws TwitterException, InterruptedException {


        Twitter twitter = new TwitterFactory().getInstance();

        ResponseList<Status> favorites = twitter.getFavorites();

        while(favorites.size() > 0) {

            System.out.println("First favourite = " + favorites.get(0).getText());

            for (Status favorite : favorites) {
                twitter.destroyFavorite(favorite.getId());
                Thread.sleep(1000*1);
            }

            Thread.sleep(1000*10);

            favorites = twitter.getFavorites();
        }
    }
}
