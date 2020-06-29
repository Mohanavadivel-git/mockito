package com.example.mockito;

import com.example.mockito.controller.helloworldController;
import com.example.mockito.repository.HelloworldRepository;
import com.example.mockito.service.HelloworldService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MockitoApplicationTests {

	@Mock
	helloworldController helloworldController;

	@MockBean
	HelloworldRepository helloworldRepository;

	@MockBean
	HelloworldService helloworldService;

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

}
