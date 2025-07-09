package com.finteka.profile.interfaces.rest;

import com.finteka.profile.infrastructure.persistence.models.ClienteEntity;
import com.finteka.profile.infrastructure.persistence.models.ProfesionalEntity;
import com.finteka.profile.service.ClienteService;
import com.finteka.profile.service.ProfesionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfesionalService profesionalService;
    private final ClienteService clienteService;

    public ProfileController(ProfesionalService profesionalService, ClienteService clienteService) {
        this.profesionalService = profesionalService;
        this.clienteService = clienteService;
    }

    // --- PROFESIONALES ---
    @GetMapping("/profesionales")
    public List<ProfesionalEntity> getAllProfesionales() {
        List<ProfesionalEntity> result = profesionalService.findAll().stream()
                .peek(p -> p.setPassword(null))
                .collect(Collectors.toList());
        System.out.println("[DEBUG] Fetched all profesionales, count: " + result.size());
        return result;
    }

    @GetMapping("/profesionales/{id}")
    public ResponseEntity<ProfesionalEntity> getProfesional(@PathVariable Long id) {
        Optional<ProfesionalEntity> profesional = profesionalService.findById(id);
        if (profesional.isPresent()) {
            ProfesionalEntity p = profesional.get();
            p.setPassword(null);
            System.out.println("[DEBUG] Fetched profesional with id: " + id);
            return ResponseEntity.ok(p);
        }
        System.out.println("[DEBUG] Profesional not found with id: " + id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/profesionales")
    public ProfesionalEntity createProfesional(@RequestBody ProfesionalEntity profesional) {
        // Ignore incoming id for new entities
        profesional.setId(null);
        System.out.println("[DEBUG] Creating profesional: " + profesional.getEmail());
        return profesionalService.save(profesional);
    }

    @PutMapping("/profesionales/{id}")
    public ResponseEntity<ProfesionalEntity> updateProfesional(@PathVariable Long id, @RequestBody ProfesionalEntity profesional) {
        System.out.println("[DEBUG] Updating profesional with id: " + id);
        return profesionalService.findById(id)
                .map(existing -> {
                    profesional.setId(id);
                    ProfesionalEntity updated = profesionalService.save(profesional);
                    System.out.println("[DEBUG] Updated profesional: " + updated.getEmail());
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> {
                    System.out.println("[DEBUG] Profesional not found with id: " + id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping("/profesionales/{id}")
    public ResponseEntity<Void> deleteProfesional(@PathVariable Long id) {
        if (profesionalService.findById(id).isPresent()) {
            profesionalService.deleteById(id);
            System.out.println("[DEBUG] Deleted profesional with id: " + id);
            return ResponseEntity.noContent().build();
        }
        System.out.println("[DEBUG] Tried to delete non-existent profesional with id: " + id);
        return ResponseEntity.notFound().build();
    }

    // GET profesionales without password (public view)
    @GetMapping("/profesionales/public")
    public List<ProfesionalEntity> getAllProfesionalesPublic() {
        return profesionalService.findAll().stream()
                .peek(p -> p.setPassword(null))
                .collect(Collectors.toList());
    }

    // --- CLIENTES ---
    @GetMapping("/clientes")
    public List<ClienteEntity> getAllClientes() {
        List<ClienteEntity> result = clienteService.findAll().stream()
                .peek(c -> c.setPassword(null))
                .collect(Collectors.toList());
        System.out.println("[DEBUG] Fetched all clientes, count: " + result.size());
        return result;
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntity> getCliente(@PathVariable Long id) {
        Optional<ClienteEntity> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            ClienteEntity c = cliente.get();
            c.setPassword(null);
            System.out.println("[DEBUG] Fetched cliente with id: " + id);
            return ResponseEntity.ok(c);
        }
        System.out.println("[DEBUG] Cliente not found with id: " + id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ClienteEntity createCliente(@RequestBody ClienteEntity cliente) {
        // Ignore incoming id for new entities
        cliente.setId(null);
        System.out.println("[DEBUG] Creating cliente: " + cliente.getEmail());
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntity> updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        System.out.println("[DEBUG] Updating cliente with id: " + id);
        return clienteService.findById(id)
                .map(existing -> {
                    // Only update allowed fields, do not overwrite version/id
                    existing.setNombre(cliente.getNombre());
                    existing.setEmail(cliente.getEmail());
                    existing.setTelefono(cliente.getTelefono());
                    // Set password only if provided (avoid null overwrite)
                    if (cliente.getPassword() != null) {
                        existing.setPassword(cliente.getPassword());
                    }
                    ClienteEntity updated = clienteService.save(existing);
                    System.out.println("[DEBUG] Updated cliente: " + updated.getEmail());
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> {
                    System.out.println("[DEBUG] Cliente not found with id: " + id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clienteService.findById(id).isPresent()) {
            clienteService.deleteById(id);
            System.out.println("[DEBUG] Deleted cliente with id: " + id);
            return ResponseEntity.noContent().build();
        }
        System.out.println("[DEBUG] Tried to delete non-existent cliente with id: " + id);
        return ResponseEntity.notFound().build();
    }

    // GET clientes without password (public view)
    @GetMapping("/clientes/public")
    public List<ClienteEntity> getAllClientesPublic() {
        return clienteService.findAll().stream()
                .peek(c -> c.setPassword(null))
                .collect(Collectors.toList());
    }

    // --- LOGIN ENDPOINTS ---
    @GetMapping("/profesionales/login")
    public ResponseEntity<ProfesionalEntity> loginProfesional(@RequestParam String email, @RequestParam String password) {
        List<ProfesionalEntity> profesionales = profesionalService.findAll();
        for (ProfesionalEntity profesional : profesionales) {
            if (profesional.getEmail().equals(email) && profesional.getPassword().equals(password)) {
                profesional.setPassword(null); // Do not expose password
                System.out.println("[DEBUG] Profesional login successful for email: " + email);
                return ResponseEntity.ok(profesional);
            }
        }
        System.out.println("[DEBUG] Profesional login failed for email: " + email);
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/clientes/login")
    public ResponseEntity<ClienteEntity> loginCliente(@RequestParam String email, @RequestParam String password) {
        List<ClienteEntity> clientes = clienteService.findAll();
        for (ClienteEntity cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getPassword().equals(password)) {
                cliente.setPassword(null); // Do not expose password
                System.out.println("[DEBUG] Cliente login successful for email: " + email);
                return ResponseEntity.ok(cliente);
            }
        }
        System.out.println("[DEBUG] Cliente login failed for email: " + email);
        return ResponseEntity.status(401).build();
    }
}
