package com.grupo23.Grupo230022022.services;

import java.util.List;

import com.grupo23.Grupo230022022.entities.NotaPedido;


public interface INotaPedidoService {
	
	public List<NotaPedido> getAll();
	public boolean insertOrUpdate(NotaPedido notaPedido);
	public NotaPedido findById(int id);
	public boolean remove(int id);
}
