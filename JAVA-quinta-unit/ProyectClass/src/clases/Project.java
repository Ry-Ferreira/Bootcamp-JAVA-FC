package clases;

public class Project {

	public String nombre;
	public String descripcion;
	
	public void elevatorPitch() {
		System.out.format("\n" + nombre + " : " + descripcion);
	}
	
	// SOBRECARGA DE CONSTRUCTORES	
	public Project(){
		nombre = "Torre";
		descripcion = "Torre ejecutiva de Honduras";
		elevatorPitch();
	};
	
	public Project(String name) {
		this.nombre = name;
		descripcion = "Isla Fidji";
		elevatorPitch();
	}
	
	public Project(String name, String description) {
		this.nombre = name;
		this.descripcion = description;
		elevatorPitch();
	}
}
