package com.jacob.server;

import com.jacob.simpleGambling.Gambler;

public class BizLogic {

	public void serverSideLogic(Gambler g) {

		/*
		 * Cuando un usuario tiene menos de 40 créditos en la sesión de juego, sus
		 * tiradas son realmente aleatorias. ○ Si un usuario tiene entre 40 y 60
		 * créditos, entonces el servidor empieza a hacer un poco de trampa: ■ Por cada
		 * tirada ganadora, antes de comunicarla al cliente, el servidor hace una tirada
		 * de 30% de probabilidad que decide si el servidor volverá a tirar en esa
		 * ronda. ■ Si eso es verdadero, el servidor vuelve a tirar y comunica el nuevo
		 * resultado. ○ Si el usuario tiene más de 60 créditos, el servidor actúa igual,
		 * pero en este caso la probabilidad de repetir la ronda aumenta al 60%.
		 */

		if (g.getCreditos() == 0) {
			System.out.println("BIZ: no tiene creditos");
			return;
		}

		if (g.getCreditos() < 40) {
			System.out.println("BIZ: a random shot");
			g.randShot();
		} else {
			if (g.getCreditos() >= 40 && g.getCreditos() <= 60) {
				System.out.println("BIZ: 30% of possibilities shot");
				g.ejecutarConPosibilidad(30);
			} else {
				if (g.getCreditos() > 60) {
					System.out.println("BIZ: 60% of possibilities shot");
					g.ejecutarConPosibilidad(60);
				}
			}
		}

		// just to know what happens
		System.out.println("BIZ " + g.getBlock1() + " - " + g.getBlock2() + " - " + g.getBlock3());
		System.out.println("CREDITOS ANTES " + g.getCreditos());

		if (g.isGana()) {
			System.out.println("BIZ: GANA");
		} else {
			System.out.println("BIZ: PIERDE");
		}

		System.out.println("CREDITOS DESPUES " + g.getCreditos());

	}

}
