package TestData;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import BaseClass.BaseClass;

public class CourseFilterData extends BaseClass{
	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());	
	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	

	
}
