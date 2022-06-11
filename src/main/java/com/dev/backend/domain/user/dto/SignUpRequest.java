package com.dev.backend.domain.user.dto;

import com.dev.backend.domain.user.Role;
import com.dev.backend.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "이름을 입력해주세요")
    private String firstName;

    @NotBlank(message = "성을 입력해주세요")
    private String lastName;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @Email
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "전화번호를 입력해주세요")
    private String phoneNumber;

    private String userGithub;

    private String userDesc;

    // Role은 db로 조작해서 제거 가능해서 뺐습니다. 사실 관리자 없잖아요 ^^;;

    private String userImg;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .lastName(lastName)
                .firstName(firstName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phoneNumber(phoneNumber)
                .role(Role.USER)
                .userGithub(userGithub)
                .userDesc(userDesc)
                .userImg(userImg)
                .build();
    }
}
