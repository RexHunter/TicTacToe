package rexxie.sessions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import rexxie.entities.CellContent;
import rexxie.entities.Player;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayersSessionTest {
    private PlayersSession playersSession = new PlayersSession();

    @Test
    public void addPlayerWhenPlayerIsSuccessfullyAddedToPlayersList() throws Exception {
        Player mockPlayer = Player.createBuilder()
                .setName("Mock players#1")
                .build();
        playersSession.addPlayer(mockPlayer);
        assertThat(playersSession.getPlayers(), hasItems(mockPlayer));
    }

    @Test
    public void nextPlayerWhenPlayersAreSuccessfullyChanging() throws Exception {
        Player mockPlayer1 = Player.createBuilder()
                .setName("Mock player#1")
                .setCellContent(CellContent.CROSS)
                .build();
        Player mockPlayer2 = Player.createBuilder()
                .setName("Mock player#1")
                .setCellContent(CellContent.NOUGHT)
                .build();
        playersSession.addPlayer(mockPlayer1);
        playersSession.addPlayer(mockPlayer2);
        assertThat(mockPlayer1, is(playersSession.nextPlayer()));
        assertThat(mockPlayer2, is(playersSession.nextPlayer()));
    }

    @Test
    public void restartSessionWithSuccessfullyRestarting() throws Exception {
        Player mockPlayer1 = Player.createBuilder()
                .setName("Mock player#1")
                .setCellContent(CellContent.CROSS)
                .build();
        Player mockPlayer2 = Player.createBuilder()
                .setName("Mock player#1")
                .setCellContent(CellContent.NOUGHT)
                .build();
        playersSession.addPlayer(mockPlayer1);
        playersSession.addPlayer(mockPlayer2);
        playersSession.nextPlayer();
        playersSession.restart();
        assertThat(mockPlayer1, is(playersSession.nextPlayer()));
    }

}