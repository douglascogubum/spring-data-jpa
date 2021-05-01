package br.com.genekz.springdata.service;

import br.com.genekz.springdata.model.Position;
import br.com.genekz.springdata.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PositionCrudService {

    @Autowired
    private PositionRepository positionRepository;

    public void initial(Scanner scanner, int action) {
        switch (action) {
            case 1:
                save(scanner);
            break;
            case 2:
                update(scanner);
            break;
            case 3:
                select();
            break;
            case 4:
                delete(scanner);
            break;
        }
    }

    private void save(Scanner scanner) {

        System.out.println("Descricao do cargo");
        String description = scanner.next();

        Position position = new Position();
        position.setDescription(description);

        positionRepository.save(position);
        System.out.println("Saved!");
    }

    private void update(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();

        System.out.println("New Description");
        String description = scanner.next();

        Position position = new Position();
        position.setId(id);
        position.setDescription(description);

        positionRepository.save(position);
        System.out.println("Updated!");
    }

    private void select() {
        Iterable<Position> positions = positionRepository.findAll();
        positions.forEach(position -> System.out.println(position));
    }

    private void delete(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();

        positionRepository.deleteById(id);
        System.out.println("Deleted!");
    }
}