package com.jacob.simpleGambling;

import java.util.Random;

/*
* Class para sesión con datos de usuario. 
* Contiene el valor de cada imagen a ser presentada 
*
* @author FUTURE KUSHKI ENGINEER
*         Jacob Orellana<br>
*         jacobore@hotmail.com<br>
* 
* @date 18/07/2021
* @version 1.0
*/

public class Gambler {

	private Integer block1 = 5;
	private Integer block2 = 5;
	private Integer block3 = 5;

	// al iniciar la sesion se asignan 10 creditos
	private Integer creditos = 10;

	private boolean gana;

	private String casoEjecutado;

	public Integer getBlock1() {
		return block1;
	}

	public void setBlock1(Integer block1) {
		this.block1 = block1;
	}

	public Integer getBlock2() {

		return block2;
	}

	public void setBlock2(Integer block2) {
		this.block2 = block2;
	}

	public Integer getBlock3() {

		return block3;
	}

	public void setBlock3(Integer block3) {
		this.block3 = block3;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	// Encuentra una imagen random
	public void randShot() {
		Random rand = new Random();

		block1 = rand.nextInt(4);
		block2 = rand.nextInt(4);
		block3 = rand.nextInt(4);
	}

	
	// Identifica si el user gana y le da creditos
	public boolean isGana() {
		if (block1 == block2 && block1 == block3) {
			creditos += 40;
			gana = true;
		} else {
			creditos--;
			gana = false;
		}
		return gana;
	}

	public void setGana(boolean gana) {
		this.gana = gana;
	}

	// Ejecuta logica con posibilidades
	
	public void ejecutarConPosibilidad(int posibilidad) {
		Random rand = new Random();
		
		if (posibilidad == 30) {
			block1 = 0;
			block2 = rand.nextInt(4);
			block3 = rand.nextInt(4);
		}

		if (posibilidad == 30) {
			block1 = 0;
			block2 = block1;
			block3 = rand.nextInt(4);
		}
	}

	
	// para pruebas unitarias
	public String getCasoEjecutado() {
		if (creditos < 40) {
			System.out.println("BIZ: a random shot");
			casoEjecutado = "random";
		} else {
			if (creditos >= 40 && creditos <= 60) {
				casoEjecutado = "30% de posibilidad";
			} else {
				if (creditos > 60) {
					casoEjecutado = "60% de posibilidad";
				}
			}
		}

		return casoEjecutado;
	}

	public void setCasoEjecutado(String casoEjecutado) {
		this.casoEjecutado = casoEjecutado;
	}

}
