package br.com.akasystem.core.services.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import br.com.akasystem.core.enums.Status;
import br.com.akasystem.core.repositorys.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/09/02
 * @param <T> Tipo da entidade
 * @param <I> Tipo do identificador ( ID )
 */
@Service
public class MainService<T extends SingleMainEntity,I> {

	private MainRepository<T, I> akaMainRepository;
	
	
	public List<T> saveAll(List<T> list){
		
		List<T> result = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(T t: list) {
				t = saveOrUpdate(t);
				result.add(t);
			}
		}
			return result;
  	}
	
	@Transactional
	public T saveOrUpdate(T entity){
		//TODO fazer auditoria
		try {
			if(akaMainRepository == null)
				throw new RuntimeException("Não existe repositorio criado... "+entity.getClass().getName());
			
			return akaMainRepository.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(T entity) {
		akaMainRepository.delete(entity);
	}
	
	public void removeById(I id) {
		akaMainRepository.updateEntity(Status.REMOVE, id);
	}
	
	public void invativeById(I id) {
		akaMainRepository.updateEntity(Status.INATIVE, id);
	}
	
	public void activeById(I id) {
		akaMainRepository.updateEntity(Status.ACTIVE, id);
	}
	
	public T findById(I id) {
		return akaMainRepository.findById(id).orElse(null);
	}
	
	/**
	 * defino os dados alterados e mantenho os que não foram alterados.
	 * @author Lucas Rodrigues
	 * @since 2021/10/02
	 * @param entityExisting
	 * @param modifiedEntity
	 * @return modifiedEntit
	 */
	public T margeEntity(T entityExisting, T modifiedEntity) {
		modifiedEntity.merge(entityExisting);
		return modifiedEntity;
	}
	
	public void setRepository(MainRepository<T, I> repository) {
		this.akaMainRepository = repository;
	}
	
}
