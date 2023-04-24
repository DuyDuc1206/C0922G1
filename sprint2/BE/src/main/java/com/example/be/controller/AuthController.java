package com.example.be.controller;

import com.example.be.dto.request.SignInForm;
import com.example.be.dto.request.SignUpForm;
import com.example.be.dto.response.JWTResponse;
import com.example.be.dto.response.ResponseMessage;
import com.example.be.model.Role;
import com.example.be.model.RoleName;
import com.example.be.model.User;
import com.example.be.security.jwt.JWTProvider;
import com.example.be.security.userPrinciple.UserPrinciple;
import com.example.be.service.IRoleService;
import com.example.be.service.IUserService;
import com.example.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm, BindingResult bindingResult) {
        new SignUpForm().validate(iUserService.findAll(), signUpForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        if (iUserService.existByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Tên đăng " + signUpForm.getUsername() + " nhập đã được sử dụng, vui lòng chọn tên khác"), HttpStatus.BAD_REQUEST);
        }
        if (iUserService.existByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email " + signUpForm.getEmail() + " đã được sử dụng"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getEmail());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role roleAdmin = iRoleService.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role not found 1"));
                    roles.add(roleAdmin);
                    break;
//                case "employee":
//                    Role roleEmployee = iRoleService.roleEmployee().orElseThrow(() -> new RuntimeException("Role not found 2"));
//                    roles.add(roleEmployee);
//                    break;
                default:
                    Role roleCustomer = iRoleService.findByName(RoleName.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Role not found 3"));
                    roles.add(roleCustomer);
            }
        });
        user.setRoles(roles);
        iUserService.save(user);
        return new ResponseEntity<>(new ResponseMessage("Đăng kí thành công"), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody @Valid SignInForm signInForm) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JWTResponse(token,
                userPrinciple.getName(),
                userPrinciple.getAuthorities()));
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> profile(@PathVariable("id") int id) {
        return new ResponseEntity<>(iUserService.findById(id), HttpStatus.ACCEPTED);
    }
//    @PostMapping("/avatar")
//    public ResponseEntity<?> changeAvatar(@RequestBody AvatarDto avatarDto) {
//        User user = iUserService.findById(avatarDto.getId()).orElse(null);
//        assert user != null;
//        user.setAvatar(avatarDto.getAvatar());
//        iUserService.save(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PatchMapping("/change-password")
//    public ResponseEntity<List<FieldError>> changePassword(@RequestBody @Valid PasswordDto passwordDto,
//                                                           BindingResult bindingResult) {
//        new PasswordDto().validate(passwordDto, bindingResult);
//        Account account = accountService.findAccountByEmail(passwordDto.getUsername());
//        if (account == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        String password = account.getPassword();
//        String oldPassWord = passwordDto.getOldPassword();
//        Boolean checkOldPassword = accountService.checkOldPassword(oldPassWord, password);
//        if (!checkOldPassword) {
//            bindingResult.rejectValue("oldPassword", "passwordError2", "Mật khẩu cũ sai");
//        }
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
//        }
//        String hashPassword = BCrypt.hashpw(passwordDto.getPasswordConfirm(), BCrypt.gensalt(12));
//        account.setPassword(hashPassword);
//        accountService.updateAccount(account);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
