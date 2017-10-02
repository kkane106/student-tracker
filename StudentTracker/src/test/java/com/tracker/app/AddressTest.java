package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Address;
import com.tracker.app.repo.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {
		
	@Autowired
	private AddressRepository addressRepo;
	
	@Test
	public void test_address_mappings() {
		Address address = addressRepo.findOne(1);
		assertEquals("Testville", address.getCity());
		assertEquals("United States", address.getCountry());
		assertEquals(1, address.getId());
		assertEquals("80220", address.getPostalCode());
		assertEquals("Colorado", address.getState());
		assertEquals("123 Test Street", address.getStreet());
		assertEquals("Apt. 21", address.getStreet2());

	}
	
}
