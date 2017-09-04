package rexxie.condition;

public class GameConditionFactory {
    public GameCondition getGameCondition(GameConditions gameConditions) {
        switch (gameConditions) {
            case NORMAL:
                return new DefaultGameCondition();
            default:
                return new DefaultGameCondition();
        }
    }
}
