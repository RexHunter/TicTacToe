package rexxie.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rexxie.entities.CellContent;
import rexxie.entities.Player;
import rexxie.input.GameInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImpTest {
    @Mock
    private GameInput<String> stringGameInput;
    @Mock
    private GameInput<Integer> integerGameInput;

    private PlayerService playerService;

    @Before
    public void setUp() throws Exception {
        playerService = new PlayerServiceImp(stringGameInput, integerGameInput);
    }

    @Test
    public void getPlayerWhenPlayerBuiltCorrectly() throws Exception {
        Player expectedPlayer = Player.createBuilder()
                .setName("Player")
                .setCellContent(CellContent.CROSS)
                .build();
        when(stringGameInput.getInput()).thenReturn(expectedPlayer.getName());
        when(integerGameInput.getInput()).thenReturn(1);
        Player actualUser = playerService.getPlayer();
        assertThat(expectedPlayer, is(actualUser));
    }

    @Test(expected = InvalidValueEnteredTooManyTimesException.class)
    public void getPlayerWhenIncorrectValueWasEnteredTooManyTimes() throws Exception {
        Player expectedPlayer = Player.createBuilder()
                .setName("Player")
                .setCellContent(CellContent.CROSS)
                .build();
        when(stringGameInput.getInput()).thenReturn(expectedPlayer.getName());
        when(integerGameInput.getInput()).thenThrow(new NumberFormatException());
        playerService.getPlayer();
    }

    @Test
    public void getPlayerWithOppositeCellContent() throws Exception {
        Player expectedPlayer = Player.createBuilder()
                .setName("Player")
                .setCellContent(CellContent.CROSS)
                .build();
        when(stringGameInput.getInput()).thenReturn(expectedPlayer.getName());
        Player actualUser = playerService.getPlayerWithOppositeCellContent(CellContent.NOUGHT);
        assertThat(expectedPlayer, is(actualUser));
    }

}