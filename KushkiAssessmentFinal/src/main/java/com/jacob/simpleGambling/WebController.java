package com.jacob.simpleGambling;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jacob.server.BizLogic;

/*
* Class controladora de la pagina existente. 
*
* @author FUTURE KUSHKI ENGINEER
*         Jacob Orellana<br>
*         jacobore@hotmail.com<br>
* 
* @date 18/07/2021
* @version 1.0
*/

@Controller
public class WebController implements WebMvcConfigurer {

	BizLogic bl = new BizLogic();

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	
	/*
	* Metodo para post comun. 
	*
	* @author FUTURE KUSHKI ENGINEER
	*         Jacob Orellana<br>
	*         jacobore@hotmail.com<br>
	* 
	* @date 18/07/2021
	* @version 1.0
	*/
	
	@GetMapping("/")
	public String showForm(Gambler gambler) {
		return "form";
	}
	
	/*
	* Metodo para ejecucipon de biz logic. 
	*
	* @author FUTURE KUSHKI ENGINEER
	*         Jacob Orellana<br>
	*         jacobore@hotmail.com<br>
	* 
	* @date 18/07/2021
	* @version 1.0
	*/

	@RequestMapping(value = "/bizLogic", method = RequestMethod.POST)
	public String quitarCredito(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		bl.serverSideLogic(gambler);

		return "form";
	}

	
	/*
	* Metodo para ejecucipon de una espera para el app. 
	*
	* @author FUTURE KUSHKI ENGINEER
	*         Jacob Orellana<br>
	*         jacobore@hotmail.com<br>
	* 
	* @date 18/07/2021
	* @version 1.0
	*/

	@RequestMapping(value = "/mensajeEspera", method = RequestMethod.GET)
	@ResponseBody
	public String mensajeEspera(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		System.out.println("espere");

		return "";
	}

	
	/*
	* Metodo extraer el graficodel bloque 1. 
	*
	* @author FUTURE KUSHKI ENGINEER
	*         Jacob Orellana<br>
	*         jacobore@hotmail.com<br>
	* 
	* @date 18/07/2021
	* @version 1.0
	*/
	
	@RequestMapping(value = "/uno", method = RequestMethod.GET)
	@ResponseBody
	public String uno(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("uno " + "/img/img" + gambler.getBlock1() + ".jpg");

		return "/img/img" + gambler.getBlock1() + ".jpg";
	}

	/*
	* Metodo extraer el grafico del bloque 2. 
	*
	* @author FUTURE KUSHKI ENGINEER
	*         Jacob Orellana<br>
	*         jacobore@hotmail.com<br>
	* 
	* @date 18/07/2021
	* @version 1.0
	*/
	
	@RequestMapping(value = "/dos", method = RequestMethod.GET)
	@ResponseBody
	public String dos(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("dos " + "/img/img" + gambler.getBlock2() + ".jpg");

		return "/img/img" + gambler.getBlock2() + ".jpg";
	}

	/*
	* Metodo extraer el grafico del bloque 3. 
	*
	* @author FUTURE KUSHKI ENGINEER
	*         Jacob Orellana<br>
	*         jacobore@hotmail.com<br>
	* 
	* @date 18/07/2021
	* @version 1.0
	*/
	
	@RequestMapping(value = "/tres", method = RequestMethod.GET)
	@ResponseBody
	public String tres(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("tres " + "/img/img" + gambler.getBlock3() + ".jpg");

		return "/img/img" + gambler.getBlock3() + ".jpg";
	}

}
