package com.krakedev.tallerjdbc.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.tallerjdbc.entidades.Vehiculo;
import com.krakedev.tallerjdbc.jdbc.DeleteVehiculo;
import com.krakedev.tallerjdbc.jdbc.InsertVehiculo;
import com.krakedev.tallerjdbc.jdbc.SelectVehiculo;
import com.krakedev.tallerjdbc.jdbc.UpdateVehiculo;

@Service
public class VehiculoService {
	

	public boolean insertarVehiculo(Vehiculo vehiculo) {
		return InsertVehiculo.insertar(vehiculo);		
	}
	
	public ArrayList<Vehiculo> listar() {
		return SelectVehiculo.listar();
	}
	
	public Vehiculo buscarPorPlaca(String placa) {
		return SelectVehiculo.buscarPorPlaca(placa);
	}
			
	public boolean actualizar(Vehiculo vehiculoNuevo, String placa) {
		return UpdateVehiculo.modificar(vehiculoNuevo, placa);
	}
	
	public boolean eliminar(String placa) {
		return DeleteVehiculo.eliminar(placa);
	}
}
