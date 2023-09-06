package it.unimi.di.sweng.esame;

import org.jetbrains.annotations.NotNull;

public interface Observable<T> {
    @NotNull T getState();
}
