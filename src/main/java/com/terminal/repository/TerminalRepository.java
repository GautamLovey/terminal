package com.terminal.repository;

import com.terminal.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal,String> {

    public List<Terminal> findByItemType(String itemType);

   // Optional<List<Terminal>> findAllById(String terminalId);
}
