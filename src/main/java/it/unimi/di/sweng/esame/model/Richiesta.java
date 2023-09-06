package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public final class Richiesta {
    private final @NotNull String codice;
    private final int durata;
    private final @NotNull String comune;
    private final @NotNull LocalDate data;

    public Richiesta(@NotNull String codice, int durata, @NotNull String comune, @NotNull LocalDate data) {
        this.codice = codice;
        this.durata = durata;
        this.comune = comune;
        this.data = data;
    }

    @Override
    public String toString() {
        return null;
    }

    public @NotNull String codice() {
        return codice;
    }

    public int durata() {
        return durata;
    }

    public @NotNull String comune() {
        return comune;
    }

    public @NotNull LocalDate data() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Richiesta) obj;
        return Objects.equals(this.codice, that.codice) &&
                this.durata == that.durata &&
                Objects.equals(this.comune, that.comune) &&
                Objects.equals(this.data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, durata, comune, data);
    }

}
