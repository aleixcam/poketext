package infrastructure.presentation.controller;

import cercador.Cercador;
import combat.Jugadors;
import teambuilder.Equips;

public class BaseController {
    public void play() {
        Jugadors.iniciarCombat();
    }

    public void teambuilder() {
        Equips.construirEquip();
    }

    public void pokedex() {
        Cercador.cercadorPrincipal();
    }
}
