package com.narayana.FileUpload;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FileUploadApplication.class)
@WebAppConfiguration
public class FileUploadTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testFileMetadata() throws Exception {
		mockMvc.perform(get("/api/file/1")).andExpect(status().isOk());
	}
	
	@Test
	public void testAllFileMetadata() throws Exception {
		mockMvc.perform(get("/api/file/all")).andExpect(status().isOk());
	}
	 
	@Test
	public void should_upload_image_to_upload_path() throws Exception {
	MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
	mockMvc.perform(fileUpload("/api/upload").file(file))
	.andExpect(status().isOk());
	}

}
