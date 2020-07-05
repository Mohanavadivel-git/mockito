package com.example.mockito;

import com.example.mockito.controller.helloworldController;
import com.example.mockito.repository.HelloworldRepository;
import com.example.mockito.service.HelloworldService;
import org.mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MockitoApplicationTests {

	@Mock
	helloworldController helloworldController;

	@MockBean
	HelloworldRepository helloworldRepository;

	@MockBean
	HelloworldService helloworldService;

	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Mock
	List mockspiedList = new ArrayList<String>();

	@Captor
	ArgumentCaptor argumentCaptor;

	@Mock
	Map<String, String> wordMap;

	@InjectMocks
	MyDictionary myDictionary = new MyDictionary();


	@Test
	public void endpointReturnsHelloWorld(){
		Mockito.when(helloworldController.helloworld()).thenReturn("helloworldmock");
		assertEquals("helloworldmock",helloworldController.helloworld());
	}

	@Test
	public void repoLayerReturnsHelloWorld(){
		Mockito.when(helloworldRepository.retrieve()).thenReturn("helloworld");
		assertEquals("helloworld",helloworldRepository.retrieve());
		Mockito.verify(helloworldRepository).retrieve();
	}

	@Test
	public void serviceLayerRetrunsValueFromRepoLayer(){
		Mockito.when(helloworldService.helloworld()).thenReturn("helloworld");
		assertEquals("helloworld",helloworldService.helloworld());
		Mockito.verify(helloworldService).helloworld();
	}

	@Test
	public void spytest(){
		boolean isEmpty ;
		isEmpty = spiedList.isEmpty();

		spiedList.add("one");
		spiedList.add("two");

		Mockito.verify(spiedList).isEmpty();
		assertEquals(true, isEmpty);

		Mockito.verify(spiedList).add("one");
		Mockito.verify(spiedList).add("two");
		assertEquals(2, spiedList.size());

		Mockito.doReturn(100).when(spiedList).size();
		assertEquals(100, spiedList.size());
	}

	@Test
	public void captorTest(){
		mockspiedList.add("one");
		Mockito.verify(mockspiedList).add(argumentCaptor.capture());
		assertEquals("one", argumentCaptor.getValue());
	}

	@Test
	public void injectMocksTest(){
		Mockito.when(myDictionary.getMeaning("word")).thenReturn("meaning");
		assertEquals("meaning",myDictionary.getMeaning("word"));
	}
}
