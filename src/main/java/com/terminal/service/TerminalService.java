package com.terminal.service;

import com.terminal.exception.TerminalExceptionHandler;
import com.terminal.model.Terminal;
import com.terminal.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {
    @Autowired
    TerminalRepository terminalRepository;
    public ResponseEntity<List<Terminal>> getFTRTerminals(){
        List<Terminal> terminals = terminalRepository.findAll();
        return ResponseEntity.ok(terminals);
    }
    public  ResponseEntity<Terminal> getTerminalByTerminalId(String terminalId) throws TerminalExceptionHandler{
        Optional<Terminal> terminals = terminalRepository.findById(terminalId);
        if(terminals.isEmpty()){
            throw new TerminalExceptionHandler("data not exist","402");
        }
        Terminal terminal = terminals.get();
       // Optional<List<Terminal>> optionalList = Optional.of(myList)
        return ResponseEntity.ok(terminal);
    }
    public ResponseEntity<List<Terminal>> getTerminalsByItemType(String itemType){
        List<Terminal> terminals = terminalRepository.findByItemType(itemType);
        return  ResponseEntity.ok(terminals);
    }

    public ResponseEntity<Terminal> insertNewTerminal(Terminal terminal){
        Terminal terminal1 = terminalRepository.saveAndFlush(terminal);
        return ResponseEntity.ok(terminal1);
    }
    public String updateTerminal(String terminalId, Integer newCapacity){
        Optional<Terminal> terminal = terminalRepository.findById(terminalId);
        Terminal terminal1 = terminal.get();
        terminal1.setCapacity(newCapacity);
        return "Update Successfully";

    }
    public String removeTerminal(String terminalId){
         terminalRepository.deleteById(terminalId);
         return "Deleted Successfully";
    }
}
