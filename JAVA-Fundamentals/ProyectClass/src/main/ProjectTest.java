package main;

import clases.Project;

public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Project Edificacion = new Project();
		Edificacion.elevatorPitch();
		
		Project EdificacionDos = new Project("Hospital");
		EdificacionDos.elevatorPitch();
		
		Project EdificacionTres = new Project("Escuela", "Para ninios y ninias");
		EdificacionTres.elevatorPitch();

	}

}
