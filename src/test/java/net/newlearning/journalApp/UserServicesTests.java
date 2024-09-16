//package net.newlearning.journalApp;
//
//import net.newlearning.journalApp.Entity.User;
//import net.newlearning.journalApp.Repository.UserRepository;
//import net.newlearning.journalApp.service.UserServices;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Disabled
//@SpringBootTest
//public class UserServicesTests {
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserServices userServices;
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testSaveNewUser(User  user){
//        assertTrue(userServices.saveNewUser(user));
//
//    }
//
//    @Disabled
//@ParameterizedTest
//    @CsvSource({"1,2,3",
//            "8,9,90"
//    })
//    public void tests(int a, int b, int expected){
//        assertEquals(expected , a +b);
//    }
//}
