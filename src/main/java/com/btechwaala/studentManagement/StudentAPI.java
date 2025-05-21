package com.btechwaala.studentManagement;


import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StudentAPI {

    HashMap<Integer,Student> studentDb = new HashMap<>();
}
