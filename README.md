# 사다리 게임

## 스트림, 람다, Optional

### 람다

- [x] MoveStrategy에 대한 익명 클래스로 구현하고 있는 것을 람다를 적용해 구현한다.
- [x] nextstep.fp.Lambda의 sumAll, SumAllEven, sumAllOverThree method를 람다를 활용해 중복을 제거한다.

### 스트림

- [x] List에 담긴 숫자 중 3보다 큰 숫자를 2배한 후 모든 값의 합을 구한다.
  - [x] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
- [x] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
  - [x] 단어의 길이가 12자를 초과하는 단어를 추출한다.
  - [x] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  - [x] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
  - [x] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.

### Optional

- [x] nextstep.optional.User의 ageIsInRange2() 메서드를 구현한다.
  - [x] 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메서드를 구현한다.
  - [x] agesInRange1() 메서드와 같은 기능을 Optional을 활용해 구현한다.
  - [x] nextstep.optional.UserTest의 테스트를 모두 pass해야 한다
- [x] nextstep.optional.Users의 getUser() 메서드를 자바 8의 stream과 Optional을 활용해 구현한다.
  - [x] 자바 8의 stream과 Optional을 사용하도록 리팩토링한다.
  - [x] UsersTest의 단위 테스트를 통과해야 한다.
- [x] nextstep.optional.ExpressionTest의 테스트가 통과되도록 Expressiondml of 메서드를 구현한다.
  - [x] of 메서드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

## 사다리

### 기능 요구사항

- [x] 사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다.
  - [x] 사람 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사다리 높이를 입력받아야 한다.
  - [x] 사다리 높이 하나에는 라인을 통해 전진 또는 후진할 수 있다.
  - [x] 사다리 타기의 라인이 겹쳐지지 않도록 한다.
- [x] 사다리를 출력할 때 사람 이름도 같이 출력한다.
- [x] 사다리 실행 결과를 출력해야 한다.
- [x] 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### 기능 정리

#### User

- 5글자 이하인 name을 가진다.

#### Users

- `,`를 구분자로 사람 이름을 구분한다.
- 유저수를 반환한다.
- 유저목록을 반환한다.
- 위치에 해당하는 유저 반환한다.
- 유저의 위치를 변경한다.

#### Position

- 다음 포지션으로 이동시 현재 포지션에서 +1을 한다.
- 이전 포지션으로 이동시 현재 포지션에서 -1을 한다.
- 현재 포지션 반환한다.

#### Direction

- 첫 포인트에 대한 left는 false인 Direction 객체를 반환한다.
- 마지막 포인트에 대해 이전 포인트의 right 값과 같도록 반환한다.
- 다음 포인트에 대해 이전 프인트의 right가 true이면 다음 포인트의 left는 true, right는 false인 Direction 객체를 반환한다.
  - 만약 이전 포인트의 right가 false이면 left는 false인 Direction 객체를 반환한다.

#### Point

- 첫 포인트에 대해 위치가 0이고, 방향 전환할 수 있는 left는 false인 포인트를 반환한다.
- 다음 포인트부터는 이전 프인트에 대해 의존하여 반환한다.

#### LadderLine

- 사용자의 수 만큼 포인트들이 모인 사다리 라인을 반환한다.

#### LadderHeight

- 사다리의 높이를 반환한다.

#### Ladder

- 사다리의 높이만큼 사다리라인들을 가진 리스트를 반환한다.

#### LadderReward

- 입력한 꽝 또는 금액 반환한다.

#### LadderRewards

- 입력한 꽝 또는 금액 리스트 반환한다.

#### LadderGame

- 사다리게임에 참여하는 유저들의 목록을 반환한다.
- 유저수만큼 사다리 다리를 가진 사다리를 반환한다.
- 사다리 결과에 따른 유저와 유저가 받을 경품들의 목록을 반환한다.

#### LadderResult

- 유저 입력 시 해당 유저에 대한 최종 경품을 반환한다.
- 사다리 타기 게임에 참가한 유저들의 목록을 반환한다.
