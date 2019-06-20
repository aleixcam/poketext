package common.infrastructure.classes.cercador;

import ability.application.AbilityApplicationInjector;
import ability.application.GetAbilities.GetAbilitiesUseCase;
import common.infrastructure.printer.MatrixPrinter;
import common.infrastructure.service.ReaderService;

public class Habilitats {

    public static void cercarHabilitats() {
        String filter_name = "";
        String[] s;
        boolean sortir = false;

        do {

            GetAbilitiesUseCase service = AbilityApplicationInjector.injectGetAbilitiesUseCase();
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
            s = ReaderService.read().split(" ");

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
