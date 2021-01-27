package TestData;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class AddCourseTestData {
	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());	
	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public String[] AddCourseData() {
		testData = new String[8];	
		testData[0] = tdImport.getValue(1, 2);
		testData[1] = tdImport.getValue(1, 3);
		testData[2] = tdImport.getValue(1, 4);
		testData[3] = tdImport.getValue(1, 5);
		testData[4] = tdImport.getValue(1, 6);
		testData[5] = tdImport.getValue(1, 7);
		testData[6] = tdImport.getValue(1, 8);
		testData[7] = tdImport.getValue(1, 9);
		return testData;
	}
	
	public String[] LATData() {
		testData = new String[3];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		return testData;
	
	}
	
	public String[] PVOData() {
		testData = new String[11];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = tdImport.getValue(2, 3);
		testData[4] = tdImport.getValue(2, 4);
		testData[5] = tdImport.getValue(2, 5);
		testData[6] = tdImport.getValue(2, 6);
		testData[7] = tdImport.getValue(2, 7);
		testData[8] = tdImport.getValue(2, 8);
		testData[9] = tdImport.getValue(2, 9);
		testData[10] = tdImport.getValue(2, 10);
		
		return testData;
	}
	
	public String[] FAQData() {
		testData = new String[2];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
	
		return testData;
	}
	
	public String[] ATAData() {
		testData = new String[5];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = tdImport.getValue(2, 3);
		testData[4] = tdImport.getValue(2, 4);
		
		return testData;
	}
	
	public String[] AssociatedFilesData() {
		testData = new String[2];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
	
		return testData;
	}
	
	public String[] AwardData() {
		testData = new String[5];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = tdImport.getValue(2, 3);
		testData[4] = tdImport.getValue(2, 4);
		
		return testData;
	}
	public String[] coursesFilterList() {
		testData = new String[3];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		
		
		return testData;
		
	}
	
	public String[] ProcessRequestPageData() {
		testData = new String[10];	
		testData[0] = tdImport.getValue(2, 0);//userName
		testData[1] = tdImport.getValue(2, 1);//First Name
		testData[2] = tdImport.getValue(2, 2);//Last Name
		testData[3] = tdImport.getValue(2, 3);//Email
		testData[4] = tdImport.getValue(2, 4);//Phone
		testData[5] = tdImport.getValue(2, 5);//Account Name
		testData[6] = tdImport.getValue(2, 6);//Property name
		testData[7] = tdImport.getValue(2, 7);//Level
		testData[8] = tdImport.getValue(2, 8);//Focus Track
		testData[9] = tdImport.getValue(2, 9);//Reporting manager
				
		return testData;
	}
}
