package com.simpleapp.crud.dto.response;

import com.simpleapp.crud.modals.User;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserResponse implements ModalResponseGeneric<User, UserResponse> {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public UserResponse fromModal(User entry) {
        return this.setUserName(entry.getUserName())
                    .setFirstName(entry.getFirstName())
                    .setLastName(entry.getLastName())
                    .setEmail(entry.getEmail());
    }

    @Override
    public List<UserResponse> fromModal(List<User> entries) {
        return entries
                .stream()
                .map(entry -> new UserResponse().fromModal(entry))
                .collect(Collectors.toList());
    }
}
