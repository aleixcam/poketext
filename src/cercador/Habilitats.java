package cercador;

import java.io.IOException;

import application.ability.GetAbilities.GetAbilitesUseCase;
import infrastructure.persistence.sqlite.AbilityRepositorySQLite;
import infrastructure.transformer.matrix.AbilityAssemblerMatrix;
import infrastructure.transformer.matrix.MatrixAssembler;
import utils.Comuna;

public class Habilitats {

    static void cercarHabilitats() throws IOException {
        String filter_name = "";
        String[] s;
        boolean sortir = false;

        do {

            GetAbilitesUseCase service = new GetAbilitesUseCase(new AbilityRepositorySQLite(), new AbilityAssemblerMatrix());
            String[][] abilities = service.execute(filter_name);

            // Mostrar per pantalla els moviments
            System.out.printf("Nom: %s%n", filter_name);
            MatrixAssembler.printQuery(abilities);
            System.out.printf("Nom: %s%n", filter_name);

            // Opcions del menú
            System.out.printf("%nCERCADOR: HABILITATS%n");
            System.out.println("N. Filtrar per nom");
            System.out.println("E. Eliminar filtre");
            System.out.println("Q. Sortir");
            s = Comuna.obtenirText().split(" ");

            // Seleccions del menú
            if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                filter_name = s[1];
            } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 1)) {
                filter_name = "";
            } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
