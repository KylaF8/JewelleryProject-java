import Resources.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    LinkedList days = new LinkedList<>();
    LinkedList months = new LinkedList();

    @BeforeEach
    void setUp() {
        months.addNode("January");
        months.addNode("February");
    }

    @AfterEach
    void tearDown() {
        months.deleteAll();
    }

    @Test
    void getHeadTest() {
        assertEquals("January",months.getHead().getData());

    }

    @Test
    void AddNodeTest() {
        assertNull(months.get(2));//in 0 and 1 index
        months.addNode("December");
        assertEquals("December",months.get(2));//now should be in 2
    }

    @Test
    void getTest() {
        assertEquals(months.getHead().getData(),months.get(0));
        assertNull(years.get(0));
        assertEquals("February",months.get(1));
    }

    @Test
    void deleteAllTest() {
        assertEquals(months.getHead().getData(),months.get(0));
        months.deleteAll();
        assertNull(months.get(0));

    }

    @Test
    void listSizeTest() {
        assertEquals(2,months.listSize());
        assertEquals(0,years.listSize());
    }




}
