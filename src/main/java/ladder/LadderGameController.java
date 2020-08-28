package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    public static void main(String[] args) {
        String names = InputView.scanParticipantNames();
        Participants participants = Participants.from(names);

        LadderResult ladderResult = LadderResult.of(participants, InputView.scanLadderResult());

        int ladderHeight = InputView.scanLadderHeight();
        Ladder ladder = Ladder.of(ladderHeight, participants, new LineRandomGenerator());
        OutputView.printLadder(participants, ladder, ladderResult);

        LadderGameResult ladderGameResult = participants.calculateResult(ladder, ladderResult);
        for (int i = 0; i < 3; i++) {
            String wishParticipantName = InputView.scanWishParticipantName();
            OutputView.printLadderResult(ladderGameResult, wishParticipantName);
        }
    }
}
