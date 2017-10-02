package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Image;
import com.tracker.app.repo.ImageRepositoy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageTest {

	@Autowired
	private ImageRepositoy imageRepo;
	
	@Test
	public void test_employee_mappings() {
		Image image = imageRepo.findOne(1);
		assertEquals(1, image.getId());
		assertEquals("https://upload.wikimedia.org/wikipedia/commons/7/7c/Profile_avatar_placeholder_large.png", image.getUrl());
		assertEquals("Default User Image", image.getTitle());

	}
}
