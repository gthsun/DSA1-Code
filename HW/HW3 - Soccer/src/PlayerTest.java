import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        assertEquals("Steve Lacy", p.getName());
    }

    @Test
    void getPosition() {
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        assertEquals("midfield", p.getPosition());
    }

    @Test
    void getMinutes_played() {
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        assertEquals(100, p.getMinutes_played());
    }

    @Test
    void getGoals() {
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        assertEquals(5, p.getGoals());
    }

    @Test
    void getAssists() {
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        assertEquals(3, p.getAssists());
    }

    @Test
    void getSog_percentage() {
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        assertEquals(66.7, p.getSog_percentage());
    }

    @Test
    void equals(){
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        Player a = new Player();
        assertFalse(p.equals(a));
        a = p;
        assertTrue(p.equals(a));
    }

    @Test
    void getToString(){
        Player p = new Player("Steve Lacy", "midfield", 100, 5, 3, 66.7);
        String expected = "Player: Steve Lacy, Position: midfield, Minutes played: 100, Goals: 5, Assists: 3, and Shots on goal percentage: 66.7%";
        assertNotEquals(expected, p.toString());
        expected = "Name: Steve Lacy, Position: midfield, Minutes Played: 100, Goals: 5, Assists: 3, and Shots on goal percentage: 66.7%";
        assertEquals(expected, p.toString());
    }
}