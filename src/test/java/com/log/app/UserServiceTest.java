package com.log.app;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import com.log.app.configuration.PropertiSourceDev;
import com.log.app.controllers.TipoProductosRestController;
import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.Usuario;
import com.log.app.exepciones.EmailYaExisteExeption;
import com.log.app.exepciones.LoginRequestIncorrectaExeption;
import com.log.app.helpers.AuthenticationResponse;
import com.log.app.services.Impl.TipoProductoServiceImpl;
import com.log.app.services.Impl.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-dev.properties")

public class UserServiceTest {

    @Autowired
    UserService userService;

    String testEmail = "test@clawtech.com.uy";
    String testPassword = "testPassword";
    String testNombre = "test";
    String testApellido = "test";

    @Before
    public void testCreateUser() throws EmailYaExisteExeption {

        Usuario usuario = userService.createUser(testEmail, testPassword, testNombre, testApellido);
        assertThat(usuario.getEmail()).isEqualTo(testEmail);
        // assertThat(usuario.getPassword()).isEqualTo(testPassword);//todo: desemcriptar password para prueba 
        assertThat(usuario.getNombre()).isEqualTo(testNombre);
        assertThat(usuario.getApellido()).isEqualTo(testApellido);
        assertThat(usuario.getIdUsuario()).isNotNull();

    }

    @Test
    public void testAuthenticateUsuario() throws LoginRequestIncorrectaExeption {
        AuthenticationResponse usuario = userService.authenticateUsuario(testEmail, testPassword);
        assertThat(usuario.getEmail()).isEqualTo(testEmail);
        // assertThat(usuario.getPassword()).isEqualTo(testPassword);
        assertThat(usuario.getIdUsuario()).isNotNull();

    }
@After
    @Test
    public void testDeleteUser() {
       userService.deleteByEmail(testEmail);
       assertThat(userService.findByEmail(testEmail)).isNull();
    

    }
}
