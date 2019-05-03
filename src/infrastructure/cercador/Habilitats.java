package infrastructure.cercador;

import application.ability.GetAbilities.GetAbilitiesService;
import infrastructure.persistence.SQLite.AbilityRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.presentation.reader.StreamReader;
import infrastructure.presentation.transformer.matrix.AbilityAssemblerMatrix;

public class Habilitats {

    public static void cercarHabilitats() {
        String filter_name = "";
        String[] s;
        boolean sortir = false;

        do {

            GetAbilitiesService service = new GetAbilitiesService(new AbilityRepositorySQLite(), new AbilityAssemblerMatrix());
            String[][] abilities = service.execute(filter_name);

            // Mostrar per pantalla els moviments
            System.out.printf("Nom: %s%n", filter_name);
            MatrixPrinter.print(abilities);
            System.out.printf("Nom: %s%n", filter_name);

            // Opcions del menú
            System.out.printf("%nCERCADOR: HABILITATS%n");
            System.out.println("N. Filtrar per nom");
            System.out.println("E. Eliminar filtre");
            System.out.println("Q. Sortir");
            s = StreamReader.read().split(" ");

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
