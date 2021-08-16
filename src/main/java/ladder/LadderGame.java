package ladder;

import ladder.model.Ladder;
import ladder.model.Players;
import ladder.view.InputView;

public class LadderGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.printPlayerNameInputMessage();
        Players players = new Players(inputView.inputPlayerNames());

        inputView.printNewLine();
        inputView.printLadderHeightInputMessage();
        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = new Ladder(players.count(), ladderHeight);
    }
}
