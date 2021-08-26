package br.com.akasystem.akasales.domains;

import java.time.LocalDateTime;

import br.com.akasystem.core.domain.main.AKAMainEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AKAUser extends AKAMainEntity{
	
	private String id;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	
	
	
}
