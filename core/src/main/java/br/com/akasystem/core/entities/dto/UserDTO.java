package br.com.akasystem.core.entities.dto;

import java.io.Serializable;
import java.util.UUID;

import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.entities.main.dto.MainEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDTO extends MainEntityDTO<UUID> implements Serializable {
	
	private static final long serialVersionUID = -5387736056997906355L;

	private String email;
	
	private String phone;
	
	private String password;
	
	public UserDTO(User user) {
		super(user);
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.password = user.getPassword();
	}
	
	
	
}
