package com.gf.ejer.services;

import java.util.List;
import java.util.Optional;

import com.gf.ejer.models.Lote;

public interface LotesServices {

	Lote save(Lote l);
	Optional<Lote> findId(Long id);
	List<Lote> findAll(Lote l);

}
