package br.com.akasystem.input.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.akasystem.core.entities.Privilege;
import br.com.akasystem.core.entities.Roles;
import br.com.akasystem.core.entities.User;
import br.com.akasystem.core.enums.Status;
import br.com.akasystem.core.services.PrivilegeService;
import br.com.akasystem.core.services.RolesService;
import br.com.akasystem.core.services.UserService;
import br.com.akasystem.sales.entities.UserPejorative;
import br.com.akasystem.sales.services.UserPejorativeService;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe de configuração para teste, valida somente para o perfil test
 * @author Lucas Rodrigues
 * @since 2021/08/28
 */
@Configuration
@Profile("test")
@Slf4j
public class ConfigTest implements CommandLineRunner {

	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPejorativeService userPejorativeService;
	
	@Override
	public void run(String... args) throws Exception {
		
		log.info("-----------------------------------------------------------------------------------");
		log.info("Criando estrutura para o sistem");
		
		
		UUID id = UUID.randomUUID();
		log.info("Criando roles...");
		Roles role1 = new Roles();
		role1.setDtInsert(LocalDateTime.now());
		role1.setDtUpdate(LocalDateTime.now());
		role1.setIdInsert(id);
		role1.setIdUpdate(id);
		role1.setName("SEL_ADMIN");
		role1.setStatus(Status.ACTIVE);
		
		Roles role2 = new Roles();
		role2.setDtInsert(LocalDateTime.now());
		role2.setDtUpdate(LocalDateTime.now());
		role2.setIdInsert(id);
		role2.setIdUpdate(id);
		role2.setName("UPD_ADMIN");
		role2.setStatus(Status.ACTIVE);
		
		Roles role3 = new Roles();
		role3.setDtInsert(LocalDateTime.now());
		role3.setDtUpdate(LocalDateTime.now());
		role3.setIdInsert(id);
		role3.setIdUpdate(id);
		role3.setName("DEL_ADMIN");
		role3.setStatus(Status.ACTIVE);
		rolesService.saveAll(Arrays.asList(role1,role2,role3));
		
		
		
		log.info("Criando user...");
		User user =  new User();
		user.setDtInsert(LocalDateTime.now());
		user.setDtUpdate(LocalDateTime.now());
		user.setIdInsert(id);
		user.setIdUpdate(id);
		user.setName("aka-system");
		user.setEmail("aka-system@aka.com.br");
		user.setPassword("1234");
		user.setPhone("1100000000");
		user.setStatus(Status.ACTIVE);
		user = userService.saveOrUpdate(user);
		
		
		
		log.info("Criando previleges...");
		Privilege privilegexuser1 = new Privilege();
		privilegexuser1.setDtInsert(LocalDateTime.now());
		privilegexuser1.setDtUpdate(LocalDateTime.now());
		privilegexuser1.setIdInsert(id);
		privilegexuser1.setIdUpdate(id);
		privilegexuser1.setName("SEL_ADMIN");
		privilegexuser1.setStatus(Status.ACTIVE);
		privilegexuser1.setRoles(role1);
		privilegexuser1.setUser(user);
		
		Privilege privilegexuser2 = new Privilege();
		privilegexuser2.setDtInsert(LocalDateTime.now());
		privilegexuser2.setDtUpdate(LocalDateTime.now());
		privilegexuser2.setIdInsert(id);
		privilegexuser2.setIdUpdate(id);
		privilegexuser2.setName("UPD_ADMIN");
		privilegexuser2.setStatus(Status.ACTIVE);
		privilegexuser2.setRoles(role2);
		privilegexuser2.setUser(user);
		
		Privilege privilegexuser3 = new Privilege();
		privilegexuser3.setDtInsert(LocalDateTime.now());
		privilegexuser3.setDtUpdate(LocalDateTime.now());
		privilegexuser3.setIdInsert(id);
		privilegexuser3.setIdUpdate(id);
		privilegexuser3.setName("DEL_ADMIN");
		privilegexuser3.setStatus(Status.ACTIVE);
		privilegexuser3.setRoles(role3);
		privilegexuser3.setUser(user);
		
		privilegeService.saveAll(Arrays.asList(privilegexuser1,privilegexuser2,privilegexuser3));
		
		log.info("-----------------------------------------------------------------------------------");
		log.info("Criando estrutura para sales");
		
		log.info("Criando rolexsale1...");
		Roles rolexsale1 = new Roles();
		rolexsale1.setDtInsert(LocalDateTime.now());
		rolexsale1.setDtUpdate(LocalDateTime.now());
		rolexsale1.setIdInsert(user.getId());
		rolexsale1.setIdUpdate(user.getId());
		rolexsale1.setName("SEL_SALES");
		rolexsale1.setStatus(Status.ACTIVE);
		
		Roles rolexsale2 = new Roles();
		rolexsale2.setDtInsert(LocalDateTime.now());
		rolexsale2.setDtUpdate(LocalDateTime.now());
		rolexsale2.setIdInsert(user.getId());
		rolexsale2.setIdUpdate(user.getId());
		rolexsale2.setName("UPD_SALES");
		rolexsale2.setStatus(Status.ACTIVE);
		
		Roles rolexsale3 = new Roles();
		rolexsale3.setDtInsert(LocalDateTime.now());
		rolexsale3.setDtUpdate(LocalDateTime.now());
		rolexsale3.setIdInsert(user.getId());
		rolexsale3.setIdUpdate(user.getId());
		rolexsale3.setName("DEL_SALES");
		rolexsale3.setStatus(Status.ACTIVE);
		rolesService.saveAll(Arrays.asList(rolexsale1,rolexsale2,rolexsale3));
		
		
		
		log.info("-----------------------------------------------------------------");
		log.info("Criando userxsale1...");
		User userxsale1 =  new User();
		userxsale1.setDtInsert(LocalDateTime.now());
		userxsale1.setDtUpdate(LocalDateTime.now());
		userxsale1.setIdInsert(user.getId());
		userxsale1.setIdUpdate(user.getId());
		userxsale1.setName("Sport Center");
		userxsale1.setEmail("sportcenter@gmail.com.br");
		userxsale1.setPassword("1234");
		userxsale1.setPhone("118948919");
		userxsale1.setStatus(Status.ACTIVE);
		userxsale1 = userService.saveOrUpdate(userxsale1);
		
		
		
		log.info("Criando previleges userxsale1...");
		Privilege privilegexuserxsale1_1 = new Privilege();
		privilegexuserxsale1_1.setDtInsert(LocalDateTime.now());
		privilegexuserxsale1_1.setDtUpdate(LocalDateTime.now());
		privilegexuserxsale1_1.setIdInsert(user.getId());
		privilegexuserxsale1_1.setIdUpdate(user.getId());
		privilegexuserxsale1_1.setName(rolexsale1.getName());
		privilegexuserxsale1_1.setStatus(Status.ACTIVE);
		privilegexuserxsale1_1.setRoles(rolexsale1);
		privilegexuserxsale1_1.setUser(userxsale1);
		
		Privilege privilegexuserxsale1_2 = new Privilege();
		privilegexuserxsale1_2.setDtInsert(LocalDateTime.now());
		privilegexuserxsale1_2.setDtUpdate(LocalDateTime.now());
		privilegexuserxsale1_2.setIdInsert(user.getId());
		privilegexuserxsale1_2.setIdUpdate(user.getId());
		privilegexuserxsale1_2.setName(rolexsale2.getName());
		privilegexuserxsale1_2.setStatus(Status.ACTIVE);
		privilegexuserxsale1_2.setRoles(rolexsale2);
		privilegexuserxsale1_2.setUser(userxsale1);
		
		Privilege privilegexuserxsale1_3 = new Privilege();
		privilegexuserxsale1_3.setDtInsert(LocalDateTime.now());
		privilegexuserxsale1_3.setDtUpdate(LocalDateTime.now());
		privilegexuserxsale1_3.setIdInsert(user.getId());
		privilegexuserxsale1_3.setIdUpdate(user.getId());
		privilegexuserxsale1_3.setName(rolexsale3.getName());
		privilegexuserxsale1_3.setStatus(Status.ACTIVE);
		privilegexuserxsale1_3.setRoles(rolexsale3);
		privilegexuserxsale1_3.setUser(userxsale1);
		privilegeService.saveAll(Arrays.asList(privilegexuserxsale1_1,privilegexuserxsale1_2,privilegexuserxsale1_3));

		
		
		log.info("Criando user userxsalexpejorative1");
		UserPejorative userxsalexpejorative1 =  new UserPejorative();
		userxsalexpejorative1.setId(userxsale1.getId());
		userxsalexpejorative1.setCnpj("93.762.327/0001-81");
		userxsalexpejorative1 = userPejorativeService.saveOrUpdate(userxsalexpejorative1);
		
		
		log.info("-----------------------------------------------------------------");
		log.info("Criando user userxsale2...");
		User userxsale2 =  new User();
		userxsale2.setDtInsert(LocalDateTime.now());
		userxsale2.setDtUpdate(LocalDateTime.now());
		userxsale2.setIdInsert(user.getId());
		userxsale2.setIdUpdate(user.getId());
		userxsale2.setName("Tec Center");
		userxsale2.setEmail("teccenter@gmail.com.br");
		userxsale2.setPassword("1234");
		userxsale2.setPhone("1152312333");
		userxsale2.setStatus(Status.ACTIVE);
		userxsale2 = userService.saveOrUpdate(userxsale2);
		
		
		
		log.info("Criando previleges userxsale2...");
		Privilege privilegexuserxsale2_1 = new Privilege();
		privilegexuserxsale2_1.setDtInsert(LocalDateTime.now());
		privilegexuserxsale2_1.setDtUpdate(LocalDateTime.now());
		privilegexuserxsale2_1.setIdInsert(id);
		privilegexuserxsale2_1.setIdUpdate(id);
		privilegexuserxsale2_1.setName(rolexsale1.getName());
		privilegexuserxsale2_1.setStatus(Status.ACTIVE);
		privilegexuserxsale2_1.setRoles(rolexsale1);
		privilegexuserxsale2_1.setUser(userxsale2);
		
		Privilege privilegexuserxsale2_2 = new Privilege();
		privilegexuserxsale2_2.setDtInsert(LocalDateTime.now());
		privilegexuserxsale2_2.setDtUpdate(LocalDateTime.now());
		privilegexuserxsale2_2.setIdInsert(id);
		privilegexuserxsale2_2.setIdUpdate(id);
		privilegexuserxsale2_2.setName(rolexsale2.getName());
		privilegexuserxsale2_2.setStatus(Status.ACTIVE);
		privilegexuserxsale2_2.setRoles(rolexsale2);
		privilegexuserxsale2_2.setUser(userxsale2);
		
		Privilege privilegexuserxsale2_3 = new Privilege();
		privilegexuserxsale2_3.setDtInsert(LocalDateTime.now());
		privilegexuserxsale2_3.setDtUpdate(LocalDateTime.now());
		privilegexuserxsale2_3.setIdInsert(id);
		privilegexuserxsale2_3.setIdUpdate(id);
		privilegexuserxsale2_3.setName(rolexsale3.getName());
		privilegexuserxsale2_3.setStatus(Status.ACTIVE);
		privilegexuserxsale2_3.setRoles(rolexsale3);
		privilegexuserxsale2_3.setUser(userxsale2);
		privilegeService.saveAll(Arrays.asList(privilegexuserxsale2_1,privilegexuserxsale2_2,privilegexuserxsale2_3));
		
		
		log.info("Criando user userxsalexpejorative2");
		UserPejorative userxsalexpejorative2 =  new UserPejorative();
		userxsalexpejorative2.setId(userxsale2.getId());
		userxsalexpejorative2.setCnpj("99.747.184/0001-15");
		userxsalexpejorative2 = userPejorativeService.saveOrUpdate(userxsalexpejorative2);
		
	}
	
}