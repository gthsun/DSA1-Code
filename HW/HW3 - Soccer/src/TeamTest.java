import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Player a = new Player();
    Player b = new Player("Bob", "defense", 50, 12, 4, 50.0);
    Player c = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
    Player[] players = {a, b, c};
    Team t = new Team(players);

    @Test
    void getTeam() {
        assertNotEquals(players, t.getTeam());
    }

    @Test
    void setTeam() {
        t.setTeam(players);
        assertNotEquals(players, t.getTeam());
    }

    @Test
    void testToString() {
    }

    @Test
    void SOGAverage() {
    }

    @Test
    void positionCount() {
    }

    @Test
    void sort() {
    }

    @Test
    void onTeam() {
    }

    @Test
    void mostGoals() {
    }
}