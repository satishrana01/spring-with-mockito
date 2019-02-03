package SpringMethodValidationTest;

import com.google.common.base.Predicate;
import com.springvalidate.NotAuthrized;
import com.springvalidate.SpringBootWebApplication;
import com.springvalidate.model.Account;
import com.springvalidate.model.User;
import com.springvalidate.service.AuthorisationService;
import com.springvalidate.service.UserService;
import com.springvalidate.service.impl.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@ContextConfiguration({
        "classpath:validation-aspect-context.xml"
})
public class UnitTestCaseWithMockito {

    @Inject
    UserService service;

    private AuthorisationService authorisationService;

    private Account taxAccount;

    @Before
    public void setUp() {

        taxAccount = new Account("1234", "TEST");
        authorisationService = Mockito.mock(AuthorisationService.class);
        //service = new UserServiceImpl(authorisationService);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testValideUser() throws NotAuthrized {

        User user = createUser();
        when(authorisationService.authorise(any(String.class), any(Predicate.class))).thenReturn(taxAccount);
        try {
            service.valideUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private User createUser() {
        User user = new User();
        user.setFistName("AAA");
        user.setLastName("BBB");
        return user;
    }

}
