//package net.newlearning.journalApp;
//
//import net.newlearning.journalApp.Entity.User;
//import net.newlearning.journalApp.Repository.UserRepository;
//import net.newlearning.journalApp.service.UserDetailsServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//@Disabled
//@SpringBootTest
//public class UserDetailsServiceImplTest {
//
//   @InjectMocks
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Mock
//    private UserRepository userRepository;
//
//@BeforeEach
//void setup(){
//    MockitoAnnotations.initMocks(this);
//}
//
//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("inrinrick").roles(new ArrayList<>()).build());
//        UserDetails  user = userDetailsService.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//    }
//}
