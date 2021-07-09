package teambuilder.team.infrastructure.Controller;

import shared.core.infrastructure.Service.ReaderService;
import teambuilder.team.domain.Team;
import teambuilder.team.infrastructure.Injector.TeamInfrastructureInjector;

final public class TeamController {

    public void create(String... args) {
        Team.empty();
    }

    public void edit(String... args) {
        Team.retrieve();
    }

    public void remove(String... args) {
        TeamInfrastructureInjector.csvTeamRepository().remove(ReaderService.read());
    }
}
