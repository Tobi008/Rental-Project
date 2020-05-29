package edu.depaul.RentalTests;

import junit.framework.TestCase;
import edu.depaul.shop.command.Command;
import edu.depaul.shop.data.Data;
import edu.depaul.shop.data.Inventory;
import edu.depaul.shop.data.Record;
import edu.depaul.shop.data.Video;

// TODO:
// write an integration test that tests the data classes.
// add in some videos, check out, check in, delete videos, etc.
// check that errors are reported when necessary.
// check that things are going as expected.
public class TEST1 extends TestCase {
  private Inventory _inventory = Data.newInventory();
  public TEST1(String name) {
    super(name);
  }
  private void check(Video v, int numOwned, int numOut, int numRentals) {
    Record r = _inventory.get(v);
    assertEquals(numOwned, r.numOwned());
    assertEquals(numOut, r.numOut());
    assertEquals(numRentals, r.numRentals());
  }
    
  public void test1() {
    Command clearCmd = Data.newClearCmd(_inventory);
    clearCmd.run();
    
    Video v1 = Data.newVideo("Title1", 2000, "Director1");
    assertEquals(0, _inventory.size());
    assertTrue(Data.newAddCmd(_inventory, v1, 5).run());
    assertEquals(1, _inventory.size());
    assertTrue(Data.newAddCmd(_inventory, v1, 5).run());
    assertEquals(1, _inventory.size());
    check(v1,10,0,0);
    
    // TODO  
    //New Video
    Video v2 = Data.newVideo("Title2", 2010, "DIRECTOR2");
	assertEquals(1, _inventory.size());
	assertTrue(Data.newAddCmd(_inventory, v2, 100).run());
	assertEquals(2, _inventory.size());
	assertTrue(Data.newAddCmd(_inventory, v2, 1).run());
	assertEquals(2, _inventory.size());
	
			// Adding null
			assertFalse(Data.newAddCmd(_inventory, null, 100).run());
			assertEquals(2, _inventory.size());

			// Checking out
			assertTrue(Data.newOutCmd(_inventory, v2).run());
			//expect(v2, "Title2 (2010) : DIRECTOR2 [101,1,1]");

			// Checking in
			assertTrue(Data.newInCmd(_inventory, v2).run());
			//expect(v2, "Title2 (2010) : DIRECTOR2 [101,0,1]");

			assertEquals(2, _inventory.size());

			// Removing video with negative change, overall 0 entries
			assertTrue(Data.newAddCmd(_inventory, v2, -101).run());
			assertEquals(1, _inventory.size());
  }
}
