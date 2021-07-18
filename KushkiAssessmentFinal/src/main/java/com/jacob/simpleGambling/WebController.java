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

@Controller
public class WebController implements WebMvcConfigurer {

	BizLogic bl = new BizLogic();

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(Gambler gambler) {
		return "form";
	}

	@RequestMapping(value = "/bizLogic", method = RequestMethod.POST)
	public String quitarCredito(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		bl.serverSideLogic(gambler);

		return "form";
	}

	@RequestMapping(value = "/mensajeEspera", method = RequestMethod.GET)
	@ResponseBody
	public String mensajeEspera(@Valid Gambler gambler, @RequestParam(value = "action", required = false) String action,
			BindingResult bindingResult) {

		System.out.println("espere");

		return "";
	}

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
