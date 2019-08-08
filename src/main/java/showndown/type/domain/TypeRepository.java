package showndown.type.domain;

public interface TypeRepository {

    int getDamageFactor(Type attacking, Type defending);
}
