package controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.SpringCassandraRepositoryApplicationTests;
import com.infotech.controller.BookController;
import com.infotech.entity.Book;
import com.infotech.service.BookService;
import com.infotech.service.BookServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class, secure = false)
@WebAppConfiguration
@ContextConfiguration(classes = SpringCassandraRepositoryApplicationTests.class )
public class BookControllerTest {
      
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	Set<String> list=new HashSet<String>();
	Book mockBook =new Book(1,"Study","GeetaPublish",list);
	
	/*String bookJson="{\n" + 
			"        \"id\": 1,\n" + 
			"        \"title\": \"Study\",\n" + 
			"        \"publisher\": \"GeetaPublish\",\n" + 
			"        \"tags\": null\n" + 
			"    }";*/
	
	@Test
	public void retriveBook() throws Exception {
		Mockito.when(
				(bookService.findOne(Mockito.anyInt()))).thenReturn(mockBook);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/book/1").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("**********"+result.getResponse());
		String expected = "{id:1,title:Study,publisher:GeetaPublish,tags:null}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testFindOne() throws Exception
	{
		Set<String> list=new HashSet<String>(); 
		Book mockBook =new Book(1,"Study","GeetaPublish",list);
		/*Book b = new Book();
		b.setId(1);
		b.setTitle("QAInfotech");
		b.setPublisher("Mayank");
		b.setTags(list);*/
		when(bookService.findOne(1)).thenReturn(mockBook);
		mockMvc.perform(get("/book/1")
		.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].id", is(1)))
		.andExpect(jsonPath("$[0].title", is("QAInfotech")))
		.andExpect(jsonPath("$[0].publisher", is("Mayank")));
		//.andExpect(jsonPath("$[0].tags", isEmpty()));
	}
	
}
