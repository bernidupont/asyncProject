package fr.bernidupont.asyncProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@MockBean
	PrintThreadId printThreadId;

	@Test
	public void contextLoads() {
	}


	@Test
	public void shouldTestAsynchronousExecution() {

		final Integer NB_EXPECTED_THREAD = 10;
		ArrayList<Long> threadIds = new ArrayList<>();

		for (int i=0; i<NB_EXPECTED_THREAD; i++) {
			Long threadId = printThreadId.runFromAnotherThreadPool();
			if (!threadIds.contains(threadId)) {
				threadIds.add(threadId);
			}
		}
		assertTrue(threadIds.size()==NB_EXPECTED_THREAD);
	}
}
