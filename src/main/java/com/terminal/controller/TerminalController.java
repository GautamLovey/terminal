package com.terminal.controller;

import com.terminal.exception.TerminalExceptionHandler;
import com.terminal.model.Terminal;
import com.terminal.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ftr/terminals")
public class TerminalController {
    @Autowired
    TerminalService terminalService;
    @GetMapping("/")
    public ResponseEntity<List<Terminal>> fetchFTRTerminals(){
     return terminalService.getFTRTerminals();

    }
    @GetMapping("/fetchTerminalByTerminalId/{terminalId}")
    public  ResponseEntity<Terminal> fetchTerminalByTerminalId(@PathVariable String terminalId) throws TerminalExceptionHandler {
      return terminalService.getTerminalByTerminalId(terminalId);
    }
    @GetMapping("/fetchTerminalsByItemType/{itemType}")
    public ResponseEntity<List<Terminal>> fetchTerminalsByItemType(@PathVariable String itemType){
      return terminalService.getTerminalsByItemType(itemType);
    }
    @PostMapping("/")
    public ResponseEntity<Terminal> insertNewTerminal(@RequestBody Terminal terminal){
       return terminalService.insertNewTerminal(terminal);
    }
    @PutMapping("/updateTerminal/{terminalId}/{newCapacity}")
    public ResponseEntity<String> updateTerminal(@PathVariable String terminalId,@PathVariable Integer newCapacity){
      return ResponseEntity.ok(terminalService.updateTerminal(terminalId,newCapacity));
    }
    @DeleteMapping("/removeTerminal/{terminalId}")
    public ResponseEntity<String> removeTerminal(@PathVariable String terminalId){
       return ResponseEntity.ok(terminalService.removeTerminal(terminalId));
    }
}
