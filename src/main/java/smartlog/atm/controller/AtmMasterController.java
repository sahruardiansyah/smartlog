package smartlog.atm.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import smartlog.atm.entity.CreateAtmRequest;
import smartlog.atm.entity.ModifyAtmRequest;
import smartlog.atm.service.AtmService;
import smartlog.db.entity.AtmMaster;
import smartlog.db.repository.AtmRepository;
import smartlog.payload.ErrorResponse;
import smartlog.payload.SuccessDataResponse;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class AtmMasterController {
    @Autowired
    AtmService atmService;
    @Autowired
    AtmRepository repository;

    @RequestMapping(value = "/atm", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?>createAtm (@RequestBody CreateAtmRequest request){
        AtmMaster atmMaster = atmService.processCreateAtm(new AtmMaster(request));
        SuccessDataResponse<AtmMaster> response=new SuccessDataResponse<>("succes",atmMaster);
        return new ResponseEntity<Object>(response, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/atm/{id}", method = RequestMethod.PUT)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?>modifyAtm (@PathVariable Long id,@RequestBody ModifyAtmRequest request){
       try {
           AtmMaster atmMaster = atmService.processModifyAtm(new AtmMaster(id, request));
           SuccessDataResponse<AtmMaster> response=new SuccessDataResponse<>("succes",atmMaster);
           return new ResponseEntity<Object>(response, HttpStatus.CREATED);
       }catch (NoSuchElementException ex){
           ErrorResponse error = new ErrorResponse("404", "Officer not found.",404);
           return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
       }
    }
    @RequestMapping(value = "/atm", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public List<AtmMaster> getAll(){
        return (List<AtmMaster>) repository.findAll();
    }

}
