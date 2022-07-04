package com.log.app;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import com.log.app.configuration.PropertiSourceDev;
import com.log.app.controllers.TipoProductosRestController;
import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.TipoUsuario;
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

    @InjectMocks
    UserService userService;

    @Mock
    IUsuarioDao userRepository;

    @Mock
    AuthenticationManager authenticationManager;

    String testEmail = "test@clawtech.com.uy";
    String testPassword = "testPassword";
    String testNombre = "test";
    String testApellido = "test";
    Usuario usuario = new Usuario();
    

    @Before
    public void testCreateUser() throws EmailYaExisteExeption {


        usuario.setEmail(testEmail);
        usuario.setPassword(testPassword);
        usuario.setNombre(testNombre);
        usuario.setApellido(testApellido);
        usuario.setTipoUsuario(TipoUsuario.ADMIN);


        org.mockito.Mockito.when(userRepository.findByEmail(testEmail)).thenReturn(usuario);
        org.mockito.Mockito.when(userRepository.save(usuario)).thenReturn(usuario);
        org.mockito.Mockito.when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(testEmail, testPassword))).thenReturn(null);





   



    }

    @Test
    public void testAuthenticateUsuario() throws LoginRequestIncorrectaExeption {
        // AuthenticationResponse usuario = userService.authenticateUsuario(testEmail, testPassword);
        // assertThat(usuario.getEmail()).isEqualTo(testEmail);
        // // assertThat(usuario.getPassword()).isEqualTo(testPassword);
        // assertThat(usuario.getIdUsuario()).isNotNull();

    }

    @After
    @Test
    public void testDeleteUser() {
        userService.deleteByEmail(testEmail);
        // assertThat(userService.findByEmail(testEmail)).isNull();

    }
}
