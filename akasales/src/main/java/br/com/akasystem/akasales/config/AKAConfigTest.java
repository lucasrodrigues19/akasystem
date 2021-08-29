package br.com.akasystem.akasales.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Classe de configuração para teste, valida somente para o perfil test
 * @author Lucas Rodrigues
 * @since 2021/08/28
 */
@Configuration
@Profile("test")
public class AKAConfigTest {

}
