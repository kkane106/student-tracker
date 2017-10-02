package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Contact;
import com.tracker.app.repo.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactTest {
	@Autowired
	private ContactRepository contactRepo;
	
	@Test
	public void test_contact_mappings() {
		Contact contact = contactRepo.findOne(1);
		assertEquals(1, contact.getId());
		assertEquals("Test", contact.getFname());
		assertEquals("Test", contact.getLname());
		assertEquals("test@test.com", contact.getEmail());
		assertEquals("(555)303-8682", contact.getPhone());
	}
}
