package edu.cnm.deepdive.beer_buddy.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import edu.cnm.deepdive.beer_buddy.model.database.BarDatabase;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.util.LiveDataTestUtil;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;


@SmallTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BarDaoTest {

    private static BarDatabase db;
    private static BarDao dao;
    private static long barId;
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @BeforeClass
    public static void setup() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, BarDatabase.class)
                .allowMainThreadQueries()
                .build();
        dao = db.getBarListingDao();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        db.close();
    }

    @Test
    public void insert() {
        Bar bar = new Bar();
        bar.setLocation("Albuquerque");
        bar.setName("Marble");
        bar.setType("Brewery");
        bar.setBarId(1234);
        barId = dao.insert(bar);
        assertTrue(barId > 0);
    }

    @Test(expected = SQLiteConstraintException.class)
    // This should pass because we EXPECTED it to fail (Test passed means fail)
    public void insertNullBar() {
        Bar bar = new Bar();
        long id = dao.insert(bar);
        fail("This shouldn't get here!");
    }

    @Test
    public void postInsertFindById() throws InterruptedException {
        Bar bar = LiveDataTestUtil.getValue(dao.findById(barId));
        assertNotNull(bar);
        assertEquals("Marble", bar.getName());
    }
}