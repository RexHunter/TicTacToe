package rexxie.services;

import rexxie.entities.CellContent;
import rexxie.entities.Player;

public interface PlayerService {
    Player getPlayer() throws InvalidValueEnteredTooManyTimesException;
    Player getPlayerWithOppositeCellContent(CellContent selectedValue);
}
