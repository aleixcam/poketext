package teambuilder.team.domain.Service;

import teambuilder.team.domain.Team;

public interface TeamTransformer<T> {

    T transform(Team team);
    Team reverseTransform(T data);
}
