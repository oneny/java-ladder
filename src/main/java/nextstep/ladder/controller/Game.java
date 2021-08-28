package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.ladder.factory.LaddersFactory;
import nextstep.ladder.domain.ladder.line.strategy.HorizontalLinesGenerateRandomStrategy;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = getParticipants(inputView);

        int ladderHeight = inputView.receiveLadderHeight();
        int ladderCount = participants.size() - 1;
        int horizontalLineCount = ladderHeight - 1;

        Ladders ladders = getLadders(ladderHeight, ladderCount, horizontalLineCount);

        outputView.printResult(participants, ladders);
    }

    private Ladders getLadders(int height, int ladderCount, int horizontalLineCount) {
        return LaddersFactory.generateWith(height, ladderCount,
                new HorizontalLinesGenerateRandomStrategy(horizontalLineCount, height));
    }

    private static Participants getParticipants(InputView inputView) {
        List<String> userNames = inputView.receiveUserNames();

        return new Participants(userNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList()));
    }
}
