package com.project.segunfrancis.jokeslibrary;

import java.util.Random;

public class JokesSource {
    private static String[] jokes = {
            "Q: What did the spider do on the computer? A: Made a website!",
            "Q: What did the computer do at lunchtime? A: Had a byte!",
            "Q: What does a baby computer call his father? A: Data!",
            "Q: Why did the computer keep sneezing? A: It had a virus!",
            "Q: What is a computer virus? A: A terminal illness!",
            "Q: Why was the computer cold? A: It left it's Windows open!",
            "Mom: Your great-aunt just passed away. LOL. Son: Why is that funny? Mom: It’s not funny, David! What do you mean? Son: Mom, LOL means Laughing Out Loud. Mom: I thought it meant Lots of Love. I have to call everyone back.",
            "Mom: What do IDK, LY & TTYL mean? Son: I don’t know, love you, talk to you later. Mom: OK, I will ask your sister.",
            "Q: Why was there a bug in the computer? A: Because it was looking for a byte to eat?",
            "Q: Why did the computer squeak? A: Because someone stepped on it's mouse!",
            "Q: What do you get when you cross a computer and a life guard? A: A screensaver!",
            "Q: Where do all the cool mice live? A: In their mousepads",
            "Q: What do you get when you cross a computer with an elephant? A: Lots of memory!"
    };

    public static String getJoke() {
        int randomNumber = new Random().nextInt(jokes.length - 1);
        return jokes[randomNumber];
    }
}
