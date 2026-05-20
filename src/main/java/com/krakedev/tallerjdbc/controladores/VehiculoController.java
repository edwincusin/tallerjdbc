package com.krakedev.tallerjdbc.controladores;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.tallerjdbc.entidades.Vehiculo;
import com.krakedev.tallerjdbc.servicios.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	private final VehiculoService vehiculoService;
		
	public VehiculoController(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	@PostMapping
	public boolean insertarVehiculo(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.insertarVehiculo(vehiculo);		
	}
	
	@GetMapping
	public ArrayList<Vehiculo> listar() {
		return vehiculoService.listar();
	}
	
	@GetMapping("/{placa}")
	public Vehiculo buscarPorPlaca(@PathVariable String placa) {
		return vehiculoService.buscarPorPlaca(placa);
	}

	@PutMapping("/{placa}")
	public boolean actualizar(@RequestBody Vehiculo vehiculoNuevo, @PathVariable String placa) {
		return vehiculoService.actualizar(vehiculoNuevo, placa);
	}
	
	@DeleteMapping("/{placa}")
	public boolean eliminar(@PathVariable String placa) {
		return vehiculoService.eliminar(placa);
	}
}
