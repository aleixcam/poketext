package shared.type.domain;

public interface TypeRepository {

    int getDamageFactor(Type attacking, Type defending);
}
