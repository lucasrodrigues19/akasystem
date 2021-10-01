package br.com.akasystem.core.services.main;

import java.util.Optional;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.akasystem.core.entities.main.MainEntity;
import br.com.akasystem.core.enums.StatusActive;
import br.com.akasystem.core.repository.main.MainRepository;
import lombok.AllArgsConstructor;

/**
 * @author Lucas Rodrigues
 * @since 2021/09/02
 * @param <T> Tipo da entidade
 * @param <I> Tipo do identificador ( ID )
 */
@MappedSuperclass
@AllArgsConstructor(onConstructor = @__(@Autowired))
public abstract class MainService<T extends MainEntity<I>,I> {

	private final MainRepository<T, I> akaMainRepository;
	
	
	public T saveOrUpdate(T entity){
		//TODO fazer auditoria
//		if(entity.getId() != null) {
//			//caso a entidade ja exista, preciso atualizar os dados alterados e manter os que não foram alterados
//			I id = (I) entity.getId();
//			Optional<T> optionalEntityExisting = akaMainRepository.findById(id);
//			T entityExisting = optionalEntityExisting.get();
//			margeEntity(entityExisting, entity);
//		}
		return save(entity);
	}
	
	public T save(T entity){
		return akaMainRepository.save(entity);
	}
	
	public void delete(T entity) {
		akaMainRepository.delete(entity);
	}
	
	public void removeById(I id) {
		akaMainRepository.updateEntity(StatusActive.REMOVE.getINT(), id);
	}
	
	public void invativeById(I id) {
		akaMainRepository.updateEntity(StatusActive.INATIVE.getINT(), id);
	}
	
	public void activeById(I id) {
		akaMainRepository.updateEntity(StatusActive.ACTIVE.getINT(), id);
	}
	
	public T findById(I id) {
		return akaMainRepository.findById(id).get();
	}
	
	public abstract T margeEntity(T entityExisting, T modifiedEntity);
		
}
