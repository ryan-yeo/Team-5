import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList = new ArrayList<Camcorder>();
		chromebookList = new ArrayList<Chromebook>();
	}

	@Test
	public void addCamcorderTest() {
	    
		// Item list is not null, so that can add a new item
	    assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

	    // Given an empty list, after adding 1 item, the size of the list is 1
	    ResourceCentre.addCamcorder(camcorderList, cc1);
	    assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

	    // The item just added is as same as the first item of the list
	    assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));

	    // Add another item. test The size of the list is 2?
	    ResourceCentre.addCamcorder(camcorderList, cc2);
	    assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	    } 
	
	@Test
	public void addChromebookTest() {


	     // NICOLE
	     // fail("Not yet implemented"); 
	     // Item list is not null, so that can add a new item
	     assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

	     // Given an empty list, after adding 1 item, the size of the list is 1
	     ResourceCentre.addChromebook(chromebookList, cb1);
	     assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

	     // The item just added is as same as the first item of the list
	     assertSame("Test that Chromeboook is added same as 1st item of the list?", cb1, chromebookList.get(0));

	     // Add another item. test The size of the list is 2?
	     ResourceCentre.addChromebook(chromebookList, cb2);
	     assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	    }


	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		//test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// test if the expected output string same as the list of camcorders retrieved
		// from the SourceCentre
		allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

	}

	@Test
	public void retrieveAllChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		
		// test if Item list is not null but empty, so that can add a new item
			assertNotNull("Test if there is valid Chromebook arrarylist to add to", chromebookList);
			
		// test if list of Chromebook retrived from the SourceCentre is empty
			String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
			String testOutput = "";
			assertEquals("Check that ViewAllCamcorderlist", testOutput, allChromebook);
			
		// given an empty list, after adding 2 items, test if the size of the list is 2
			ResourceCentre.addChromebook(chromebookList, cb1);
			ResourceCentre.addChromebook(chromebookList, cb2);
			assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
			
		// test if expected output string same as the list Chromebooks retrieved from the SourceCenter
			allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
			testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
			testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
			assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {
		// fail("Not yet implemented");
		// write your code here

		// Item list is not null, so that can loan an item
		assertNotNull("Test if there is valid Camcorder arraylist to loan", camcorderList);
	
		//After the CC001 in camcorderList is loaned with a due date of 10, the due date changed
		ResourceCentre.addCamcorder(camcorderList, cc1);
		boolean op01 = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "21-7-2020");
		assertEquals(true, op01);
		
		boolean op02 = ResourceCentre.doLoanCamcorder(camcorderList, "CC0011", "29-7-2020");
		assertEquals(false, op02);
		
	}

	@Test
	public void doLoanChromebookTest() {
		// fail("Not yet implemented");
		// write your code here

		// Item list is not null, so that can loan an item
		
		assertNotNull("Test if there is valid Chromebook arraylist to loan", chromebookList);
		
		//After the CC001 in camcorderList is loaned with a due date of 10, the due date changed
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		boolean op01 = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "21-7-2020");
		assertEquals(true, op01);
						
		boolean op02 = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "29-7-2020");
		assertEquals(false, op02);

	}

	@Test
	public void doReturnCamcorderTest() {
		// fail("Not yet implemented");
		// write your code here

		assertNotNull("Test if there is a valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);

		// Test if item is available so that it cannot be returned
		Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Test if available camcorder CC001 is unable to return", isReturned);

		// Test if item is unavailable so that it can be returned
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		assertTrue("Test if unavailable camcorder C002 is returned", isReturned);

		// Test if non-existed item is unable to return
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
		assertFalse("Test if non-exisiting item camcorder is returned", isReturned);

	}

	@Test
	public void doReturnChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is a valid Chromebook arraylist to add to", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);

		// Test if item is available so that it cannot be returned
		Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CC0011");
		assertFalse("Test if available chromebook CC001 is unable to return", isReturned);

		
		// Test if item is unavailable so that it can be returneds
		ResourceCentre.addChromebook(chromebookList, cb2);
		cb2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CC0012");
		assertTrue("Test if unavailable chromebook C002 is returned", isReturned);

		// Test if non-existed item is unable to return
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CC0013");
		assertFalse("Test if non-exisiting item chromebook is returned", isReturned);

	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
