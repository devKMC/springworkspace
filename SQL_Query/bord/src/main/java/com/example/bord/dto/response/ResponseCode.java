package com.example.bord.dto.response;


// public interface ResponseCode {
//     String SUCCESS ="SU";
//     String Validation_failed = "VF";
//     String Duplicate_email = "DE";
//     String Duplicate_nickname = "DN";
//     String Duplicate_telephone_number = "DT";
//     String This_board_does_not_exist = "NB";
//     String This_user_does_not_exist = "NU";
//     String Login_information_mismatch = "SF";
//     String Authorization_Failed = "AF";
//     String Do_not_have_permission = "NP";
//     String Database_error = "DBE";
// }
public interface ResponseCode {
    //200
    String SUCCESS = "SU";
    //400
    String VALIDATION_FAIL = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXIST_BOARD = "NB";
    //401
    String NOT_EXIST_USER = "NU";
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAIL = "AF";
    String NO_PERMISSION = "NP";
    //500
    String DATABASE_ERROR = "DBE";
}

