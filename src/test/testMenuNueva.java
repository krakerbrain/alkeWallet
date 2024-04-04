package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import clases.Menu;

class testMenuNueva {

	@Test
	void test() {
		Menu menuMock = mock(Menu.class);
		
			menuMock.menuPpal();
			
	}

}
