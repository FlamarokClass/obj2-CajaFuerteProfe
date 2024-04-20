package ar.edu.unahur.po2.caja;

public class CajaFuerte {

	private Boolean abierta = true;
	private Integer clave;	
	private Integer cantidaDeIntentosFallidos = 0;

	public Boolean estaAbierta() {
		return abierta;
	}

/*	Se eliminan ya que son refactorizados
 public void cerrar() {		
		this.abierta = false;
	
	}

	public void abrir() {		
		this.abierta = true;
	}
 */

	public void cerrar(Integer clave) {		
		if (this.abierta) {
			this.abierta = false;
		this.clave = clave;
		}		
	}

	public void abrir(Integer clave) {		
		if (this.clave.equals(clave) && (!this.estaBloqueada())) {
			this.abierta = true;
			this.cantidaDeIntentosFallidos=0;
		} else {
			this.cantidaDeIntentosFallidos ++;
		}
	}

	public Boolean estaBloqueada() {	
		return this.cantidaDeIntentosFallidos >=3 ;
	}
}
