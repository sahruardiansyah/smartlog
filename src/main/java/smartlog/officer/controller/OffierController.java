package smartlog.officer.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import smartlog.authenticate.entity.CurrentUser;
import smartlog.authenticate.entity.UserPrincipal;
import smartlog.db.entity.OfficerMaster;
import smartlog.db.entity.Role;
import smartlog.db.repository.OfficerMasterRepository;
import smartlog.exception.EmailAlreadyExistException;
import smartlog.exception.PhoneAlreadyExistException;
import smartlog.officer.entity.CreateOfficerRequest;
import smartlog.officer.entity.ModifyOfficerRequest;
import smartlog.officer.service.OfficerService;
import smartlog.payload.ErrorResponse;
import smartlog.payload.SuccessDataResponse;
import smartlog.payload.SuccessListResponse;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class OffierController {

    @Autowired
    OfficerService officerService;

    @Autowired
    OfficerMasterRepository repository;

    @RequestMapping(value = "/officer", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> createOfficer(@RequestBody CreateOfficerRequest request){
       try {
           OfficerMaster officerMaster =officerService.processCreateOfficer(new OfficerMaster(request));
           SuccessDataResponse<?> response=new SuccessDataResponse<>("succes","create new officer succes!");
           return new ResponseEntity<Object>(response, HttpStatus.CREATED);
       }catch (EmailAlreadyExistException ex){
           ErrorResponse error = new ErrorResponse("Bad Request", "Email is already taken", 500);
           return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
       }catch (PhoneAlreadyExistException ex) {
           ErrorResponse response = new ErrorResponse("Bad request", "Phone number already taken!", 500);
           return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
       }
    }
    @RequestMapping(value = "/officer", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public List<OfficerMaster> getAll(){
        return (List<OfficerMaster>) repository.findAll();
    }

    @RequestMapping(value = "/officer/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            OfficerMaster officer = officerService.findById(id).get();
            SuccessDataResponse<OfficerMaster> res = new SuccessDataResponse<OfficerMaster>("success", officer);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            ErrorResponse error = new ErrorResponse("404", "Officer not found.",404);
            return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/officer/{id}", method = RequestMethod.PUT)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> modifyOfficer(@PathVariable Long id, @RequestBody ModifyOfficerRequest request){
        try {
            Role role = new Role(request.getRoleId());
            OfficerMaster officer = new OfficerMaster(id, request);
            officer.setRole(role);
            officer = officerService.processModifyOfficer(officer);
            SuccessDataResponse<OfficerMaster> res = new SuccessDataResponse<OfficerMaster>("success", officer);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            ErrorResponse error = new ErrorResponse("404", "Officer not found.",404);
            return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/officer/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> deleteOfficer(@PathVariable Long id){
        try {
            OfficerMaster exist = officerService.findById(id).get();
            if (exist != null){
                repository.deleteById(id);
                List<OfficerMaster> list = (List<OfficerMaster>) repository.findAll();
                SuccessListResponse<OfficerMaster> res = new SuccessListResponse<>("success", list);
                return new ResponseEntity<Object>(res, HttpStatus.OK);
            }
        }catch (NoSuchElementException ex){
            ErrorResponse error = new ErrorResponse("404", "Officer not found.",404);
            return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
        }
        return null;
}
    @RequestMapping(value = "/officer/current", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getCurrentUser(@CurrentUser OfficerMaster currentUser) {
        try {
            if (currentUser == null || currentUser.getOfficerId() == null) {
                ErrorResponse error = new ErrorResponse("Not Found", "Officer not found.", 0);
                return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
            }
//            logger.info("get current user with user id {}", currentUser.getId());
            OfficerMaster user = officerService.findById(currentUser.getOfficerId()).get();
            SuccessDataResponse<OfficerMaster> res = new SuccessDataResponse<OfficerMaster>("success", user);
            return new ResponseEntity<Object>(res, HttpStatus.OK);

        }catch (NoSuchElementException ex) {
            ErrorResponse error = new ErrorResponse("Not Found", "Officer not found.", 0);
            return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
        }
    }
}
