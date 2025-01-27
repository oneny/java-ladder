package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.utils.LadderUtil.DELIMITER;

public class Users {

  private final List<User> users;

  private Users(List<User> users) {
    this.users = users;
  }

  public static Users createUsers(String inputUsers) {
    return new Users(Arrays.stream(inputUsers.split(DELIMITER))
            .map(User::new)
            .collect(Collectors.toList()));
  }

  public User userByIndex(int index) {
    return users.get(index);
  }

  public List<User> unmodifiableUsers() {
    return Collections.unmodifiableList(users);
  }

  public void userSwap(int prevIndex, int currentIndex) {
    Collections.swap(users, prevIndex, currentIndex);
  }

  public int countOfUser() {
    return users.size();
  }
}
