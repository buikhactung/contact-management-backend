package com.tungbk.contactmanagement.DTO;

import lombok.*;

import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private String phoneNumber;
    private String note;
    private File images;

}
