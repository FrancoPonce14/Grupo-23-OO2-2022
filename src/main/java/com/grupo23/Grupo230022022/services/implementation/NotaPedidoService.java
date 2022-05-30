package com.grupo23.Grupo230022022.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo23.Grupo230022022.entities.NotaPedido;
import com.grupo23.Grupo230022022.repositories.INotaPedidoRepository;
import com.grupo23.Grupo230022022.services.INotaPedidoService;

@Service("notaPedidoService")
public class NotaPedidoService implements INotaPedidoService {

	@Autowired
	//@Qualifier("notaPedidoRepository")
	private INotaPedidoRepository notaPedidoRepository;

	@Override
	public List<NotaPedido> getAll() {
		return notaPedidoRepository.findAll();
	}

	@Override
	public boolean insertOrUpdate(NotaPedido notaPedido) {
		try {
			notaPedidoRepository.save(notaPedido);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public NotaPedido findById(int id) {
		return notaPedidoRepository.findById(id).orElse(null);
	}

	@Override
	public boolean remove(int id) {
		try {
			notaPedidoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
