package me.iHDeveloper.system.command;

public @interface CommandInfo {
    String command();
    String description();
    boolean op();
    boolean player();
}
