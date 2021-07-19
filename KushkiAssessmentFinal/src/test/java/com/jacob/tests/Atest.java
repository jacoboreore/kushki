package com.jacob.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jacob.server.BizLogic;
import com.jacob.simpleGambling.Gambler;
import com.jacob.simpleGambling.ValidatingFormInputApplication;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ValidatingFormInputApplication.class)
public class Atest {

	@Test
	public void ejmTest() {
		Gambler g = new Gambler();
		g.setCreditos(10);

		BizLogic bl = new BizLogic();
		bl.serverSideLogic(g);

		assertThat(g.getCasoEjecutado()).isEqualTo("random");
	}

}