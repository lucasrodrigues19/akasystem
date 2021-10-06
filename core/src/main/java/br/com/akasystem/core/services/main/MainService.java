package br.com.akasystem.core.services.main;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.akasystem.core.entities.main.SingleMainEntity;
import br.com.akasystem.core.enums.Status;
import br.com.akasystem.core.repository.main.MainRepository;

/**
 * @author Lucas Rodrigues
 * @since 2021/09/02
 * @param <T> Tipo da entidade
 * @param <I> Tipo do identificador ( ID )
 * @param <R> Repositorio
 */
@Service
public class MainService<T extends SingleMainEntity,I> {

	private MainRepository<T, I> akaMainRepository;
	
	public T saveOrUpdate(T entity){
		//TODO fazer auditoria
		try {
			if(entity.getId() != null) {
				UUID id =   entity.getId();
				Optional<T> optionalEntityExisting = akaMainRepository.findById(id);
				T entityExisting = optionalEntityExisting.orElse(null);
				if(entityExisting != null)
					margeEntity(entityExisting, entity);
			}
			
			return akaMainRepository.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(T entity) {
		akaMainRepository.delete(entity);
	}
	
	public void removeById(UUID id) {
		akaMainRepository.updateEntity(Status.REMOVE, id);
	}
	
	public void invativeById(UUID id) {
		akaMainRepository.updateEntity(Status.INATIVE, id);
	}
	
	public void activeById(UUID id) {
		akaMainRepository.updateEntity(Status.ACTIVE, id);
	}
	
	public T findById(UUID id) {
		return akaMainRepository.findById(id).get();
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
