package  com.example.agendinaBE.service.ruoli;

import java.util.List;

import com.example.agendinaBE.model.RuoliEntity;

public  interface IRuoliService{
	List<RuoliEntity> findAllRuoli();
	RuoliEntity createRuoli  (RuoliEntity dto) ;
	RuoliEntity updateRuoli  ( RuoliEntity dto);
	void deleteRuoli (Long id);
}