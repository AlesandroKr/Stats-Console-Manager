package com.github.alesandrokr;

public interface Command {
    void execute(String[] args);
    String getUsage();
}
