package edu.cnm.deepdive.beer_buddy.model.dao;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import edu.cnm.deepdive.beer_buddy.model.database.BarDatabase;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.mockito.Mockito;

@SmallTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BarDaoTest {

    private static BarDatabase db;
    private static BarDao dao;
    private static long barId;

    @BeforeClass
    public static void setup() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, BarDatabase.class).build();
        dao = db.getBarListingDao();
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

    @Test(expected = Exception.class) // This should pass because we EXPECTED it to fail (Test passed means fail)
    public void insertNullBar() {
        Bar bar = new Bar();
        long id = dao.insert(bar);
        fail("This shouldn't get here!");
    }


    @Test
    public void postInsertFindById() {
        LifecycleOwner owner = Mockito.mock(LifecycleOwner.class);
        dao.findById(barId).observe(owner, (movie) -> {

        });
    }

    @AfterClass
    public static void tearDown() throws Exception {
        db.close();
    }
}
