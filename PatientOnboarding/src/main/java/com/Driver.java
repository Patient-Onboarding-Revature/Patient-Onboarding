package com;

import com.dao.EthnicityDao;
import com.dao.MaritalStatusDao;
import com.dao.RaceDao;
import com.dao.SalutationDao;
import com.dao.SexDao;
import com.dao.SuffixDao;
import com.model.Ethnicity;
import com.model.MaritalStatus;
import com.model.Race;
import com.model.Salutation;
import com.model.Sex;
import com.model.Suffix;

public class Driver {

	public static void main(String[] args) {
		
		insertInitialValues();
		
	}

	private static void insertInitialValues() {
		
		Ethnicity e1 = new Ethnicity("Hispanic or Latino or Spanish Origin");
		Ethnicity e2 = new Ethnicity("Not Hispanic or Latino or Spanish Origin");
		
		EthnicityDao.insert(e1);
		EthnicityDao.insert(e2);
		
		Race r1 = new Race("American Indian or Alaska Native");
		Race r2 = new Race("Asian");
		Race r3 = new Race("Black or African American");
		Race r4 = new Race("Native Hawaiian or Other Pacific Islander");
		Race r5 = new Race("White");
		
		RaceDao.insert(r1);
		RaceDao.insert(r2);
		RaceDao.insert(r3);
		RaceDao.insert(r4);
		RaceDao.insert(r5);
		
		MaritalStatus m1 = new MaritalStatus("Married");
		MaritalStatus m2 = new MaritalStatus("Widowed");
		MaritalStatus m3 = new MaritalStatus("Divorced");
		MaritalStatus m4 = new MaritalStatus("Separated");
		MaritalStatus m5 = new MaritalStatus("Never Married");
		
		MaritalStatusDao.insert(m1);
		MaritalStatusDao.insert(m2);
		MaritalStatusDao.insert(m3);
		MaritalStatusDao.insert(m4);
		MaritalStatusDao.insert(m5);
		
		Sex s1 = new Sex("Female");
		Sex s2 = new Sex("Male");
		Sex s3 = new Sex("Other");
		
		SexDao.insert(s1);
		SexDao.insert(s2);
		SexDao.insert(s3);
		
		Salutation l1 = new Salutation("Mr.");
		Salutation l2 = new Salutation("Mrs.");
		Salutation l3 = new Salutation("Miss.");
		Salutation l4 = new Salutation("Ms.");
		Salutation l5 = new Salutation("Dr.");
		
		SalutationDao.insert(l1);
		SalutationDao.insert(l2);
		SalutationDao.insert(l3);
		SalutationDao.insert(l4);
		SalutationDao.insert(l5);
		
		Suffix f1 = new Suffix("Sr.");
		Suffix f2 = new Suffix("Jr.");
		
		SuffixDao.insert(f1);
		SuffixDao.insert(f2);
		
	}
	
}
