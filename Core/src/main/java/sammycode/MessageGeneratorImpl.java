package sammycode;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageGeneratorImpl  implements MassageGenerator{

//    ===  constant ===
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

//    ====  field ====
    @Autowired
    private Game game;
    private int guessCount = 10;

//    ===   init ===
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

//    ===  public methods ===
    @Override
    public String getMainMessage() {
       return "Number is between " +
               game.getSmallest() +
               " and" +
               game.getBiggest() +
               ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return "You guessed it ! The number was " + game.getNumber();
        } else if (game.isGameLose()) {
            return "You lost. The number was" + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if (game.getRemainingGuesses() == guessCount) {
            return "What is your first guess ?";
        } else {
            String direction = "Lower";

            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + "guess left";
        }
    }
}
