package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public record Richiesta(@NotNull String codice, int durata, @NotNull String comune, @NotNull LocalDate data) {}
