//package net.newlearning.journalApp;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//import org.springframework.security.core.userdetails.User;
//import java.util.stream.Stream;
//
//@Disabled
//public class UserArgumentsProvider  implements   ArgumentsProvider{
//
//
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
//        return  Stream.of(
//                Arguments.of(User.builder().username("shyam").password("shyam").build()),
//                Arguments.of(User.builder().username("ram").password("ram").build())
//
//        );
//    }
//}
