package guessNumberGame.data;


import guessNumberGame.data.GameDao;
import guessNumberGame.data.RoundDao;
import junit.framework.TestCase;
import guessNumberGame.Service.GameService;
import guessNumberGame.TestApplicationConfiguration;
import guessNumberGame.models.Game;
import guessNumberGame.models.Round;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoundDatabaseDaoTest extends TestCase {
    @Autowired
    RoundDao roundDao;

    @Autowired
    GameDao gameDao;
    public RoundDatabaseDaoTest ()
    {
        
    }
    
    @Before
    public void setUp() {
        List<Round> rounds = roundDao.getAll();
        for(Round round : rounds) {
            roundDao.deleteById(round.getId());
        }

        List<Game> games = gameDao.getAll();
        for(Game game : games) {
            gameDao.deleteById(game.getGameId());
        }
    }

    @Test
    public void testAdd() {
        GameService gameService = new GameService();
        Game game = gameService.newGame();
        gameDao.add(game);

        Round round = new Round();
        round.setGameId(game.getGameId());
        gameService.setTimeStamp(round);
        round.setGuess("1234");
        round.setGuessResult("e:2:p:1");
        roundDao.add(round);
        Round fromDao = roundDao.findById(round.getId());

        assertEquals(round.getId(), fromDao.getId());
    }

    @Test
    public void testGetAll() {
        GameService gameService = new GameService();
        Game game = gameService.newGame();
        gameDao.add(game);

        Game game2 = gameService.newGame();
        gameDao.add(game2);

        Round round = new Round();
        round.setGuess("1111");
        round.setGameId(game.getGameId());

        Round round2 = new Round();
        round2.setGuess("2222");
        round2.setGameId(game2.getGameId());

        roundDao.add(round);
        roundDao.add(round2);

        List<Round> rounds = roundDao.getAll();
        assertEquals(2, rounds.size());
    }

    @Test
    public void testGetAllOfGame() {
         GameService gameService = new GameService();
         Game game1 = gameService.newGame();
         gameDao.add(game1);

         Game game2 = gameService.newGame();
         gameDao.add(game2);

         List<Game> games = gameDao.getAll();
         System.out.println("*** " + games.size());
         System.out.println("*** " + game1.getGameId());

         int targetID = game1.getGameId();
         Round round1 = new Round();
         round1.setGuess("1111");
         round1.setGameId(targetID);

         Round round2 = new Round();
         round2.setGuess("2222");
         round2.setGameId(targetID);

         Round round3 = new Round();
         round3.setGuess("3333");
         round3.setGameId(game2.getGameId());

         roundDao.add(round1);
         roundDao.add(round2);
         roundDao.add(round3);

         List<Round> rounds = roundDao.getAllOfGame(targetID);

         assertEquals(2, rounds.size());
         assertTrue(rounds.contains(round1));
         assertFalse(rounds.contains(round3));
    }

}
